package com.medeirosdaniel.srvinputfile.Service;

//import com.medeirosdaniel.srvinputfile.Entity.UsuarioEntity;
//import com.medeirosdaniel.srvinputfile.Repository.UsuarioRepository;
import com.medeirosdaniel.srvinputfile.Security.EncriptaSecurity;
import com.medeirosdaniel.srvinputfile.Security.ValidaLoginSecurity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    public List<UsuarioEntity> buscaTodosOsUsuarios() {
//        return usuarioRepository.findAll();
//    }
//
//    public UsuarioEntity buscaUsuarioPorId(Long id){
//        Optional<UsuarioEntity> busca = usuarioRepository.findById(id);
//        UsuarioEntity resultado = new UsuarioEntity();
//        resultado.setId(busca.get().getId());
//        resultado.setNome(busca.get().getNome());
//        resultado.setSobrenome(busca.get().getSobrenome());
//        resultado.setEmail(busca.get().getEmail());
//        resultado.setCelular(busca.get().getCelular());
//        resultado.setSenha(busca.get().getSenha());
//        return resultado;
//    }
//
//    public UsuarioEntity buscaUsuarioPorEmail(String email){
//        return usuarioRepository.buscaUsuarioPorEmail(email);
//    }
//
//    public UsuarioEntity buscaUsuarioPorCelular(String celular){
//        return usuarioRepository.buscaUsuarioPorCelular(celular);
//    }
//
//    public UsuarioEntity adicionaNovoUsuario(UsuarioEntity usuarioEntity) {
//        return usuarioRepository.save(usuarioEntity);
//    }
//
//    @Transactional
//    public UsuarioEntity atualizaUsuario(UsuarioEntity usuarioEntity){
//        UsuarioEntity dadosAntigos = new UsuarioEntity();
//        dadosAntigos = usuarioRepository.buscaUsuarioPorEmail(usuarioEntity.getEmail());
//
//        ValidaLoginSecurity vls = new ValidaLoginSecurity();
//
//        if (vls.validaLoginDoUsuario(usuarioEntity.getSenha(), dadosAntigos.getSenha())) {
//            EncriptaSecurity es = new EncriptaSecurity();
//            UsuarioEntity atualizaDados = new UsuarioEntity();
//            atualizaDados.setId(dadosAntigos.getId());
//            atualizaDados.setNome(usuarioEntity.getNome().toUpperCase());
//            atualizaDados.setSobrenome(usuarioEntity.getSobrenome().toUpperCase());
//            atualizaDados.setEmail(usuarioEntity.getEmail());
//            atualizaDados.setCelular(usuarioEntity.getCelular());
//            atualizaDados.setSenha(dadosAntigos.getSenha());
//            usuarioRepository.flush();
//            return atualizaDados;
//        } else {
//            return new UsuarioEntity();
//        }
//
//
//    }


}
