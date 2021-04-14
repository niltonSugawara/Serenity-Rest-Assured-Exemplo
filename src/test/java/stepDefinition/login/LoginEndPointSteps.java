package stepDefinition.login;

import core.ManipulaArquivo;
import enums.ErroUsuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import static net.serenitybdd.rest.RestRequests.*;

public class LoginEndPointSteps {

    private String urlAPIUsuarios;
    private static final String LOGIN_ENDPOINT = "/login";
    final static String LOGIN_SUCESSO = "Login realizado com sucesso";
    ManipulaArquivo manipulaArquivo;
    JSONObject jsonParametros = new JSONObject();


    @Dado("que possuo a uri da API")
    public void quePossuoAUriDaAPI() {
       urlAPIUsuarios =  manipulaArquivo.retornaValorParametros("urlAPI") + LOGIN_ENDPOINT;
    }

    @Dado("envio a requisicao com {string} e {string}")
    public void envioARequisicaoComE(String email, String senha) {
        jsonParametros.put("email",email);
        jsonParametros.put("password",senha);
    }


    @Entao("valido que o usuario existe")
    public void validoQueOUsuarioExiste() {
        given()
                .contentType("application/json")
                .body(jsonParametros.toString())
                .when()
                .post(urlAPIUsuarios)
                .then()
                .statusCode(200)
                .assertThat()
                .body("message", Matchers.containsString(LOGIN_SUCESSO));
    }

    @Dado("envio a requisicao com \"nadaver@qa.com\"e {string}")
    public void envioARequisicaoComNadaverQaComE(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("valido que o email esta incorreto")
    public void validoQueOEmailEstaIncorreto() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("valido que a senha esta incorreta")
    public void validoQueASenhaEstaIncorreta() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
