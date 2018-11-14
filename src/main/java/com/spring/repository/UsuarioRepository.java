package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
