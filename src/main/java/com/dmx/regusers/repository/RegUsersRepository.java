package com.dmx.regusers.repository;

import com.dmx.regusers.model.RegUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegUsersRepository extends JpaRepository<RegUsers,Long> {

    Optional<RegUsers> findByLoginName(String loginName);
}

