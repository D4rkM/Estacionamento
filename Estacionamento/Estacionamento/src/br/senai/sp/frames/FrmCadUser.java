package br.senai.sp.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class FrmCadUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public FrmCadUser() {
		setResizable(false);
		setTitle("Cadastro de Usu\u00E1rios");
		setBounds(100, 100, 466, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 436, 259);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 411, 201);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 11, 34, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Telefone:");
		label_1.setBounds(10, 36, 52, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Usu\u00E1rio:");
		label_2.setBounds(10, 61, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Senha:");
		label_3.setBounds(10, 86, 46, 14);
		panel_1.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 8, 315, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 33, 190, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(72, 58, 156, 20);
		panel_1.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 83, 156, 20);
		panel_1.add(passwordField);
		
		JLabel label_4 = new JLabel("Privil\u00E9gio: ");
		label_4.setBounds(10, 121, 59, 14);
		panel_1.add(label_4);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adm", "Usu\u00E1rio"}));
		comboBox.setBounds(72, 120, 69, 17);
		panel_1.add(comboBox);
		
		JCheckBox checkBox = new JCheckBox("Ativo");
		checkBox.setBounds(72, 144, 69, 23);
		panel_1.add(checkBox);
		
		JButton button_4 = new JButton("Salvar");
		button_4.setBounds(181, 223, 72, 23);
		panel.add(button_4);
	}

}
