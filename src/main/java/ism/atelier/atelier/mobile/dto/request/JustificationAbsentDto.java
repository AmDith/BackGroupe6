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
    private String motifs;
    private String titre;
    private List<MultipartFile> piecesJointes;
}
