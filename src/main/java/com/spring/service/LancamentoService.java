package com.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.model.Lancamento;
import com.spring.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoSalvo = bucarLancamentoPeloId(id);
    	BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
    	return lancamentoRepository.save(lancamentoSalvo);
	}
	
	public Lancamento bucarLancamentoPeloId(Long id) {
		Lancamento lancamentoSalvo = lancamentoRepository.getOne(id);
    	if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoSalvo;
	}
}
