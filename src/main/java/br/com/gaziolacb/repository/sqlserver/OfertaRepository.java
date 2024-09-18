package br.com.gaziolacb.repository.sqlserver;

import br.com.gaziolacb.entities.key.ServicoKey;
import br.com.gaziolacb.entities.dto.OfertaConsolidadaDTO;
import br.com.gaziolacb.entities.dto.FaixaPrecoDTO;
import br.com.gaziolacb.entities.dto.OfertaDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;

import java.util.*;

@ApplicationScoped
public class OfertaRepository implements PanacheRepository<OfertaDTO> {

    public List<OfertaConsolidadaDTO> buscarServicosTecnicos() {
        String tipo = "SELECT 'SERVICO_TECNICO' AS TIPO, ";
        String joins = getJoinsServicoTecnico();
        String whereClause = "A.CD_EMPGCB = 21 AND A.CD_TIPSRV = 3";
        return buscarOfertas(tipo, joins, whereClause, false);
    }

    public List<OfertaConsolidadaDTO> buscarServicosTecnicosDiario() {
        String tipo = "SELECT 'SERVICO_TECNICO' AS TIPO, ";
        String joins = getJoinsServicoTecnico();
        String whereClause = "A.CD_EMPGCB = 21 AND A.CD_TIPSRV = 3 AND (B.EVENT_TIMESTAMP > '2024-09-16 13:00:00.0000000' OR C.EVENT_TIMESTAMP > '2024-09-16 13:00:00.0000000')";
        return buscarOfertas(tipo, joins, whereClause, false);
    }

    public List<OfertaConsolidadaDTO> buscarFiqueSeguros() {
        String tipo = "SELECT 'FIQUE_SEGURO' AS TIPO, ";
        String joins = getJoinsFiqueSeguro();
        String whereClause = "A.CD_EMPGCB = 21 AND A.CD_TIPSRV = 2 AND A.CD_CLFSRV = 8";
        return buscarOfertas(tipo, joins, whereClause, false);
    }

    public List<OfertaConsolidadaDTO> buscarFiqueSegurosDiario() {
        String tipo = "SELECT 'FIQUE_SEGURO' AS TIPO, ";
        String joins = getJoinsFiqueSeguro();
        String whereClause = "A.CD_EMPGCB = 21 AND A.CD_TIPSRV = 2 AND A.CD_CLFSRV = 8 AND (B.EVENT_TIMESTAMP > '2024-09-16 13:00:00.0000000' OR C.EVENT_TIMESTAMP > '2024-09-16 13:00:00.0000000')";
        return buscarOfertas(tipo, joins, whereClause, false);
    }

    public List<OfertaConsolidadaDTO> buscarOutrosSeguros() {
        String tipo = "SELECT 'SEGUROS' AS TIPO, ";
        String joins = getJoinsOutrosServicos();
        String whereClause = "A.CD_EMPGCB = 21 AND A.CD_TIPSRV = 2 AND A.CD_CLFSRV <> 8";
        return buscarOfertas(tipo, joins, whereClause, true);
    }

