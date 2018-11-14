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
import com.spring.model.Usuario;
import com.spring.repository.UsuarioRepository;
import com.spring.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Usuario> listar(){
            return usuarioRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
    	Usuario usuarioSalvo = usuarioRepository.save(usuario);
    	publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
    	return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id) {
    	Usuario usuario = usuarioRepository.getOne(id);
    	if (usuario != null)
			return ResponseEntity.ok(usuario);
		else
			return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	usuarioRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarAll(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
    	Usuario usuarioSalvo = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioSalvo);
    }  
}
