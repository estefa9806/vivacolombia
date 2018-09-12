package com.tcs.certificacion.vivaair.task;

import static com.tcs.certificacion.vivaair.ui_interface.ObtenerDatosVuelos.ENSAYOVUELO;
import static com.tcs.certificacion.vivaair.ui_interface.ObtenerDatosVuelos.TARIFASVUELO;
import static com.tcs.certificacion.vivaair.ui_interface.ObtenerDatosVuelos.TOTALVUELO;

import java.util.ArrayList;
import java.util.List;

import com.tcs.certificacion.vivaair.questions.MiCompra;
import com.tcs.certificacion.vivaair.utilities.EscribirEnXML;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ExportarDatos implements Task {
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.asksFor(MiCompra.apareceEnLaPagina());
	 	 List<String> datosVuelo = new ArrayList<>();
			datosVuelo.add(0,ENSAYOVUELO.resolveAllFor(actor).get(0).getText());
			datosVuelo.add(1,TARIFASVUELO.resolveAllFor(actor).get(0).getText());
			datosVuelo.add(2,TOTALVUELO.resolveAllFor(actor).get(0).getText());
			EscribirEnXML.escribir(datosVuelo);
	}
	
	public static ExportarDatos delVuelo() {
		return Tasks.instrumented(ExportarDatos.class);
		}
}
