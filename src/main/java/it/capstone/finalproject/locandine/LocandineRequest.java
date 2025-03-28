package it.capstone.finalproject.locandine;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocandineRequest {

    @NotBlank(message = "L'URL dell'immagine è obbligatorio")
    private String immagineurl;


}
