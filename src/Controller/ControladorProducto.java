package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import BD.SentenciasProducto;
import BD.SentenciasTipoProducto;
import Main.Principal;
import Model.Producto;
import Model.comboEntidadTP;
import View.JFrameTipoProducto;

public class ControladorProducto implements ActionListener,MouseListener {
	Principal frm;
	SentenciasProducto sentpro;
	JFrameTipoProducto frame2;
	SentenciasTipoProducto senttpro;
	
	
	@SuppressWarnings("unchecked")
	public ControladorProducto(Principal frm, SentenciasProducto sentpro) 
	{
		this.frm = frm;
		this.sentpro = sentpro;
		
		frm.panelproductos.table.setModel (cargarJtable());
		frm.panelproductos.btnRegistrarPro.addActionListener(this);
		frm.panelproductos.btnModificarPro.addActionListener(this);
		frm.panelproductos.btnLimpiarPro.addActionListener(this);
		frm.panelproductos.btnTProudcto.addActionListener(this);
		frm.panelproductos.JcomboBoxTproduct.setModel(cargarCombo());
		frm.panelproductos.table.addMouseListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelproductos.btnRegistrarPro)
		{
			comboEntidadTP entidad = (comboEntidadTP) frm.panelproductos.JcomboBoxTproduct.getSelectedItem();
			
		    Producto pro= new Producto(Integer.parseInt(frm.panelproductos.textIdprod.getText()),frm.panelproductos.textCodproducto.getText(), frm.panelproductos.textNombre.getText(),
		    		entidad.getIdtpro(),frm.panelproductos.textDimensiones.getText(),frm.panelproductos.textProveedor.getText(),
					frm.panelproductos.textDescripcion.getText(),Integer.parseInt(frm.panelproductos.textCantStock.getText()),Float.parseFloat(frm.panelproductos.textPrecioventa.getText()),
					Float.parseFloat(frm.panelproductos.textPrecioProveedor.getText()));
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelclientes.table.getModel();
			
			String fila[]= {pro.getIdproducto()+"",pro.getNombre(),pro.getGama(),pro.getDimensiones(),pro.getProveedor(),pro.getDescripcion(),pro.getCantStock()+"",pro.getPrecioventa()+"",pro.getPrecioproveedor()+""};
			
			modelo.addRow(fila);
			
			sentpro.insertar(pro);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelproductos.btnModificarPro)
		{
			comboEntidadTP entidad = (comboEntidadTP) frm.panelproductos.JcomboBoxTproduct.getSelectedItem();
			
			Producto pro= new Producto(Integer.parseInt(frm.panelproductos.textIdprod.getText()),frm.panelproductos.textCodproducto.getText(), frm.panelproductos.textNombre.getText(),
					entidad.getIdtpro(),frm.panelproductos.textDimensiones.getText(),frm.panelproductos.textProveedor.getText(),
					frm.panelproductos.textDescripcion.getText(),Integer.parseInt(frm.panelproductos.textCantStock.getText()),Float.parseFloat(frm.panelproductos.textPrecioventa.getText()),
					Float.parseFloat(frm.panelproductos.textPrecioProveedor.getText()));
			
			sentpro.modificar(pro);
			//System.out.println("Los datos se modificaron correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelproductos.btnLimpiarPro)
		{
			frm.panelproductos.textIdprod.setText("0");
			frm.panelproductos.textCodproducto.setText("");
			frm.panelproductos.textNombre.setText("");
			frm.panelproductos.textDimensiones.setText("");
			frm.panelproductos.textProveedor.setText("");
			frm.panelproductos.textDescripcion.setText("");
			frm.panelproductos.textCantStock.setText("");
			frm.panelproductos.textPrecioventa.setText("");
			frm.panelproductos.textPrecioProveedor.setText("");
		}
		if(e.getSource()==frm.panelproductos.btnTProudcto)
		{
			JFrameTipoProducto frame2 = new JFrameTipoProducto();
			
			SentenciasTipoProducto senttpro=new SentenciasTipoProducto();
			ControladorTipoProducto ctrltpro=new ControladorTipoProducto(frame2,senttpro);
			
			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
		}
	 }
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"ID", "Codigo Producto", "Nombre", "Id Tipo Producto", "Dimensiones", "Proveedor", "Descripci\u00F3n ", "Cantidad Stock", "Precio Venta", "Precio Proveedor"};
		DefaultTableModel modelo = new DefaultTableModel(sentpro.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelproductos.table)
		{
			
		int fila=frm.panelproductos.table.getSelectedRow();
		
		frm.panelproductos.textIdprod.setText((String) frm.panelproductos.table.getValueAt(fila, 0));
		frm.panelproductos.textCodproducto.setText((String) frm.panelproductos.table.getValueAt(fila, 1));
		frm.panelproductos.textNombre.setText((String) frm.panelproductos.table.getValueAt(fila, 2));
		frm.panelproductos.JcomboBoxTproduct.setSelectedItem((String)frm.panelproductos.table.getValueAt(fila, 3));
		frm.panelproductos.textDimensiones.setText((String) frm.panelproductos.table.getValueAt(fila, 4));
		frm.panelproductos.textProveedor.setText((String) frm.panelproductos.table.getValueAt(fila, 5));
		frm.panelproductos.textDescripcion.setText((String) frm.panelproductos.table.getValueAt(fila, 6));
		frm.panelproductos.textCantStock.setText((String) frm.panelproductos.table.getValueAt(fila, 7));
		frm.panelproductos.textPrecioventa.setText((String) frm.panelproductos.table.getValueAt(fila, 8));
		frm.panelproductos.textPrecioProveedor.setText((String) frm.panelproductos.table.getValueAt(fila, 9));
		
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelproductos.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentpro.seleccionregistro(),new String[] {
				 "ID", "Codigo Producto", "Nombre", "Id Tipo Producto", "Dimensiones", "Proveedor", "Descripci\u00F3n ", "Cantidad Stock", "Precio Venta", "Precio Proveedor"
			});
		frm.panelproductos.table.setModel(modelo);
	}
	public DefaultComboBoxModel cargarCombo() 
	{
		DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(sentpro.cargarComboConID("gama_producto", new String[] {"Id_gama","Gama"}));
		return modeloCombo;
	}

}

