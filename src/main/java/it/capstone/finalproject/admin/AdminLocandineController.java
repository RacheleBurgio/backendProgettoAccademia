package it.capstone.finalproject.admin;

import it.capstone.finalproject.locandine.LocandineRequest;
import it.capstone.finalproject.locandine.LocandineResponse;
import it.capstone.finalproject.locandine.LocandineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin/locandine")
@RequiredArgsConstructor
public class AdminLocandineController {

    private final LocandineService locandineService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Doppia protezione
    public ResponseEntity<LocandineResponse> uploadLocandina(
            @RequestBody @Valid LocandineRequest request) {
        return ResponseEntity.ok(locandineService.createLocandina(request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLocandina(@PathVariable Long id) {
        locandineService.deleteLocandina(id);
        return ResponseEntity.noContent().build();
    }
}
