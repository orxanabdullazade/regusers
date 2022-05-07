package com.dmx.regusers.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name = "ereg_credentials")
@Data
public class RegUsers {

    @Id
    @Basic(optional = false)
    @Column(name = "LOGIN_NAME",length = 200)
    private String loginName;

    @Column(name = "PERSON_TYPE_CODE")
    private Short personTypeCode;

    @Column(name = "VERSION")
    private BigInteger version;

    @Column(name = "HASHED_PASSWORD",columnDefinition = "CHAR",length = 64)
    private String hashedPassword;

    @Column(name = "STATUS")
    private Short status;

    @Column(name = "INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @Column(name = "MOBILE_STATUS",nullable = false)
    private Short mobileStatus;

    @Column(name = "ORIGIN",nullable = false)
    private Short origin;



}
