package project.agenda.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.agenda.model.Contato;
import project.agenda.repository.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
public class ContatoController {
	
	 private final ContatoRepository repository;
     
	 // Salvando contatos no banco
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public Contato save( @RequestBody Contato contato) {
    	 return repository.save(contato);
     }
     
     // deletando um contato do banco
     @ResponseStatus(HttpStatus.NO_CONTENT)
     @DeleteMapping("{id}")
     public void delete( @PathVariable Integer id) {
    	  repository.deleteById(id);
     }
     
     // listando todos os contatos do banco
     @GetMapping
     public List<Contato> list() {
    	 return repository.findAll();
     }
     
     // favoritando contato do tipo booleano
     @PatchMapping("{id}/favorito")
     public void favorite( @PathVariable Integer id, Boolean favorito) {
    	 Optional<Contato> contato = repository.findById(id);
    	 contato.ifPresent(c -> {
    		  c.setFavorito(favorito);
    		  repository.save(c);
    	 });
     }
    	
}
















