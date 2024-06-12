package br.com.tresptecnologia.service.endereco;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.cliente.Endereco;
import br.com.tresptecnologia.repository.endereco.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends BaseService<Endereco> implements IEnderecoService {

    protected EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
