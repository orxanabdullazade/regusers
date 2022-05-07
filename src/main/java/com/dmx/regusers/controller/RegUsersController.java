package com.dmx.regusers.controller;

import com.dmx.regusers.dto.RegUserUpdateDto;
import com.dmx.regusers.dto.RegUsersDto;
import com.dmx.regusers.service.RegUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/eregusers")
public class RegUsersController {

    @Autowired
    private RegUsersService regUsersService;

    @GetMapping
    public ResponseEntity<Page<RegUsersDto>> getAll(Pageable pageable){
//        throw new RuntimeException("No users found");
        return ResponseEntity.ok(regUsersService.getAllRegUsers(pageable));
    }

    @GetMapping("/{loginName}")
    public ResponseEntity<RegUsersDto> getOne(@PathVariable String loginName){
//        log.info(loginName);
        return ResponseEntity.ok(regUsersService.getOneRegUser(loginName));
    }

    @PutMapping("/{loginName}")
    public  ResponseEntity<RegUsersDto> updateOneRegUser(@PathVariable String loginName,@RequestBody RegUserUpdateDto request){
        return ResponseEntity.ok(regUsersService.updateRegUser(loginName,request));
    }

    @PostMapping
    public ResponseEntity<RegUsersDto> searchRegUser(@Valid @RequestBody RegUsersDto request){
        return ResponseEntity.ok(regUsersService.searchRegUser(request));
    }

}
