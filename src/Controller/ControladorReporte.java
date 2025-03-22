package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Main.Principal;
import Main.Reportes;

public class ControladorReporte implements ActionListener {
	Principal frm;
	Reportes sentrep;
	
	
	public ControladorReporte(Principal frm, Reportes sentrep) 
	{
		this.frm = frm;
		this.sentrep = sentrep;
		
		frm.panelreportes.btnRepEmpleados.addActionListener(this);
		frm.panelreportes.btnRepRepCliente.addActionListener(this);
		frm.panelreportes.btnRepPedido.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelreportes.btnRepEmpleados)
		{
			String parametro=JOptionPane.showInputDialog("Ingrese Codigo de Oficina");
			String archivo="reportes/RepEmpleados_Oficina.jasper";
			
		    Reportes reportes = new Reportes();
			reportes.reportesConParametros(archivo,parametro);
		}
		if(e.getSource()==frm.panelreportes.btnRepRepCliente)
		{
			String reporte="reportes/RepClientes.jasper";//url del arcbivo generado por iReport en carpeta
			 Reportes reportes = new Reportes();
				reportes.reportesSinParametros(reporte);
		}
		if(e.getSource()==frm.panelreportes.btnRepPedido)
		{
			String reporte="reportes/RepPedidos.jasper";//url del arcbivo generado por iReport en carpeta
			 Reportes reportes = new Reportes();
				reportes.reportesSinParametros(reporte);
		}
			
	 }

}

