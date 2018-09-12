package com.tcs.certificacion.vivaair.ui_interface;

import net.serenitybdd.screenplay.targets.Target;

public class AdultosPage {
	public  static final Target TXTNOMBRE = Target.the("Nombre del pasajero ").locatedBy("//input[@id='Adults[{0}].FirstName']");
	public static final Target TXTAPELLIDO = Target.the("Apellido Del pasajero").locatedBy("//input[@id='Adults[{0}].LastName']");
	public  static final Target CBGENERO = Target.the("Genero del pasajero").locatedBy("//div[@id='s2id_Adults[{0}].gender']");
	public  static final Target TXTGENERO = Target.the("TXT GENERO").locatedBy("//div[.='Femenino']");
	public static final Target TXTID= Target.the("Id del pasajero").locatedBy("//input[@id='Adults[{0}].IdentificationNumber']");
	public  static final Target CHECKASISTENCIA = Target.the("Asistencia").locatedBy("//label/input[@id='Passengers[0].HandicapYes']");
	public  static final Target TXTCORREO = Target.the("Correo Del pasajero").locatedBy("//input[@id='Passengers[0].email']");
	public  static final Target TXTCORREOVERIFICACION = Target.the("Correo del pasajero").locatedBy("//input[@id='Passengers[0].repeatemail']");
	public  static final Target TXTCELULAR = Target.the("Numero Adultos").locatedBy("//input[@id='Passengers0_mobile']");
}
