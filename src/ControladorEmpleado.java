import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

public class ControladorEmpleado implements ActionListener,MouseListener {
	Principal frm;
	SentenciasEmpleado sentemp;
	
	
	public ControladorEmpleado(Principal frm, SentenciasEmpleado sentemp) 
	{
		this.frm = frm;
		this.sentemp = sentemp;
		
		frm.panelempleados.table.setModel (cargarJtable());
		frm.panelempleados.btnRegistrar.addActionListener(this);
		frm.panelempleados.btnModificar.addActionListener(this);
		frm.panelempleados.btnLimpiarEmp.addActionListener(this);
		frm.panelempleados.table.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelempleados.btnRegistrar)
		{
		    Empleado emp= new Empleado(Integer.parseInt(frm.panelempleados.textidempleado.getText()), frm.panelempleados.textDni.getText(),
					frm.panelempleados.textNombre.getText(),frm.panelempleados.textApellidos.getText(),frm.panelempleados.textDomicilio.getText(),
					frm.panelempleados.textTelefono.getText(),frm.panelempleados.textCodigo_Repventas.getText(),frm.panelempleados.textCodigooficina.getText(),
					Integer.parseInt(frm.panelempleados.textIdjefe.getText()),frm.panelempleados.textCargo.getText(),frm.panelempleados.textEmail.getText());
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelempleados.table.getModel();
			
			String fila[]= {emp.getIdempleado()+"",emp.getDni(),emp.getNombre(),emp.getApellidos(),emp.getDomicilio(),emp.getCodigorepventas(),emp.getCodigooficina(),
					emp.getIdjefe()+"",emp.getCargo(),emp.getEmail()};
			
			modelo.addRow(fila);
			
			sentemp.insertar(emp);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelempleados.btnModificar)
		{
			Empleado emp= new Empleado(Integer.parseInt(frm.panelempleados.textidempleado.getText()), frm.panelempleados.textDni.getText(),
					frm.panelempleados.textNombre.getText(),frm.panelempleados.textApellidos.getText(),frm.panelempleados.textDomicilio.getText(),
					frm.panelempleados.textTelefono.getText(),frm.panelempleados.textCodigo_Repventas.getText(),frm.panelempleados.textCodigooficina.getText(),
					Integer.parseInt(frm.panelempleados.textIdjefe.getText()),frm.panelempleados.textCargo.getText(),frm.panelempleados.textEmail.getText());
			
			sentemp.modificar(emp);
			//System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelempleados.btnLimpiarEmp)
		{
			frm.panelempleados.textidempleado.setText("0");
			frm.panelempleados.textDni.setText("");
			frm.panelempleados.textNombre.setText("");
			frm.panelempleados.textApellidos.setText("");
			frm.panelempleados.textDomicilio.setText("");
			frm.panelempleados.textTelefono.setText("");
			frm.panelempleados.textCodigo_Repventas.setText("");
			frm.panelempleados.textCodigooficina.setText("");
			frm.panelempleados.textIdjefe.setText("");
			frm.panelempleados.textCargo.setText("");
			frm.panelempleados.textEmail.setText("");
		}
	 }
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Id", "DNI", "Nombre", "Apellidos", "Domicilio", "Tel\u00E9fono ", "Cod. Rep. Ventas", "Cod. Oficina", "Id Jefe", "Cargo", "Email"};
		DefaultTableModel modelo = new DefaultTableModel(sentemp.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelempleados.table)
		{
			
		int fila=frm.panelempleados.table.getSelectedRow();
		
		frm.panelempleados.textidempleado.setText((String) frm.panelempleados.table.getValueAt(fila, 0));
		frm.panelempleados.textDni.setText((String) frm.panelempleados.table.getValueAt(fila, 1));
		frm.panelempleados.textNombre.setText((String) frm.panelempleados.table.getValueAt(fila, 2));
		frm.panelempleados.textApellidos.setText((String) frm.panelempleados.table.getValueAt(fila, 3));
		frm.panelempleados.textDomicilio.setText((String) frm.panelempleados.table.getValueAt(fila, 4));
		frm.panelempleados.textTelefono.setText((String)frm.panelempleados.table.getValueAt(fila, 5));
		frm.panelempleados.textCodigo_Repventas.setText((String) frm.panelempleados.table.getValueAt(fila, 6));
		frm.panelempleados.textCodigooficina.setText((String) frm.panelempleados.table.getValueAt(fila, 7));
		frm.panelempleados.textIdjefe.setText((String) frm.panelempleados.table.getValueAt(fila, 8));
		frm.panelempleados.textCargo.setText((String) frm.panelempleados.table.getValueAt(fila, 9));
		frm.panelempleados.textEmail.setText((String) frm.panelempleados.table.getValueAt(fila, 10));
		
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelempleados.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentemp.seleccionregistro(),new String[] {
				 "Id", "DNI", "Nombre", "Apellidos", "Domicilio", "Tel\u00E9fono ", "Cod. Rep. Ventas", "Cod. Oficina", "Id Jefe", "Cargo", "Email"
			});
		frm.panelempleados.table.setModel(modelo);
	}

}

