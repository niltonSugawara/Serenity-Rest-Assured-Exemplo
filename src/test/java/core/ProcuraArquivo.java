package core;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public abstract class ProcuraArquivo {


    private String nomeArquivo;
    private String parametro;

    String getFileProperties() {
        InputStream inputStream;
        try {
            Properties properties = new Properties();
            String arquivo = this.nomeArquivo;
            inputStream = getClass().getClassLoader().getResourceAsStream(arquivo);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("O arquivo " + arquivo + " não foi encontrado");
            }
            return properties.getProperty(this.parametro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

}
