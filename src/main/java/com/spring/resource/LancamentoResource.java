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
import com.spring.model.Lancamento;
import com.spring.repository.LancamentoRepository;
import com.spring.service.LancamentoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {
	
    @Autowired
    private LancamentoRepository lancamentoRepository;
    
    @Autowired
    private LancamentoService lancamentoService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Lancamento> getlist(){
            return lancamentoRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Lancamento> save(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
    	System.out.println("entidade: "+ lancamento);
    	Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
    	publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
    	return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getById(@PathVariable Long id) {
    	Lancamento lancamento = lancamentoRepository.getOne(id);
    	if (lancamento != null)
			return ResponseEntity.ok(lancamento);
		else
			return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	lancamentoRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> update(@PathVariable Long id, @Valid @RequestBody Lancamento lancamento){
    	Lancamento lancamentoSalvo = lancamentoService.atualizar(id, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
    }  
}