    private List<OfertaConsolidadaDTO> buscarOfertas(String tipo, String joins, String whereClause, boolean isOutrosSeguros) {
        String sql = tipo +
                (isOutrosSeguros ?
                        "B.CD_TIPSGO         AS CODE, " +
                        "B.CD_BND            AS BRAND, " +
                        "B.DS_TIPSGO         AS NAME, " +
                        "D.DS_COSGO          AS DESCRIPTION, " +
                        "D.CD_COSGO          AS CLASSIFICATIONCODE, " +
                        "B.CD_EPSRV          AS SERVICEPROVIDERCODE, " +
                        "12                  AS PERIOD, " +
                        "C.VR_FVSGO_MIN      AS MINSKUPRICE, " +
                        "C.VR_FVSGO_MAX      AS MAXSKUPRICE, " +
                        "C.VR_FPTSGO_CLI     AS PRICE, " +
                        "0                   AS FEE, " +
                        "C.DT_FPTSGO_INI_VIG AS STARTDATE, " +
                        "C.DT_FPTSGO_FIM_VIG AS ENDDATE "
                        :
                        "B.CD_SRVCMC         AS CODE, " +
                        "B.CD_BND            AS BRAND, " +
                        "B.DS_SRVCMC         AS NAME, " +
                        "B.DS_SRVCMC         AS DESCRIPTION, " +
                        "B.CD_SRVCMC         AS CLASSIFICATIONCODE, " +
                        "B.CD_EPSRV          AS SERVICEPROVIDERCODE, " +
                        "B.QT_SRVCMC_MES     AS PERIOD, " +
                        "C.VR_FPCSRV_MIN     AS MINSKUPRICE, " +
                        "C.VR_FPCSRV_MAX     AS MAXSKUPRICE, " +
                        "C.VR_FPCSRV_CLI     AS PRICE, " +
                        "C.TX_FPCSRV_CLI     AS FEE, " +
                        "C.DT_FPCSRV_INI_VIG AS STARTDATE, " +
                        "C.DT_FPCSRV_FIM_VIG AS ENDDATE "
                ) +
                "FROM EMP_PRS_TIP_SRV A " +
                joins + " " +
                "WHERE " + whereClause;

        Query query = getEntityManager().createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        List<OfertaDTO> ofertas = new ArrayList<>();

        for (Object[] result : results) {
            String[] processedStrings = processString((String) result[3]);
            OfertaDTO dto = new OfertaDTO(
                    (String) result[0],  // tipo
                    ((Number) result[1]).intValue(),  // externalCode
                    ((Number) result[2]).intValue(),  // brand
                    (String) result[3],  // name
                    processedStrings[1],  // description
                    ((Number) result[5]).intValue(),  // classificationCode
                    ((Number) result[6]).intValue(),  // serviceProviderCode
                    ((Number) result[7]).intValue(),  // period
                    (Float) result[8],  // minSkuPrice
                    (Float) result[9],  // maxSkuPrice
                    (Float) result[10], // price
                    (isOutrosSeguros ? null : (Float) result[11]), // fee (0 for seguro)
                    result[12] != null ? result[12].toString() : null, // startDate
                    result[13] != null ? result[13].toString() : null  // endDate
            );
            ofertas.add(dto);
        }

        return consolidarServicosSeguros(ofertas);
    }

    public List<OfertaConsolidadaDTO> consolidarServicosSeguros(List<OfertaDTO> servicosDTO) {
        Map<ServicoKey, OfertaConsolidadaDTO> consolidadoMap = new LinkedHashMap<>();

        for (OfertaDTO dto : servicosDTO) {
            ServicoKey key = new ServicoKey(dto.getExternalCode(), dto.getBrand(), dto.getTipo().equals("SEGUROS") ? dto.getClassificationCode() : 0);

            // Verifica se a chave já existe no mapa
            if (!consolidadoMap.containsKey(key)) {
                // Se não existe, cria uma nova lista de faixas
                List<FaixaPrecoDTO> faixas = new ArrayList<>();
                FaixaPrecoDTO novaFaixa = new FaixaPrecoDTO(
                        dto.getMinSkuPrice(),
                        dto.getMaxSkuPrice(),
                        dto.getPrice(),
                        dto.getFee(),
                        dto.getStartDate(),
                        dto.getEndDate()
                );
                faixas.add(novaFaixa);

                // Cria o DTO consolidado e o adiciona ao mapa
                OfertaConsolidadaDTO consolidado = new OfertaConsolidadaDTO(
                        dto.getTipo(),
                        dto.getExternalCode(),
                        dto.getBrand(),
                        dto.getName(),
                        dto.getDescription(),
                        dto.getClassificationCode(),
                        dto.getServiceProviderCode(),
                        dto.getPeriod(),
                        faixas,
                        dto.getFee(),
                        dto.getStartDate(),
                        dto.getEndDate()
                );
                consolidadoMap.put(key, consolidado);
            } else {
                // Se já existe, adiciona a nova faixa ao DTO existente
                OfertaConsolidadaDTO consolidado = consolidadoMap.get(key);
                FaixaPrecoDTO novaFaixa = new FaixaPrecoDTO(
                        dto.getMinSkuPrice(),
                        dto.getMaxSkuPrice(),
                        dto.getPrice(),
                        dto.getFee(),
                        dto.getStartDate(),
                        dto.getEndDate()
                );

                // Verifica se a faixa já existe na lista de faixas
                boolean faixaExistente = consolidado.getFaixasDePreco().stream().anyMatch(f -> f.equals(novaFaixa));
                if (!faixaExistente) {
                    consolidado.getFaixasDePreco().add(novaFaixa);
                }
            }
        }
        return new ArrayList<>(consolidadoMap.values());
    }

