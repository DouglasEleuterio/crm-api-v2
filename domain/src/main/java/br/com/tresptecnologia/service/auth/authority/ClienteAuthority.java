package br.com.tresptecnologia.service.auth.authority;

public class ClienteAuthority {

    private ClienteAuthority() {
    }

    public static final String CREATE = "Cliente.Adicionar";
    public static final String FETCH = "Cliente.Listar";
    public static final String SEARCH = "Cliente.Consultar";
    public static final String DELETE = "Cliente.Excluir";
}
