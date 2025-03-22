package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Main.Principal;
import model.Venta;
import model.comboEntidadTP;
import BD.SentenciasDetallePedido;

public class ControladorDetallePedido implements ActionListener,MouseListener {
	Principal frm;
	SentenciasDetallePedido sentven;
	
	
	public ControladorDetallePedido(Principal frm, SentenciasDetallePedido sentven) 
	{
		this.frm = frm;
		this.sentven = sentven;
		
		frm.panelventas.table.setModel (cargarJtable());
		frm.panelventas.btnAgregarVen.addActionListener(this);
		frm.panelventas.btnModificarVen.addActionListener(this);
		frm.panelventas.btnLimpiarVen.addActionListener(this);
		frm.panelventas.JcomboCodprod.setModel(cargarCombo());
		frm.panelventas.table.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		

		if(e.getSource()==frm.panelventas.btnAgregarVen)
		{
			comboEntidadTP entidad = (comboEntidadTP) frm.panelproductos.JcomboBoxTproduct.getSelectedItem();
			
			float subtotal = 0,totalpagar = 0;
			
				int cantidad=Integer.parseInt(frm.panelventas.textCantidad.getText());
				float precio=Float.parseFloat(frm.panelventas.textPreciounitario.getText());
				
				subtotal=cantidad*precio;
				totalpagar=subtotal+totalpagar;
				
			
		    Venta ven= new Venta(Integer.parseInt(frm.panelventas.textidpedido.getText()),entidad.getIdtpro(),
		    		Integer.parseInt(frm.panelventas.textCantidad.getText()), Float.parseFloat(frm.panelventas.textPreciounitario.getText()),
		    		subtotal);
		    
		    //frm.panelventas.textTotalPagar.setText(String.valueOf(totalpagar));
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelventas.table.getModel();
			
			String fila[]= {ven.getIdpedido()+"",ven.getIdproducto()+"",ven.getCantidad()+"",ven.getPreciounidad()+"",ven.getSubtotal()+""};
			
			modelo.addRow(fila);
			
			sentven.insertar(ven);
			//sentven.suma(null);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
			//calculos();
	  
			//sentven.eliminar(ven);
			//totalPagar();

		}
		if(e.getSource()==frm.panelventas.btnModificarVen)
		{
			comboEntidadTP entidad = (comboEntidadTP) frm.panelproductos.JcomboBoxTproduct.getSelectedItem();
			
			int cantidad=Integer.parseInt(frm.panelventas.textCantidad.getText());
			float precio=Float.parseFloat(frm.panelventas.textPreciounitario.getText());
			
			float resultado=cantidad*precio;
			float totalpagar=resultado+resultado;
			
			Venta ven= new Venta(Integer.parseInt(frm.panelventas.textidpedido.getText()),entidad.getIdtpro(),
		    		Integer.parseInt(frm.panelventas.textCantidad.getText()), Float.parseFloat(frm.panelventas.textPreciounitario.getText()),
		    		resultado);
		    
			sentven.modificar(ven);
			System.out.println("Los datos se modificaron correctamente");
			
			cargarTabla();
		}
		if(e.getSource()==frm.panelventas.btnLimpiarVen)
		{
			frm.panelventas.textidpedido.setText("");
		    frm.panelventas.textCantidad.setText("");
		    frm.panelventas.textPreciounitario.setText("");
		    frm.panelventas.textTotalPagar.setText("");
		}
	 }
	public DefaultTableModel cargarJtable(){
		String columnas[] = {"Id Pedido", "Id Producto", "Cantidad", "Precio Unitario", "SubTotal"};
		DefaultTableModel modelo = new DefaultTableModel(sentven.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelventas.table)
		{
			
		int fila=frm.panelventas.table.getSelectedRow();
		
			frm.panelventas.textidpedido.setText((String) frm.panelventas.table.getValueAt(fila, 0));
		    frm.panelventas.JcomboCodprod.setSelectedItem( (String) frm.panelventas.table.getValueAt(fila, 1));
		    frm.panelventas.textCantidad.setText( (String) frm.panelventas.table.getValueAt(fila, 2));
		    frm.panelventas.textPreciounitario.setText( (String) frm.panelventas.table.getValueAt(fila, 3));
		    frm.panelventas.textTotalPagar.setText( (String) frm.panelventas.table.getValueAt(fila, 4));
		    
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelventas.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentven.seleccionregistro(),new String[] {
				 "Id Pedido", "Id Producto", "Cantidad", "Precio Unitario", "SubTotal"
			});
		frm.panelventas.table.setModel(modelo);
	}
	public DefaultComboBoxModel cargarCombo() 
	{
		DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(sentven.cargarComboConID("productos", new String[] {"Id_producto","Codigo_Producto"}));
		return modeloCombo;
	}
	/*public void calculos()
	{
		float subtotal[] = null;
		float totalpagar=0;
		int cantidadItems=frm.panelventas.table.getRowCount();
		
		for(int i=0;i<cantidadItems;i++)
		{
			subtotal[i]=Float.parseFloat((String) frm.panelventas.table.getValueAt(i,5));
			totalpagar=totalpagar+subtotal[i];
		}
		
		frm.panelventas.textTotalPagar.setText(String.valueOf(totalpagar));
		
	}*/

}

