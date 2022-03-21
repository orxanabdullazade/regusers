package com.dmx.regusers.dto;

import com.dmx.regusers.model.RegUsers;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public final class RegUsersDto implements Serializable {

    private static final long serialVersionUID=1L;

    @NotNull(message = "This value is required.")
    @Email(message = "Email format not correct")
    @Size(min = 3,max = 50,message = "Email size must be between {min} and {max}")
    private String loginName;
    private Short status;
    private Short mobileStatus;
    private Character hashedPassword;
    private Date insertDate;

//    public RegUsersDto(RegUsers entity) {
//        this.loginName = entity.getLoginName();
//        this.status = entity.getStatus();
//        this.mobileStatus = entity.getMobileStatus();
//        this.hashedPassword = entity.getHashedPassword();
//    }
}
