package com.pragma.creditos.steps;


import com.pragma.creditos.models.CreditoData;
import com.pragma.creditos.tasks.SolicitarCredito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.serenitybdd.screenplay.rest.interactions.WaitUntilResponseStatusIs;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {

    @Step("El actor solicita un crédito.")
    public void elActorSolicitaUnCredito(Actor actor, CreditoData creditoData) {
        actor.attemptsTo(
            SolicitarCredito.con(creditoData)
        );
    }

    @Step("El actor verifica que la solicitud de crédito fue creada.")
    public void elActorVerificaQueLaSolicitudDeCreditoFueCreada(Actor actor) {
        actor.attemptsTo(
            Get.resource("/creditos"),
            Ensure.that(Text.of(LastResponse.body()).asString()).contains("Solicitud creada")
        );
    }

    @Step("El actor espera {0} segundos.")
    public void elActorEsperaSegundos(int seconds) {
        actor.attemptsTo(
            WaitUntilResponseStatusIs.ok().forSeconds(seconds)
        );
    }

    @Step("El actor limpia la base de datos.")
    public void elActorLimpiaLaBaseDeDatos(Actor actor) {
        actor.attemptsTo(
            Delete.from("/creditos")
        );
    }
}