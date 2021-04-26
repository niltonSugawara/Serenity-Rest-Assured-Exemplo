package stepDefinition.usuarios;

import core.ManipulaArquivo;
import core.Request;
import core.TokenRequest;
import enums.ErroUsuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.RestRequests.*;

public class UsuariosEndpointSteps {

    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Response response;

    final static String USUARIOS_ENDPOINT = "/usuarios";
    final static String CADASTRO_OK = "Cadastro realizado com sucesso";
    private String urlAPIUsuarios;

    @Dado("que possuo a uri da API com endpoint de usuarios")
    public void quePossuoAUriDaAPIComEndpointDeUsuarios() {
       urlAPIUsuarios = manipulaArquivo.retornaValorParametros("urlAPI") + USUARIOS_ENDPOINT;
    }

    @Dado("preencho o body para a requisicao com os parametros {string} {string} {string}")
    public void preenchoOBodyParaARequisicaoComOsParametros(String nome, String password, String administrador) {
        response = given()
                .contentType("application/json")
                .header("Authorization", TokenRequest.retornaToken())
                .body(Request.retornaParametrosBodyUsuario(nome,password,administrador))
                .when()
                .post(urlAPIUsuarios);
    }

    @Entao("valido que o cadstro ocorreu com sucesso")
    public void validoQueOCadstroOcorreuComSucesso() {
        response.then()
                .statusCode(201)
                .assertThat()
                .body("message", Matchers.containsString(CADASTRO_OK));
    }

    @Dado("envio uma requisicao sem nenhum parametro")
    public void envioUmaRequisicaoSemNenhumParametro() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("valido todos os campos obrigatorios")
    public void validoTodosOsCamposObrigatorios() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("envio uma requisicao com parametros invalidos")
    public void envioUmaRequisicaoComParametrosInvalidos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("valido todos os tratamentos dos campos")
    public void validoTodosOsTratamentosDosCampos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
