package br.com.fiap.safeheat_backend_java.service;

import br.com.fiap.safeheat_backend_java.model.Usuario;
import br.com.fiap.safeheat_backend_java.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAllByOrderByIdAsc();
    }
}
