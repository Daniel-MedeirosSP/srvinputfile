package com.medeirosdaniel.srvinputfile.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptaSecurity {

    public String encripta(String senha){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }
}
