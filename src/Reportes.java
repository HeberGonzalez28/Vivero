import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.view.JasperViewer;

public class Reportes {
	//Metodo para vializar un reporte sin parametros----------------------------------------------
	public void reportesSinParametros(String reporte)
	{
		Conector con = new Conector();//coneccion a la base de datos
		
		try {
		JasperPrint rep=JasperFillManager.fillReport(reporte,null,con.getConexion());
		JasperViewer view = new JasperViewer(rep,false);
		view.setVisible(true);
		
		}catch (JRException e) {
			e.printStackTrace();
		}
	}
	//Metodo para visualizar un reporte con parametros tipo String---------------------------------------------
	public void reportesConParametros(String archivo,String parametro)
	{
		Conector con = new Conector();
		
		try {
		
		Map parametros = new HashMap();
		parametros.put("cod_ofi",parametro);
		
		JasperPrint rep=JasperFillManager.fillReport(archivo,parametros,con.getConexion());
		JasperViewer view = new JasperViewer(rep,false);
		view.setVisible(true);
		
		}catch (JRException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[])
    {
		//Reportes repo = new Reportes();
		//repo.reportesSinParametros("reportes/RepEmpleados.jasper");
		//repo.reportesSinParametros(null);
		//repo.reportesConParametros(null,null);
	}

}

