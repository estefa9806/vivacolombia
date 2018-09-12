package com.tcs.certificacion.vivaair.ui_interface;

import net.serenitybdd.screenplay.targets.Target;

public class ObtenerDatosVuelos {

	public  static final Target CIUDADVUELO = Target.the("Ciudad del vuelo ").locatedBy("//div[@class='outbound']//div[@class='location']['{1}']");
	public  static final Target ENSAYOVUELO = Target.the(" vuelo ").locatedBy("//div[@class='basketFlight']");
	public  static final Target TARIFASVUELO = Target.the("Tarifas del vuelo ").locatedBy("//div[@class='basketPayment']");
	public  static final Target TOTALVUELO = Target.the("Toral del vuelo ").locatedBy("//div[@class='basketTotal']");
}
