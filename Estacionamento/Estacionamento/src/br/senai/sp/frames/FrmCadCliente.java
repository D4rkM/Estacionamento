package br.senai.sp.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class FrmCadCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtLogradouro;
	private JTextField txtTelefone;

	/**
	 * Create the frame.
	 */
	public FrmCadCliente() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 487, 299);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 462, 232);
		panel.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 11, 34, 14);
		panel_1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(106, 8, 346, 20);
		panel_1.add(txtNome);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(84, 78, 368, 137);
		panel_1.add(panel_2);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(89, 16, 129, 20);
		panel_2.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(13, 19, 31, 14);
		panel_2.add(lblCep);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(228, 19, 46, 14);
		panel_2.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(284, 16, 58, 20);
		panel_2.add(txtNumero);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(89, 47, 253, 20);
		panel_2.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(89, 106, 164, 20);
		panel_2.add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(13, 50, 38, 14);
		panel_2.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(13, 109, 46, 14);
		panel_2.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(263, 109, 38, 14);
		panel_2.add(lblEstado);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(13, 81, 66, 14);
		panel_2.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(89, 78, 253, 20);
		panel_2.add(txtLogradouro);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setEditable(true);
		cbEstado.setBounds(303, 106, 39, 20);
		panel_2.add(cbEstado);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(235, 36, 136, 20);
		panel_1.add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(185, 39, 52, 14);
		panel_1.add(lblTelefone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(213, 261, 72, 23);
		panel.add(btnSalvar);
	}

}
