import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class PanelProductos extends JPanel {
	public JTextField textCodproducto;
	public JComboBox JcomboBoxTproduct;
	public JTextField textDimensiones;
	public JTable table;
	
	public JButton btnRegistrarPro;
	public JButton btnModificarPro;
	
	 JLabel lblRegistrarUnEmpleado;
	 JTextField textProveedor;
	 JLabel lblProveedor;
	 JTextField textNombre;
	 JLabel lblNom;
	 JTextField textCantStock;
	JLabel lblCantStock;
	 JTextField textPrecioventa;
	 JLabel lblPrecioventa;
	 JTextField textPrecioProveedor;
	 JLabel lblPrecioprove;
	 JLabel lblDescripcion;
	 JTextField textDescripcion;
	 public JButton btnLimpiarPro;
	 JButton btnTProudcto;
	 
	 SentenciasProducto sentpro;
	  JLabel lblId;
	  JTextField textIdprod;

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		sentpro = new SentenciasProducto();
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblIdempleado = new JLabel("Codigo Producto");
		lblIdempleado.setBounds(217, 55, 179, 14);
		add(lblIdempleado);
		
		textCodproducto = new JTextField();
		textCodproducto.setBounds(217, 67, 179, 20);
		add(textCodproducto);
		textCodproducto.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblTproducto = new JLabel("Tipo Producto");
		lblTproducto.setBounds(620, 55, 75, 14);
		add(lblTproducto);
		
		JcomboBoxTproduct = new JComboBox();
		DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(sentpro.cargarComboConID("gama_producto", new String[] {"Id_gama","Gama"}));
		JcomboBoxTproduct.setModel(modeloCombo);
		JcomboBoxTproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			comboEntidadTP cEntidad=(comboEntidadTP)JcomboBoxTproduct.getSelectedItem();
			System.out.println(cEntidad.getIdtpro());	
			}
		});
		JcomboBoxTproduct.setBounds(620, 69, 179, 20);
		add(JcomboBoxTproduct);
		
		//Label y TextFiedl Apellido---------------------------------------------------------------------------------
		JLabel lblDimensiones = new JLabel("Dimensiones");
		lblDimensiones.setBounds(824, 55, 75, 14);
		add(lblDimensiones);
		
		textDimensiones = new JTextField();
		textDimensiones.setColumns(10);
		textDimensiones.setBounds(824, 69, 179, 20);
		add(textDimensiones);
		
		//Botones---------------------------------------------------------------------------------
		btnRegistrarPro = new JButton("Registrar");
		btnRegistrarPro.setBounds(29, 238, 89, 23);
		add(btnRegistrarPro);
		
		btnModificarPro = new JButton("Modificar");
		btnModificarPro.setBounds(195, 238, 89, 23);
		add(btnModificarPro);
		
		//Tabla---------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 272, 1032, 257);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Codigo Producto", "Nombre", "Id Tipo Producto", "Dimensiones", "Proveedor", "Descripci\u00F3n ", "Cantidad Stock", "Precio Venta", "Precio Proveedor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(147);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(149);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(109);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(143);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(131);
		table.getColumnModel().getColumn(7).setPreferredWidth(97);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(71);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(94);
		
		lblRegistrarUnEmpleado = new JLabel("Registros de Productos");
		lblRegistrarUnEmpleado.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblRegistrarUnEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUnEmpleado.setBounds(10, 23, 1032, 21);
		add(lblRegistrarUnEmpleado);
		
		textProveedor = new JTextField();
		textProveedor.setColumns(10);
		textProveedor.setBounds(10, 128, 179, 20);
		add(textProveedor);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 114, 75, 14);
		add(lblProveedor);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(418, 67, 179, 20);
		add(textNombre);
		
		lblNom = new JLabel("Nombre");
		lblNom.setBounds(418, 55, 75, 14);
		add(lblNom);
		
		textCantStock = new JTextField();
		textCantStock.setColumns(10);
		textCantStock.setBounds(412, 128, 179, 20);
		add(textCantStock);
		
		lblCantStock = new JLabel("Cantidad Stock");
		lblCantStock.setBounds(412, 114, 108, 14);
		add(lblCantStock);
		
		textPrecioventa = new JTextField();
		textPrecioventa.setColumns(10);
		textPrecioventa.setBounds(617, 128, 179, 20);
		add(textPrecioventa);
		
		lblPrecioventa = new JLabel("Precio Venta");
		lblPrecioventa.setBounds(617, 114, 75, 14);
		add(lblPrecioventa);
		
		textPrecioProveedor = new JTextField();
		textPrecioProveedor.setColumns(10);
		textPrecioProveedor.setBounds(824, 128, 179, 20);
		add(textPrecioProveedor);
		
		lblPrecioprove = new JLabel("Precio Proveedor");
		lblPrecioprove.setBounds(824, 114, 108, 14);
		add(lblPrecioprove);
		
		lblDescripcion = new JLabel("Descripción ");
		lblDescripcion.setBounds(211, 114, 75, 14);
		add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(211, 128, 179, 20);
		add(textDescripcion);
		
		btnLimpiarPro = new JButton("Limpiar Campos");
		btnLimpiarPro.setBounds(336, 238, 113, 23);
		add(btnLimpiarPro);
		
		btnTProudcto = new JButton("Tipo de Producto");
		btnTProudcto.setBounds(841, 238, 154, 23);
		add(btnTProudcto);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 55, 75, 14);
		add(lblId);
		
		textIdprod = new JTextField();
		textIdprod.setEditable(false);
		textIdprod.setText("0");
		textIdprod.setColumns(10);
		textIdprod.setBounds(10, 69, 179, 20);
		add(textIdprod);
		
	}
}
