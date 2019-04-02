package my.service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect
@Getter
@Setter
@Builder
public class Pet {
    private Long id;
    private String name;
}
