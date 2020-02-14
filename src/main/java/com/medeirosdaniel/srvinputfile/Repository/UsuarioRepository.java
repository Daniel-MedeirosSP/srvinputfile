package com.medeirosdaniel.srvinputfile.Repository;
//
//import com.medeirosdaniel.srvinputfile.Entity.UsuarioEntity;
//import com.medeirosdaniel.srvinputfile.Repository.Interface.UsuarioRepositoryInterface;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//@Repository
//public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>,UsuarioRepositoryInterface {
//
//    @Query(value = "SELECT * FROM usuario where email=?1",nativeQuery = true)
//    public UsuarioEntity buscaUsuarioPorEmail(@Param("email")String email);
//
//    @Query(value = "SELECT * FROM usuario WhERE celular=?1",nativeQuery = true)
//    public UsuarioEntity buscaUsuarioPorCelular(@Param("celular") String celular);
//
//
//}
