package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import BD.SentenciasOficina;
import Main.Principal;
import Model.Oficina;

public class ControladorOficina implements ActionListener,MouseListener {
	Principal frm;
	SentenciasOficina sentOfi;
	
	
	public ControladorOficina(Principal frm, SentenciasOficina sentOfi) 
	{
		this.frm = frm;
		this.sentOfi = sentOfi;
		
		frm.paneloficinas.table.setModel (cargarJtable());
		frm.paneloficinas.btnRegistrarOfi.addActionListener(this);
		frm.paneloficinas.btnModificarOfi.addActionListener(this);
		frm.paneloficinas.btnLimpiarOfi.addActionListener(this);
		frm.paneloficinas.table.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.paneloficinas.btnRegistrarOfi)
		{
		    Oficina Ofi= new Oficina(frm.paneloficinas.textcodigooficina.getText(),frm.paneloficinas.textciudad.getText(),frm.paneloficinas.textFax.getText(),
		    		frm.paneloficinas.texttelefono.getText(),frm.paneloficinas.textdireccion.getText(),frm.paneloficinas.textEmail.getText());
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.paneloficinas.table.getModel();
			
			String fila[]= {Ofi.getCodigooficina(),Ofi.getCiudad(),Ofi.getFax(), Ofi.getTelefono(), Ofi.getDireccion(),Ofi.getEmail()};
			
			modelo.addRow(fila);
			
			sentOfi.insertar(Ofi);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.paneloficinas.btnModificarOfi)
		{
			Oficina Ofi= new Oficina(frm.paneloficinas.textcodigooficina.getText(),frm.paneloficinas.textciudad.getText(),frm.paneloficinas.textFax.getText(),
		    		frm.paneloficinas.texttelefono.getText(),frm.paneloficinas.textdireccion.getText(),frm.paneloficinas.textEmail.getText());
		    
			sentOfi.modificar(Ofi);
			//System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.paneloficinas.btnLimpiarOfi)
		{
			frm.paneloficinas.textcodigooficina.setText("");
			frm.paneloficinas.textciudad.setText("");
			frm.paneloficinas.textFax.setText("");
			frm.paneloficinas.texttelefono.setText("");
			frm.paneloficinas.textdireccion.setText("");
			frm.paneloficinas.textEmail.setText("");
		}
	 }
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Codigo Oficina", "Ciudad", "Fax", "Tel\u00E9fono ", "Direcci\u00F3n ", "E-mail"};
		DefaultTableModel modelo = new DefaultTableModel(sentOfi.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.paneloficinas.table)
		{
			
		int fila=frm.paneloficinas.table.getSelectedRow();
		
		frm.paneloficinas.textcodigooficina.setText((String) frm.paneloficinas.table.getValueAt(fila, 0));
		frm.paneloficinas.textciudad.setText((String) frm.paneloficinas.table.getValueAt(fila, 1));
		frm.paneloficinas.textFax.setText((String) frm.paneloficinas.table.getValueAt(fila, 2));
		frm.paneloficinas.texttelefono.setText((String) frm.paneloficinas.table.getValueAt(fila, 3));
		frm.paneloficinas.textdireccion.setText((String) frm.paneloficinas.table.getValueAt(fila, 4));
		frm.paneloficinas.textEmail.setText((String) frm.paneloficinas.table.getValueAt(fila, 5));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void cargarTabla()
	{
		//Actualiza la tabla con los nuevos datos modificados--------------------------------------
		DefaultTableModel modelo= (DefaultTableModel) frm.paneloficinas.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentOfi.seleccionregistro(),new String[] {
				 "Codigo Oficina", "Ciudad", "Fax", "Tel\u00E9fono ", "Direcci\u00F3n ", "E-mail"
			});
		frm.paneloficinas.table.setModel(modelo);
	}

}

