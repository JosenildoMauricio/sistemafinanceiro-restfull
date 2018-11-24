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
import com.spring.model.TipoLancamento;
import com.spring.repository.TipoLancamentoRepository;
import com.spring.service.TipoLancamentoService;

@RestController
@RequestMapping("/tipo-lancamento")
public class TipoLancamentoResource {
	
    @Autowired
    private TipoLancamentoRepository tipoLancamentoRepository;
    
    @Autowired
    private TipoLancamentoService tipoLancamentoService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<TipoLancamento> getlist(){
            return tipoLancamentoRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<TipoLancamento> save(@Valid @RequestBody TipoLancamento tipoLancamento, HttpServletResponse response) {
    	TipoLancamento tipoLancamentoSalvo = tipoLancamentoRepository.save(tipoLancamento);
    	publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoLancamentoSalvo.getId()));
    	return ResponseEntity.status(HttpStatus.CREATED).body(tipoLancamentoSalvo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoLancamento> getById(@PathVariable Long id) {
    	TipoLancamento tipoLancamento = tipoLancamentoRepository.getOne(id);
    	if (tipoLancamento != null)
			return ResponseEntity.ok(tipoLancamento);
		else
			return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	tipoLancamentoRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoLancamento> update(@PathVariable Long id, @Valid @RequestBody TipoLancamento tipoLancamento){
    	TipoLancamento tipoLancamentoSalvo = tipoLancamentoService.atualizar(id, tipoLancamento);
		return ResponseEntity.ok(tipoLancamentoSalvo);
    }  
}
