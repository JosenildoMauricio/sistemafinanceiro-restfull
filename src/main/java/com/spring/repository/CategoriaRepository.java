package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
