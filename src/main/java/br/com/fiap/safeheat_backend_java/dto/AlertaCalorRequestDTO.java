package br.com.fiap.safeheat_backend_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class AlertaCalorRequestDTO {

    @NotNull(message = "Grau é obrigatório.")
    private String grau;

    @NotBlank(message = "Mensagem é obrigatória.")
    private String mensagem;

    @JsonProperty("data_alerta")
    private LocalDateTime dataAlerta;

    @NotBlank(message = "Nível de risco é obrigatório.")
    @JsonProperty("nivel_risco")
    private String nivelRisco;

    @NotNull(message = "ID do local é obrigatório.")
    @JsonProperty("id_local")
    private Long localId;

    public AlertaCalorRequestDTO() {
    }

    public AlertaCalorRequestDTO(String grau, String mensagem, LocalDateTime dataAlerta, String nivelRisco, Long localId) {
        this.grau = grau;
        this.mensagem = mensagem;
        this.dataAlerta = dataAlerta;
        this.nivelRisco = nivelRisco;
        this.localId = localId;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDateTime dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }
}
