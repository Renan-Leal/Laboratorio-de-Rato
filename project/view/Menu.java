package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.exception.CampoInvalidoException;
import model.vo.TipoUsuario;
import model.vo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private PainelLogin painelLogin;
	private PainelAgendamentoTreino painelAgendamentoTreino;
	private PainelCadastroEndereco painelCadastroEndereco;
	private PainelListagemEndereco painelListagemEnderecoAlterado;
	private PainelCadastroTreino painelCadastroTreino;
	private PainelCadastroUsuario painelCadastroUsuario;
	private PainelListagemEndereco painelListagemEndereco;

	private JMenuItem mntmListarEnderecos;
	private JMenuItem mntmCadastrarEndereco;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnUsuarios;
	private JMenuItem mntmCadastrarUsuario;
	private JMenuItem mntmListarUsuario;
	private JMenu mnTreinos;
	private JMenuItem mntmCadastrarTreino;
	private JMenuItem mntmListarTreinos;
	private JMenu mnAgendamentos;
	private JMenuItem mntmCadastrarAgendamento;
	private JMenuItem mntmListarAgendamento;
	private JMenu mnEnderecos;

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

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);

		mntmCadastrarUsuario = new JMenuItem("Cadastrar");
		mnUsuarios.add(mntmCadastrarUsuario);

		mntmListarUsuario = new JMenuItem("Listar");
		mnUsuarios.add(mntmListarUsuario);

		mnTreinos = new JMenu("Treinos");
		menuBar.add(mnTreinos);

		mntmCadastrarTreino = new JMenuItem("Cadastrar");
		mnTreinos.add(mntmCadastrarTreino);

		mntmListarTreinos = new JMenuItem("Listar");
		mnTreinos.add(mntmListarTreinos);

		mnAgendamentos = new JMenu("Agendamentos");
		menuBar.add(mnAgendamentos);

		mntmCadastrarAgendamento = new JMenuItem("Cadastrar");
		mnAgendamentos.add(mntmCadastrarAgendamento);

		mntmListarAgendamento = new JMenuItem("Listar");
		mnAgendamentos.add(mntmListarAgendamento);

		mnEnderecos = new JMenu("Enderecos");
		menuBar.add(mnEnderecos);

		mntmCadastrarEndereco = new JMenuItem("Cadastrar");
		mntmCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEndereco = new PainelCadastroEndereco();
				painelCadastroEndereco.setVisible(true);
				// registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
				frame.setContentPane(painelCadastroEndereco);
				frame.revalidate();
			}
		});
		mnEnderecos.add(mntmCadastrarEndereco);

		mntmListarEnderecos = new JMenuItem("Listar");
		mntmListarEnderecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelListagemEnderecoAlterado = new PainelListagemEndereco();
				painelListagemEnderecoAlterado.setVisible(true);
				// registrarCliqueBotaoEditarDoPainelListagemEndereco();

				frame.setContentPane(painelListagemEnderecoAlterado);
				// Atualiza a tela principal
				frame.revalidate();
			}
		});
		mnEnderecos.add(mntmListarEnderecos);

		// Fazer m�todo para desbloquear o menu
		bloquearTodoMenu();

		painelLogin = new PainelLogin();
		painelLogin.getBtnLogar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario usuarioAutenticado = painelLogin.autenticar();
					bloquearTodoMenu();
					if (usuarioAutenticado != null && usuarioAutenticado.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);
						mnEnderecos.setEnabled(true);
						mnUsuarios.setEnabled(true);
						painelCadastroUsuario = new PainelCadastroUsuario();
						frame.setContentPane(painelCadastroUsuario);
						frame.revalidate();
						
						
					} else if (usuarioAutenticado != null && usuarioAutenticado.getTipoUsuario() == TipoUsuario.PERSONAL_TRAINER){
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);
						painelCadastroTreino = new PainelCadastroTreino();
						frame.setContentPane(painelCadastroTreino);
						frame.revalidate();
					} else {
						mnAgendamentos.setEnabled(true);
						painelAgendamentoTreino = new PainelAgendamentoTreino();
						frame.setContentPane(painelAgendamentoTreino);
						frame.revalidate();
					}
					
					
				} catch (CampoInvalidoException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					
				}

			}
		});

		frame.setContentPane(painelLogin);

//		protected void registrarCliqueBotaoEditarDoPainelListagemEndereco() {
//			painelListagemEnderecoAlterado.getBtnEditar().addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					painelCadastroEndereco = new PainelCadastroEndereco(painelListagemEnderecoAlterado);
//					painelCadastroEndereco.setVisible(true);
//					registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
//					//Atualiza a tela principal
//					frame.setContentPane(painelCadastroEndereco);
//					frame.revalidate();
//				}
//			});
//		}

//		protected void registrarCliqueBotaoVoltarDoPainelCadastroEndereco() {
//			if(painelCadastroEndereco == null) {
//				painelCadastroEndereco = new PainelCadastroEndereco(null);
//			}
//			painelCadastroEndereco.getBtnVoltar().addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					painelListagemEnderecoAlterado = new PainelListagemEndereco();
//					painelListagemEnderecoAlterado.setVisible(true);
//					registrarCliqueBotaoEditarDoPainelListagemEndereco();
//					frame.setContentPane(painelListagemEnderecoAlterado);
//					frame.revalidate();
//				}
//			});

	}

	private void bloquearTodoMenu() {
		mnAgendamentos.setEnabled(false);
		mnTreinos.setEnabled(false);
		mnEnderecos.setEnabled(false);
		mnUsuarios.setEnabled(false);
	}

}
