package com.tcs.certificacion.vivaair.stepdefinition;


import static com.tcs.certificacion.vivaair.ui_interface.TomarTiquetesReservaPage.*;
import static com.tcs.certificacion.vivaair.utilities.MyDriver.suDriver;

import java.util.List;
import java.util.Map;

import com.tcs.certificacion.vivaair.interaction.SeleccionarPreciosTiquetes;
import com.tcs.certificacion.vivaair.task.AgregarPasajeros;
import com.tcs.certificacion.vivaair.task.ExportarDatos;
import com.tcs.certificacion.vivaair.task.IngresarDatosReservarVuelo;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class ReservarVueloDefinition {
	public static Actor Estefa;

	@Before
	public void setUp() {
		OnStage.setTheStage(new Cast());
		OnStage.theActorCalled("Estefa");
		OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(suDriver().en("https://www.vivaair.com/co/")));
	}
	@When("^deseo reservar un vuelo ingreso los datos para realizarlo$")
	public void deseoReservarUnVueloIngresoLosDatosParaRealizarlo(List<Map<String,String>> datosreservas) throws Exception {
		OnStage.theActorInTheSpotlight().attemptsTo(	IngresarDatosReservarVuelo.conLosDatos(
			datosreservas.get(0).get("fecha_ida"),
			datosreservas.get(0).get("fecha_regreso"),
			datosreservas.get(0).get("ciudad_origen"),
			datosreservas.get(0).get("ciudad_destino"),
			datosreservas.get(0).get("cantidad_adultos"),
			datosreservas.get(0).get("cantidad_ninos"),
			datosreservas.get(0).get("cantidad_infantes"),
			datosreservas.get(0).get("tipo_moneda")));
		OnStage.theActorInTheSpotlight().remember("tipo_moneda",datosreservas.get(0).get("tipo_moneda"));
		OnStage.theActorInTheSpotlight().remember("cantidad_adultos",datosreservas.get(0).get("cantidad_adultos"));
	}
	
	@When("^deseo reservar el vuelo de ida con el precio mas barato y el de regreso con el mas costoso$")
	public void deseoReservarElVueloDeIdaConElPrecioMasBaratoYElDeRegresoConElMasCostoso() throws Exception {
		OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarPreciosTiquetes.seleccionar(OnStage.theActorInTheSpotlight().sawAsThe("tipo_moneda"),"Menor"));
		OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarPreciosTiquetes.seleccionar(OnStage.theActorInTheSpotlight().sawAsThe("tipo_moneda"),"Mayor"));
		OnStage.theActorInTheSpotlight().wasAbleTo(WaitUntil.the(BTNACEPTAR, isVisible()));
		OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BTNACEPTAR));
	}
	

@When("^deseo ingresar los datos de todos los pasajeros$")
public void deseoIngresarLosDatosDeTodosLosPasajeros(List<Map<String,String>> datospasajeros)  {
	OnStage.theActorInTheSpotlight().attemptsTo(AgregarPasajeros.deTipoAdulto(
			OnStage.theActorInTheSpotlight().sawAsThe("cantidad_adultos"), 
			datospasajeros.get(0).get("nombre"),
			datospasajeros.get(0).get("apellidos"),
			datospasajeros.get(0).get("genero"),
			datospasajeros.get(0).get("identificacion"),
			datospasajeros.get(0).get("asistencia"),
			datospasajeros.get(0).get("correo"),
			datospasajeros.get(0).get("celular")));
}

	@Then("^podre exportar y visualizar los datos de mi vuelo$")
	public void podreExportarYVisualizarLosDatosDeMiVuelo()  {
		OnStage.theActorInTheSpotlight().attemptsTo(ExportarDatos.delVuelo());
	}

}
