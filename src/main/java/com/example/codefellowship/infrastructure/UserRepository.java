package com.example.codefellowship.infrastructure;

import com.example.codefellowship.domain.ApplicationUser;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaProperties <ApplicationUser,Long>{
    public ApplicationUser findUserByUsername(String username);
}
