package br.com.tresptecnologia.repository.produto;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.notafiscal.Prod;
import br.com.tresptecnologia.enumeration.EnumSituacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends BaseRepository<Prod> {

    @Query(value = """
    from Prod prd
    left join TabelaAliquotaDiferenciada tad on prd.ncm = tad.ncm
    left join prd.det det
    join det.infnf inf
    join inf.ide ide
    join inf.dest des
    
    where tad.situacao = true
    and tad.enumSituacao =:eSituacaoTad
    and (det.imposto.cofins.cofinsaliq is not null or det.imposto.pis.pisaliq is not null)
    and ide.dhEmiDT >= tad.inicioVigencia
    and (ide.dhEmiDT <= tad.fimVigencia or tad.fimVigencia is null )
    and des.cnpj =:cnpjDestinatario
""")
    Page<Prod> getAllIncidenciaMonofasica(EnumSituacao eSituacaoTad, String cnpjDestinatario, Pageable pageable);

    @Query(value = """
    from Prod prd
    left join TabelaAliquotaDiferenciada tad on prd.ncm = tad.ncm
    left join prd.det det
    join det.infnf inf
    join inf.ide ide
    join inf.dest des
    
    where tad.situacao = true
    and tad.enumSituacao =:eSituacaoTad
    and (det.imposto.cofins.cofinsaliq is not null or det.imposto.pis.pisaliq is not null)
    and ide.dhEmiDT >= tad.inicioVigencia
    and (ide.dhEmiDT <= tad.fimVigencia or tad.fimVigencia is null )
""")
    Page<Prod> getAllIncidenciaMonofasica(EnumSituacao eSituacaoTad, Pageable pageable);
}
