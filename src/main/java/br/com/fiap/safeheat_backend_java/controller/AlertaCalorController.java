package br.com.fiap.safeheat_backend_java.controller;

import br.com.fiap.safeheat_backend_java.dto.AlertaCalorRequestDTO;
import br.com.fiap.safeheat_backend_java.dto.AlertaCalorResponseDTO;
import br.com.fiap.safeheat_backend_java.mapper.AlertaCalorMapper;
import br.com.fiap.safeheat_backend_java.model.AlertaCalor;
import br.com.fiap.safeheat_backend_java.model.LocalMonitorado;
import br.com.fiap.safeheat_backend_java.service.AlertaCalorService;
import br.com.fiap.safeheat_backend_java.service.LocalMonitoradoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaCalorController {

    private final AlertaCalorService alertaService;
    private final LocalMonitoradoService localService;

    public AlertaCalorController(AlertaCalorService alertaService, LocalMonitoradoService localService) {
        this.alertaService = alertaService;
        this.localService = localService;
    }

    @GetMapping
    public List<AlertaCalorResponseDTO> listarTodos() {
        return alertaService.listarTodos()
                .stream()
                .map(AlertaCalorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AlertaCalorResponseDTO buscarPorId(@PathVariable Long id){
        return AlertaCalorMapper.toDTO(alertaService.buscarPorId(id));
    }

    @PostMapping
    public AlertaCalorResponseDTO salvar(@RequestBody @Valid AlertaCalorRequestDTO dto){
        LocalMonitorado local = localService.buscarPorId(dto.getLocalId());

        AlertaCalor alerta = AlertaCalorMapper.toEntity(dto, local);

        return AlertaCalorMapper.toDTO(alertaService.salvar(alerta));
    }

    @PutMapping("/{id}")
    public AlertaCalorResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid AlertaCalorRequestDTO dto) {
        LocalMonitorado local = localService.buscarPorId(dto.getLocalId());

        AlertaCalor alerta = AlertaCalorMapper.toEntity(dto, local);
        alerta.setId(id);

        return AlertaCalorMapper.toDTO(alertaService.atualizar(id, alerta));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return alertaService.deletar(id);
    }
}
