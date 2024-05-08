package br.com.tresptecnologia.core.controller.constants;

public final class BaseControllerConstants {

    private BaseControllerConstants() {
    }

    public static final String FIND_COLUMNS_DOC =
            """
                    Define as colunas que serão retornados.
                    """;

    public static final String FIND_PAGE_DOC =
            """
                    Query no padrão **RSQL** para filtragem dos valores.
                     
                    **Sintaxe:**

                    * Iqual : `==`
                    * Negação : `!=`
                    * Maior que : `=lt=` or `<`
                    * Maior que ou igual que : `=le=` or `<=`
                    * Menor que : `=gt=` or `>`
                    * Menor que ou igual que : `=ge=` or `>=`
                    * Em : `=in=`
                    * Não em : `=out=`
                    * Contém : `*valor*`
                                        
                    **Exemplos**:
                    * `search=nome==*a` : a query irá consultar os valores onde o nome inicia com a letra `a`
                    * `search=nome==Teste` : a query irá consultar os valores onde o nome é igual `Teste`
                    * `search=relacao.nome==*teste*` : a query irá consultar os valores onde o nome é igual `Teste`

                    **Observação**:
                    Para entidades que possuem relacionamento, a query irá realizar automaticamente o join caso seja realizada
                    a chamada de acordo `propriedade.valor`. Por exemplo, digamos que temos a entidade `cidade` com o relacionamento
                    `estado`, e desejamos filtrar pelo nome do estado, basta adicionar na query search o valor `estado.nome`, desde modo,
                    a api irá adicionar o join e filtrará os valores pelo nome do estado.
                    """;

}
