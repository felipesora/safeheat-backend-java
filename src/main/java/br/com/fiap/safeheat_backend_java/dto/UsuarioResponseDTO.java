package br.com.fiap.safeheat_backend_java.dto;

import java.util.List;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<LocalMonitoradoResponseDTO> locaisFavoritos;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, String senha, List<LocalMonitoradoResponseDTO> locaisFavoritos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.locaisFavoritos = locaisFavoritos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<LocalMonitoradoResponseDTO> getLocaisFavoritos() {
        return locaisFavoritos;
    }

    public void setLocaisFavoritos(List<LocalMonitoradoResponseDTO> locaisFavoritos) {
        this.locaisFavoritos = locaisFavoritos;
    }
}
