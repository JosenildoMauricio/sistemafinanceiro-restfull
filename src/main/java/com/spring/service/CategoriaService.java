package com.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.model.Categoria;
import com.spring.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria atualizar(Long id, Categoria categoria) {
		Categoria categoriaSalva = bucarCategoriaPeloId(id);
    	BeanUtils.copyProperties(categoria, categoriaSalva, "id");
    	return categoriaRepository.save(categoriaSalva);
	}
	
	public Categoria bucarCategoriaPeloId(Long id) {
		Categoria categoriaSalva = categoriaRepository.getOne(id);
    	if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaSalva;
	}
}
