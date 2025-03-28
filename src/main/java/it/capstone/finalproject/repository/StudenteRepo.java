package it.capstone.finalproject.repository;

import it.capstone.finalproject.entities.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudenteRepo extends JpaRepository<Studenti, Long> {
    Optional<Studenti> findByNome(String nome);
}
