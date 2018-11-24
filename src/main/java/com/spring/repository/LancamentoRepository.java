package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
