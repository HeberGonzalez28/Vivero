package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class JFrameFactura extends JFrame {

	private JPanel contentPane;
	JTextField textIdClient;
	JTextField textCodRepvent;
	 JTable table;
	 JButton btnRegistroTPro;
	 JButton btnModificarTpro;
	 JButton btnLimpiarTpro;
	 JButton btnCerrarTpro;
	 JTextField textIdfact;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFactura frame2 = new JFrameFactura();
					
					//SentenciasTipoProducto senttpro=new SentenciasTipoProducto();
					//ControladorTipoProducto ctrltpro=new ControladorTipoProducto(frame2,senttpro);
					
					frame2.setLocationRelativeTo(null);
					frame2.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameFactura() {
		setUndecorated(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Factura", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("IdCliente");
		lblCliente.setBounds(10, 63, 102, 14);
		contentPane.add(lblCliente);
		
		JLabel lblCodRepvent = new JLabel("Cod. Representante Venta");
		lblCodRepvent.setBounds(10, 94, 129, 14);
		contentPane.add(lblCodRepvent);
		
		textIdClient = new JTextField();
		textIdClient.setEditable(false);
		textIdClient.setBounds(174, 60, 190, 20);
		contentPane.add(textIdClient);
		textIdClient.setColumns(10);
		
		textCodRepvent = new JTextField();
		textCodRepvent.setEditable(false);
		textCodRepvent.setBounds(174, 91, 190, 20);
		contentPane.add(textCodRepvent);
		textCodRepvent.setColumns(10);
		
		btnRegistroTPro = new JButton("Registrar");
		btnRegistroTPro.setBounds(10, 266, 89, 23);
		contentPane.add(btnRegistroTPro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 141, 402, 102);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Factura", "Id Cliente", "N\u00BA de Factura", "Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(148);
		table.getColumnModel().getColumn(2).setPreferredWidth(145);
		
		btnModificarTpro = new JButton("Modificar");
		btnModificarTpro.setBounds(112, 266, 89, 23);
		contentPane.add(btnModificarTpro);
		
		btnLimpiarTpro = new JButton("Limpiar Campos");
		btnLimpiarTpro.setBounds(211, 266, 114, 23);
		contentPane.add(btnLimpiarTpro);
		
		btnCerrarTpro = new JButton("Cerrar");
		btnCerrarTpro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrarTpro.setBounds(335, 266, 89, 23);
		contentPane.add(btnCerrarTpro);
		
		JLabel lblId = new JLabel("Id Factura");
		lblId.setBounds(10, 27, 92, 14);
		contentPane.add(lblId);
		
		textIdfact = new JTextField();
		textIdfact.setEditable(false);
		textIdfact.setText("0");
		textIdfact.setColumns(10);
		textIdfact.setBounds(174, 24, 89, 20);
		contentPane.add(textIdfact);
	}
}
