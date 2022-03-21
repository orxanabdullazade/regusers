package com.dmx.regusers.mapper;

import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.model.RegUsers;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper
public interface RequestMapper {
    RegUsersDto toRegUserDto(RegUsers regUsers);
}
