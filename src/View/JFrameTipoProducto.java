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

import BD.SentenciasTipoProducto;
import Controller.ControladorTipoProducto;


import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameTipoProducto extends JFrame {

	private JPanel contentPane;
	public JTextField textTPro;
	public JTextField textDescripcion;
	 public JTable table;
	 public JButton btnRegistroTPro;
	 public JButton btnModificarTpro;
	 public JButton btnLimpiarTpro;
	 JButton btnCerrarTpro;
	 public JTextField textIdTpro;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTipoProducto frame2 = new JFrameTipoProducto();
					
					SentenciasTipoProducto senttpro=new SentenciasTipoProducto();
					ControladorTipoProducto ctrltpro=new ControladorTipoProducto(frame2,senttpro);
					
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
	public JFrameTipoProducto() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registre el Tipo de Producto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoPro = new JLabel("Tipo de Producto");
		lblTipoPro.setBounds(10, 63, 102, 14);
		contentPane.add(lblTipoPro);
		
		JLabel lblDescripcion = new JLabel("Descripción ");
		lblDescripcion.setBounds(10, 94, 102, 14);
		contentPane.add(lblDescripcion);
		
		textTPro = new JTextField();
		textTPro.setBounds(112, 60, 252, 20);
		contentPane.add(textTPro);
		textTPro.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(112, 91, 252, 20);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
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
				"Id", "Tipo Producto", "Descripci\u00F3n "
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(148);
		table.getColumnModel().getColumn(2).setPreferredWidth(379);
		
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
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 27, 92, 14);
		contentPane.add(lblId);
		
		textIdTpro = new JTextField();
		textIdTpro.setEditable(false);
		textIdTpro.setText("0");
		textIdTpro.setColumns(10);
		textIdTpro.setBounds(112, 24, 89, 20);
		contentPane.add(textIdTpro);
	}
}
