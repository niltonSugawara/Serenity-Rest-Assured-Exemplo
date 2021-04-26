package runner.usuarios;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:features/usuarios"},
        glue = {"classpath:stepDefinition"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class UsuariosRunner {
}
