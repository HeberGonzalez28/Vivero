package View;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelClientes extends JPanel {
	public JTextField textidcliente;
	public JTextField textnombrecliente;
	public JTextField textapellidoscont;
	public JTextField textrtn;
	public JTextField texttelefono;
	public JTextField textdireccion;
	public JTable table;
	public JButton btnRegistrarCli;
	public JButton btnModificarCli;
	public JLabel lblNombreContacto;
	 public JTextField textnombrecont;
	 JLabel lblFax;
	 public JTextField textFax;
	 JLabel lblCdigoPostal;
	 public JTextField textCodigoPostal;
	 JLabel lblIdRVenta;
	 JLabel lblCredito;
	 public JTextField textRVenta;
	 public JTextField textCredito;
	 JLabel lblRegistrarNuevoCliente;
	 public JButton btnLimpiarCli;

	/**
	 * Create the panel.
	 */
	public PanelClientes() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Id Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 50, 89, 14);
		add(lblNewLabel);
		
		textidcliente = new JTextField();
		textidcliente.setEditable(false);
		textidcliente.setText("0");
		textidcliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textidcliente.setBounds(10, 68, 100, 20);
		add(textidcliente);
		textidcliente.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblNombreCliente = new JLabel("Nombre Cliente / Empresa");
		lblNombreCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreCliente.setBounds(129, 50, 162, 14);
		add(lblNombreCliente);
		
		textnombrecliente = new JTextField();
		textnombrecliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textnombrecliente.setColumns(10);
		textnombrecliente.setBounds(129, 68, 200, 20);
		add(textnombrecliente);
		
		//Label y TextFiedl Apellido---------------------------------------------------------------------------------
		JLabel lblApellidos = new JLabel("Apellidos del Contacto");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(569, 50, 128, 14);
		add(lblApellidos);
		
		textapellidoscont = new JTextField();
		textapellidoscont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapellidoscont.setColumns(10);
		textapellidoscont.setBounds(569, 68, 200, 20);
		add(textapellidoscont);
		
		//Label y TextFiedl DNI---------------------------------------------------------------------------------
		JLabel lblrtn = new JLabel("RTN");
		lblrtn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblrtn.setBounds(10, 99, 49, 14);
		add(lblrtn);
		
		textrtn = new JTextField();
		textrtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrtn.setColumns(10);
		textrtn.setBounds(10, 113, 135, 20);
		add(textrtn);
		
		//Label y TextFiedl Telefono---------------------------------------------------------------------------------
		JLabel lblTelefono = new JLabel("Teléfono ");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefono.setBounds(170, 99, 89, 14);
		add(lblTelefono);
		
		texttelefono = new JTextField();
		texttelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		texttelefono.setColumns(10);
		texttelefono.setBounds(170, 113, 179, 20);
		add(texttelefono);
		
		//Label y TextFiedl Direccion---------------------------------------------------------------------------------
		JLabel lblDireccin = new JLabel("Dirección ");
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDireccin.setBounds(569, 99, 68, 14);
		add(lblDireccin);
		
		textdireccion = new JTextField();
		textdireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textdireccion.setColumns(10);
		textdireccion.setBounds(569, 113, 200, 20);
		add(textdireccion);
		
		//Botones---------------------------------------------------------------------------------
		btnRegistrarCli = new JButton("Registrar");
		btnRegistrarCli.setBounds(10, 249, 89, 23);
		add(btnRegistrarCli);
		
		btnModificarCli = new JButton("Modificar");
		btnModificarCli.setBounds(144, 249, 89, 23);
		add(btnModificarCli);
		
		//Tabla---------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 1032, 233);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre Cliente / Empresesa", "Nombre Contacto", "Apellidos Contacto", "RTN", "Tel\u00E9fono ", "Fax", "Direcci\u00F3n ", "Codigo Postal", "Id Rep. Ventas", "Cr\u00E9dito "
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(157);
		table.getColumnModel().getColumn(2).setPreferredWidth(133);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(162);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(112);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(91);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(205);
		table.getColumnModel().getColumn(8).setPreferredWidth(89);
		table.getColumnModel().getColumn(9).setPreferredWidth(86);
		table.getColumnModel().getColumn(10).setResizable(false);
		table.getColumnModel().getColumn(10).setPreferredWidth(111);
		
		lblNombreContacto = new JLabel("Nombre del Contacto");
		lblNombreContacto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreContacto.setBounds(348, 50, 128, 14);
		add(lblNombreContacto);
		
		textnombrecont = new JTextField();
		textnombrecont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textnombrecont.setColumns(10);
		textnombrecont.setBounds(348, 68, 200, 20);
		add(textnombrecont);
		
		lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFax.setBounds(384, 99, 39, 14);
		add(lblFax);
		
		textFax = new JTextField();
		textFax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFax.setColumns(10);
		textFax.setBounds(384, 113, 135, 20);
		add(textFax);
		
		lblCdigoPostal = new JLabel("Código Postal");
		lblCdigoPostal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigoPostal.setBounds(10, 144, 89, 14);
		add(lblCdigoPostal);
		
		textCodigoPostal = new JTextField();
		textCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCodigoPostal.setColumns(10);
		textCodigoPostal.setBounds(10, 158, 135, 20);
		add(textCodigoPostal);
		
		lblIdRVenta = new JLabel("Codigo Rep. Ventas");
		lblIdRVenta.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdRVenta.setBounds(180, 144, 169, 14);
		add(lblIdRVenta);
		
		lblCredito = new JLabel("Crédito ");
		lblCredito.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCredito.setBounds(384, 144, 105, 14);
		add(lblCredito);
		
		textRVenta = new JTextField();
		textRVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRVenta.setColumns(10);
		textRVenta.setBounds(180, 158, 135, 20);
		add(textRVenta);
		
		textCredito = new JTextField();
		textCredito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCredito.setColumns(10);
		textCredito.setBounds(384, 158, 135, 20);
		add(textCredito);
		
		lblRegistrarNuevoCliente = new JLabel("Registrar Nuevo Cliente");
		lblRegistrarNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarNuevoCliente.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblRegistrarNuevoCliente.setBounds(10, 11, 1032, 20);
		add(lblRegistrarNuevoCliente);
		
		btnLimpiarCli = new JButton("Limpiar Campos");
		btnLimpiarCli.setBounds(281, 249, 116, 23);
		add(btnLimpiarCli);
		
	}
}
