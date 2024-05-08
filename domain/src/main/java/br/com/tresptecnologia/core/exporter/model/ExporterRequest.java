package br.com.tresptecnologia.core.exporter.model;

import br.com.tresptecnologia.core.controller.constants.BaseControllerConstants;
import br.com.tresptecnologia.shared.validation.RequiredSize;
import br.com.tresptecnologia.core.exporter.ExporterProperties;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.List;

@Getter
@Setter
public class ExporterRequest {

    @RequiredSize(label = "exporter.title")
    @Parameter(description = "Título do arquivo exportado", required = true)
    private String title;

    @Parameter(description = "Nome do arquivo")
    private String fileName;

    @Parameter(description = BaseControllerConstants.FIND_PAGE_DOC)
    private String search;

    @RequiredSize(label = "exporter.columns")
    @Parameter(description = "Lista das colunas que serão exportadas." +
            "As colunas devem seguir a regra: `column={campo da entidade},{label que será gerada no arquivo}`." +
            "**Exemplo**:" +
            "* `export/pdf?column=nome,Nome da Coluna&column=sigla;Sigla da Coluna`", required = true)
    private List<String> columns;

    private List<ExporterSort> sort;

    private ExporterProperties properties;

    @Getter
    @Setter
    static class ExporterSort {
        String field;
        String order;
    }

    public Sort getSpringSort() {
        if (sort == null) {
            return Sort.by("id").ascending();
        }
        return Sort.by(sort.stream()
                .map(x -> "asc".equals(x.order) ?
                        Sort.Order.asc(x.field) : Sort.Order.desc(x.field))
                .toList());
    }

}
