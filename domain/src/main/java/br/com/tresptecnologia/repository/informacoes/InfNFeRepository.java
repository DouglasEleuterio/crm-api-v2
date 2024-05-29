package br.com.tresptecnologia.repository.informacoes;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.notafiscal.InfNFe;
import br.com.tresptecnologia.enumeration.EnumSituacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfNFeRepository extends BaseRepository<InfNFe> {
    Optional<InfNFe> findByIdnf(String idnf);

    @Query(value = """
            from InfNFe nfe
            join nfe.ide ide
            join nfe.det det
            right join det.prod prd
            right join det.imposto imp
            
            join imp.pis pis
            right join pis.pisaliq pia
            
            join imp.cofins cof
            right join cof.cofinsaliq cfa
            
            left join TabelaAliquotaDiferenciada tad on prd.ncm = tad.ncm
            
            where tad.situacao = true
            and tad.enumSituacao =:situacao
            
            """)
    List<InfNFe> getAllProdutosComMonofasicos(EnumSituacao situacao);
}
