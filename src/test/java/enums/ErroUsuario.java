package enums;

public enum ErroUsuario {

    NOME_CAMPO_VAZIO("nome é obrigatório"),
    EMAIL_CAMPO_VAZIO("email é obrigatório"),
    EMAIL_CAMPO_VALOR_INCORRETO("email deve ser um email válido"),
    PASSWORD_CAMPO_VAZIO("password é obrigatório"),
    PASSWORD_CAMPO_VALOR_INCORRETO("password deve ser uma string"),
    ADMINISTRADOR_CAMPO_VAZIO("administrador é obrigatório"),
    ADMINISTRADOR_CAMPO_VALOR_INCORRETO("administrador deve ser 'true' ou 'false'");

    private String tipoErro;

    ErroUsuario(String tipoErro) { this.tipoErro = tipoErro;}

    public String getErroUsuario() { return tipoErro; }

}
