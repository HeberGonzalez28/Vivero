package View;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import org.jdesktop.swingx.JXDatePicker;

import BD.SentenciasDetallePedido;
import model.comboEntidadDP;

import javax.swing.JComboBox;

public class PanelVentas extends JPanel {
	public JTextField textidpedido;
	public JComboBox JcomboCodprod;
	public JTextField textCantidad;
	public JTextField textPreciounitario;
	public JTable table;
	public JButton btnAgregarVen;
	public JButton btnModificarVen;
	public JTextField textTotalPagar;
	public JButton btnLimpiarVen;
	
	SentenciasDetallePedido sentven;
	JTextField textIdFact;
	 JLabel lblIdFactura;
	 private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public PanelVentas() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		sentven= new SentenciasDetallePedido();
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblidpedido = new JLabel("Id Pedido");
		lblidpedido.setBounds(204, 57, 112, 14);
		add(lblidpedido);
		
		textidpedido = new JTextField();
		textidpedido.setBounds(204, 76, 179, 20);
		add(textidpedido);
		textidpedido.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblIdproducto = new JLabel("Código Producto");
		lblIdproducto.setBounds(415, 57, 179, 14);
		add(lblIdproducto);
		
		JcomboCodprod = new JComboBox();
		DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(sentven.cargarComboConID("productos", new String[] {"Id_producto","Codigo_Producto"}));
		JcomboCodprod.setModel(modeloCombo);
		JcomboCodprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboEntidadDP cEntidad=(comboEntidadDP)JcomboCodprod.getSelectedItem();
				System.out.println(cEntidad.getIdpro());	
			}
		});
		JcomboCodprod.setBounds(415, 73, 179, 20);
		add(JcomboCodprod);
		
		//Label y TextFiedl Apellido---------------------------------------------------------------------------------
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(617, 54, 112, 14);
		add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(617, 73, 179, 20);
		add(textCantidad);
		
		//Label y TextFiedl DNI---------------------------------------------------------------------------------
		JLabel lblTotaAP = new JLabel("TOTAL A PAGAR");
		lblTotaAP.setBounds(762, 454, 89, 14);
		add(lblTotaAP);
		
		//Label y TextFiedl Telefono---------------------------------------------------------------------------------
		JLabel lblpreciounidad = new JLabel("Precio Unitario");
		lblpreciounidad.setBounds(833, 57, 112, 14);
		add(lblpreciounidad);
		
		textPreciounitario = new JTextField();
		textPreciounitario.setColumns(10);
		textPreciounitario.setBounds(833, 73, 179, 20);
		add(textPreciounitario);
		
		//Botones---------------------------------------------------------------------------------
		btnAgregarVen = new JButton("Agregar");
		btnAgregarVen.setBounds(10, 195, 89, 23);
		add(btnAgregarVen);
		
		btnModificarVen = new JButton("Modificar");
		btnModificarVen.setBounds(146, 195, 89, 23);
		add(btnModificarVen);
		
		//Tabla---------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 229, 1032, 200);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Pedido", "Id Producto", "Cantidad", "Precio Unitario", "SubTotal"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
		table.getColumnModel().getColumn(1).setPreferredWidth(122);
		table.getColumnModel().getColumn(2).setPreferredWidth(123);
		table.getColumnModel().getColumn(3).setPreferredWidth(133);
		table.getColumnModel().getColumn(4).setPreferredWidth(133);
		
		textTotalPagar = new JTextField();
		textTotalPagar.setColumns(10);
		textTotalPagar.setBounds(863, 451, 179, 20);
		add(textTotalPagar);
		
		btnLimpiarVen = new JButton("Limpiar Campos");
		btnLimpiarVen.setBounds(289, 195, 119, 23);
		add(btnLimpiarVen);
		
		textIdFact = new JTextField();
		textIdFact.setEditable(false);
		textIdFact.setColumns(10);
		textIdFact.setBounds(15, 76, 179, 20);
		add(textIdFact);
		
		lblIdFactura = new JLabel("Id Factura");
		lblIdFactura.setBounds(15, 57, 112, 14);
		add(lblIdFactura);
		
		btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Aun en desarrollo");
			}
		});
		btnNewButton.setBounds(617, 471, 89, 23);
		add(btnNewButton);
		
	}

}
