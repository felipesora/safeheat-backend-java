package br.com.fiap.safeheat_backend_java.dto;

import jakarta.validation.constraints.*;

public class LocalMonitoradoRequestDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Rua é obrigatória.")
    private String rua;

    @NotBlank(message = "Número é obrigatório.")
    private String numero;

    private String complemento; // opcional

    @NotBlank(message = "Bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória.")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório.")
    private String estado;

    @NotBlank(message = "CEP é obrigatório.")
    private String cep;

    @NotNull(message = "Latitude é obrigatória.")
    private Double latitude;

    @NotNull(message = "Longitude é obrigatória.")
    private Double longitude;

    @NotNull(message = "ID do usuário é obrigatório.")
    private Long usuarioId;

    public LocalMonitoradoRequestDTO() {
    }

    public LocalMonitoradoRequestDTO(String nome, String rua, String numero, String complemento, String bairro,
                                     String cidade, String estado, String cep, Double latitude,
                                     Double longitude, Long usuarioId) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
