package com.tcs.certificacion.vivaair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class MiCompra implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return net.serenitybdd.screenplay.questions.Visibility.of(Target.the("Mi viaje").locatedBy("//*[@class='full']")).viewedBy(actor).asBoolean();
	}
	public static MiCompra apareceEnLaPagina() {
		return new MiCompra();
	}
}
