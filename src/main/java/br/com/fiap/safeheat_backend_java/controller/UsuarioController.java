package br.com.fiap.safeheat_backend_java.controller;

import br.com.fiap.safeheat_backend_java.dto.UsuarioRequestDTO;
import br.com.fiap.safeheat_backend_java.dto.UsuarioResponseDTO;
import br.com.fiap.safeheat_backend_java.mapper.UsuarioMapper;
import br.com.fiap.safeheat_backend_java.model.Usuario;
import br.com.fiap.safeheat_backend_java.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
        return UsuarioMapper.toDTO(service.buscarPorId(id));
    }

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody @Valid UsuarioRequestDTO dto){
        return UsuarioMapper.toDTO(service.salvar(UsuarioMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO dto){
        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario.setId(id);
        return UsuarioMapper.toDTO(service.atualizar(id,usuario));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return service.deletar(id);
    }
}
