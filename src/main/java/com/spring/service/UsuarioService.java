package com.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.model.Usuario;
import com.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario usuarioSalvo = bucarUsuarioPeloId(id);
    	BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
    	return usuarioRepository.save(usuarioSalvo);
	}
	
	public Usuario bucarUsuarioPeloId(Long id) {
		Usuario usuarioSalvo = usuarioRepository.getOne(id);
    	if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo;
	}
}
