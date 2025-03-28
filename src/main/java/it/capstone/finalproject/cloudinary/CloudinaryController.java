package it.capstone.finalproject.cloudinary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class CloudinaryController {
    private final Cloudinary cloudinary;


    @PostMapping(path = "/uploadme", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CloudinaryResponse uploadToCloudinary(
            @RequestPart("file") MultipartFile file) {

        try {
            // Carica il file su Cloudinary
            Map<String, Object> result = cloudinary.uploader().upload(file.getBytes(), Cloudinary.asMap("folder", "locandine", "public_id", file.getOriginalFilename()));

            // Ottieni l'URL dell'immagine caricata
            String imageUrl = (String) result.get("secure_url");

            CloudinaryResponse response = new CloudinaryResponse(imageUrl);
            System.out.println(response);
            return response;


        } catch (IOException e) {
            throw new RuntimeException("Errore durante l'upload su Cloudinary", e);
        }
    }
}

