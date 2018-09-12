package com.tcs.certificacion.vivaair.ui_interface;

import net.serenitybdd.screenplay.targets.Target;

public class TomarTiquetesReservaPage {
	public static final Target VALORTIQUETE = Target.the("Valor Tiquete ida").locatedBy("//*[@id='availabilityFirst']//div[@class='totalPrice']//span[1]"); 
	public static final Target VALORTIQUETEREGRESO = Target.the("Valor Tiquete ida").locatedBy("//*[@id='pnlReturn']//div[@class='totalPrice']//span[1]"); 
	public static final Target SELECCIONARTIQUETEIDA = Target.the("selecionar Tiquete ida").locatedBy("//*[@id='availabilityFirst']//div[@class='totalPrice']//span[text()='{0}']");
	public static final Target SELECCIONARTIQUETEREGRESO = Target.the("selecionar Tiquete ida").locatedBy("//*[@id='pnlReturn']//div[@class='totalPrice']//span[text()='{0}']");
public static final Target BTNACEPTAR = Target.the("Boton aceptar").locatedBy("//a[@title='Acepto']");
public static final  Target ESPERA = Target.the("Boton aceptar").locatedBy("//div[@class='product-class-header basic']/span[text()='Viva']");
}
