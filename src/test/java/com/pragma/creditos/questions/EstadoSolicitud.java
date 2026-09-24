package com.pragma.creditos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class EstadoSolicitud implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.receivedBy(actor).jsonPath().getString("estado");
    }

    public static Question<String> deLaSolicitud() {
        return new EstadoSolicitud();
    }
}