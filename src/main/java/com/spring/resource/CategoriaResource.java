package com.spring.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.event.RecursoCriadoEvent;
import com.spring.model.Categoria;
import com.spring.repository.CategoriaRepository;
import com.spring.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/lista-categorias")
    public List<Categoria> getlist(){
            return categoriaRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
    	Categoria categoriaSalva = categoriaRepository.save(categoria);
    	publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
    	return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
    	Categoria categoria = categoriaRepository.getOne(id);
    	if (categoria != null)
			return ResponseEntity.ok(categoria);
		else
			return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	categoriaRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria categoria){
    	Categoria categoriaSalva = categoriaService.atualizar(id, categoria);
		return ResponseEntity.ok(categoriaSalva);
    }  
}
