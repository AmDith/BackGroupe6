package ism.atelier.atelier.mobile.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JustificationRequestDto {
    private String titre;
    private String motif;
    private MultipartFile pieceJointe;
}
