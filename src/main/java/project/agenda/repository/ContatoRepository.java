package project.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.agenda.model.Contato;

public interface ContatoRepository  extends JpaRepository<Contato, Integer>{

}
