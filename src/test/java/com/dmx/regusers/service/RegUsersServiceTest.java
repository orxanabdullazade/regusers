package com.dmx.regusers.service;

import java.util.Date;
import java.math.BigInteger;

import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.mapper.RequestMapper;
import com.dmx.regusers.model.RegUsers;
import com.dmx.regusers.repository.RegUsersRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RegUsersServiceTest {

    private static final String LOGIN_NAME = "elhaam1d0@gmail.com";

    @Mock
    private RegUsersRepository regUsersRepository;
    @InjectMocks
    private RegUsersService regUsersService;

    @Test
    public void testGetAllRegUsers_itShouldReturnPageableUsers() {

    }

    @Test
    @Ignore
    @DisplayName("test one reg user")
    public void testGetOneRegUser() {
        //Arrange
        RegUsers regUsers = getRegUsers();

        when(regUsersRepository.findByLoginName(ArgumentMatchers.any(String.class)))
                .thenReturn(Optional.ofNullable(regUsers));

        //Act
        RegUsersDto regUsersDto = regUsersService.getOneRegUser(LOGIN_NAME);

        //Assert
        assertAll(
                () -> assertNotNull(regUsersDto),
                () -> assertEquals(regUsersDto.getLoginName(), LOGIN_NAME)
        );
    }

    private RegUsers getRegUsers() {
        RegUsers regUsers = new RegUsers();
        regUsers.setLoginName(LOGIN_NAME);
        regUsers.setPersonTypeCode((short) 0);
        regUsers.setHashedPassword("asdasd");
        regUsers.setStatus((short) 0);
        regUsers.setInsertDate(new Date());
        regUsers.setMobileStatus((short) 0);
        regUsers.setOrigin((short) 0);
        return regUsers;
    }


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