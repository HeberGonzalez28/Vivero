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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelUsuarios extends JPanel {
	public JTextField textidusuario;
	public JTextField textUsuario;
	public JTextField textPassword;
	public JTable table;
	public JButton btnAgregar;
	public JButton btnModificar;
	public JButton btnLimpiarUsu;

	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblIdusuario = new JLabel("Id");
		lblIdusuario.setBounds(10, 30, 75, 14);
		add(lblIdusuario);
		
		textidusuario = new JTextField();
		textidusuario.setEditable(false);
		textidusuario.setText("0");
		textidusuario.setBounds(10, 42, 179, 20);
		add(textidusuario);
		textidusuario.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 73, 75, 14);
		add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(10, 87, 179, 20);
		add(textUsuario);
		
		//Label y TextFiedl Apellido---------------------------------------------------------------------------------
		JLabel lblpassword = new JLabel("Password ");
		lblpassword.setBounds(225, 73, 75, 14);
		add(lblpassword);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(225, 87, 179, 20);
		add(textPassword);
		
		//Botones---------------------------------------------------------------------------------
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(33, 195, 89, 23);
		add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(199, 195, 89, 23);
		add(btnModificar);
		
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
				"Id", "Usuario", "Password", "Roll"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		
		btnLimpiarUsu = new JButton("Limpiar Campos");
		btnLimpiarUsu.setBounds(341, 195, 106, 23);
		add(btnLimpiarUsu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Agente de venta", "Agente contable"}));
		comboBox.setBounds(461, 86, 133, 22);
		add(comboBox);
		
		JLabel lblroll = new JLabel("Roll");
		lblroll.setBounds(460, 73, 75, 14);
		add(lblroll);
		
	}
}
