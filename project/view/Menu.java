package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.exception.CampoInvalidoException;
import model.exception.SenhaInvalidaException;
import model.vo.Endereco;
import model.vo.TipoUsuario;
import model.vo.Treino;
import model.vo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Menu {

	private JFrame frame;
	private PainelLogin painelLogin;
	private PainelCadastroAgendamento painelCadastroAgendamento;
	private PainelCadastroEndereco painelCadastroEndereco;
	private PainelCadastroTreino painelCadastroTreino;
	private PainelCadastroUsuario painelCadastroUsuario;
	private PainelListagemEnderecos painelListagemEndereco;
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
	protected Usuario usuarioAutenticado;
	private PainelPrincipal painelPrincipal;

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
		frame.setBounds(100, 100, 601, 344);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setForeground(new Color(128, 255, 128));
		frame.setJMenuBar(menuBar);

		painelLogin = new PainelLogin();
		painelLogin.getBtnLogar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuarioAutenticado = painelLogin.autenticar();
					bloquearTodoMenu();
					if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);
						mnEnderecos.setEnabled(true);
						mnUsuarios.setEnabled(true);
						painelPrincipal = new PainelPrincipal();
						frame.setContentPane(painelPrincipal);
						frame.revalidate();

					} else if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.PERSONAL_TRAINER) {
						mnAgendamentos.setEnabled(true);
						mnTreinos.setEnabled(true);
						painelPrincipal = new PainelPrincipal();
						frame.setContentPane(painelPrincipal);
						frame.revalidate();

					} else if (usuarioAutenticado != null
							&& usuarioAutenticado.getTipoUsuario() == TipoUsuario.CLIENTE) {
						mnAgendamentos.setEnabled(true);
						painelPrincipal = new PainelPrincipal();
						frame.setContentPane(painelPrincipal);
						frame.revalidate();
					} else {
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (CampoInvalidoException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		frame.setContentPane(painelLogin);

		mnUsuarios = new JMenu("Usuários");
		mnUsuarios.setEnabled(false);
		mnUsuarios.setForeground(Color.WHITE);
		mnUsuarios.setBackground(Color.BLACK);
		mnUsuarios.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		mnUsuarios.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-grupo-de-usuários-50.png")));
		menuBar.add(mnUsuarios);

		mntmCadastrarUsuario = new JMenuItem("Cadastrar");
		mntmCadastrarUsuario.setBackground(Color.WHITE);
		mntmCadastrarUsuario.setForeground(Color.BLACK);
		mntmCadastrarUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroUsuario = new PainelCadastroUsuario(null);
				frame.setContentPane(painelCadastroUsuario);
				frame.revalidate();
				registrarCliqueBotaoSalvarUsuario();
				registrarCliqueBotaoVoltarDoPainelCadastroUsuario();

			}
		});
		mntmCadastrarUsuario.setIcon(new ImageIcon(
				Menu.class.getResource("/model/icones/icons8-adicionar-usuário-do-sexo-feminino-50.png")));
		mnUsuarios.add(mntmCadastrarUsuario);

		mntmListarUsuario = new JMenuItem("Listagem");
		mntmListarUsuario.setForeground(Color.BLACK);
		mntmListarUsuario.setBackground(Color.WHITE);
		mntmListarUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemUsuario = new PainelListagemUsuarios();
				frame.setContentPane(painelListagemUsuario);
				frame.revalidate();
				registrarCliqueBotaoEditarUsuario();
				registrarCliqueBotaoVoltarDoPainelListagemUsuario();

			}
		});
		mntmListarUsuario
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-utilizador-50.png")));
		mnUsuarios.add(mntmListarUsuario);

		mnTreinos = new JMenu("Treinos");
		mnTreinos.setBackground(Color.BLACK);
		mnTreinos.setForeground(Color.WHITE);
		mnTreinos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		mnTreinos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-strength-50.png")));
		menuBar.add(mnTreinos);

		mntmCadastrarTreino = new JMenuItem("Cadastrar");
		mntmCadastrarTreino.setForeground(Color.BLACK);
		mntmCadastrarTreino.setBackground(Color.WHITE);
		mntmCadastrarTreino.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmCadastrarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroTreino = new PainelCadastroTreino(usuarioAutenticado, null);
				frame.setContentPane(painelCadastroTreino);
				frame.revalidate();
				registrarCliqueBotaoSalvarTreino();
				registrarCliqueBotaoVoltarDoPainelCadastroTreino();
			}
		});
		mntmCadastrarTreino.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-adicionar-50 (1).png")));
		mnTreinos.add(mntmCadastrarTreino);

		mntmListarTreinos = new JMenuItem("Listagem");
		mntmListarTreinos.setForeground(Color.BLACK);
		mntmListarTreinos.setBackground(Color.WHITE);
		mntmListarTreinos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmListarTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemTreino = new PainelListagemTreinos(usuarioAutenticado);
				frame.setContentPane(painelListagemTreino);
				frame.revalidate();
				registrarCliqueBotaoEditarTreino();
				registrarCliqueBotaoVoltarDoPainelListarTreino();
				registrarCliqueBotaoEncaminharEmailTreino();
			}
		});
		mntmListarTreinos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-vários-50.png")));
		mnTreinos.add(mntmListarTreinos);

		mnAgendamentos = new JMenu("Agendamentos");
		mnAgendamentos.setBackground(Color.BLACK);
		mnAgendamentos.setForeground(Color.WHITE);
		mnAgendamentos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		mnAgendamentos
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-women-track-and-field-50.png")));
		menuBar.add(mnAgendamentos);
		mntmCadastrarAgendamento = new JMenuItem("Cadastrar");
		mntmCadastrarAgendamento.setBackground(Color.WHITE);
		mntmCadastrarAgendamento.setForeground(Color.BLACK);
		mntmCadastrarAgendamento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmCadastrarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroAgendamento = new PainelCadastroAgendamento(usuarioAutenticado, null);
				frame.setContentPane(painelCadastroAgendamento);
				frame.revalidate();
				registrarCliqueBotaoCadastrarAgendamento();
				registrarCliqueBotaoVoltarDoPainelCadastrarAgendamento();
			}
		});
		mntmCadastrarAgendamento
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-adicionar-arquivo-50.png")));
		mnAgendamentos.add(mntmCadastrarAgendamento);

		mntmListarAgendamento = new JMenuItem("Listagem");
		mntmListarAgendamento.setForeground(Color.BLACK);
		mntmListarAgendamento.setBackground(Color.WHITE);
		mntmListarAgendamento.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmListarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemAgendamento = new PainelListagemAgendamentos();
				frame.setContentPane(painelListagemAgendamento);
				frame.revalidate();
				registrarCliqueBotaoVoltarDoPainelListarAgendamento();
			}
		});
		mntmListarAgendamento
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-editar-propriedade-50.png")));
		mnAgendamentos.add(mntmListarAgendamento);

		mnEnderecos = new JMenu("Endereços");
		mnEnderecos.setBackground(Color.BLACK);
		mnEnderecos.setForeground(Color.WHITE);
		mnEnderecos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		mnEnderecos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-endereço-50.png")));
		menuBar.add(mnEnderecos);

		mntmCadastrarEndereco = new JMenuItem("Cadastrar");
		mntmCadastrarEndereco.setBackground(Color.WHITE);
		mntmCadastrarEndereco.setForeground(Color.BLACK);
		mntmCadastrarEndereco.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmCadastrarEndereco
				.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-endereço-50 (1).png")));
		mntmCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEndereco = new PainelCadastroEndereco(null);
				painelCadastroEndereco.setVisible(true);
				// registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
				frame.setContentPane(painelCadastroEndereco);
				frame.revalidate();
				registrarCliqueBotaoSalvarEndereco();
				registrarCliqueBotaoVoltarDoPainelCadastroEndereco();
			}
		});
		mnEnderecos.add(mntmCadastrarEndereco);

		mntmListarEnderecos = new JMenuItem("Listagem");
		mntmListarEnderecos.setBackground(Color.WHITE);
		mntmListarEnderecos.setForeground(Color.BLACK);
		mntmListarEnderecos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mntmListarEnderecos.setIcon(new ImageIcon(Menu.class.getResource("/model/icones/icons8-mapa-50.png")));
		mntmListarEnderecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelListagemEndereco = new PainelListagemEnderecos();
				painelListagemEndereco.setVisible(true);
				registrarCliqueBotaoEditarListagemEndereco();
				registrarCliqueBotaoVoltarDoPainelListagemEndereco();

				frame.setContentPane(painelListagemEndereco);
				// Atualiza a tela principal
				frame.revalidate();
			}
		});
		mnEnderecos.add(mntmListarEnderecos);

		// Método para desbloquear o menu
		bloquearTodoMenu();
	}

	protected void registrarCliqueBotaoEncaminharEmailTreino() {
		painelListagemTreino.getBtnEncaminharEmailTreino().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelListagemTreino.encaminharEmailTreino();
				
			}
		});

	}

	protected void registrarCliqueBotaoCadastrarAgendamento() {
		painelCadastroAgendamento.getBtnSalvar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroAgendamento.cadastrarAgendamentoTreino();

			}
		});

	}

	protected void registrarCliqueBotaoEditarTreino() {
		painelListagemTreino.getBtnEditar().addActionListener((new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Treino treinoSelecionado = painelListagemTreino.getTreinoSelecionado();
				painelCadastroTreino = new PainelCadastroTreino(usuarioAutenticado, treinoSelecionado);
				frame.setContentPane(painelCadastroTreino);
				frame.revalidate();
				registrarCliqueBotaoSalvarTreino();

			}
		}));

	}

	protected void registrarCliqueBotaoSalvarTreino() {
		painelCadastroTreino.getBtnCadastrar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				painelCadastroTreino.cadastrarTreino();

			}
		}));

	}

	protected void registrarCliqueBotaoSalvarUsuario() {
		painelCadastroUsuario.getBtnSalvar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelCadastroUsuario.cadastrarUsuario();
				} catch (SenhaInvalidaException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		}));

	}

	protected void registrarCliqueBotaoEditarUsuario() {
		painelListagemUsuario.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = painelListagemUsuario.getUsuarioSelecionado();
				painelCadastroUsuario = new PainelCadastroUsuario(usuario);
				frame.setContentPane(painelCadastroUsuario);
				frame.revalidate();
				registrarCliqueBotaoSalvarUsuario();
			}
		});

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

	protected void registrarCliqueBotaoVoltarDoPainelCadastroEndereco() {
		painelCadastroEndereco.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelListagemEndereco() {
		painelListagemEndereco.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelCadastroUsuario() {
		painelCadastroUsuario.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelListagemUsuario() {
		painelListagemUsuario.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelCadastroTreino() {
		painelCadastroTreino.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelListarTreino() {
		painelListagemTreino.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelCadastrarAgendamento() {
		painelCadastroAgendamento.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	protected void registrarCliqueBotaoVoltarDoPainelListarAgendamento() {
		painelListagemAgendamento.getBtnVoltar().addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(painelPrincipal);
				frame.revalidate();
			}
		}));
	}

	private void bloquearTodoMenu() {
		mnAgendamentos.setEnabled(false);
		mnTreinos.setEnabled(false);
		mnEnderecos.setEnabled(false);

	}
}