    public String getJoinsServicoTecnico() {
        String joins = "INNER JOIN SRV_CMC B ON B.CD_EMPGCB = A.CD_EMPGCB " +
                "AND B.CD_BND = A.CD_BND " +
                "AND B.CD_EPSRV = A.CD_EPSRV " +
                "AND B.CD_SRVCMC = A.CD_CLFSRV " +
                "AND B.DT_SRVCMC_INI_VIG < CURRENT_DATE " +
                "AND (B.DT_SRVCMC_FIM_VIG IS NULL OR B.DT_SRVCMC_FIM_VIG >= CURRENT_DATE) " +
                "AND B.ST_SRVCMC_SRV_PTD != 'M' " +
                "INNER JOIN FXA_PCO_CMC_SRV C ON C.CD_EMPGCB = B.CD_EMPGCB " +
                "AND C.CD_BND = B.CD_BND " +
                "AND C.CD_EPSRV = B.CD_EPSRV " +
                "AND C.CD_SRVCMC = B.CD_SRVCMC " +
                "AND C.DT_FPCSRV_INI_VIG < CURRENT_DATE " +
                "AND (C.DT_FPCSRV_FIM_VIG IS NULL OR C.DT_FPCSRV_FIM_VIG >= CURRENT_DATE)";
        return joins;
    }

    public String getJoinsFiqueSeguro() {
        String joins = "INNER JOIN SRV_CMC B ON B.CD_EMPGCB = A.CD_EMPGCB " +
                "AND B.CD_BND = A.CD_BND " +
                "AND B.CD_EPSRV = A.CD_EPSRV " +
                "AND B.DT_SRVCMC_INI_VIG < CURRENT_DATE " +
                "AND (B.DT_SRVCMC_FIM_VIG IS NULL OR B.DT_SRVCMC_FIM_VIG >= CURRENT_DATE) " +
                "INNER JOIN FXA_PCO_CMC_SRV C ON C.CD_EMPGCB = B.CD_EMPGCB " +
                "AND C.CD_BND = B.CD_BND " +
                "AND C.CD_EPSRV = B.CD_EPSRV " +
                "AND C.CD_SRVCMC = B.CD_SRVCMC " +
                "AND C.DT_FPCSRV_INI_VIG < CURRENT_DATE " +
                "AND (C.DT_FPCSRV_FIM_VIG IS NULL OR C.DT_FPCSRV_FIM_VIG >= CURRENT_DATE)";
        return joins;
    }

    public String getJoinsOutrosServicos() {
        String joins = "INNER JOIN TIP_SGO B ON B.CD_EMPGCB = A.CD_EMPGCB " +
                "AND B.CD_BND = A.CD_BND " +
                "AND B.CD_EPSRV = A.CD_EPSRV " +
                "AND B.CD_TIPSGO = A.CD_CLFSRV " +
                "INNER JOIN FXA_PCO_TIP_SGO C ON C.CD_EMPGCB = B.CD_EMPGCB " +
                "AND C.CD_BND = B.CD_BND " +
                "AND C.CD_EPSRV = B.CD_EPSRV " +
                "AND C.CD_TIPSGO = B.CD_TIPSGO " +
                "AND C.DT_FPTSGO_FIM_VIG IS NULL " +
                "INNER JOIN CLF_OBJ_SGO D ON D.CD_EMPGCB = C.CD_EMPGCB " +
                "AND D.CD_BND = C.CD_BND " +
                "AND D.CD_EPSRV = C.CD_EPSRV " +
                "AND D.CD_COSGO = C.CD_COSGO";
        return joins;
    }

    public String[] processString(String input) {
        // Remove números da string
        input = input.replaceAll("\\d", "");

        // Se a string contém '-', faz o split e retorna os dois elementos
        if (input.contains("-")) {
            String[] parts = input.split("-");
            return new String[] { parts[0].trim(), parts.length > 1 ? parts[1].trim() : "" };
        }

        // Caso não haja '-', retorna a string sem números em dois campos (por exemplo, para name e description)
        return new String[] { "", input.trim()};
    }

}
