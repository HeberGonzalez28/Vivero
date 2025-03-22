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
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelEmpleados extends JPanel {
	public JTextField textidempleado;
	public JTextField textNombre;
	public JTextField textApellidos;
	public JTable table;
	
	public JButton btnRegistrar;
	public JButton btnModificar;
	
	 JLabel lblRegistrarUnEmpleado;
	 public JTextField textDomicilio;
	 JLabel lblDomicilio;
	 public JTextField textDni;
	 JLabel lblDni;
	 public JTextField textCodigo_Repventas;
	JLabel lblCodigoRepVentas;
	 public JTextField textCodigooficina;
	 JLabel lblCodigoOficina;
	 public JTextField textIdjefe;
	 JLabel lblIdJefe;
	 public JTextField textCargo;
	 JLabel lblCargo;
	 public JTextField textEmail;
	 JLabel lblEmail;
	 JLabel lblTelefono;
	 public JTextField textTelefono;
	 public JButton btnLimpiarEmp;

	/**
	 * Create the panel.
	 */
	public PanelEmpleados() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblIdempleado = new JLabel("Id");
		lblIdempleado.setBounds(10, 55, 75, 14);
		add(lblIdempleado);
		
		textidempleado = new JTextField();
		textidempleado.setEditable(false);
		textidempleado.setText("0");
		textidempleado.setBounds(10, 67, 179, 20);
		add(textidempleado);
		textidempleado.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(413, 55, 75, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(413, 69, 179, 20);
		add(textNombre);
		
		//Label y TextFiedl Apellido---------------------------------------------------------------------------------
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(617, 55, 75, 14);
		add(lblApellido);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(617, 69, 179, 20);
		add(textApellidos);
		
		//Botones---------------------------------------------------------------------------------
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(29, 238, 89, 23);
		add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(195, 238, 89, 23);
		add(btnModificar);
		
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
				"Id", "DNI", "Nombre", "Apellidos", "Domicilio", "Tel\u00E9fono ", "Cod. Rep. Ventas", "Cod. Oficina", "Id Jefe", "Cargo", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(147);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(149);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(141);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(158);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(131);
		table.getColumnModel().getColumn(6).setPreferredWidth(97);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(71);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(56);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(109);
		table.getColumnModel().getColumn(10).setResizable(false);
		table.getColumnModel().getColumn(10).setPreferredWidth(184);
		
		lblRegistrarUnEmpleado = new JLabel("Registros de Empleados");
		lblRegistrarUnEmpleado.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblRegistrarUnEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUnEmpleado.setBounds(10, 23, 1032, 21);
		add(lblRegistrarUnEmpleado);
		
		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(824, 69, 179, 20);
		add(textDomicilio);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(824, 55, 75, 14);
		add(lblDomicilio);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(211, 67, 179, 20);
		add(textDni);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(211, 53, 75, 14);
		add(lblDni);
		
		textCodigo_Repventas = new JTextField();
		textCodigo_Repventas.setColumns(10);
		textCodigo_Repventas.setBounds(211, 128, 179, 20);
		add(textCodigo_Repventas);
		
		lblCodigoRepVentas = new JLabel("Codigo Rep. Ventas");
		lblCodigoRepVentas.setBounds(211, 114, 179, 14);
		add(lblCodigoRepVentas);
		
		textCodigooficina = new JTextField();
		textCodigooficina.setColumns(10);
		textCodigooficina.setBounds(412, 128, 179, 20);
		add(textCodigooficina);
		
		lblCodigoOficina = new JLabel("Codigo Oficina");
		lblCodigoOficina.setBounds(412, 114, 180, 14);
		add(lblCodigoOficina);
		
		textIdjefe = new JTextField();
		textIdjefe.setColumns(10);
		textIdjefe.setBounds(614, 128, 179, 20);
		add(textIdjefe);
		
		lblIdJefe = new JLabel("Id Jefe");
		lblIdJefe.setBounds(614, 114, 179, 14);
		add(lblIdJefe);
		
		textCargo = new JTextField();
		textCargo.setColumns(10);
		textCargo.setBounds(818, 128, 179, 20);
		add(textCargo);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(818, 114, 172, 14);
		add(lblCargo);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 183, 179, 20);
		add(textEmail);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 169, 75, 14);
		add(lblEmail);
		
		lblTelefono = new JLabel("Teléfono ");
		lblTelefono.setBounds(10, 114, 75, 14);
		add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(10, 128, 179, 20);
		add(textTelefono);
		
		btnLimpiarEmp = new JButton("Limpiar Campos");
		btnLimpiarEmp.setBounds(330, 238, 108, 23);
		add(btnLimpiarEmp);
		
	}
}
