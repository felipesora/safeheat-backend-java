package br.com.fiap.safeheat_backend_java.dto;

import br.com.fiap.safeheat_backend_java.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({ "id_local", "nome", "rua", "numero", "complemento", "bairro", "cidade", "estado", "cep", "latitude", "longitude", "usuario_id" })
public class LocalMonitoradoDTO {

    @JsonProperty("id_local")
    private Long id;

    @NotBlank(message = "O nome do local é obrigatório")
    @Size(min = 3, max = 150, message = "O nome do local deve ter entre 3 e 150 caracteres")
    private String nome;

    @NotBlank(message = "A rua é obrigatória")
    @Size(min = 3, max = 150, message = "A rua deve ter entre 3 e 150 caracteres")
    private String rua;

    @NotBlank(message = "O número é obrigatório")
    @Size(min = 1, max = 5, message = "O múmero deve ter entre 1 e 5 caracteres")
    private String numero;

    @Size(min = 3, max = 100, message = "O complemento deve ter entre 3 e 100 caracteres")
    private String complemento;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(min = 3, max = 150, message = "O bairro deve ter entre 3 e 150 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(min = 3, max = 150, message = "A cidade deve ter entre 3 e 150 caracteres")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres")
    private String estado;

    @NotBlank(message = "O CEP é obrigatório")
    @Size(min = 8, max = 9, message = "O CEP deve ter entre 8 e 9 caracteres")
    private String cep;

    private Double latitude;

    private Double longitude;

    @JsonProperty("usuario_id")
    private Long usuarioId;
}
