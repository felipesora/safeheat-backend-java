package br.com.fiap.safeheat_backend_java.service;

import br.com.fiap.safeheat_backend_java.model.LocalMonitorado;
import br.com.fiap.safeheat_backend_java.repository.LocalMonitoradoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalMonitoradoService extends BaseServiceImpl<LocalMonitorado, Long, LocalMonitoradoRepository> {

    public LocalMonitoradoService(LocalMonitoradoRepository repository) {
        super(repository);
    }

    @Override
    public List<LocalMonitorado> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
