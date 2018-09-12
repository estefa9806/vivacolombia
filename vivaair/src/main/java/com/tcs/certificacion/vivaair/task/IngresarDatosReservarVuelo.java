package com.tcs.certificacion.vivaair.task;
import static com.tcs.certificacion.vivaair.ui_interface.IngresarDatosReservaPage.*;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
public class IngresarDatosReservarVuelo implements Task {
	private String  fecha_ida;
	private String fecha_regreso;
	private String ciudad_origen;
	private String ciudad_destino;
	private String cantidad_adultos;
	private String cantidad_ninos;
	private String cantidad_infantes;
	private String tipo_moneda;

	public IngresarDatosReservarVuelo(String fecha_ida, String fecha_regreso, String ciudad_origen, String ciudad_destino,
			String cantidad_adultos, String cantidad_ninos, String cantidad_infantes, String tipo_moneda) {
		this.fecha_ida = fecha_ida;
		this.fecha_regreso = fecha_regreso;
		this.ciudad_origen = ciudad_origen;
		this.ciudad_destino = ciudad_destino;
		this.cantidad_adultos = cantidad_adultos;
		this.cantidad_ninos = cantidad_ninos;
		this.cantidad_infantes = cantidad_infantes;
		this.tipo_moneda = tipo_moneda;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ORIGEN),Enter.theValue(ciudad_origen).into(TXTCIUDADORIGEN).thenHit(Keys.ENTER));
		actor.attemptsTo(Click.on(DESTINO),Enter.theValue(ciudad_destino).into(TXTCIUDADDESTINO).thenHit(Keys.ENTER));
		actor.wasAbleTo(FechaCalendario.seleccionar(fecha_ida));
		actor.wasAbleTo(FechaCalendario.seleccionar(fecha_regreso));
		actor.attemptsTo(Click.on(NADULTO),Enter.theValue(cantidad_adultos).into(TXTADULTOS).thenHit(Keys.ENTER));
		actor.attemptsTo(Click.on(NINFANTES),Enter.theValue(cantidad_infantes).into(TXTINFANTES).thenHit(Keys.ENTER));
		actor.attemptsTo(Click.on(NNINOS),Enter.theValue(cantidad_ninos).into(TXTNINOS).thenHit(Keys.ENTER));
		actor.attemptsTo(Click.on(MONEDA),Enter.theValue(tipo_moneda).into(TXTMONEDA).thenHit(Keys.ENTER),Click.on(BTNRESERVAR));
	}
	public static IngresarDatosReservarVuelo conLosDatos(String fecha_ida, String fecha_regreso, String ciudad_origen, String ciudad_destino,
			String cantidad_adultos, String cantidad_ninos, String cantidad_infantes, String tipo_moneda) {
		return Tasks.instrumented(IngresarDatosReservarVuelo.class,fecha_ida, fecha_regreso,ciudad_origen,ciudad_destino,cantidad_adultos,cantidad_ninos,cantidad_infantes,tipo_moneda);
		}
}
