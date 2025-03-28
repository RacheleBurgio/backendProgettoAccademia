package it.capstone.finalproject.locandine;

import it.capstone.finalproject.entities.Locandine;
import it.capstone.finalproject.repository.LocandineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocandineService {
    private final LocandineRepository locandineRepository;

    public List<LocandineResponse> getAllLocandine() {
        return locandineRepository.findAllByOrderByDataCreazioneDesc().stream()
                .map(l -> new LocandineResponse(l.getId(), l.getImmagineurl(), l.getDataCreazione()))
                .collect(Collectors.toList());
    }
    @Transactional
    public LocandineResponse createLocandina(LocandineRequest request) {
        Locandine locandina = Locandine.builder()
                .immagineurl(request.getImmagineurl())
                .build();

        return convertToResponse(locandineRepository.save(locandina));
    }
    private LocandineResponse convertToResponse(Locandine locandina) {
        return LocandineResponse.builder()
                .id(locandina.getId())
                .immagineurl(locandina.getImmagineurl())
                .dataCreazione(locandina.getDataCreazione())
                .build();
    }

    @Transactional
    public void deleteLocandina(Long id) {
        locandineRepository.deleteById(id);
    }
}