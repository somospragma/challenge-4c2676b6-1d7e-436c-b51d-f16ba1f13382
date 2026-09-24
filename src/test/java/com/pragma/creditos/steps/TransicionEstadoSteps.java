package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class TransicionEstadoSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito en estado {string}")
    public void dadoUnCreditoEnEstado(String estado) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto();
        solicitarCredito.conDatos(credito);
        Serenity.recordReportData().withTitle("Estado inicial").andContents(estado);
    }

    @When("se cambia el estado a {string}")
    public void cuandoSeCambiaElEstadoA(String nuevoEstado) {
        solicitarCredito.cambiarEstado(nuevoEstado);
    }

    @Then("el sistema debe estar en el estado {string}")
    public void entoncesElSistemaDebeEstarEnElEstado(String estadoEsperado) {
        String estadoActual = solicitarCredito.obtenerEstado();
        assertThat(estadoActual).isEqualTo(estadoEsperado);
    }
}