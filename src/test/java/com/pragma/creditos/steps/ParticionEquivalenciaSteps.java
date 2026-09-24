package com.pragma.creditos.steps;

import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.questions.EstadoSolicitud;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.then;

public class ParticionEquivalenciaSteps {

    @Step
    public void que_el_sistema_esta_en_funcionamiento() {
        // Inicialización del sistema o contexto necesario
    }

    @Step
    public void cuando_se_ingresan_los_siguientes_datos(Actor actor, String monto, String plazo, String tipoCredito, String perfilSolicitante) {
        actor.attemptsTo(
            SolicitarCredito.conDatos(monto, plazo, tipoCredito, perfilSolicitante)
        );
    }

    @Step
    public void entonces_el_sistema_debe_aprobar_la_solicitud(Actor actor) {
        then(actor).should(Ensure.that(EstadoSolicitud.es()).isEqualTo("Aprobado"));
    }

    @Step
    public void y_se_debe_enviar_una_notificacion_al_solicitante(Actor actor) {
        // Verificación de la notificación
    }

    @Step
    public void entonces_el_sistema_debe_rechazar_la_solicitud(Actor actor) {
        then(actor).should(Ensure.that(EstadoSolicitud.es()).isEqualTo("Rechazado"));
    }

    @Step
    public void y_no_se_debe_enviar_ninguna_notificacion_al_solicitante(Actor actor) {
        // Verificación de la ausencia de notificación
    }
}