package com.tcs.certificacion.vivaair.interaction;

import static com.tcs.certificacion.vivaair.ui_interface.TomarTiquetesReservaPage.SELECCIONARTIQUETEIDA;
import static com.tcs.certificacion.vivaair.ui_interface.TomarTiquetesReservaPage.SELECCIONARTIQUETEREGRESO;
import static com.tcs.certificacion.vivaair.ui_interface.TomarTiquetesReservaPage.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
public class SeleccionarPreciosTiquetes implements Interaction {
	String moneda;
String promedio;
	public SeleccionarPreciosTiquetes(String moneda,String promedio) {
		this.moneda=moneda;
		this.promedio=promedio;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		DecimalFormat formateador = new DecimalFormat("###,###.##"); 
		 switch (promedio) {
         case "Menor":
        	 List<String> preciosTiquetes = new ArrayList<>();
     		Comparator<Integer> comparador = Collections.reverseOrder();
     		for (int i=0;i<VALORTIQUETE.resolveAllFor(actor).size();i++) {
     			preciosTiquetes.add(i,VALORTIQUETE.resolveAllFor(actor).get(i).getText().replaceAll(moneda, "").replace(".","").trim());
     		}
     		List<Integer> preciosOrdenados = new ArrayList<>(preciosTiquetes.size());
     		for(String current:preciosTiquetes){
     			preciosOrdenados.add(Integer.parseInt(current));
     			}
     		Collections.sort(preciosOrdenados, comparador);
        	 String valorMenor=(moneda+" "+formateador.format(preciosOrdenados.get(VALORTIQUETE.resolveAllFor(actor).size()-1)));
        		actor.attemptsTo(Click.on(SELECCIONARTIQUETEIDA.of(valorMenor)));
        		break;
         case  "Mayor":
        	 List<String> preciosTiquetesMayor = new ArrayList<>();
     		Comparator<Integer> comparadorMayor = Collections.reverseOrder();
     		for (int i=0;i<VALORTIQUETEREGRESO.resolveAllFor(actor).size();i++) {
     			preciosTiquetesMayor.add(i,VALORTIQUETEREGRESO.resolveAllFor(actor).get(i).getText().replaceAll(moneda, "").replace(".","").trim());
     		}
     		List<Integer> preciosOrdenadosMayor = new ArrayList<>(preciosTiquetesMayor.size());
     		for(String currentMayor:preciosTiquetesMayor){
     			preciosOrdenadosMayor.add(Integer.parseInt(currentMayor));
     			}
     		Collections.sort(preciosOrdenadosMayor, comparadorMayor);
        	 actor.attemptsTo(Click.on(SELECCIONARTIQUETEREGRESO.of(moneda+" "+formateador.format(preciosOrdenadosMayor.get(0)))));
         default: promedio = "Valor Invalido";
                  break;
     }

	}
	public static SeleccionarPreciosTiquetes seleccionar(String moneda,String promedio) {
		return Tasks.instrumented(SeleccionarPreciosTiquetes.class,moneda,promedio);
	}
	

	
}
