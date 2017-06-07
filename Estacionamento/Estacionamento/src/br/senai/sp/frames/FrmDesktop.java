package br.senai.sp.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.DAO.MovimentacaoDAO;
import br.senai.sp.DAO.ClienteDAO;
import br.senai.sp.DAO.PrecoDAO;
import br.senai.sp.DAO.UsuarioDAO;
import br.senai.sp.models.Cliente;
import br.senai.sp.models.Movimentacao;
import br.senai.sp.models.Preco;
import br.senai.sp.models.Usuario;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;

public class FrmDesktop extends JFrame implements KeyListener {

	private JTable tblCaixa;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTable tblEntradas;
	private JList<String> listCliente;
	private JList<String> listUsuario;
	private JPanel contentPane;
	private JTable tblPrecos;
	private JTable tblSaidas;

	private byte opcaoUsuario;
	private int idUsuario;
	private byte opcaoCliente;
	private int idCliente;

	DefaultListModel<String> modeloListaUsuario = new DefaultListModel<String>();
	DefaultListModel<String> modeloListaCliente = new DefaultListModel<String>();

	JComboBox<String> cbEstado = new JComboBox<String>();
	JComboBox<String> cbPrivilegio = new JComboBox<String>();
	JCheckBox cbxAtivo = new JCheckBox("Ativo");
	
	JButton btnExcluir = new JButton("Excluir");
	JButton btnAlterar = new JButton("Alterar");
	JButton btnSalvar = new JButton("Salvar");
	JButton btSalvarUser = new JButton("Salvar");
	JButton btAlterarUser = new JButton("Alterar");
	JButton btExcluirUser = new JButton("Excluir");
	
	JLayeredPane abaCaixa = new JLayeredPane();
	JLayeredPane abaPrecos = new JLayeredPane();
	JLayeredPane abaUsuarios = new JLayeredPane();
	JLayeredPane abaClientes = new JLayeredPane();
	JLayeredPane abaSaidas = new JLayeredPane();
	JLayeredPane abaEntradas = new JLayeredPane();
	Date relogio = new Date();

	JPanel pnlClientes = new JPanel();
	JPanel pnlUsuarios = new JPanel();

	private JTextField txtLogradouro;
	private JTextField txtNomeUser;
	private JTextField txtTelefoneUser;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Create the frame.
	 */

