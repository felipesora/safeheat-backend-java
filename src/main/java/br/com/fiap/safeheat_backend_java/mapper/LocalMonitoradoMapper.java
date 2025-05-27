package br.com.fiap.safeheat_backend_java.mapper;

import br.com.fiap.safeheat_backend_java.dto.AlertaCalorResponseDTO;
import br.com.fiap.safeheat_backend_java.dto.LocalMonitoradoRequestDTO;
import br.com.fiap.safeheat_backend_java.dto.LocalMonitoradoResponseDTO;
import br.com.fiap.safeheat_backend_java.model.LocalMonitorado;
import br.com.fiap.safeheat_backend_java.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class LocalMonitoradoMapper {
    public static LocalMonitoradoResponseDTO toDTO(LocalMonitorado local){
        List<AlertaCalorResponseDTO> alertas = local.getAlertas()
                .stream()
                .map(AlertaCalorMapper::toDTO)
                .collect(Collectors.toList());

        return new LocalMonitoradoResponseDTO(
            local.getId(),
            local.getNome(),
            local.getRua(),
            local.getNumero(),
            local.getComplemento(),
            local.getBairro(),
            local.getCidade(),
            local.getEstado(),
            local.getCep(),
            local.getLatitude(),
            local.getLongitude(),
            local.getUsuario().getId(),
            alertas
        );
    }

    public static LocalMonitorado toEntity(LocalMonitoradoRequestDTO dto, Usuario usuario){
        LocalMonitorado local = new LocalMonitorado();
        local.setNome(dto.getNome());
        local.setRua(dto.getRua());
        local.setNumero(dto.getNumero());
        local.setComplemento(dto.getComplemento());
        local.setBairro(dto.getBairro());
        local.setCidade(dto.getCidade());
        local.setEstado(dto.getEstado());
        local.setCep(dto.getCep());
        local.setLatitude(dto.getLatitude());
        local.setLongitude(dto.getLongitude());
        local.setUsuario(usuario);
        return local;
    }
}
