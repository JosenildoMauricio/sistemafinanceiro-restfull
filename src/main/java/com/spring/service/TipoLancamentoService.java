package com.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.model.TipoLancamento;
import com.spring.repository.TipoLancamentoRepository;

@Service
public class TipoLancamentoService {
	
	@Autowired
	private TipoLancamentoRepository tipoLancamentoRepository;

	public TipoLancamento atualizar(Long id, TipoLancamento usuario) {
		TipoLancamento tipoLancamentoSalvo = bucarTipoLancamentoPeloId(id);
    	BeanUtils.copyProperties(usuario, tipoLancamentoSalvo, "id");
    	return tipoLancamentoRepository.save(tipoLancamentoSalvo);
	}
	
	public TipoLancamento bucarTipoLancamentoPeloId(Long id) {
		TipoLancamento tipoLancamentoSalvo = tipoLancamentoRepository.getOne(id);
    	if (tipoLancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoLancamentoSalvo;
	}
}
