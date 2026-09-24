package com.pragma.creditos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import com.pragma.creditos.models.CreditoData;

public class SolicitarCredito implements Task {

    private final CreditoData creditoData;

    public SolicitarCredito(CreditoData creditoData) {
        this.creditoData = creditoData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/creditos").with(request -> request.body(creditoData))
        );
    }

    public static SolicitarCredito conDatos(CreditoData creditoData) {
        return new SolicitarCredito(creditoData);
    }
}