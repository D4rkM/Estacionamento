package br.senai.sp.frames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.io.Closeable;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.DAO.MovimentacaoDAO;
import br.senai.sp.models.Movimentacao;
import br.senai.sp.models.Usuario;
import br.senai.sp.util.CalculoHoras;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSaida extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca = new JTextField();;
	private JTextField txtHoraSaida;

	/**
	 * Create the frame.
	 */
	public FrmSaida() {
		setResizable(false);
		setTitle("Sa\u00EDda de Ve\u00EDculos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0, 0, 434, 41);
		contentPane.add(pnlTitulo);
		
		JPanel pnlDados = new JPanel();
		pnlDados.setBounds(0, 41, 434, 220);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);
		
		JLabel lblPlacaDoVeculo = new JLabel("Placa do Ve\u00EDculo:");
		lblPlacaDoVeculo.setBounds(10, 11, 91, 14);
		pnlDados.add(lblPlacaDoVeculo);
		
		txtPlaca.setBounds(10, 30, 86, 20);
		pnlDados.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblHoraSaida = new JLabel("Hora de Saida");
		lblHoraSaida.setBounds(199, 11, 75, 14);
		pnlDados.add(lblHoraSaida);
		
		txtHoraSaida = new JTextField();
		txtHoraSaida.setBounds(199, 30, 86, 20);
		pnlDados.add(txtHoraSaida);
		txtHoraSaida.setColumns(10);
		
		JButton btnConfirma = new JButton("Confirmar Saida");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularHoras();
			}
		});
		btnConfirma.setBounds(292, 186, 132, 23);
		pnlDados.add(btnConfirma);
		
		
	}
	
	void calcularHoras(){
		MovimentacaoDAO dados = new MovimentacaoDAO();
		Movimentacao mov = new Movimentacao();
		
		dados.dadosMovimentacao(txtPlaca.getText());
		Double horaEntrada = Double.parseDouble((mov.getHoraEntrada()));
		Double horaSaida = Double.parseDouble(txtHoraSaida.getText());

		CalculoHoras tempo = new CalculoHoras();
		JOptionPane.showMessageDialog(null, tempo.calculoDeHoras(horaEntrada, horaSaida));
	}
}
