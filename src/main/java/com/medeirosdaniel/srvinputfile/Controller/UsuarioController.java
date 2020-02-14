package com.medeirosdaniel.srvinputfile.Controller;

import com.medeirosdaniel.srvinputfile.Entity.UsuarioEntity;
import com.medeirosdaniel.srvinputfile.Security.EncriptaSecurity;
import com.medeirosdaniel.srvinputfile.Security.ValidaLoginSecurity;
import com.medeirosdaniel.srvinputfile.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> buscaTodosOsUsuarios() {
        return usuarioService.buscaTodosOsUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioEntity buscaUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioService.buscaUsuarioPorId(id);
    }

    @GetMapping("/email/{email}")
    public UsuarioEntity buscaUsuarioPorEmail(@PathVariable("email") String email) {
        return usuarioService.buscaUsuarioPorEmail(email);
    }

    @GetMapping("/celular/{celular}")
    public UsuarioEntity buscaUsuarioPorCelular(@PathVariable("celular") String celular) {
        return usuarioService.buscaUsuarioPorCelular(celular);
    }

    @GetMapping("/encoder/{palavra}/{email}")
    public Boolean encoderPalavra(@PathVariable("palavra")String palavra,@PathVariable("email")String email) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UsuarioEntity testa = usuarioService.buscaUsuarioPorEmail(email);
        String x = testa.getSenha();
        ValidaLoginSecurity n = new ValidaLoginSecurity();
        return n.validaLoginDoUsuario(palavra,x);
    }

    @PostMapping("/{nome}/{sobre}/{email}/{celular}/{senha}")
    public UsuarioEntity adicionaNovoUsuario(@PathVariable("nome") String nome, @PathVariable("sobre") String sobre, @PathVariable("email") String email,
                                             @PathVariable("celular") String celular, @PathVariable("senha") String senha) {
        EncriptaSecurity es = new EncriptaSecurity();
        UsuarioEntity novo = new UsuarioEntity();
        novo.setNome(nome.toUpperCase());
        novo.setSobrenome(sobre.toUpperCase());
        novo.setEmail(email.toLowerCase());
        novo.setCelular(celular);
        novo.setSenha(es.encripta(senha));
        return usuarioService.adicionaNovoUsuario(novo);
    }


    @PutMapping("/{nome}/{sobre}/{email}/{celular}/{senha}")
    public UsuarioEntity alteraDadosDoUsuarioPorEmail(@PathVariable("nome") String nome, @PathVariable("sobre") String sobre, @PathVariable("email") String email,
                                                      @PathVariable("celular") String celular, @PathVariable("senha") String senha) {
        UsuarioEntity dados = new UsuarioEntity();
        dados.setNome(nome);
        dados.setSobrenome(sobre);
        dados.setEmail(email);
        dados.setCelular(celular);
        dados.setSenha(senha);
        return usuarioService.atualizaUsuario(dados);

    }


}
