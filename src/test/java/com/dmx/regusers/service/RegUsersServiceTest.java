package com.dmx.regusers.service;
import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.mapper.RequestMapper;
import com.dmx.regusers.model.RegUsers;
import com.dmx.regusers.repository.RegUsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RegUsersServiceTest {

    @Mock
    private  RegUsersRepository regUsersRepository;
    @Mock
    private  RequestMapper requestMapper;
    @InjectMocks
    private  RegUsersService regUsersService;

    @Test
    public void testGetOneRegUser() {
        //Given
        RegUsers regUsers=new RegUsers();
        regUsers.setLoginName("elhaam1d0@gmail.com");
        //When
        when(regUsersRepository.findByLoginName("elhaam1d0@gmail.com")).thenReturn(Optional.of(regUsers));
        //Then
        assertEquals(regUsers, regUsersService.getOneRegUser("elhaam1d0@gmail.com"));
    }


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