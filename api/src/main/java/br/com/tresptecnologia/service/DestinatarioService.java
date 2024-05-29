package br.com.tresptecnologia.service;

import br.com.tresptecnologia.repository.destinatario.DestinatarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinatarioService {

    private final DestinatarioRepository repository;

    public List<String> getAll() {
        return repository.getAllCnpj();
    }
}
