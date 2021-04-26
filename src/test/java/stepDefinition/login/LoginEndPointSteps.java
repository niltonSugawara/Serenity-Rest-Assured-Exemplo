package stepDefinition.login;

import core.ManipulaArquivo;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import static net.serenitybdd.rest.RestRequests.*;

public class LoginEndPointSteps {

    private String urlAPILogin;
    private static final String LOGIN_ENDPOINT = "/login";
    final static String LOGIN_SUCESSO = "Login realizado com sucesso";
    final static String ERRO_EMAIL_SENHA = "Email e/ou senha inválidos";
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    JSONObject jsonParametros = new JSONObject();
    Response response;


    @Dado("que possuo a uri da API")
    public void quePossuoAUriDaAPI() {
       urlAPILogin =  manipulaArquivo.retornaValorParametros("urlAPI") + LOGIN_ENDPOINT;
    }

    @Dado("envio a requisicao com {string} e {string}")
    public void envioARequisicaoComE(String email, String senha) {
        jsonParametros.put("email",email);
        jsonParametros.put("password",senha);
        response = given()
                .contentType("application/json")
                .body(jsonParametros.toString())
                .when()
                .post(urlAPILogin);
    }


    @Entao("valido que o usuario existe")
    public void validoQueOUsuarioExiste() {
        response.then()
                .statusCode(200)
                .assertThat()
                .body("message", Matchers.containsString(LOGIN_SUCESSO));
    }

    @Entao("valido que o email esta incorreto")
    public void validoQueOEmailEstaIncorreto() {
        response.then()
                .statusCode(401)
                .assertThat()
                .body("message", Matchers.containsString(ERRO_EMAIL_SENHA));

    }

    @Entao("valido que a senha esta incorreta")
    public void validoQueASenhaEstaIncorreta() {
        response.then()
                .statusCode(401)
                .assertThat()
                .body("message", Matchers.containsString(ERRO_EMAIL_SENHA));
    }


}
