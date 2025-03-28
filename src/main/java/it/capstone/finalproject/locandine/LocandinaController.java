package it.capstone.finalproject.locandine;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/locandine")
@RequiredArgsConstructor
public class LocandinaController {
    private final LocandineService locandineService;

    @GetMapping("/all")
    public List<LocandineResponse> getAllLocandine() {
        return locandineService.getAllLocandine();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public LocandineResponse createLocandine(@RequestBody LocandineRequest locandineRequest) {
        return locandineService.createLocandina(locandineRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLocandina(@PathVariable Long id) {
        locandineService.deleteLocandina(id);
    }
}


