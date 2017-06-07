package br.senai.sp.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import br.senai.sp.DAO.AutenticaUsuario;
import br.senai.sp.frames.FrmDesktop;
import br.senai.sp.models.Usuario;
import java.awt.event.KeyAdapter;

public class FrmLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 371, 52);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 52, 371, 229);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(211, 61, 122, 23);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(211, 108, 122, 23);
		panel_1.add(txtSenha);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(211, 46, 46, 14);
		panel_1.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(211, 93, 46, 14);
		panel_1.add(lblSenha);
		
		JButton btnEntra = new JButton("Entrar");
		btnEntra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				verificaUsuario();
			}
		});
		btnEntra.setBounds(230, 154, 89, 23);
		
		btnEntra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				verificaUsuario();
			}
		});
		panel_1.add(btnEntra);
	}
	
	private void verificaUsuario(){
		AutenticaUsuario verUser = new AutenticaUsuario();
		Usuario user = new Usuario();
		user = verUser.validacao(txtUsuario.getText(), txtSenha.getText());
		
		if (user.isAtivo()){
			FrmDesktop desktop = new FrmDesktop();
			desktop.setLocationRelativeTo(null);
			desktop.setExtendedState(MAXIMIZED_BOTH);
			desktop.setVisible(true);
			dispose();
			
		}else{
			JOptionPane.showMessageDialog(null,
					"Usuário ou Senha incorretos!\n\nTente novamente e se o problema persistir entre\n em contato com o administrador do sistema.",
					"Autenticação Falhou", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
