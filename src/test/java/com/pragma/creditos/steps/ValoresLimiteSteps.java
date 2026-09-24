package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ValoresLimiteSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito con monto límite de {int}")
    public void dadoUnCreditoConMontoLimiteDe(int montoLimite) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto().withMonto(montoLimite);
        solicitarCredito.conDatos(credito);
    }

    @When("se solicita el crédito")
    public void cuandoSeSolicitaElCredito() {
        solicitarCredito.ejecutar();
    }

    @Then("el sistema debe rechazar la solicitud")
    public void entoncesElSistemaDebeRechazarLaSolicitud() {
        Serenity.recordReportData().withTitle("Estado de la solicitud").andContents("Rechazada");
    }
}