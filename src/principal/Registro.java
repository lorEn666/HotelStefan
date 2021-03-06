package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Frame;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JLabel lblFondo;
	private JPanel panel;
	private JLabel lblNombreApp;
	private JLabel lblCerrar;
	private JLabel lblMinimizar;
	private JLabel lblMaximizar;
	private JTextField textFieldUser;
	private JLabel lblRegistro;
	private JButton btnAñadirUser;
	private JButton btnSignIn;
	private JTextField txtContrasea;
	private JCheckBox chckbxAdmin;
	private ArrayList<Usuario> vUsuarios;
	private boolean maximizado = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 0, 1280, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombreApp = new JLabel("Hotel Stefan *****");
		lblNombreApp.setBounds(538, 0, 212, 30);
		lblNombreApp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreApp.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		lblNombreApp.setForeground(new Color(184, 134, 11));
		panel.add(lblNombreApp);
		
		lblCerrar = new JLabel("");
		lblCerrar.setBounds(22, 9, 14, 14);
		lblCerrar.addMouseListener(new LblCerrarMouseListener());
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrar.setToolTipText("Cerrar");
		lblCerrar.setIcon(new ImageIcon(".\\recursos\\close.png"));
		panel.add(lblCerrar);
		
		lblMinimizar = new JLabel("");
		lblMinimizar.setBounds(46, 9, 14, 14);
		lblMinimizar.addMouseListener(new LblMinimizarMouseListener());
		lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setToolTipText("Minimizar");
		lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimize.png"));
		panel.add(lblMinimizar);
		
		lblMaximizar = new JLabel("");
		lblMaximizar.setBounds(70, 9, 14, 14);
		lblMaximizar.addMouseListener(new LblMaximizarMouseListener());
		lblMaximizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaximizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximizar.setToolTipText("Maximizar");
		lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximize.png"));
		panel.add(lblMaximizar);
		
		textFieldUser = new JTextField();
		textFieldUser.addFocusListener(new TextFieldUserFocusListener());
		textFieldUser.setText("USUARIO");
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUser.setBounds(460, 189, 368, 40);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setForeground(new Color(184, 134, 11));
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(460, 76, 368, 70);
		contentPane.add(lblRegistro);
		
		btnAñadirUser = new JButton("A\u00D1ADIR");
		btnAñadirUser.addActionListener(new BtnAñadirUserActionListener());
		btnAñadirUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAñadirUser.setBounds(460, 405, 368, 50);
		contentPane.add(btnAñadirUser);
		
		btnSignIn = new JButton("VOLVER");
		btnSignIn.addActionListener(new BtnSignInActionListener());
		btnSignIn.addMouseListener(new BtnSignInMouseListener());
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignIn.setBounds(650, 511, 368, 50);
		contentPane.add(btnSignIn);
		
		txtContrasea = new JTextField();
		txtContrasea.addFocusListener(new TxtContraseaFocusListener());
		txtContrasea.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtContrasea.setText("CONTRASE\u00D1A");
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.setBounds(460, 258, 368, 40);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		chckbxAdmin = new JCheckBox("ADMINISTRADOR");
		chckbxAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxAdmin.setBounds(460, 332, 368, 40);
		contentPane.add(chckbxAdmin);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
		lblFondo.setBounds(0, 30, 1280, 720);
		contentPane.add(lblFondo);
		lblFondo.setFocusable(true);
		lblFondo.requestFocus();
		vUsuarios = IoDatos.leerDatos();
		
	}
	private class LblCerrarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblCerrar.setIcon(new ImageIcon(".\\recursos\\closeSelected.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblCerrar.setIcon(new ImageIcon(".\\recursos\\close.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}
	private class LblMinimizarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimizeSelected.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblMinimizar.setIcon(new ImageIcon(".\\recursos\\minimize.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			setState(JFrame.ICONIFIED);
		}
	}
	private class LblMaximizarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximizeSelected.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblMaximizar.setIcon(new ImageIcon(".\\recursos\\maximize.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if (!maximizado) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				maximizado = true;
			} else {
				setExtendedState(JFrame.NORMAL);
				maximizado = false;
			}

		}
	}
	private class TextFieldUserFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			textFieldUser.setText("");
			lblFondo.setFocusable(false);
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			if (textFieldUser.getText().equals("")) {
				textFieldUser.setText("USUARIO");
			}
		}
	}
	private class BtnSignInMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
		}
	}
	private class BtnSignInActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			LogIn log = new LogIn();
			log.setVisible(true);
			dispose();
		}
	}
	private class TxtContraseaFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			txtContrasea.setText("");
		}	
		@Override
		public void focusLost(FocusEvent arg0) {
			txtContrasea.setText(txtContrasea.getText());
			
			Pattern pPasswd = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,16}$");
			Matcher mPasswd = pPasswd.matcher(txtContrasea.getText());
			
			if (txtContrasea.getText().equals("")) {
				txtContrasea.setText("CONTRASEÑA");
			}
			
			if (!mPasswd.matches()) {
				JOptionPane.showMessageDialog(null, "La contraseña debe contener un mínimo de 8 carácteres y máximo 16."+ "\n"
						+ "Mayúsculas, minúsculas y números, uno de cada tipo por lo menos.");
			}
			
			
		}
	}
	private class BtnAñadirUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
								
			for (Usuario usuario : vUsuarios) {
				if (usuario.getNombreUsuario().equals(textFieldUser.getText())) {
					JOptionPane.showMessageDialog(null, "El usuario indicado ya fue introducido anteriormente");
					textFieldUser.setText("USUARIO");
					txtContrasea.setText("CONTRASEÑA");
					chckbxAdmin.setSelected(false);
					return;
				}
			}
			
			
			JOptionPane.showMessageDialog(null, "El nuevo usuario fue introducido");
			
			
			Usuario usu = new Usuario(textFieldUser.getText(), txtContrasea.getText(), chckbxAdmin.isSelected());
			vUsuarios.add(usu);
			
			IoDatos.guardarUsusarios(vUsuarios);
			textFieldUser.setText("USUARIO");
			txtContrasea.setText("CONTRASEÑA");
			chckbxAdmin.setSelected(false);
			
			
			
		}
	}
}
