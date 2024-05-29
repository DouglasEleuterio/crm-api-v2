package br.com.tresptecnologia.service.tabelavaloresmonofasicosnf;

import br.com.tresptecnologia.enumeration.EnumSituacao;
import br.com.tresptecnologia.model.tabelavaloresmonofasicosnf.TabelaValoresMonofasicosNF;
import br.com.tresptecnologia.model.xml.InfNFeResponse;
import br.com.tresptecnologia.model.xml.NFeResponse;
import br.com.tresptecnologia.repository.informacoes.InfNFeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TabelaValoresMonofasicosNFService {

    @PersistenceContext
    private EntityManager entityManager;

    private InfNFeRepository infNFeRepository;

    public List<TabelaValoresMonofasicosNF> findAllProdutosComMonosfasico()  {
        List<TabelaValoresMonofasicosNF> resultList = new ArrayList<>();
        List<?> result =  entityManager.createNativeQuery("""
                            SELECT IDE.IDE_NNF as numeroNF,
                                   PRD.PRD_NCM as numeroNCM,
                                   PRD.PRD_X_PROD as nomeProduto,
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
                            -- Tabela Aliquota Diferenciada
                                     LEFT JOIN TAD_TAB_ALIQUOTA_DIFERENCIADA TAD ON PRD.PRD_NCM = TAD.TAD_NU_NCM
                            WHERE TAD.SITUACAO = 1
                              AND TAD.TAD_ST_SITUACAO = 'ATIVO'
                              AND TO_DATE(TO_CHAR(TO_TIMESTAMP_TZ(IDE.IDE_DH_EMI, 'YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 'YYYY-MM-DD'), 'YYYY-MM-DD') >=
                                  TAD.TAD_DT_INICIO_VIGENCIA
                              AND (TO_DATE(TO_CHAR(TO_TIMESTAMP_TZ(IDE.IDE_DH_EMI, 'YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 'YYYY-MM-DD'), 'YYYY-MM-DD') <=
                                  TAD.TAD_DT_FIM_VIGENCIA OR TAD.TAD_DT_FIM_VIGENCIA IS NULL )
                            -- AND PRD_X_PROD = 'COCA-COLA ORIG PT 2L CX06'
                            GROUP BY IDE.IDE_NNF, PRD.PRD_NCM, PRD.PRD_X_PROD, PIA.PIA_VPIS, CFA.CFA_VCOFINS, PRD.PRD_V_UN_COM, PRD.PRD_Q_COM,
                                     PRD.PRD_V_PROD, IDE.IDE_DH_EMI
                        """)
                .getResultList();
        var resultConv = (List<Object[]>) result;
        for (Object[] o : resultConv) {
            resultList.add(TabelaValoresMonofasicosNF.builder()
                    .numeroNF(o[0].toString())
                    .numeroNCM(o[1].toString())
                    .nomeProduto(o[2].toString())
                    .pia_vpis(Double.valueOf(Objects.isNull(o[3]) ? "0" : o[3].toString()))
                    .cfa_vcofins(Double.valueOf(Objects.isNull(o[4]) ? "0" : o[4].toString()))
                    .prd_v_un_com(Double.valueOf(Objects.isNull(o[5]) ? "0" : o[5].toString()))
                    .prd_q_com(Double.valueOf(Objects.isNull(o[6]) ? "0" : o[6].toString()))
                    .prd_v_prod(Double.valueOf(Objects.isNull(o[7]) ? "0" : o[7].toString()))
                    .build());
        }

        return resultList;
    }

    public List<NFeResponse> findAllProdutosComMonosfasico() {
        var result = infNFeRepository.getAllProdutosComMonofasicos(EnumSituacao.ATIVO);

        return null;
    }

}
