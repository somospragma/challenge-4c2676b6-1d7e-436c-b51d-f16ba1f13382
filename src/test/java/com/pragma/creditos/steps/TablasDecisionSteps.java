package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class TablasDecisionSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito con monto {int} y plazo {int}")
    public void dadoUnCreditoConMontoYPlazo(int monto, int plazo) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto().withMonto(monto).withPlazo(plazo);
        solicitarCredito.conDatos(credito);
    }

    @When("se aplica la tabla de decisión")
    public void cuandoSeAplicaLaTablaDeDecision() {
        solicitarCredito.ejecutar();
    }

    @Then("el sistema debe decidir {string}")
    public void entoncesElSistemaDebeDecidir(String decision) {
        String resultado = solicitarCredito.obtenerResultado();
        assertThat(resultado).isEqualTo(decision);
    }
}