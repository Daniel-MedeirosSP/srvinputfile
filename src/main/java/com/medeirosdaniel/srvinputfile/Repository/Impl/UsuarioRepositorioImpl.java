package com.medeirosdaniel.srvinputfile.Repository.Impl;

import com.medeirosdaniel.srvinputfile.Entity.UsuarioEntity;
import com.medeirosdaniel.srvinputfile.Repository.Interface.UsuarioRepositoryInterface;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UsuarioRepositorioImpl implements UsuarioRepositoryInterface {
   @PersistenceContext private EntityManager entityManager;

 //    @Override
//    public List<UsuarioEntity> mostraTodosOsUsuariosPorEmail(String email) {
//        String sql =
//                "SELECT * FROM usuario WHER email IN (:identificadoresUnicos)";
//
//        Query createQuery = this.entityManager.createNativeQuery(sql, UsuarioEntity.class);
//        createQuery.setParameter("email", email);
//
//        return createQuery.getResultList();
//    }
}
