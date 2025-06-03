package ism.atelier.atelier.mobile.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class JustificationAbsentDto {
    private String absenceId;
    @NotNull(message = "Le motif est obligatoire")
    private String motifs;
    @NotNull(message = "Le titre est obligatoire")
    private String titre;
    private List<MultipartFile> piecesJointes;
}
