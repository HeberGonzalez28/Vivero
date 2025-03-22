package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import BD.SentenciasUsuario;
import Main.Principal;
import model.Usuario;

public class ControladorUsuario implements ActionListener,MouseListener {
	Principal frm;
	SentenciasUsuario sentusu;
	
	
	public ControladorUsuario(Principal frm, SentenciasUsuario sentusu) 
	{
		this.frm = frm;
		this.sentusu = sentusu;
		
		frm.panelusuarios.table.setModel (cargarJtable());
		frm.panelusuarios.btnAgregar.addActionListener(this);
		frm.panelusuarios.btnModificar.addActionListener(this);
		frm.panelusuarios.btnLimpiarUsu.addActionListener(this);
		frm.panelusuarios.table.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelusuarios.btnAgregar)
		{
		    Usuario usu= new Usuario(Integer.parseInt(frm.panelusuarios.textidusuario.getText()), frm.panelusuarios.textUsuario.getText(),
					frm.panelusuarios.textPassword.getText());
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelclientes.table.getModel();
			
			String fila[]= {usu.getIdusuario()+"",usu.getUsuario(),usu.getPassword()};
			
			modelo.addRow(fila);
			
			sentusu.insertar(usu);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelusuarios.btnModificar)
		{
			Usuario usu= new Usuario(Integer.parseInt(frm.panelusuarios.textidusuario.getText()), frm.panelusuarios.textUsuario.getText(),
					frm.panelusuarios.textPassword.getText());
			
			sentusu.modificar(usu);
			//System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelusuarios.btnLimpiarUsu)
	    {
		frm.panelusuarios.textidusuario.setText("0");
		frm.panelusuarios.textUsuario.setText("");
		frm.panelusuarios.textPassword.setText("");
	    }
	 }
	
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Id", "Usuario", "Password"};
		DefaultTableModel modelo = new DefaultTableModel(sentusu.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelusuarios.table)
		{
			
		int fila=frm.panelusuarios.table.getSelectedRow();
		
		frm.panelusuarios.textidusuario.setText((String) frm.panelusuarios.table.getValueAt(fila, 0));
		frm.panelusuarios.textUsuario.setText((String) frm.panelusuarios.table.getValueAt(fila, 1));
		frm.panelusuarios.textPassword.setText((String) frm.panelusuarios.table.getValueAt(fila, 2));
		
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelusuarios.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentusu.seleccionregistro(),new String[] {
					"Id", "Usuario", "Password"
			});
		frm.panelusuarios.table.setModel(modelo);
	}

}

