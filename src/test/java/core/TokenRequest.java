package core;


import static net.serenitybdd.rest.RestRequests.*;
import org.json.JSONObject;

public class TokenRequest {

    final static String LOGIN_ENDPOINT = "/login";
    private static ManipulaArquivo manipulaArquivo;

    public static String retornaToken() {
       String url = manipulaArquivo.retornaValorParametros("urlAPI") + LOGIN_ENDPOINT;
       return given()
               .contentType("application/json")
               .body(parametrosBodyRequisicaoToken())
               .when()
               .post(url)
               .then()
               .extract()
               .body()
               .path("authorization")
               .toString();
    }

    private static String parametrosBodyRequisicaoToken() {
        JSONObject parametros = new JSONObject();
        parametros.put("email","fulano@qa.com");
        parametros.put("password","teste");
        return parametros.toString();
    }
}
