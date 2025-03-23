package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Main.Principal;
import Model.Cliente;
import BD.SentenciasCliente;
import View.PanelClientes;

public class ControladorCliente implements ActionListener, MouseListener {
	Principal frm;
	SentenciasCliente sentcli;
	
	
	public ControladorCliente(Principal frm, SentenciasCliente sentcli) 
	{
		this.frm = frm;
		this.sentcli = sentcli;
		
		frm.panelclientes.table.setModel (cargarJtable());
		frm.panelclientes.btnRegistrarCli.addActionListener(this);
		frm.panelclientes.btnModificarCli.addActionListener(this);
		frm.panelclientes.btnLimpiarCli.addActionListener(this);
		frm.panelclientes.table.addMouseListener(this);
		//frm.panelclientes.cbciudad.setModel(cargarCombo());
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelclientes.btnRegistrarCli)
		{
		    Cliente cli= new Cliente(Integer.parseInt(frm.panelclientes.textidcliente.getText()), frm.panelclientes.textnombrecliente.getText(),
					frm.panelclientes.textnombrecont.getText(), frm.panelclientes.textapellidoscont.getText(), frm.panelclientes.textrtn.getText(),
					frm.panelclientes.texttelefono.getText(),frm.panelclientes.textFax.getText(),frm.panelclientes.textdireccion.getText(),frm.panelclientes.textCodigoPostal.getText(),
					frm.panelclientes.textRVenta.getText(),Float.parseFloat(frm.panelclientes.textCredito.getText()));
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelclientes.table.getModel();
			
			String fila[]= {cli.getIdcliente()+"",cli.getNombrecli(),cli.getNombrecont(),cli.getApellidocont(),cli.getRtn(),cli.getTelefono(),cli.getFax(),cli.getDireccion(),cli.getCodigopostal(),cli.getCodigorepreventas()+"",cli.getCredito()+""};
			
			modelo.addRow(fila);
			
			sentcli.insertar(cli);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
			
		}
		if(e.getSource()==frm.panelclientes.btnModificarCli)
		{
			Cliente cli= new Cliente(Integer.parseInt(frm.panelclientes.textidcliente.getText()), frm.panelclientes.textnombrecliente.getText(),
					frm.panelclientes.textnombrecont.getText(), frm.panelclientes.textapellidoscont.getText(), frm.panelclientes.textrtn.getText(),
					frm.panelclientes.texttelefono.getText(),frm.panelclientes.textFax.getText(),frm.panelclientes.textdireccion.getText(),frm.panelclientes.textCodigoPostal.getText(),
					frm.panelclientes.textRVenta.getText(),Float.parseFloat(frm.panelclientes.textCredito.getText()));
			
			sentcli.modificar(cli);
			System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelclientes.btnLimpiarCli)
		{
			frm.panelclientes.textidcliente.setText("0");
			frm.panelclientes.textnombrecliente.setText("");
			frm.panelclientes.textnombrecont.setText("");
			frm.panelclientes.textapellidoscont.setText("");
			frm.panelclientes.textrtn.setText("");
			frm.panelclientes.texttelefono.setText("");
			frm.panelclientes.textFax.setText("");
			frm.panelclientes.textdireccion.setText("");
			frm.panelclientes.textCodigoPostal.setText("");
			frm.panelclientes.textRVenta.setText("");
			frm.panelclientes.textCredito.setText("");
		}
		
	 }
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Id", "Nombre Cliente / Empresesa", "Nombre Contacto", "Apellidos Contacto", "RTN", "Tel\u00E9fono ", "Fax", "Direcci\u00F3n ", "Codigo Postal", "Id Rep. Ventas", "Cr\u00E9dito "};
		DefaultTableModel modelo = new DefaultTableModel(sentcli.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelclientes.table)
		{
			
		int fila=frm.panelclientes.table.getSelectedRow();
		
		frm.panelclientes.textidcliente.setText((String) frm.panelclientes.table.getValueAt(fila, 0));
		frm.panelclientes.textnombrecliente.setText((String) frm.panelclientes.table.getValueAt(fila, 1));
		frm.panelclientes.textnombrecont.setText((String) frm.panelclientes.table.getValueAt(fila, 2));
		frm.panelclientes.textapellidoscont.setText((String) frm.panelclientes.table.getValueAt(fila, 3));
		frm.panelclientes.textrtn.setText((String) frm.panelclientes.table.getValueAt(fila, 4));
		frm.panelclientes.texttelefono.setText((String) frm.panelclientes.table.getValueAt(fila, 5));
		frm.panelclientes.textFax.setText((String) frm.panelclientes.table.getValueAt(fila, 6));
		frm.panelclientes.textdireccion.setText((String) frm.panelclientes.table.getValueAt(fila, 7));
		frm.panelclientes.textCodigoPostal.setText((String) frm.panelclientes.table.getValueAt(fila, 8));
		frm.panelclientes.textRVenta.setText((String) frm.panelclientes.table.getValueAt(fila, 9));
		frm.panelclientes.textCredito.setText((String) frm.panelclientes.table.getValueAt(fila, 10));
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelclientes.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentcli.seleccionregistro(),new String[] {
				 "Id", "Nombre Cliente / Empresesa", "Nombre Contacto", "Apellidos Contacto", "RTN", "Tel\u00E9fono ", "Fax", "Direcci\u00F3n ", "Codigo Postal", "Id Rep. Ventas", "Cr\u00E9dito "
			});
		frm.panelclientes.table.setModel(modelo);
	}
	/*public DefaultComboBoxModel cargarCombo()
	{
		DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel(sentcli.cargarComboConID("ciudad", new String[] {"idciudad","nombre"}));
		return modeloCombo;
	}*/

}

