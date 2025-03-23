package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import BD.SentenciasPedido;
import Main.Principal;
import Model.Pedido;

public class ControladorPedido implements ActionListener,MouseListener {
	Principal frm;
	SentenciasPedido sentped;
	
	
	public ControladorPedido(Principal frm, SentenciasPedido sentped) 
	{
		this.frm = frm;
		this.sentped = sentped;
		
		frm.panelpedidos.table.setModel (cargarJtable());
		frm.panelpedidos.btnAgregarPed.addActionListener(this);
		frm.panelpedidos.btnModificarPed.addActionListener(this);
		frm.panelpedidos.btnLimpiarPed.addActionListener(this);
		frm.panelpedidos.table.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==frm.panelpedidos.btnAgregarPed)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(frm.panelpedidos.datePickerFechaP.getDate());
			String strDate1 = dateFormat.format(frm.panelpedidos.datePickerFechaEsp.getDate());
			String strDate2 = dateFormat.format(frm.panelpedidos.datePickerFechaEnt.getDate());
			
			Pedido pe= new Pedido(Integer.parseInt(frm.panelpedidos.textidpedido.getText()),strDate,strDate1,strDate2,frm.panelpedidos.comboBoxEstado.getSelectedItem().toString(),
					frm.panelpedidos.textDescrip.getText(),Integer.parseInt(frm.panelpedidos.textIdcliente.getText()));
		    
			DefaultTableModel modelo= (DefaultTableModel)frm.panelpedidos.table.getModel();
			
			String fila[]= {pe.getIdpedido()+"",pe.getFechaped(),pe.getFechaesp(),pe.getFechaent(),pe.getEstado(),pe.getDescripcion(),pe.getIdcliente()+""};
			
			modelo.addRow(fila);
			
			sentped.insertar(pe);
			System.out.println("Los datos se agrego correctamente");
			cargarTabla();
		}
		if(e.getSource()==frm.panelpedidos.btnModificarPed)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(frm.panelpedidos.datePickerFechaP.getDate());
			String strDate2 = dateFormat.format(frm.panelpedidos.datePickerFechaEsp.getDate());
			String strDate3 = dateFormat.format(frm.panelpedidos.datePickerFechaEnt.getDate());
			
			Pedido pe= new Pedido(Integer.parseInt(frm.panelpedidos.textidpedido.getText()),strDate,strDate2,strDate3,frm.panelpedidos.comboBoxEstado.getSelectedItem().toString(),
					frm.panelpedidos.textDescrip.getText(),Integer.parseInt(frm.panelpedidos.textIdcliente.getText()));
	
			sentped.modificar(pe);
			//System.out.println("Los datos se modificaron correctamente");
			
			cargarTabla();
		}
		if(e.getSource()==frm.panelpedidos.btnLimpiarPed)
		{
			frm.panelpedidos.textidpedido.setText("0");
		    frm.panelpedidos.comboBoxEstado.setSelectedItem("Selecionar");
		    frm.panelpedidos.textDescrip.setText("");
		    frm.panelpedidos.textIdcliente.setText("");
		}
	 }
	public DefaultTableModel cargarJtable(){
		String[] columnas = {"Id Pedido", "Fecha del Pedido", "Fecha Esperada", "Fecha Entrega", "Estado", "Descripcion", "Id Cliente"};
		DefaultTableModel modelo = new DefaultTableModel(sentped.seleccionregistro(),columnas);
		return modelo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frm.panelpedidos.table)
		{
			int fila=frm.panelpedidos.table.getSelectedRow();
			
			String strDate = (String) frm.panelpedidos.table.getValueAt(fila, 1);
			String strDate1 = (String) frm.panelpedidos.table.getValueAt(fila, 2);
			String strDate2 = (String) frm.panelpedidos.table.getValueAt(fila, 3);
			
			Date date, date1,date2;
			
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate1);
				date2 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate2);
				
				frm.panelpedidos.datePickerFechaP.setDate(date);
				frm.panelpedidos.datePickerFechaEsp.setDate(date1);
				frm.panelpedidos.datePickerFechaEnt.setDate(date2);
				
				frm.panelpedidos.textidpedido.setText((String) frm.panelpedidos.table.getValueAt(fila, 0));
			    frm.panelpedidos.comboBoxEstado.setSelectedItem( (String) frm.panelpedidos.table.getValueAt(fila, 4));
			    frm.panelpedidos.textDescrip.setText( (String) frm.panelpedidos.table.getValueAt(fila, 5));
			    frm.panelpedidos.textIdcliente.setText( (String) frm.panelpedidos.table.getValueAt(fila, 6));
			   
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		DefaultTableModel modelo= (DefaultTableModel) frm.panelpedidos.table.getModel();
		 modelo.setRowCount(0);
		 modelo.setDataVector(sentped.seleccionregistro(),new String[] {
				 "Id Pedido", "Fecha del Pedido", "Fecha Esperada", "Fecha Entrega", "Estado", "Descripcion", "Id Cliente"
			});
		frm.panelpedidos.table.setModel(modelo);
	}

}

