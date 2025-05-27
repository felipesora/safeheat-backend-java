package br.com.fiap.safeheat_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sh_local_monitorado")
public class LocalMonitorado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_seq")
    @SequenceGenerator(name = "local_seq", sequenceName = "LOCAL_SEQ", allocationSize = 1)
    @Column(name = "id_local")
    @JsonProperty("id_local")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150)
    private String rua;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(length = 50)
    private String complemento;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(precision = 10, scale = 6)
    private Double latitude;  // para mapa/localização

    @Column(precision = 10, scale = 6)
    private Double longitude; // para mapa/localização

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
