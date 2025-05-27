package br.com.fiap.safeheat_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
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
@Entity
@Table(name = "sh_alertas_calor")
public class AlertaCalor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alerta_seq")
    @SequenceGenerator(name = "alerta_seq", sequenceName = "ALERTA_SEQ", allocationSize = 1)
    @Column(name = "id_alerta")
    @JsonProperty("id_alerta")
    private Long id;

    @Column(nullable = false, length = 50)
    private String grau;

    @Column(nullable = false, length = 300)
    private String mensagem;

    @Column(name = "data_alerta", updatable = false)
    private LocalDateTime dataAlerta;

    @Column(name = "nivel_risco",nullable = false, length = 100)
    private String nivelRisco;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private LocalMonitorado local;

    @PrePersist
    protected void onCreate() {
        this.dataAlerta = LocalDateTime.now();
    }

}
