package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuAcademia {

	private JFrame frame;
	private PainelLogin painelLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAcademia window = new MenuAcademia();
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
	public MenuAcademia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 30);
		frame.setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mnUsuarios.add(mntmCadastrarCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar");
		mnUsuarios.add(mntmListarClientes);
		
		JMenu mnEnderecos = new JMenu("Enderecos");
		menuBar.add(mnEnderecos);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnEnderecos.add(mntmCadastrar);
		
		JMenuItem mntmListarPersonal = new JMenuItem("Listar");
		mnEnderecos.add(mntmListarPersonal);
		
		JMenu mnTreinos = new JMenu("Treinos");
		menuBar.add(mnTreinos);
		
		JMenuItem mntmCadastrarTreino = new JMenuItem("Cadastrar");
		mnTreinos.add(mntmCadastrarTreino);
		
		JMenuItem mntmListarTreinos = new JMenuItem("Listar");
		mnTreinos.add(mntmListarTreinos);
		
		JMenu mnAgendamentos = new JMenu("Agentamentos");
		menuBar.add(mnAgendamentos);
		
		JMenuItem mntmCadastrarAgendamento = new JMenuItem("Cadastrar");
		mnAgendamentos.add(mntmCadastrarAgendamento);
		
		JMenuItem mntmListarAgendamentos = new JMenuItem("Listar");
		mnAgendamentos.add(mntmListarAgendamentos);
		
		mnAgendamentos.setEnabled(false);
		mnEnderecos.setEnabled(false);
		mnTreinos.setEnabled(false);
		mnUsuarios.setEnabled(false);
		
		painelLogin = new PainelLogin();
		frame.setContentPane(painelLogin);
	}
}
