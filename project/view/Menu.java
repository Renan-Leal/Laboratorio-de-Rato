package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import model.vo.TipoUsuario;
import model.vo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Menu {

	private JFrame frame;
	private PainelLogin painelLogin;
	private PainelAgendamentoTreino painelAgendamentoTreino;
	private PainelCadastroEndereco painelCadastroEndereco;
	private PainelCadastroTreino painelCadastroTreino;
	private PainelCadastroUsuario painelCadastroUsuario;
	private PainelListagemEndereco painelListagemEndereco;
	private PainelListagemUsuarios painelListagemUsuario;
	private PainelListagemTreinos painelListagemTreino;
	private PainelListagemAgendamentos painelListagemAgendamento;

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

		painelLogin = new PainelLogin();
		painelLogin.getBtnLogar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario usuarioAutenticado = painelLogin.autenticar();
					bloquearTodoMenu();
					if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);
						mnEnderecos.setEnabled(true);
						mnUsuarios.setEnabled(true);

					} else if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.PERSONAL_TRAINER) {
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);

					} else if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.CLIENTE) {
						mnAgendamentos.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
					}

				} catch (CampoInvalidoException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		frame.setContentPane(painelLogin);

		mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setIcon(new ImageIcon(
				Menu.class.getResource("/model/icones/icons8-primeiro-plano-do-grupo-selecionado-30.png")));
		menuBar.add(mnUsuarios);

		mntmCadastrarUsuario = new JMenuItem("Cadastrar");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO continuar método de cadastrar usuário
				painelCadastroUsuario = new PainelCadastroUsuario(null, null);
				frame.setContentPane(painelCadastroUsuario);
				frame.revalidate();

			}
		});
		mntmCadastrarUsuario.setIcon(
				new ImageIcon(Menu.class.getResource("/model/icones/icons8-adicionar-usuário-masculino-30.png")));
		mnUsuarios.add(mntmCadastrarUsuario);

		mntmListarUsuario = new JMenuItem("Listar");
		mntmListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemUsuario = new PainelListagemUsuarios();
				frame.setContentPane(painelListagemUsuario);
				frame.revalidate();

			}
		});
		mntmListarUsuario
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-usuário-feminino-30.png")));
		mnUsuarios.add(mntmListarUsuario);

		mnTreinos = new JMenu("Treinos");
		mnTreinos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-barra-de-peso-30.png")));
		menuBar.add(mnTreinos);

		mntmCadastrarTreino = new JMenuItem("Cadastrar");
		mntmCadastrarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroTreino = new PainelCadastroTreino();
				frame.setContentPane(painelCadastroTreino);
				frame.revalidate();
			}
		});
		mntmCadastrarTreino.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-adicionar-30 (1).png")));
		mnTreinos.add(mntmCadastrarTreino);

		mntmListarTreinos = new JMenuItem("Listar");
		mntmListarTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemTreino = new PainelListagemTreinos();
				frame.setContentPane(painelListagemTreino);
				frame.revalidate();
			}
		});
		mntmListarTreinos
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-propriedade-30.png")));
		mnTreinos.add(mntmListarTreinos);

		mnAgendamentos = new JMenu("Agendamentos");
		mnAgendamentos
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-halteres-com-presilha-30.png")));
		menuBar.add(mnAgendamentos);

		mntmCadastrarAgendamento = new JMenuItem("Cadastrar");
		mntmCadastrarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAgendamentoTreino = new PainelAgendamentoTreino();
				frame.setContentPane(painelAgendamentoTreino);
				frame.revalidate();
			}
		});
		mntmCadastrarAgendamento
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-adicionar-30.png")));
		mnAgendamentos.add(mntmCadastrarAgendamento);

		mntmListarAgendamento = new JMenuItem("Listar");
		mntmListarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemAgendamento = new PainelListagemAgendamentos();
				frame.setContentPane(painelListagemAgendamento);
				frame.revalidate();
			}
		});
		mntmListarAgendamento
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-propriedade-30 (1).png")));
		mnAgendamentos.add(mntmListarAgendamento);

		mnEnderecos = new JMenu("Endereços");
		mnEnderecos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-gym-30.png")));
		menuBar.add(mnEnderecos);

		mntmCadastrarEndereco = new JMenuItem("Cadastrar");
		mntmCadastrarEndereco
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-mapa-da-apple-30 (1).png")));
		mntmCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEndereco = new PainelCadastroEndereco(null);
				painelCadastroEndereco.setVisible(true);
				// registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
				frame.setContentPane(painelCadastroEndereco);
				frame.revalidate();
				registrarCliqueBotaoSalvarEndereco();
			}
		});
		mnEnderecos.add(mntmCadastrarEndereco);

		mntmListarEnderecos = new JMenuItem("Listar");
		mntmListarEnderecos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-google-maps-30.png")));
		mntmListarEnderecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelListagemEndereco = new PainelListagemEndereco();
				painelListagemEndereco.setVisible(true);
				registrarCliqueBotaoEditarListagemEndereco();

				frame.setContentPane(painelListagemEndereco);
				// Atualiza a tela principal
				frame.revalidate();
			}
		});
		mnEnderecos.add(mntmListarEnderecos);

		// Método para desbloquear o menu
		bloquearTodoMenu();
	}

	protected void registrarCliqueBotaoSalvarEndereco() {
		painelCadastroEndereco.getBtnSalvar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEndereco.cadastrarEndereco();
			}
		}));
	}

	protected void registrarCliqueBotaoEditarListagemEndereco() {
		painelListagemEndereco.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = painelListagemEndereco.getEnderecoSelecionado();
				painelCadastroEndereco = new PainelCadastroEndereco(endereco);
				frame.setContentPane(painelCadastroEndereco);
				frame.revalidate();
				registrarCliqueBotaoSalvarEndereco();
			}
		});

	}

	private void bloquearTodoMenu() {
		mnAgendamentos.setEnabled(false);
		mnTreinos.setEnabled(false);
		mnEnderecos.setEnabled(false);
		mnUsuarios.setEnabled(false);

	}
}