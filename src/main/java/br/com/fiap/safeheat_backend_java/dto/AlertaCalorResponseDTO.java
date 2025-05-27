package br.com.fiap.safeheat_backend_java.dto;

import java.time.LocalDateTime;

public class AlertaCalorResponseDTO {

    private Long id;
    private String grau;
    private String mensagem;
    private LocalDateTime dataAlerta;
    private String nivelRisco;
    private Long localId;

    public AlertaCalorResponseDTO() {
    }

    public AlertaCalorResponseDTO(Long id, String grau, String mensagem, LocalDateTime dataAlerta, String nivelRisco, Long localId) {
        this.id = id;
        this.grau = grau;
        this.mensagem = mensagem;
        this.dataAlerta = dataAlerta;
        this.nivelRisco = nivelRisco;
        this.localId = localId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
