package br.com.fiap.safeheat_backend_java.controller;

import br.com.fiap.safeheat_backend_java.dto.LocalMonitoradoRequestDTO;
import br.com.fiap.safeheat_backend_java.dto.LocalMonitoradoResponseDTO;
import br.com.fiap.safeheat_backend_java.mapper.LocalMonitoradoMapper;
import br.com.fiap.safeheat_backend_java.model.LocalMonitorado;
import br.com.fiap.safeheat_backend_java.model.Usuario;
import br.com.fiap.safeheat_backend_java.service.LocalMonitoradoService;
import br.com.fiap.safeheat_backend_java.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locais")
public class LocalMonitoradoController {

    private final LocalMonitoradoService localService;
    private final UsuarioService usuarioService;

    public LocalMonitoradoController(LocalMonitoradoService localService, UsuarioService usuarioService) {
        this.localService = localService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<LocalMonitoradoResponseDTO> listarTodos() {
        return localService.listarTodos()
                .stream()
                .map(LocalMonitoradoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LocalMonitoradoResponseDTO buscarPorId(@PathVariable Long id) {
        return LocalMonitoradoMapper.toDTO(localService.buscarPorId(id));
    }

    @PostMapping
    public LocalMonitoradoResponseDTO salvar(@RequestBody @Valid LocalMonitoradoRequestDTO dto){
        Usuario usuario = usuarioService.buscarPorId(dto.getUsuarioId());

        LocalMonitorado local = LocalMonitoradoMapper.toEntity(dto, usuario);

        return LocalMonitoradoMapper.toDTO(localService.salvar(local));
    }

    @PutMapping("/{id}")
    public LocalMonitoradoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid LocalMonitoradoRequestDTO dto){

        Usuario usuario = usuarioService.buscarPorId(dto.getUsuarioId());

        LocalMonitorado local = LocalMonitoradoMapper.toEntity(dto, usuario);
        local.setId(id);

        return LocalMonitoradoMapper.toDTO(localService.atualizar(id, local));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return localService.deletar(id);
    }
}
