package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField textUsuario;
    private JPasswordField txtPassword;
	SentenciasUsuario sentusu;
	int xMouse, yMouse;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame1 = new Login();
					
					frame1.setLocationRelativeTo(null);
					frame1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame Hola Prueba de rama1.
	 */
	public Login() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sentusu=new SentenciasUsuario();
		
		JLabel lbllogoIcono = new JLabel("");
		lbllogoIcono.setBounds(556, 34, 168, 123);
		ImageIcon ico4=new ImageIcon(getClass().getResource("/Imagenes/Vivero_Zoe_logo_Icono.png"));
		ImageIcon img4=new ImageIcon(ico4.getImage().getScaledInstance(lbllogoIcono.getWidth(),lbllogoIcono.getHeight(), Image.SCALE_SMOOTH));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 339, 351, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 444, 351, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("VIVEROS ZOÉ");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(480, 173, 320, 19);
		contentPane.add(lblNewLabel_3);
		lbllogoIcono.setIcon(img4);
		contentPane.add(lbllogoIcono);
		
		JLabel lblNewLabel_2 = new JLabel("Formando Vida");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(480, 194, 320, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(36, 278, 91, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(36, 383, 91, 19);
		contentPane.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (textUsuario.getText().equals("Ingrese su nombre de usuario")) {
			            textUsuario.setText("");
			            textUsuario.setForeground(Color.black);
			        }
			        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			            txtPassword.setText("********");
			            txtPassword.setForeground(Color.gray);
			        }
			}
		});
		textUsuario.setBorder(null);
		textUsuario.setForeground(Color.GRAY);
		textUsuario.setText("Ingrese su nombre de usuario");
		textUsuario.setBounds(36, 308, 351, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPassword.getPassword()).equals("********")) {
		            txtPassword.setText("");
		            txtPassword.setForeground(Color.black);
		        }
		        if (textUsuario.getText().isEmpty()) {
		            textUsuario.setText("Ingrese su nombre de usuario");
		            textUsuario.setForeground(Color.gray);
		        }
			}
		});
		txtPassword.setEchoChar('*');
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("********");
		txtPassword.setToolTipText("");
		txtPassword.setBorder(null);
		txtPassword.setBounds(36, 413, 351, 20);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("ENTRAR");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setBackground(new Color(113, 182, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(75, 145, 47));
			}
	
		});
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setBackground(new java.awt.Color(75, 145, 47));
		btnIngresar.setForeground(Color.WHITE);
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario=textUsuario.getText();
				String password=String.valueOf(txtPassword.getPassword());
				
				if(sentusu.obtenerUsuario(usuario,password))
						{
					dispose();
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
					
					frame.setVisible(true);
					
						}else {
					JOptionPane.showMessageDialog(null, "Error",password, JOptionPane.ERROR_MESSAGE);
					textUsuario.setText("");
					txtPassword.setText("");
					textUsuario.requestFocus();
						}
			}
		});
		btnIngresar.setBounds(184, 505, 89, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblfondo1 = new JLabel("");
		lblfondo1.setBounds(480, -21, 320, 621);
		ImageIcon ico6=new ImageIcon(getClass().getResource("/Imagenes/Paisaje.jpg"));
		ImageIcon img6=new ImageIcon(ico6.getImage().getScaledInstance(lblfondo1.getWidth(),lblfondo1.getHeight(), Image.SCALE_SMOOTH));
		lblfondo1.setIcon(img6);
		contentPane.add(lblfondo1);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(136, 54, 150, 102);
		ImageIcon ico7=new ImageIcon(getClass().getResource("/Imagenes/Vivero_Zoe_logo sin fondo.png"));
		ImageIcon img7=new ImageIcon(ico7.getImage().getScaledInstance(lbllogo.getWidth(),lbllogo.getHeight(), Image.SCALE_SMOOTH));
		lbllogo.setIcon(img7);
		contentPane.add(lbllogo);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESIÓN");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIniciarSesion.setBounds(127, 187, 177, 27);
		contentPane.add(lblIniciarSesion);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setBackground(new Color(113, 182, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBackground(new Color(75, 145, 47));
			}
		});
		btnSalir.setBounds(184, 551, 89, 23);
		contentPane.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBackground(new java.awt.Color(75, 145, 47));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
