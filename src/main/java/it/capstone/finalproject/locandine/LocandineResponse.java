package it.capstone.finalproject.locandine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocandineResponse {
    private Long id;
    private String immagineurl;
    private Date dataCreazione;

}
