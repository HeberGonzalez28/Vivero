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
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelPedidos extends JPanel {
	public JTextField textidpedido;
	public JTable table;
	public JButton btnAgregarPed;
	public JButton btnModificarPed;
	public JTextField textDescrip;
	 JXDatePicker datePickerFechaP;
	 JXDatePicker datePickerFechaEsp;
	 JXDatePicker datePickerFechaEnt;
	 JLabel lblIdCliente;
	 JTextField textIdcliente;
	 JComboBox comboBoxEstado;
	 public JButton btnLimpiarPed;

	/**
	 * Create the panel.
	 */
	public PanelPedidos() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		//Label y TextFiedl Id---------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 58, 65, 14);
		add(lblNewLabel);
		
		textidpedido = new JTextField();
		textidpedido.setText("0");
		textidpedido.setEditable(false);
		textidpedido.setBounds(10, 75, 179, 20);
		add(textidpedido);
		textidpedido.setColumns(10);
		
		//Label y TextFiedl Nombre---------------------------------------------------------------------------------
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 123, 65, 14);
		add(lblEstado);
		
		//Botones---------------------------------------------------------------------------------
		btnAgregarPed = new JButton("Agregar");
		btnAgregarPed.setBounds(33, 195, 89, 23);
		add(btnAgregarPed);
		
		btnModificarPed = new JButton("Modificar");
		btnModificarPed.setBounds(199, 195, 89, 23);
		add(btnModificarPed);
		
		//Tabla---------------------------------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 229, 1032, 300);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Pedido", "Fecha del Pedido", "Fecha Esperada", "Fecha Entrega", "Estado", "Descripcion", "Id Cliente"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(114);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(256);
		table.getColumnModel().getColumn(6).setResizable(false);
		
		JLabel lblF = new JLabel("Fecha del Pedido");
		lblF.setBounds(215, 58, 89, 14);
		add(lblF);
		
		datePickerFechaP = new JXDatePicker();
		datePickerFechaP.setBounds(215, 74, 105, 22);
		add(datePickerFechaP);
		
		JLabel lblFechaEsperada = new JLabel("Fecha Esperada");
		lblFechaEsperada.setBounds(376, 58, 89, 14);
		add(lblFechaEsperada);
		
		datePickerFechaEsp = new JXDatePicker();
		datePickerFechaEsp.setBounds(376, 74, 105, 22);
		add(datePickerFechaEsp);
		
		JLabel lblFechaEntrega = new JLabel("Fecha Entrega");
		lblFechaEntrega.setBounds(555, 58, 89, 14);
		add(lblFechaEntrega);
		
		datePickerFechaEnt = new JXDatePicker();
		datePickerFechaEnt.setBounds(555, 74, 105, 22);
		add(datePickerFechaEnt);
		
		textDescrip = new JTextField();
		textDescrip.setColumns(10);
		textDescrip.setBounds(215, 139, 179, 20);
		add(textDescrip);
		
		JLabel lblDescripcion = new JLabel("Descripción ");
		lblDescripcion.setBounds(215, 123, 65, 14);
		add(lblDescripcion);
		
		lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(441, 123, 65, 14);
		add(lblIdCliente);
		
		textIdcliente = new JTextField();
		textIdcliente.setColumns(10);
		textIdcliente.setBounds(441, 139, 179, 20);
		add(textIdcliente);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"Entregado", "Rechazado", "Pendiente"}));
		comboBoxEstado.setBounds(10, 138, 155, 22);
		add(comboBoxEstado);
		
		btnLimpiarPed = new JButton("Limpiar Campos");
		btnLimpiarPed.setBounds(332, 195, 89, 23);
		add(btnLimpiarPed);
		
	}
}
