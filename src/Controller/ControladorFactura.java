package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import BD.SentenciasTipoProducto;
import Model.Tproducto;
import View.JFrameTipoProducto;

public class ControladorFactura implements ActionListener,MouseListener {
	//Principal frm;
	JFrameTipoProducto frm2;
	SentenciasTipoProducto senttpro;
	
	
	public ControladorFactura(JFrameTipoProducto frm2, SentenciasTipoProducto senttpro) 
	{
		this.frm2 = frm2;
		this.senttpro = senttpro;
		
		frm2.table.setModel(cargarJtable());
		frm2.btnRegistroTPro.addActionListener(this);
	    frm2.btnModificarTpro.addActionListener(this);
		frm2.btnLimpiarTpro.addActionListener(this);
		//frm2.btnCerrarTpro.addActionListener(this);
		frm2.table.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm2.btnRegistroTPro)
		{
		    Tproducto tpro= new Tproducto(Integer.parseInt(frm2.textIdTpro.getText()),frm2.textTPro.getText(),frm2.textDescripcion.getText());
		    
			DefaultTableModel modelo= (DefaultTableModel)frm2.table.getModel();
			
			String fila[]= {tpro.getGama(),tpro.getDescripcion()};
			
			modelo.addRow(fila);
			
			senttpro.insertar(tpro);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm2.btnModificarTpro)
		{
			 Tproducto tpro= new Tproducto(Integer.parseInt(frm2.textIdTpro.getText()),frm2.textTPro.getText(),frm2.textDescripcion.getText());
			 
			senttpro.modificar(tpro);
			//System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm2.btnLimpiarTpro)
		{
			frm2.textTPro.setText("");
			frm2.textDescripcion.setText("");
		}
		
	 }
	

	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Id", "Tipo Producto", "Descripci\u00F3n "};
		DefaultTableModel modelo = new DefaultTableModel(senttpro.seleccionregistrotpro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm2.table)
		{
			
		int fila=frm2.table.getSelectedRow();
		
		frm2.textIdTpro.setText((String) frm2.table.getValueAt(fila, 0));
		frm2.textTPro.setText((String) frm2.table.getValueAt(fila, 1));
		frm2.textDescripcion.setText((String) frm2.table.getValueAt(fila, 2));
			
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
		DefaultTableModel modelo= (DefaultTableModel) frm2.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(senttpro.seleccionregistrotpro(),new String[] {
				 "Id", "Tipo Producto", "Descripci\u00F3n "
			});
		frm2.table.setModel(modelo);
	}

}

