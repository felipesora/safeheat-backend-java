package br.com.fiap.safeheat_backend_java.service;

import br.com.fiap.safeheat_backend_java.model.AlertaCalor;
import br.com.fiap.safeheat_backend_java.repository.AlertaCalorRepository;

import java.util.List;

public class AlertaCalorService extends BaseServiceImpl<AlertaCalor, Long, AlertaCalorRepository>{

    public AlertaCalorService(AlertaCalorRepository repository) {
        super(repository);
    }

    @Override
    public List<AlertaCalor> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
