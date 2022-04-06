package com.dmx.regusers.service;

import com.dmx.regusers.dto.RegUserUpdateDto;
import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.exception.ResourceNotFoundException;
import com.dmx.regusers.mapper.RequestMapper;
import com.dmx.regusers.model.RegUsers;
import com.dmx.regusers.repository.RegUsersRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegUsersService implements Serializable {

    private final RegUsersRepository regUsersRepository;
    private final RequestMapper requestMapper;

//    public RegUsersService(RegUsersRepository regUsersRepository,RequestMapper requestMapper) {
//        this.requestMapper = requestMapper;
//        this.regUsersRepository = regUsersRepository;
//    }

    public Page<RegUsersDto> getAllRegUsers(Pageable pageable){
        Page<RegUsers> regUsers = regUsersRepository.findAll(pageable);
        return regUsers.map(requestMapper::toRegUserDto);
//      return regUsersRepository.findAll(pageable).stream().map(p->new RegUsersDto(p)).collect(Collectors.toList());
    }

    public RegUsersDto getOneRegUser(String loginName) {
        RegUsers regUser = regUsersRepository.findByLoginName(loginName).orElseThrow(() -> new ResourceNotFoundException("Could not find this loginname: "+loginName));
        return requestMapper.toRegUserDto(regUser);
    }

    public RegUsersDto updateRegUser(String loginName, RegUserUpdateDto request) {
        Optional<RegUsers> regUser = regUsersRepository.findByLoginName(loginName);
        if (regUser.isPresent()) {
            RegUsers toUpdate = regUser.get();
            if (Objects.nonNull(request.getStatus())) {
                toUpdate.setStatus(request.getStatus());
            }
            if (Objects.nonNull(request.getMobileStatus())) {
                toUpdate.setMobileStatus(request.getMobileStatus());
            }
            if (Objects.nonNull(request.getHashedPassword())) {
                toUpdate.setHashedPassword(request.getHashedPassword());
            }
            return requestMapper.toRegUserDto(regUsersRepository.save(toUpdate));
        } else {
            throw new ResourceNotFoundException("Login name not found in updateRegUser: {}"+loginName);
        }
    }


    public RegUsersDto searchRegUser(RegUsersDto request) {
        Optional<RegUsers> regUser = regUsersRepository.findByLoginName(request.getLoginName());
        if (regUser.isEmpty()) {
            throw new ResourceNotFoundException("Login name not found in searchRegUser : {}" + request.getLoginName());
        } else {
            return requestMapper.toRegUserDto(regUser.get());
        }
    }

}
