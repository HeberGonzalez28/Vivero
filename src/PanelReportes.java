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

public class PanelReportes extends JPanel {
	public JButton btnRepEmpleados;
	public JButton btnRepRepCliente;
	 public JButton btnRepPedido;

	/**
	 * Create the panel.
	 */
	public PanelReportes() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reportes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(1052,540);
		setLayout(null);
		
		//Botones---------------------------------------------------------------------------------
		btnRepEmpleados = new JButton("Generar Reporte Empleado");
		btnRepEmpleados.setBounds(10, 58, 195, 23);
		add(btnRepEmpleados);
		
		btnRepRepCliente = new JButton("Generar Reporte Clientes");
		btnRepRepCliente.setBounds(10, 136, 195, 23);
		add(btnRepRepCliente);
		
		btnRepPedido = new JButton("Generar Reporte Pedidos");
		btnRepPedido.setBounds(10, 208, 195, 23);
		add(btnRepPedido);
		
	}
}
