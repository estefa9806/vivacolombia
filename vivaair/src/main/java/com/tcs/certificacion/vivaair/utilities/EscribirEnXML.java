package com.tcs.certificacion.vivaair.utilities;

import java.io.FileOutputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class EscribirEnXML  {
	   //Se crea la raiz del archivo xml
	public static void escribir( List<String> nombresTabla ) {
    Element root = new Element ("xml");
    Element item = new Element ( "tablaViaje" );
            Element itemCampo = new Element ("Informacionvuelos");
            //Se obtiene el nombre del campo de la tabla
            String nombreCampo = nombresTabla.get(0);
            //Se crea el tag 'nombre'; Se coloca su contenido; Se agrega al tag 'campo'
            Element itemNombre = new Element("VueloIdaYRegreso");
            itemNombre.setText( nombreCampo );
            itemCampo.addContent( itemNombre );
            Element itemTasas = new Element ("Tasas");
            //Se obtiene el nombre del campo de la tabla
            String valorTasas= nombresTabla.get(1);
            //Se crea el tag 'nombre'; Se coloca su contenido; Se agrega al tag 'campo'
            Element itemNombreTasas = new Element("TasasAereoportuarias");
            itemNombreTasas.setText( valorTasas );
            itemTasas.addContent( itemNombreTasas );
            Element itemTotal = new Element ("Total");
            //Se obtiene el nombre del campo de la tabla
            String valorTotal= nombresTabla.get(2);
            //Se crea el tag 'nombre'; Se coloca su contenido; Se agrega al tag 'campo'
            Element itemNombreTotal = new Element("PrecioTotal");
            itemNombreTotal.setText( valorTotal );
            itemTotal.addContent( itemNombreTotal);
            item.addContent( itemCampo );
            item.addContent( itemTasas );
            item.addContent( itemTotal );
            root.addContent ( item );
       

    //Se escribe le archivo xml
    XMLOutputter outputter = new XMLOutputter( Format.getPrettyFormat() );
    try{
        outputter.output ( new Document( root ), new FileOutputStream ( "src/test/resources/DatosViaje.xml" ) );
    } catch (Exception e){ e.getMessage();
    }
    }
}
