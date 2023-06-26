package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
//TODO Finalizar o método de consultar com filtro
public class PainelListagemUsuarios extends JPanel {
	
	private ArrayList<Usuario> usuarios;
	private String[] nomesColunas = { "Nome", "CPF", "Tel", "Dt.Nasc", "Tipo", "Matricula", "E-mail"};
	private JTextField txtNome;
	private JTable tblUsuarios;
	private JButton btnEditar;
	private JButton btnBuscar;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JLabel lblPaginacao;
	private JButton btnBuscarComFiltro;
	private JLabel lblTipoUsuario;
	private JComboBox cbTipoUsuario;
	private JButton btnAvancarPagina;
	private JButton btnVoltarPagina;
	private JLabel lblNome;
	private final int TAMANHO_PAGINA = 5;
	private int paginaAtual = 1;
	private int totalPaginas = 0;
	private JButton btnBuscarTodos;
	private UsuarioController controller = new UsuarioController();
	private Usuario usuarioSelecionado;
	private UsuarioSeletor seletor = new UsuarioSeletor();

	private void limparTabelaUsuarios() {
		tblUsuarios.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaUsuarios() {
		this.limparTabelaUsuarios();

		DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();

		for (Usuario u : usuarios) {
			Object[] novaLinhaDaTabela = new Object[7];
			novaLinhaDaTabela[0] = u.getPessoa().getNome();
			novaLinhaDaTabela[1] = u.getPessoa().getCpf();
			novaLinhaDaTabela[2] = u.getPessoa().getTelefone();
			novaLinhaDaTabela[3] = u.getPessoa().getDtNascimento();
			novaLinhaDaTabela[4] = u.getTipoUsuario().getValor() == 1 ? "Administrador" : u.getTipoUsuario().getValor() == 2 ? "Personal Trainer" : u.getTipoUsuario().getValor() == 3 ? "Cliente" : "NULL";
			novaLinhaDaTabela[5] = u.getMatricula();
			novaLinhaDaTabela[6] = u.getEmail();
			model.addRow(novaLinhaDaTabela);
		}
	}
	
	public PainelListagemUsuarios() {
		setBackground(new Color(108, 255, 108));
		setForeground(SystemColor.desktop);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(177dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(98dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(82dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:max(48dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(73dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:pref:grow"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("fill:pref:grow"),}));
		
		tblUsuarios = new JTable();
		tblUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		limparTabelaUsuarios();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblUsuarios.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					usuarioSelecionado = usuarios.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		
		btnBuscarComFiltro = new JButton("Buscar com Filtro");
		btnBuscarComFiltro.setBackground(Color.BLACK);
		btnBuscarComFiltro.setForeground(Color.WHITE);
		btnBuscarComFiltro.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnBuscarComFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuariosComFiltros();
				atualizarTabelaUsuarios();
			}
		});
		
		lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNome.setForeground(Color.BLACK);
		add(lblNome, "6, 3, center, center");
		
		txtNome = new JTextField();
		add(txtNome, "8, 3, fill, center");
		txtNome.setColumns(10);
		
		lblTipoUsuario = new JLabel("Tipo de Usuário:");
		lblTipoUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTipoUsuario.setForeground(Color.BLACK);
		add(lblTipoUsuario, "10, 3, center, center");
		
		cbTipoUsuario = new JComboBox(new String[] {"Administrador","Cliente","Personal"});
		cbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbTipoUsuario.setForeground(Color.BLACK);
		add(cbTipoUsuario, "12, 3, fill, fill");
		add(btnBuscarComFiltro, "14, 3, fill, fill");
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.setBackground(Color.BLACK);
		btnBuscarTodos.setForeground(Color.WHITE);
		btnBuscarTodos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuarios();
				atualizarTabelaUsuarios();
			}
		});
		
		lblPaginacao = new JLabel("1 / " + totalPaginas);
		lblPaginacao.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblPaginacao.setForeground(Color.BLACK);
		lblPaginacao.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPaginacao, "6, 5, left, bottom");
		add(btnBuscarTodos, "14, 5, fill, fill");
		add(tblUsuarios, "6, 7, 9, 1, fill, fill");
		
		atualizarQuantidadePaginas();
		
		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.setBackground(Color.BLACK);
		btnVoltarPagina.setForeground(Color.WHITE);
		btnVoltarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				buscarUsuariosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		
		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.setBackground(Color.BLACK);
		btnAvancarPagina.setForeground(Color.WHITE);
		btnAvancarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				buscarUsuariosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário selecionado?");
				
				if(opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(usuarioSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso");
						usuarios = (ArrayList<Usuario>) controller.consultarTodos();
						atualizarTabelaUsuarios();
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnExcluir, "6, 9, fill, top");
		
		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setBackground(Color.BLACK);
		btnGerarPlanilha.setForeground(Color.WHITE);
		btnGerarPlanilha.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");

				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					String resultado;
					try {
						resultado = controller.gerarPlanilha(usuarios, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnGerarPlanilha, "8, 9, left, fill");
		add(btnAvancarPagina, "12, 9, right, top");
		btnVoltarPagina.setEnabled(false);
		add(btnVoltarPagina, "14, 9, right, top");
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.BLACK);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnEditar.setEnabled(false);
		add(btnEditar, "6, 11, fill, top");

	}

	protected void buscarUsuarios() {
			this.usuarios = (ArrayList<Usuario>) controller.consultarTodos();
		
	}

	protected void buscarUsuariosComFiltros() {
		seletor = new UsuarioSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
		seletor.setNome(txtNome.getText());
		usuarios = (ArrayList<Usuario>) controller.consultarComFiltros(seletor);
		atualizarTabelaUsuarios();
		atualizarQuantidadePaginas();
	}

	private void atualizarQuantidadePaginas() {
				int totalRegistros = controller.contarTotalRegistrosComFiltros(seletor);
				
				//QUOCIENTE da divisão inteira
				totalPaginas = totalRegistros / TAMANHO_PAGINA;
				
				//RESTO da divisão inteira
				if(totalRegistros % TAMANHO_PAGINA > 0) { 
					totalPaginas++;
				}
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
		
	}
	//Torna o btnEditar acessível externamente à essa classe
		public JButton getBtnEditar() {
			return this.btnEditar;
		}

		public Usuario getUsuarioSelecionado() {
			return usuarioSelecionado;
		}
}
