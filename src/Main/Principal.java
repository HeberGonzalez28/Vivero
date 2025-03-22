package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import org.jdesktop.swingx.JXTaskPaneContainer;

import BD.SentenciasCliente;
import BD.SentenciasDetallePedido;
import BD.SentenciasEmpleado;
import BD.SentenciasOficina;
import BD.SentenciasPedido;
import BD.SentenciasProducto;
import BD.SentenciasUsuario;
import Controller.ControladorCliente;
import Controller.ControladorDetallePedido;
import Controller.ControladorEmpleado;
import Controller.ControladorOficina;
import Controller.ControladorPedido;
import Controller.ControladorProducto;
import Controller.ControladorReporte;
import Controller.ControladorUsuario;
import View.PanelClientes;
import View.PanelEmpleados;
import View.PanelOficinas;
import View.PanelPedidos;
import View.PanelProductos;
import View.PanelReportes;
import View.PanelUsuarios;
import View.PanelVentas;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXHyperlink;
import javax.swing.JSeparator;

public class Principal extends JFrame {

	private JPanel contentPane;
	public PanelClientes panelclientes;
	public PanelVentas panelventas;
	public PanelOficinas paneloficinas;
	public PanelUsuarios panelusuarios;
	public PanelPedidos panelpedidos;
	public PanelEmpleados panelempleados;
	public PanelProductos panelproductos;
	public PanelReportes panelreportes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					
					SentenciasCliente sentcli=new SentenciasCliente();
					ControladorCliente ctrlcl=new ControladorCliente(frame,sentcli);
					
					SentenciasDetallePedido sentven=new SentenciasDetallePedido();
					ControladorDetallePedido ctrlven=new ControladorDetallePedido(frame,sentven);
					
					SentenciasOficina sentofi=new SentenciasOficina();
					ControladorOficina ctrlof=new ControladorOficina(frame,sentofi);
					
					SentenciasUsuario sentusu=new SentenciasUsuario();
					ControladorUsuario ctrlus=new ControladorUsuario(frame,sentusu);
					
					SentenciasPedido sentped=new SentenciasPedido();
					ControladorPedido ctrlpe=new ControladorPedido(frame,sentped);
					
					SentenciasEmpleado sentemp=new SentenciasEmpleado();
					ControladorEmpleado ctrlem=new ControladorEmpleado(frame,sentemp);
					
					SentenciasProducto sentpro=new SentenciasProducto();
					ControladorProducto ctrlpr=new ControladorProducto(frame,sentpro);
					
					Reportes sentrep=new Reportes();
					ControladorReporte ctrlre=new ControladorReporte(frame,sentrep);
					
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//sentusu = new SentenciasUsuario();
		
		JPanel panelfondo = new JPanel();
		panelfondo.setBackground(new Color(0, 206, 209));
		panelfondo.setBounds(0, 0, 1284, 661);
		contentPane.add(panelfondo);
		
		panelfondo.setLayout(null);
		ImageIcon ico4=new ImageIcon(getClass().getResource("/Imagenes/Vivero_Zoe_logo sin fondo.png"));
		
		JPanel panellateral = new JPanel();
		panellateral.setBackground(new Color(75, 145, 47));
		panellateral.setForeground(Color.BLACK);
		panellateral.setBounds(10, 110, 202, 540);
		panelfondo.add(panellateral);
		panellateral.setLayout(null);
		
		JButton btnventas = new JButton("VENTAS");
		btnventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(true);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnventas.setBounds(81, 23, 111, 23);
		panellateral.add(btnventas);
		
		JButton btnpropiedades = new JButton("OFICINA");
		btnpropiedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(true);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnpropiedades.setBounds(81, 332, 111, 23);
		panellateral.add(btnpropiedades);
		
		JButton btnclientes = new JButton("CLIENTE");
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(true);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnclientes.setBounds(81, 74, 111, 23);
		panellateral.add(btnclientes);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(81, 506, 111, 23);
		panellateral.add(btnNewButton);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(true);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnUsuarios.setBounds(81, 432, 111, 23);
		panellateral.add(btnUsuarios);
		
