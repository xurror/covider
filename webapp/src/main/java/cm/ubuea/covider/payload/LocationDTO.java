package ub.covid.fet.payload;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class LocationDTO {
    private String current_loctaion;
    private List<String > previous_location;
    private long userid;
}
