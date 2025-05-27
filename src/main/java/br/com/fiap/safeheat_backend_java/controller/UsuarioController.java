package br.com.fiap.safeheat_backend_java.controller;

import br.com.fiap.safeheat_backend_java.dto.UsuarioRequestDTO;
import br.com.fiap.safeheat_backend_java.dto.UsuarioResponseDTO;
import br.com.fiap.safeheat_backend_java.mapper.UsuarioMapper;
import br.com.fiap.safeheat_backend_java.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody @Valid UsuarioRequestDTO dto){
        return UsuarioMapper.toDTO(service.salvar(UsuarioMapper.toEntity(dto)));
    }
}
