package it.capstone.finalproject.auth;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppAdmin, Long> {
    Optional<AppAdmin> findByUsername(String username);
    boolean existsByUsername(String username);
}