		JButton btnPedido = new JButton("PEDIDO");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(true);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnPedido.setBounds(81, 125, 111, 23);
		panellateral.add(btnPedido);
		
		JButton btnEmpleados = new JButton("EMPLEADOS");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(true);
				panelproductos.setVisible(false);
				panelreportes.setVisible(false);
			}
		});
		btnEmpleados.setBounds(81, 381, 111, 23);
		panellateral.add(btnEmpleados);
		
		JButton btnReportes = new JButton("REPORTES");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(false);
				panelreportes.setVisible(true);
			}
		});
		btnReportes.setBounds(81, 245, 111, 23);
		panellateral.add(btnReportes);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneloficinas.setVisible(false);
				panelventas.setVisible(false);
				panelclientes.setVisible(false);
				panelusuarios.setVisible(false);
				panelpedidos.setVisible(false);
				panelempleados.setVisible(false);
				panelproductos.setVisible(true);
				panelreportes.setVisible(false);
			}
		});
		btnProductos.setBounds(81, 180, 111, 23);
		panellateral.add(btnProductos);
		
		JLabel lbloficina = new JLabel("");
		lbloficina.setBounds(10, 315, 47, 40);
		ImageIcon ico=new ImageIcon(getClass().getResource("/Imagenes/oficina.png"));
		ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(lbloficina.getWidth(),lbloficina.getHeight(), Image.SCALE_SMOOTH));
		lbloficina.setIcon(img);
		panellateral.add(lbloficina);
		
		JLabel lblventa = new JLabel("");
		lblventa.setBounds(10, 6, 47, 40);
		ImageIcon ico1=new ImageIcon(getClass().getResource("/Imagenes/ventas.png"));
		ImageIcon img1=new ImageIcon(ico1.getImage().getScaledInstance(lblventa.getWidth(),lblventa.getHeight(), Image.SCALE_SMOOTH));
		lblventa.setIcon(img1);
		panellateral.add(lblventa);
		
		JLabel lblclientes = new JLabel("");
		lblclientes.setBounds(10, 57, 47, 40);
		ImageIcon ico2=new ImageIcon(getClass().getResource("/Imagenes/personas.png"));
		ImageIcon img2=new ImageIcon(ico2.getImage().getScaledInstance(lblclientes.getWidth(),lblclientes.getHeight(), Image.SCALE_SMOOTH));
		lblclientes.setIcon(img2);
		panellateral.add(lblclientes);
		
		JLabel lblusuario = new JLabel("");
		lblusuario.setBounds(10, 415, 47, 40);
		ImageIcon ico5=new ImageIcon(getClass().getResource("/Imagenes/usuario.png"));
		ImageIcon img5=new ImageIcon(ico5.getImage().getScaledInstance(lblusuario.getWidth(),lblusuario.getHeight(), Image.SCALE_SMOOTH));
		lblusuario.setIcon(img5);
		
		panellateral.add(lblusuario);
		JLabel lblsalir = new JLabel("");
		lblsalir.setBounds(10, 489, 47, 40);
		ImageIcon ico3=new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		ImageIcon img3=new ImageIcon(ico3.getImage().getScaledInstance(lblsalir.getWidth(),lblsalir.getHeight(), Image.SCALE_SMOOTH));
		lblsalir.setIcon(img3);
		panellateral.add(lblsalir);
		
		JLabel lblpedido = new JLabel("");
		lblpedido.setBounds(10, 108, 47, 40);
		ImageIcon ico6=new ImageIcon(getClass().getResource("/Imagenes/escritura.png"));
		ImageIcon img6=new ImageIcon(ico6.getImage().getScaledInstance(lblpedido.getWidth(),lblpedido.getHeight(), Image.SCALE_SMOOTH));
		lblpedido.setIcon(img6);
		panellateral.add(lblpedido);
		
		JLabel lblempleados = new JLabel("");
		lblempleados.setBounds(10, 364, 47, 40);
		ImageIcon ico7=new ImageIcon(getClass().getResource("/Imagenes/empleados.png"));
		ImageIcon img7=new ImageIcon(ico7.getImage().getScaledInstance(lblempleados.getWidth(),lblempleados.getHeight(), Image.SCALE_SMOOTH));
		lblempleados.setIcon(img7);
		panellateral.add(lblempleados);
		
		JLabel lblreporte = new JLabel("");
		lblreporte.setBounds(10, 228, 47, 40);
		ImageIcon ico8=new ImageIcon(getClass().getResource("/Imagenes/reportes.png"));
		ImageIcon img8=new ImageIcon(ico8.getImage().getScaledInstance(lblreporte.getWidth(),lblreporte.getHeight(), Image.SCALE_SMOOTH));
		lblreporte.setIcon(img8);
		panellateral.add(lblreporte);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 295, 182, 2);
		panellateral.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 466, 182, 12);
		panellateral.add(separator_1);
		
		JLabel lblproducto = new JLabel("");
		lblproducto.setBounds(10, 163, 47, 40);
		ImageIcon ico9=new ImageIcon(getClass().getResource("/Imagenes/producto.png"));
		ImageIcon img9=new ImageIcon(ico9.getImage().getScaledInstance(lblproducto.getWidth(),lblproducto.getHeight(), Image.SCALE_SMOOTH));
		lblproducto.setIcon(img9);
		panellateral.add(lblproducto);
		
		JButton btnManual = new JButton("MANUAL");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     File path = new File ("reportes/Manual de Usuario Viveros Zoe.pdf");
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
			}
		});
		btnManual.setBounds(81, 472, 111, 23);
		panellateral.add(btnManual);
		
		
		panelventas = new PanelVentas();
		panelventas.setBounds(222, 110, 1052, 540);
		panelventas.setVisible(true);
		panelfondo.add(panelventas);
		
		paneloficinas = new PanelOficinas();
		paneloficinas.setBounds(222, 110, 1052, 540);
		paneloficinas.setVisible(false);
		panelfondo.add(paneloficinas);
		
		panelclientes = new PanelClientes();
		panelclientes.setBounds(222, 110, 1052, 540);
		panelclientes.setVisible(false);
		panelfondo.add(panelclientes);
		
		panelpedidos = new PanelPedidos();
		panelpedidos.setBounds(222, 110, 1052, 540);
		panelpedidos.setVisible(false);
		panelfondo.add(panelpedidos);
		
		panelusuarios = new PanelUsuarios();
		panelusuarios.setBounds(222, 110, 1052, 540);
		panelusuarios.setVisible(false);
		panelfondo.add(panelusuarios);
		
		panelempleados = new PanelEmpleados();
		panelempleados.setBounds(222, 110, 1052, 540);
		panelempleados.setVisible(false);
		panelfondo.add(panelempleados);
		
		panelproductos = new PanelProductos();
		panelproductos.setBounds(222, 110, 1052, 540);
		panelproductos.setVisible(false);
		panelfondo.add(panelproductos);
		
		panelreportes = new PanelReportes();
		panelreportes.setBounds(222, 110, 1052, 540);
		panelreportes.setVisible(false);
		panelfondo.add(panelreportes);
		
		JLabel lblNewLabel_1 = new JLabel("Viveros Zoé ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(222, 11, 1052, 29);
		panelfondo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Formando Vida");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(222, 44, 1052, 19);
		panelfondo.add(lblNewLabel_2);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(37, 0, 150, 111);
		panelfondo.add(lbllogo);
		ImageIcon img4=new ImageIcon(ico4.getImage().getScaledInstance(lbllogo.getWidth(),lbllogo.getHeight(), Image.SCALE_SMOOTH));
		lbllogo.setIcon(img4);
		
		
		
	}
}
