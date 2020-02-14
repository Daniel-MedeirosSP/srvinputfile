package com.medeirosdaniel.srvinputfile.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ValidaLoginSecurity {

    public Boolean validaLoginDoUsuario(String senha, String bcrypt){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senha,bcrypt);
    }
}
