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

public class PanelOficinas extends JPanel {
	public JTextField textcodigooficina;
	public JTextField texttelefono;
	public JTextField textciudad;
	public JTextField textFax;
	public JTextField textdireccion;
	JTextField textEmail;
	public JTable table;
	public JButton btnRegistrarOfi;
	public JButton btnModificarOfi;
	private JLabel lblNewLabel;
	public JButton btnLimpiarOfi;
	

	/**
	 * Create the panel.
	 */
	public PanelOficinas() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oficina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,440);
		setLayout(null);
		
		//Label y TextFiedl ---------------------------------------------------------------------------------
		JLabel lbldireccion = new JLabel("Dirección ");
		lbldireccion.setBounds(218, 122, 103, 14);
		add(lbldireccion);
		
		textcodigooficina = new JTextField();
		textcodigooficina.setColumns(10);
		textcodigooficina.setBounds(10, 78, 179, 20);
		add(textcodigooficina);
		
		//Label y TextFiedl ---------------------------------------------------------------------------------
		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(10, 122, 103, 14);
		add(lbltelefono);
		
		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(10, 137, 179, 20);
		add(texttelefono);
		
		//Label y TextFiedl---------------------------------------------------------------------------------
		JLabel lblValorestimado = new JLabel("Ciudad ");
		lblValorestimado.setBounds(221, 63, 103, 14);
		add(lblValorestimado);
		
		textciudad = new JTextField();
		textciudad.setColumns(10);
		textciudad.setBounds(220, 78, 179, 20);
		add(textciudad);
		
		//Label y TextFiedl ---------------------------------------------------------------------------------
		JLabel lblColindates = new JLabel("Fax");
		lblColindates.setBounds(428, 63, 103, 14);
		add(lblColindates);
		
		textFax = new JTextField();
		textFax.setColumns(10);
		textFax.setBounds(428, 79, 179, 20);
		add(textFax);
		
		//Label y TextFiedl Direccion---------------------------------------------------------------------------------
		JLabel lblcodigo_O = new JLabel("Codigo Oficina");
		lblcodigo_O.setBounds(10, 63, 103, 14);
		add(lblcodigo_O);
		
		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(218, 138, 179, 20);
		add(textdireccion);
		
		//Botones---------------------------------------------------------------------------------
		btnRegistrarOfi = new JButton("Registrar");
		btnRegistrarOfi.setBounds(33, 195, 89, 23);
		add(btnRegistrarOfi);
		
		btnModificarOfi = new JButton("Modificar");
		btnModificarOfi.setBounds(199, 195, 89, 23);
		add(btnModificarOfi);
		
		//Tabla---------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 1032, 172);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Oficina", "Ciudad", "Fax", "Tel\u00E9fono ", "Direcci\u00F3n ", "E-mail"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(195);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(154);
		
		lblNewLabel = new JLabel("Registrar Nueva Oficina");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1032, 20);
		add(lblNewLabel);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(428, 138, 179, 20);
		add(textEmail);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(428, 122, 103, 14);
		add(lblEmail);
		
		btnLimpiarOfi = new JButton("Limpiar Campos");
		btnLimpiarOfi.setBounds(333, 195, 103, 23);
		add(btnLimpiarOfi);
		
	}
}