	public FrmDesktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 452);
		addKeyListener(this);

		JMenuBar mnArquivo = new JMenuBar();
		mnArquivo.setToolTipText("");
		setJMenuBar(mnArquivo);

		JMenu mnArquivo_1 = new JMenu("Arquivo");
		mnArquivo.add(mnArquivo_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Fechar");
		mnArquivo_1.add(mntmNewMenuItem);

		JMenu mnCliente = new JMenu("Cliente");
		mnArquivo.add(mnCliente);

		JMenuItem mnCadastrar = new JMenuItem("Cadastrar");
		mnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCadCliente cadCli = new FrmCadCliente();
				cadCli.setVisible(true);
			}
		});
		mnCliente.add(mnCadastrar);

		JMenu mnUsuarios = new JMenu("Usu\u00E1rios");
		mnArquivo.add(mnUsuarios);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCadUser cadUser = new FrmCadUser();
				cadUser.setVisible(true);
			}
		});
		mnUsuarios.add(mntmCadastrar);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnArquivo.add(mnAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tbpCentral = new JTabbedPane(JTabbedPane.TOP);
		tbpCentral.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tbpCentral.setBounds(10, 0, 873, 371);
		contentPane.add(tbpCentral);

		tbpCentral.addTab("Entradas", null, abaEntradas, null);

		tblEntradas = new JTable();

		tbpCentral.addTab("Sa\u00EDdas", null, abaSaidas, null);

		tbpCentral.addTab("Clientes", null, abaClientes, null);
		abaClientes.setLayout(null);

		pnlClientes.setBounds(10, 11, 844, 317);
		abaClientes.add(pnlClientes);
		pnlClientes.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcaoCliente = 1;
				limpaCamposClientes();
				ativarCamposClientes();
			}
		});
		btnNovo.setBounds(10, 11, 57, 23);
		pnlClientes.add(btnNovo);

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcaoCliente = 2;
				ativarCamposClientes();
			}
		});
		btnAlterar.setBounds(77, 11, 65, 23);
		pnlClientes.add(btnAlterar);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirCliente();
			}
		});

		btnExcluir.setBounds(152, 11, 65, 23);
		pnlClientes.add(btnExcluir);

		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(227, 11, 81, 23);
		pnlClientes.add(btnLocalizar);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(382, 33, 462, 232);
		pnlClientes.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 11, 34, 14);
		panel_1.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(106, 8, 346, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(84, 78, 368, 137);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		txtCep = new JTextField();
		txtCep.setBounds(89, 16, 129, 20);
		panel_2.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(13, 19, 31, 14);
		panel_2.add(lblCep);

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(228, 19, 46, 14);
		panel_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(284, 16, 58, 20);
		panel_2.add(txtNumero);
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(89, 47, 253, 20);
		panel_2.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(89, 106, 164, 20);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);

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
		txtLogradouro.setEditable(false);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(89, 78, 253, 20);
		panel_2.add(txtLogradouro);
		
		cbEstado.setModel(new DefaultComboBoxModel<String>(new String[] { ""
				+ "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO"
						+ "", "MA", "MT", "MS", "MG", "PA", "PB", "PR"
								+ "", "PE", "PI", "RJ", "RN", "RS", "RO"
										+ "", "RR", "SC", "SP", "SE", "TO"}));
		cbEstado.setBounds(301, 106, 40, 20);
		panel_2.add(cbEstado);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(235, 36, 136, 20);
		panel_1.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(185, 39, 52, 14);
		panel_1.add(lblTelefone);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (opcaoCliente) {

				case 1:
					cadastrarCliente();

				case 2:
					alterarCliente();
				}
			}
		});

		btnSalvar.setBounds(585, 283, 72, 23);
		pnlClientes.add(btnSalvar);

		tbpCentral.addTab("Usu\u00E1rios", null, abaUsuarios, null);

		pnlUsuarios.setBounds(10, 11, 844, 317);
		abaUsuarios.add(pnlUsuarios);
		pnlUsuarios.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(397, 46, 411, 201);
		pnlUsuarios.add(panel);
		panel.setLayout(null);

		JLabel lblNomeUser = new JLabel("Nome:");
		lblNomeUser.setBounds(10, 11, 34, 14);
		panel.add(lblNomeUser);

		JLabel lblTelefoneUser = new JLabel("Telefone:");
		lblTelefoneUser.setBounds(10, 36, 52, 14);
		panel.add(lblTelefoneUser);

		JLabel lblUserNome = new JLabel("Usu\u00E1rio:");
		lblUserNome.setBounds(10, 61, 46, 14);
		panel.add(lblUserNome);

		JLabel lblSenhaUser = new JLabel("Senha:");
		lblSenhaUser.setBounds(10, 86, 46, 14);
		panel.add(lblSenhaUser);

		txtNomeUser = new JTextField();
		txtNomeUser.setBounds(72, 8, 315, 20);
		panel.add(txtNomeUser);
		txtNomeUser.setColumns(10);

		txtTelefoneUser = new JTextField();
		txtTelefoneUser.setBounds(72, 33, 190, 20);
		panel.add(txtTelefoneUser);
		txtTelefoneUser.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(72, 58, 156, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(72, 83, 156, 20);
		panel.add(txtSenha);

		JLabel lblPrivilegio = new JLabel("Privil\u00E9gio: ");
		lblPrivilegio.setBounds(10, 121, 59, 14);
		panel.add(lblPrivilegio);

		
		cbPrivilegio.setModel(new DefaultComboBoxModel<String>(new String[] { "Adm", "Usu\u00E1rio" }));
		cbPrivilegio.setBounds(72, 120, 69, 17);
		panel.add(cbPrivilegio);

		
		cbxAtivo.setBounds(72, 144, 69, 23);
		panel.add(cbxAtivo);

		JButton btNewUser = new JButton("Novo");
		btNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaCamposUsuarios();
				opcaoUsuario = 1;
				ativarCamposUsuarios();
			}
		});
		btNewUser.setBounds(10, 11, 57, 23);
		pnlUsuarios.add(btNewUser);


		btAlterarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcaoUsuario = 2;
				ativarCamposUsuarios();
			}
		});
		btAlterarUser.setEnabled(false);
		btAlterarUser.setBounds(77, 11, 65, 23);
		pnlUsuarios.add(btAlterarUser);
		btExcluirUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});

		btExcluirUser.setEnabled(false);
		btExcluirUser.setBounds(152, 11, 65, 23);
		pnlUsuarios.add(btExcluirUser);

		JButton btLocalizarUser = new JButton("Localizar");
		btLocalizarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btLocalizarUser.setBounds(227, 11, 81, 23);
		pnlUsuarios.add(btLocalizarUser);

		btSalvarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switch (opcaoUsuario){
					case 1:
						cadastrarUsuario();
						break;
					case 2:
						alterarUsuario();
						break;
				}
			}
		});
		btSalvarUser.setBounds(568, 258, 72, 23);
		pnlUsuarios.add(btSalvarUser);

		tbpCentral.addTab("Pre\u00E7os", null, abaPrecos, null);

		tbpCentral.addTab("Caixa", null, abaCaixa, null);

		JPanel painelInfo = new JPanel();
		painelInfo.setBounds(0, 372, 893, 20);
		contentPane.add(painelInfo);
		painelInfo.setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio: ");
		lblUsuario.setBounds(12, 4, 48, 14);
		painelInfo.add(lblUsuario);

		JLabel lblNomeDeUsuario = new JLabel("");
		lblNomeDeUsuario.setBounds(62, 3, 96, 14);
		painelInfo.add(lblNomeDeUsuario);

		JLabel lblHora = new JLabel("");
		lblHora.setBounds(716, 4, 161, 14);
		lblHora.setText(relogio.toString());
		painelInfo.add(lblHora);

		/** Esconder ABAS (VER DEPOIS) **/

		tbpCentral.getComponentAt(3).setVisible(false);

		criarListaClientes();
		criarListaUsuarios();
		criarTabelaDeCaixa();
		criarTabelaDePrecos();
		criarTabelaDeEntrada();
		criarTabelaDeSaida();
		desativaCamposClientes();
		desativaCamposUsuarios();

	}

	/** ***************************** FUNÇÕES ******************************************/

	/* ----------- AÇÕES ----------- */

	private void cadastrarCliente() {

		Cliente cli = new Cliente();

		cli.setNome(txtNome.getText());
		cli.setTelefone(txtTelefone.getText());
		cli.setLogradouro(txtLogradouro.getText());
		cli.setCidade(txtCidade.getText());
		cli.setBairro(txtBairro.getText());
		cli.setCep(txtCep.getText());
		cli.setNumero(Integer.parseInt(txtNumero.getText()));
		String estado = cbEstado.getItemListeners().toString();
		System.out.println(estado);
		cli.setEstado(estado);
		
		ClienteDAO cad = new ClienteDAO();

		if (cad.salvarCliente(cli) == true) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
			limpaCamposClientes();
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar cliente!\n");
		}
		atualizarListaClientes();

	}

	private void alterarCliente() {
		Cliente cli = new Cliente();

		cli.setIdCliente(idCliente);
		cli.setNome(txtNome.getText());
		cli.setTelefone(txtTelefone.getText());
		cli.setLogradouro(txtLogradouro.getText());
		cli.setCidade(txtCidade.getText());
		cli.setEstado(cbEstado.getSelectedItem().toString());
		cli.setBairro(txtBairro.getText());
		cli.setCep(txtCep.getText());
		cli.setNumero(Integer.parseInt(txtNumero.getText()));

		ClienteDAO alt = new ClienteDAO();

		if (alt.alterarCliente(cli) == true) {
			JOptionPane.showMessageDialog(null, "Cliente alterado com Sucesso!");
			limpaCamposClientes();
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cliente!\n");
		}
		atualizarListaClientes();
	}

	private void excluirCliente() {
		ClienteDAO exclui = new ClienteDAO();
		int resp = JOptionPane.showConfirmDialog(null, "Deseja remover o cliente?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (resp == 0) {
			if (exclui.excluirCliente(idCliente) == true) {
				JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
				atualizarListaClientes();
				limpaCamposClientes();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao remover cliente.");
			}
		}

	}

	private void cadastrarUsuario(){
		Usuario user = new Usuario();
		
		user.setUsuario(txtUsuario.getText());
		user.setTelefone(txtTelefoneUser.getText());
		user.setNome(txtNomeUser.getText());
		user.setSenha(txtSenha.getText());
		
		if (cbxAtivo.isSelected() == true){
			user.setAtivo(true);
		}else{
			user.setAtivo(false);
		}
		
		String priv = cbPrivilegio.getSelectedItem().toString();
		
		if (priv == "Adm"){
			user.setPrivilegio("G");
		}else{
			user.setPrivilegio("U");
		}
		
		UsuarioDAO cad = new UsuarioDAO();
		
		if (cad.salvarUsuario(user) == true){
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");
			//limpaCamposUsuarios();
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar usuário!\n");
		}
		
	}
	
	private void alterarUsuario(){
		Usuario user = new Usuario();
		ativarCamposUsuarios();
		
		user.setNome(txtNome.getText());
		user.setPrivilegio(cbPrivilegio.getSelectedItem().toString());
		user.setUsuario(txtUsuario.getText());
		user.setSenha(txtSenha.getText());
		user.isAtivo();
		
		UsuarioDAO altUser = new UsuarioDAO();
		
		if (altUser.alterarUsuario(user) == true){
			JOptionPane.showMessageDialog(null, "Usuário alterado com Sucesso!");
			limpaCamposUsuarios();
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao alterar Usuário");
		}
		atualizarListaUsuarios();
	}

	private void excluirUsuario(){
		UsuarioDAO ex = new UsuarioDAO();
		int resp = JOptionPane.showConfirmDialog(null, "Deseja remover o usuário?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (resp == 0) {
			if (ex.excluirUsuario(idUsuario) == true) {
				JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
				atualizarListaClientes();
				limpaCamposClientes();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao remover usuário.");
			}
		}
		
	}
	
	/* Tabelas e Lista */

	private void criarListaUsuarios() {

		listUsuario = new JList<String>(modeloListaUsuario);

		atualizarListaUsuarios();

		listUsuario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String nome = (String) listUsuario.getSelectedValue();
				desativaCamposUsuarios();
				btAlterarUser.setEnabled(true);
				btExcluirUser.setEnabled(true);
				UsuarioDAO user = new UsuarioDAO();
				
				txtUsuario.setText(nome);
				txtNomeUser.setText(user.mostrarDadosUsuario(nome).getUsuario());
				txtSenha.setText(user.mostrarDadosUsuario(nome).getSenha());
				txtTelefoneUser.setText(user.mostrarDadosUsuario(nome).getTelefone());
				cbxAtivo.isSelected();
				cbPrivilegio.setSelectedItem(user.mostrarDadosUsuario(nome).getPrivilegio());			
				idUsuario = user.mostrarDadosUsuario(nome).getIdUsuario();
				
			}
		});

		JScrollPane spUsuario = new JScrollPane();
		spUsuario.setBounds(10, 46, 296, 259);
		pnlUsuarios.add(spUsuario);
		spUsuario.setViewportView(listUsuario);

	}

	private void atualizarListaUsuarios() {

		listUsuario.clearSelection();
		modeloListaUsuario.clear();

		UsuarioDAO dao = new UsuarioDAO();
		for (Usuario u : dao.mostrarUsuario()) {
			modeloListaUsuario.add(0, u.getNome());
		}

	}

	private void criarListaClientes() {

		listCliente = new JList<String>(modeloListaCliente);

		atualizarListaClientes();

		listCliente.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent click) {
				String nome = (String) listCliente.getSelectedValue();
				desativaCamposClientes();
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				ClienteDAO cli = new ClienteDAO();

				txtNome.setText(nome);
				txtCep.setText(cli.mostrarDadosCliente(nome).getCep());
				txtNumero.setText(Integer.toString(cli.mostrarDadosCliente(nome).getNumero()));
				cbEstado.setToolTipText(cli.mostrarDadosCliente(nome).getEstado());
				txtTelefone.setText(cli.mostrarDadosCliente(nome).getTelefone());
				txtBairro.setText(cli.mostrarDadosCliente(nome).getBairro());
				txtCidade.setText(cli.mostrarDadosCliente(nome).getCidade());
				txtLogradouro.setText(cli.mostrarDadosCliente(nome).getLogradouro());
				idCliente = cli.mostrarDadosCliente(nome).getIdCliente();

			}

		});

		JScrollPane spCliente = new JScrollPane();
		spCliente.setBounds(10, 46, 296, 259);
		pnlClientes.add(spCliente);

		spCliente.setViewportView(listCliente);

	}

	private void atualizarListaClientes() {

		listCliente.clearSelection();
		modeloListaCliente.clear();

		ClienteDAO dao = new ClienteDAO();
		for (Cliente c : dao.mostrarClientes()) {
			modeloListaCliente.add(0, c.getNome());
		}
	}

	private void criarTabelaDePrecos() {

		DefaultTableModel modeloPreco = new DefaultTableModel();
		tblPrecos = new JTable(modeloPreco);
		modeloPreco.setNumRows(0);
		modeloPreco.setColumnCount(0);
		modeloPreco.addColumn("Primeira Hora");
		modeloPreco.addColumn("Demais Horas");
		modeloPreco.addColumn("Diárias");

		tblPrecos.getColumnModel().getColumn(0).setResizable(false);
		tblPrecos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblPrecos.getColumnModel().getColumn(1).setResizable(false);
		tblPrecos.getColumnModel().getColumn(1).setPreferredWidth(115);
		tblPrecos.getColumnModel().getColumn(2).setResizable(false);
		tblPrecos.getColumnModel().getColumn(2).setPreferredWidth(115);
		tblPrecos.setEnabled(false);

		/********** VERIFICAR DEPOIS *************/

		tblPrecos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int linha = tblPrecos.getSelectedRow();
				float id = (float) tblPrecos.getValueAt(linha, 0);
			}
		});

		PrecoDAO dao = new PrecoDAO();
		for (Preco p : dao.mostarPrecos()) {
			modeloPreco.addRow(new Object[] { p.getPrimeiraHora(), p.getDemaisHoras(), p.getDiaria() });
		}

		JScrollPane spListaPrecos = new JScrollPane();
		spListaPrecos.addMouseListener(new MouseAdapter() {
		});
		spListaPrecos.setBounds(10, 11, 844, 317);
		abaPrecos.add(spListaPrecos);
		spListaPrecos.setColumnHeaderView(tblPrecos);
		spListaPrecos.setViewportView(tblPrecos);

	}

	private void criarTabelaDeCaixa() {

		DefaultTableModel modeloCaixa = new DefaultTableModel();
		tblCaixa = new JTable(modeloCaixa);

		modeloCaixa.setNumRows(0);
		modeloCaixa.setColumnCount(0);
		modeloCaixa.addColumn("Data de Abertura");
		modeloCaixa.addColumn("Valor de Abertura");
		modeloCaixa.addColumn("Data de Fechamento");
		modeloCaixa.addColumn("Valor de Fechamento");

		tblCaixa.getColumnModel().getColumn(0).setResizable(false);
		tblCaixa.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblCaixa.getColumnModel().getColumn(1).setResizable(false);
		tblCaixa.getColumnModel().getColumn(1).setPreferredWidth(115);
		tblCaixa.getColumnModel().getColumn(2).setResizable(false);
		tblCaixa.getColumnModel().getColumn(2).setPreferredWidth(115);
		tblCaixa.getColumnModel().getColumn(3).setResizable(false);
		tblCaixa.getColumnModel().getColumn(3).setPreferredWidth(115);
		tblCaixa.setEnabled(false);

		JScrollPane spCaixa = new JScrollPane();

		spCaixa.setBounds(10, 11, 844, 317);

		abaCaixa.add(spCaixa);
		spCaixa.setColumnHeaderView(tblCaixa);
		spCaixa.setViewportView(tblCaixa);

	}

	private void criarTabelaDeEntrada() {
		DefaultTableModel modeloEntrada = new DefaultTableModel();

		modeloEntrada.setNumRows(0);
		modeloEntrada.setColumnCount(0);
		modeloEntrada.addColumn("Placa");
		modeloEntrada.addColumn("Data de Entrada");
		modeloEntrada.addColumn("Hora de Entrada");

		MovimentacaoDAO dao = new MovimentacaoDAO();
		for (Movimentacao e : dao.mostrarMovimentacao()) {
			modeloEntrada.addRow(new Object[] { e.getPlaca(), e.getDataEntrada(), e.getHoraEntrada() });
		}

		JPanel pnlEntradas = new JPanel();
		pnlEntradas.setBounds(10, 11, 844, 317);
		abaEntradas.add(pnlEntradas);
		tblEntradas = new JTable(modeloEntrada);

		tblEntradas.getColumnModel().getColumn(0).setResizable(false);
		tblEntradas.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblEntradas.getColumnModel().getColumn(1).setResizable(false);
		tblEntradas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblEntradas.getColumnModel().getColumn(2).setResizable(false);
		tblEntradas.getColumnModel().getColumn(2).setPreferredWidth(100);
		pnlEntradas.setLayout(null);
		tblEntradas.setEnabled(false);

		JScrollPane spListaEntradas = new JScrollPane();
		spListaEntradas.setBounds(10, 11, 824, 271);
		pnlEntradas.add(spListaEntradas);

		spListaEntradas.setColumnHeaderView(tblEntradas);
		spListaEntradas.setViewportView(tblEntradas);

		JButton btnNewEntrada = new JButton("Entrada");
		btnNewEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMovimentacao mov = new FrmMovimentacao();
				mov.setVisible(true);
			}
		});
		btnNewEntrada.setBounds(745, 287, 89, 23);
		pnlEntradas.add(btnNewEntrada);
		JButton btnNewSaida = new JButton("Saida");
		btnNewSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmSaida saidas = new FrmSaida();
				saidas.setVisible(true);
			}
		});
		btnNewSaida.setBounds(646, 287, 89, 23);
		pnlEntradas.add(btnNewSaida);

	}

	private void criarTabelaDeSaida() {
		DefaultTableModel modeloSaida = new DefaultTableModel();

		modeloSaida.setNumRows(0);
		modeloSaida.setColumnCount(0);
		modeloSaida.addColumn("Placa");
		modeloSaida.addColumn("Data de Saída");
		modeloSaida.addColumn("Hora de Saída");

		MovimentacaoDAO dao = new MovimentacaoDAO();
		for (Movimentacao s : dao.mostrarMovimentacao()) {
			modeloSaida.addRow(new Object[] { s.getPlaca(), s.getDataSaida(), s.getHoraSaida() });
		}

		JPanel pnlSaidas = new JPanel();
		pnlSaidas.setBounds(10, 11, 844, 317);
		abaSaidas.add(pnlSaidas);
		tblSaidas = new JTable(modeloSaida);

		tblSaidas.getColumnModel().getColumn(0).setResizable(false);
		tblSaidas.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblSaidas.getColumnModel().getColumn(1).setResizable(false);
		tblSaidas.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblSaidas.getColumnModel().getColumn(2).setResizable(false);
		tblSaidas.getColumnModel().getColumn(2).setPreferredWidth(80);
		pnlSaidas.setLayout(null);
		tblSaidas.setEnabled(false);

		JScrollPane spSaidas = new JScrollPane();
		spSaidas.setBounds(10, 11, 824, 295);
		pnlSaidas.add(spSaidas);

		spSaidas.setColumnHeaderView(tblSaidas);
		spSaidas.setViewportView(tblSaidas);

	}

	/* Campos do Cliente */

	private void ativarCamposClientes() {
		txtNome.setEditable(true);
		txtBairro.setEditable(true);
		txtCep.setEditable(true);
		txtCidade.setEditable(true);
		cbEstado.setEnabled(true);
		txtNumero.setEditable(true);
		txtTelefone.setEditable(true);
		txtLogradouro.setEditable(true);
		btnSalvar.setEnabled(true);
		
	}

	private void desativaCamposClientes() {
		txtNome.setEditable(false);
		txtBairro.setEditable(false);
		txtCep.setEditable(false);
		txtCidade.setEditable(false);
		txtNumero.setEditable(false);
		txtTelefone.setEditable(false);
		cbEstado.setEnabled(false);
		txtLogradouro.setEditable(false);
		btnSalvar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}

	private void limpaCamposClientes() {
		txtNome.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtNumero.setText("");
		txtTelefone.setText("");
		txtLogradouro.setText("");
	}

	/* Campos do Usuario */

	private void ativarCamposUsuarios(){
		txtNomeUser.setEditable(true);
		txtTelefoneUser.setEditable(true);
		txtUsuario.setEditable(true);
		txtSenha.setEditable(true);
		cbPrivilegio.setEnabled(true);
		cbxAtivo.setEnabled(true);
		btSalvarUser.setEnabled(true);
	}
	
	private void desativaCamposUsuarios(){
		txtNomeUser.setEditable(false);
		txtTelefoneUser.setEditable(false);
		txtUsuario.setEditable(false);
		txtSenha.setEditable(false);
		cbPrivilegio.setEnabled(false);
		cbxAtivo.setEnabled(false);
		btSalvarUser.setEnabled(false);
	}
	
	private void limpaCamposUsuarios(){
		txtNomeUser.setText("");
		txtTelefoneUser.setText("");
		txtUsuario.setText("");
		txtSenha.setText("");
		cbxAtivo.setSelected(false);
	}
	
	/* Acões de teclas */

	@Override
	public void keyPressed(KeyEvent tecla) {
		// TODO Auto-generated method stub
		System.out.println("teste" + tecla.getKeyCode());
		JOptionPane.showMessageDialog(null, "Você pressionou uma tecla" + tecla.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent tecla) {
		// TODO Auto-generated method stub
		System.out.println("teste" + tecla.getKeyCode());

	}
}
