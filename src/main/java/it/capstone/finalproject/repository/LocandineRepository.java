package it.capstone.finalproject.repository;


import it.capstone.finalproject.entities.Locandine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LocandineRepository extends JpaRepository<Locandine, Long> {
    List<Locandine> findAllByOrderByDataCreazioneDesc();
}
