package com.dmx.regusers.service;

import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.exception.ResourceNotFoundException;
import com.dmx.regusers.mapper.RequestMapper;
import com.dmx.regusers.model.RegUsers;
import com.dmx.regusers.repository.RegUsersRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

class RegUsersServiceTest {

//    private RegUsersService regUsersService;
//    private RegUsersRepository regUsersRepository;
//    private RequestMapper requestMapper;
//
//    @BeforeEach
//    void setUp() {
//        regUsersRepository= mock(RegUsersRepository.class);
//
//        regUsersService=new RegUsersService(regUsersRepository);
//        requestMapper = Mappers.getMapper(RequestMapper.class);
//
//    }
//
//    @Test
//    public void testGetOneRegUser_whenLoginNameExist_shouldReturnRegUser(){
//
//        RegUsers regUser=new RegUsers();
//        regUser.setLoginName("orxanzadeh@gmail.com");
//        regUser.setPersonTypeCode((short) 1);
//        regUser.setVersion(null);
//        regUser.setHashedPassword(null);
//        regUser.setStatus(null);
//        regUser.setInsertDate(null);
//        regUser.setMobileStatus((short) 1);
//        regUser.setOrigin(null);
//
//        Mockito.when(regUsersRepository.findByLoginName("orxanzadeh@gmail.com")).thenReturn(Optional.of(regUser));
//
//        RegUsersDto result=regUsersService.getOneRegUser("orxanzadeh@gmail.com");
//
//        Assert.assertEquals(result,regUser);
//
//
//
//
//    }

}