package br.com.tresptecnologia.repository.tabelavaloresmonofasicosnf;

import br.com.tresptecnologia.entity.notafiscal.InfNFe;
import br.com.tresptecnologia.model.tabelavaloresmonofasicosnf.TabelaValoresMonofasicosNF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoresMonofasicosNF extends JpaRepository<InfNFe, Long> {

    @Query(value = """
                SELECT IDE.IDE_NNF,
                       TO_DATE(TO_CHAR(TO_TIMESTAMP_TZ(IDE.IDE_DH_EMI, 'YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 'YYYY-MM-DD'), 'YYYY-MM-DD') AS DT_EMISSAO,
                       PRD.PRD_NCM,
                       PRD.PRD_X_PROD,
                       PIA.PIA_VPIS,
                       CFA.CFA_VCOFINS,
                       PRD.PRD_V_UN_COM,
                       PRD.PRD_Q_COM,
                       PRD.PRD_V_PROD
                FROM NFE_NFE NFE
                         JOIN INF_INFNFE INF ON NFE.INF_ID = INF.INF_ID
                         JOIN IDE_IDE IDE ON INF.IDE_ID = IDE.IDE_ID
                         JOIN DET_DET DET ON INF.INF_ID = DET.INF_ID
                         RIGHT JOIN PRD_PROD PRD ON DET.PRD_ID = PRD.PRD_ID
                         RIGHT JOIN IMP_IMPOSTO IMP ON DET.IMP_ID = IMP.IMP_ID
                -- PIS
                         JOIN PIS_PIS ON IMP.PIS_ID = PIS_PIS.PIS_ID
                         RIGHT JOIN PIA_PISALIQ PIA ON PIS_PIS.PIA_ID = PIA.PIA_ID
                -- COFINS
                         JOIN COF_COFINS COF ON IMP.COF_ID = COF.COFINS_ID
                         RIGHT JOIN CFA_COFINSALIQ CFA ON COF.CFA_ID = CFA.CFA_ID
                -- TABELA ALIQUOTA DIFERENCIADA
                         LEFT JOIN TAD_TAB_ALIQUOTA_DIFERENCIADA TAD ON PRD.PRD_NCM = TAD.TAD_NU_NCM
                WHERE TAD.SITUACAO = 1
                  AND TAD.TAD_ST_SITUACAO = 'ATIVO'
                  AND TO_DATE(TO_CHAR(TO_TIMESTAMP_TZ(IDE.IDE_DH_EMI, 'YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 'YYYY-MM-DD'), 'YYYY-MM-DD') >=
                      TAD.TAD_DT_INICIO_VIGENCIA
                  AND (TO_DATE(TO_CHAR(TO_TIMESTAMP_TZ(IDE.IDE_DH_EMI, 'YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 'YYYY-MM-DD'), 'YYYY-MM-DD') <=
                      TAD.TAD_DT_FIM_VIGENCIA OR TAD.TAD_DT_FIM_VIGENCIA IS NULL )
                GROUP BY IDE.IDE_NNF, PRD.PRD_NCM, PRD.PRD_X_PROD, PIA.PIA_VPIS, CFA.CFA_VCOFINS, PRD.PRD_V_UN_COM, PRD.PRD_Q_COM,
                         PRD.PRD_V_PROD, IDE.IDE_DH_EMI
            """, nativeQuery = true)
    List<TabelaValoresMonofasicosNF> findAllProdutosComMonosfasico();
}
