package br.senai.sp.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMovimentacao extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtHrEntrada;
	private JTextField txtDtEntrada;
	/**
	 * Create the frame.
	 */
	public FrmMovimentacao() {
		setTitle("Entrada de Ve\u00EDculos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(24, 34, 46, 14);
		panel.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(10, 51, 86, 20);
		panel.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(161, 34, 46, 14);
		panel.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(147, 51, 86, 20);
		panel.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(161, 93, 46, 14);
		panel.add(lblCliente);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(24, 178, 46, 14);
		panel.add(lblCor);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(24, 93, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(161, 178, 46, 14);
		panel.add(lblAno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 118, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 203, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(147, 203, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox cbbTipo = new JComboBox();
		cbbTipo.setBounds(10, 118, 60, 20);
		panel.add(cbbTipo);
		
		JButton btnCadCliente = new JButton("Cadastrar Cliente");
		btnCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCadCliente cadCli = new FrmCadCliente();
				cadCli.setVisible(true);
			}
		});
		btnCadCliente.setBounds(24, 283, 125, 23);
		panel.add(btnCadCliente);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(232, 283, 89, 23);
		panel.add(btnSalvar);
		
		txtHrEntrada = new JTextField();
		txtHrEntrada.setBounds(289, 79, 86, 20);
		panel.add(txtHrEntrada);
		txtHrEntrada.setColumns(10);
		
		JLabel lblHrEntrada = new JLabel("Hora de Entrada:");
		lblHrEntrada.setBounds(289, 54, 86, 14);
		panel.add(lblHrEntrada);
		
		txtDtEntrada = new JTextField();
		txtDtEntrada.setBounds(289, 175, 86, 20);
		panel.add(txtDtEntrada);
		txtDtEntrada.setColumns(10);
		
		JLabel lblDtEntrada = new JLabel("Data de Entrada:");
		lblDtEntrada.setBounds(289, 150, 86, 14);
		panel.add(lblDtEntrada);
	}
}
