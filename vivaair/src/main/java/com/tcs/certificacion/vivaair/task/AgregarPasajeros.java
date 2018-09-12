package com.tcs.certificacion.vivaair.task;

import static com.tcs.certificacion.vivaair.ui_interface.AdultosPage.*;



import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AgregarPasajeros implements Task {
	String cantidad_adultos;
String nombre;
String apellidos;
String genero;
String identificacion;
String asistencia;
String correo;
String celular;

	public AgregarPasajeros(String cantidad_adultos,String nombre, String apellidos, String genero, String identificacion, String asistencia,
		String correo, String celular) {
		this.cantidad_adultos =cantidad_adultos;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.genero = genero;
	this.identificacion = identificacion;
	this.asistencia = asistencia;
	this.correo = correo;
	this.celular = celular;
}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		Integer cantidadadulto=Integer.parseInt(cantidad_adultos);
		actor.attemptsTo(Enter.theValue(nombre).into(TXTNOMBRE.of("0")));
		actor.attemptsTo(Enter.theValue(identificacion).into(TXTID.of("0")));
		if(asistencia.equalsIgnoreCase("SI")) {
		actor.attemptsTo(Click.on(CHECKASISTENCIA));
		}
		actor.attemptsTo(Enter.theValue(correo).into(TXTCORREO));
		actor.attemptsTo(Enter.theValue(correo).into(TXTCORREOVERIFICACION));
		actor.attemptsTo(Enter.theValue(celular).into(TXTCELULAR));
		actor.attemptsTo(Enter.theValue(apellidos).into(TXTAPELLIDO.of("0")));
		actor.attemptsTo(Click.on(CBGENERO.of("0")),Click.on(TXTGENERO));
	}
public static AgregarPasajeros deTipoAdulto(String cantidad_adultos,String nombre,
String apellidos,String genero,
String identificacion,String asistencia,
String correo,String celular) {
	return Tasks.instrumented(AgregarPasajeros.class, cantidad_adultos,nombre,apellidos,genero,identificacion,asistencia,correo,celular);
	
}
}
