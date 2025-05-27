package br.com.fiap.safeheat_backend_java.service;

import br.com.fiap.safeheat_backend_java.model.LocalMonitorado;
import br.com.fiap.safeheat_backend_java.repository.LocalMonitoradoRepository;

import java.util.List;

public class LocalMonitoradoService extends BaseServiceImpl<LocalMonitorado, Long, LocalMonitoradoRepository> {

    public LocalMonitoradoService(LocalMonitoradoRepository repository) {
        super(repository);
    }

    @Override
    public List<LocalMonitorado> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
