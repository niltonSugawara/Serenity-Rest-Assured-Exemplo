package runner.produtos;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:features/login"},
        glue = {"classpath:stepDefinition"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ProdutosRunner {
}
