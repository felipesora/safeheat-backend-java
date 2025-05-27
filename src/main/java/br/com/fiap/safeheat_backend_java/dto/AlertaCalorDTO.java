package br.com.fiap.safeheat_backend_java.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({ "id_alerta", "grau", "nivel_risco", "data_alerta", "id_local" })
public class AlertaCalorDTO {

    @JsonProperty("id_alerta")
    private Long id;

    @NotBlank(message = "O grau é obrigatório")
    @Size(min = 3, max = 50, message = "O grau deve ter entre 3 e 50 caracteres")
    private String grau;

    @NotBlank(message = "A mensagem é obrigatória")
    @Size(min = 5, max = 300, message = "A mensagem deve ter entre 5 e 300 caracteres")
    private String mensagem;

    @NotBlank(message = "O nível de risco é obrigatório")
    @Size(min = 3, max = 100, message = "O nível de risco deve ter entre 3 e 100 caracteres")
    @JsonProperty("nivel_risco")
    private String nivelRisco;

    @JsonProperty("data_alerta")
    private LocalDateTime dataAlerta;

    @NotNull(message = "O ID do local é obrigatório")
    @JsonProperty("id_local")
    private Long idLocal;
}
