package com.tcs.certificacion.vivaair.ui_interface;

import net.serenitybdd.screenplay.targets.Target;


public class IngresarDatosReservaPage {
	public  static final Target ORIGEN = Target.the("Ciudad Origen").locatedBy("//*[@id='s2id_departureCityDrop']");
	public static final Target TXTCIUDADORIGEN = Target.the("Campo origen").locatedBy("//input[@id='s2id_autogen20_search']");
	public  static final Target DESTINO = Target.the("Ciudad destino").locatedBy("//div[@id='s2id_arrivalCityDrop']");
	public static final Target TXTCIUDADDESTINO= Target.the("Campo origen").locatedBy("//input[@id='s2id_autogen21_search']");
	public  static final Target NADULTO = Target.the("Numero Adultos").locatedBy("//div[@id='s2id_Adults']");
	public static final Target TXTADULTOS= Target.the("Campo Adultos").locatedBy("//input[@id='s2id_autogen22_search']");
	public  static final Target NINFANTES = Target.the("Numero infantes").locatedBy("//div[@id='s2id_Infants2' and @class='select2-container criteriaSelect selectInfants']");
	public static final Target TXTINFANTES= Target.the("Campo Infantes").locatedBy("//input[@id='s2id_autogen25_search']");
	public  static final Target NNINOS = Target.the("Numero ninos").locatedBy("//div[@id='s2id_Children']");
	public static final Target TXTNINOS= Target.the("Campo ninos").locatedBy("//input[@id='s2id_autogen23_search']");
	public  static final Target MONEDA = Target.the("Tipo de moneda").locatedBy("//div[@id='s2id_Currency']");
	public  static final Target TXTMONEDA = Target.the("Campo  moneda").locatedBy("//input[@id='s2id_autogen15_search']");
	public  static final Target BTNRESERVAR = Target.the("Boton Reservar Vuelo").locatedBy("//a[@id='continueLink']");
	public static final Target FECHACOMPLETA = Target.the("Fecha completa").locatedBy("//*[@data-month='{0}' and @data-year='{1}']//a[contains(text(),'{2}')]");
	public static final Target BTNSIGUIENTE = Target.the("Boton siguiente calendario").locatedBy("//a[@title='Next']");
}
