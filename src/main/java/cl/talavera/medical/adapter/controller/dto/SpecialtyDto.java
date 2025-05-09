package cl.talavera.medical.adapter.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialtyDto {
    private Long id;
    private String name;
    private String description;
}
