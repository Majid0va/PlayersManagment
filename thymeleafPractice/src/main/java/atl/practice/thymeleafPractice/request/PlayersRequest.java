package atl.practice.thymeleafPractice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayersRequest {
    private long id;
    private String name;
    private long number;
    private String team;
    private MultipartFile image;

}
