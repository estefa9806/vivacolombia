package com.tcs.certificacion.vivaair.task;

import static com.tcs.certificacion.vivaair.ui_interface.IngresarDatosReservaPage.BTNSIGUIENTE;
import static com.tcs.certificacion.vivaair.ui_interface.IngresarDatosReservaPage.FECHACOMPLETA;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
public class FechaCalendario implements Task {
	String fecha;
	
	private String dia;
	private String ano;
	private String mes;

	public FechaCalendario(String fecha) {
		String datosFecha[] = fecha.split("/");
		datosFecha[1] = String.valueOf(Integer.parseInt(datosFecha[1]) - 1);
		dia = datosFecha[0];
		mes = datosFecha[1];
		ano = datosFecha[2];
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		while (!Visibility.of(FECHACOMPLETA.of(mes, ano, dia)).viewedBy(actor).asBoolean()) {
			actor.attemptsTo(Click.on(BTNSIGUIENTE));
		}
		actor.attemptsTo(Click.on(FECHACOMPLETA.of(mes, ano, dia)));
	}

	public static FechaCalendario seleccionar(String fecha) {
		return Tasks.instrumented(FechaCalendario.class, fecha);
	}
}
