package com.dmx.regusers.dto;

import lombok.Data;

@Data
public class RegUserUpdateDto {
    Short status;
    Short mobileStatus;
    Character hashedPassword;
}
