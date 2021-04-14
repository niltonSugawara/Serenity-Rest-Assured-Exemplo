package core;

public class ManipulaArquivo extends ProcuraArquivo {

    private final String ARQUIVO_AMBIENTE_PROPERTIES = "ambiente.properties";
    private final String AMBIENTE = "ambiente";

    private String getAmbiente() {
        setNomeArquivo(ARQUIVO_AMBIENTE_PROPERTIES);
        setParametro(AMBIENTE);
        return getFileProperties();
    }

    private String concatenaParametroComAmbiente(String parametroArquivoProperties) {
        return this.getAmbiente() + parametroArquivoProperties;
    }

    public String retornaValorDoParametroAssociadoAoAmbiente(String parametroRequisitado) {
        setNomeArquivo(ARQUIVO_AMBIENTE_PROPERTIES);
        setParametro(concatenaParametroComAmbiente(parametroRequisitado));
        return getFileProperties();
    }

    public String retornaValorParametros(String parametroRequisitado) {
        setNomeArquivo(ARQUIVO_AMBIENTE_PROPERTIES);
        setParametro(parametroRequisitado);
        return getFileProperties();
    }

}
