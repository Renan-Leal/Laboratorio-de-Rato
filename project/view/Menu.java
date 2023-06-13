package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private PainelLogin painelLogin;
	private PainelListagemEndereco painelListagemEnderecoAlterado;
	private CadastroEndereco cadastroEndereco;
	private JMenuItem mntmListarEnderecos;
	private JMenuItem mntmCadastrarEndereco;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastrar");
		mnUsuarios.add(mntmCadastrarUsuario);
		
		JMenuItem mntmListarUsuario = new JMenuItem("Listar");
		mnUsuarios.add(mntmListarUsuario);
		
		JMenu mnTreinos = new JMenu("Treinos");
		menuBar.add(mnTreinos);
		
		JMenuItem mntmCadastrarTreino = new JMenuItem("Cadastrar");
		mnTreinos.add(mntmCadastrarTreino);
		
		JMenuItem mntmListarTreinos = new JMenuItem("Listar");
		mnTreinos.add(mntmListarTreinos);
		
		JMenu mnAgendamentos = new JMenu("Agendamentos");
		menuBar.add(mnAgendamentos);
		
		JMenuItem mntmCadastrarAgendamento = new JMenuItem("Cadastrar");
		mnAgendamentos.add(mntmCadastrarAgendamento);
		
		JMenuItem mntmListarAgendamento = new JMenuItem("Listar");
		mnAgendamentos.add(mntmListarAgendamento);
		
		JMenu mnEnderecos = new JMenu("Enderecos");
		menuBar.add(mnEnderecos);
		
		mntmCadastrarEndereco = new JMenuItem("Cadastrar");
		mntmCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroEndereco = new CadastroEndereco();
				cadastroEndereco.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
				frame.setContentPane(cadastroEndereco);
				frame.revalidate();
				}
		});
		mnEnderecos.add(mntmCadastrarEndereco);
		
		mntmListarEnderecos = new JMenuItem("Listar");
		mntmListarEnderecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelListagemEnderecoAlterado = new PainelListagemEndereco();
				painelListagemEnderecoAlterado.setVisible(true);
				registrarCliqueBotaoEditarDoPainelListagemEndereco();
				
				frame.setContentPane(painelListagemEnderecoAlterado);
				//Atualiza a tela principal
				frame.revalidate();
			}
		});
		mnEnderecos.add(mntmListarEnderecos);
		
		//Fazer método para desbloquear o menu
		mnAgendamentos.setEnabled(false);
		mnTreinos.setEnabled(false);
		mnEnderecos.setEnabled(false);
		mnUsuarios.setEnabled(false);

		painelLogin = new PainelLogin();
		frame.setContentPane(painelLogin);

		protected void registrarCliqueBotaoEditarDoPainelListagemEndereco() {
			painelListagemEnderecoAlterado.getBtnEditar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cadastroEndereco = new CadastroEndereco(painelListagemEnderecoAlterado);
					cadastroEndereco.setVisible(true);
					registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
					//Atualiza a tela principal
					frame.setContentPane(cadastroEndereco);
					frame.revalidate();
				}
			});
		}

		protected void registrarCliqueBotaoVoltarDoPainelCadastroEndereco() {
			if(cadastroEndereco == null) {
				cadastroEndereco = new CadastroEndereco(null);
			}
			cadastroEndereco.getBtnVoltar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					painelListagemEnderecoAlterado = new PainelListagemEndereco();
					painelListagemEnderecoAlterado.setVisible(true);
					registrarCliqueBotaoEditarDoPainelListagemEndereco();
					frame.setContentPane(painelListagemEnderecoAlterado);
					frame.revalidate();
				}
			});

		
	}

}
}
