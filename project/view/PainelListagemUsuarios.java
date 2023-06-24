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
		this.setLayout(null);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(27, 34, 34, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(71, 31, 163, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		cbTipoUsuario = new JComboBox(new String[] {"Administrador","Cliente","Personal"});
		cbTipoUsuario.setBounds(337, 30, 154, 22);
		add(cbTipoUsuario);
		
		lblTipoUsuario = new JLabel("Tipo de Usuário:");
		lblTipoUsuario.setBounds(243, 34, 91, 14);
		add(lblTipoUsuario);
		
		btnBuscarComFiltro = new JButton("Buscar com Filtro");
		btnBuscarComFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuariosComFiltros();
				atualizarTabelaUsuarios();
			}
		});
		btnBuscarComFiltro.setBounds(512, 30, 121, 23);
		this.add(btnBuscarComFiltro);
		
		tblUsuarios = new JTable();
		this.limparTabelaUsuarios();
		
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
		tblUsuarios.setBounds(27, 106, 650, 133);
		this.add(tblUsuarios);
		
		btnGerarPlanilha = new JButton("Gerar Planilha");
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
		btnGerarPlanilha.setBounds(27, 248, 99, 23);
		this.add(btnGerarPlanilha);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(124, 282, 65, 23);
		btnEditar.setEnabled(false);
		this.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(27, 282, 65, 23);
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
		this.add(btnExcluir);
		
		lblPaginacao = new JLabel("1 / " + totalPaginas);
		lblPaginacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaginacao.setBounds(283, 308, 105, 14);
		add(lblPaginacao);
		
		atualizarQuantidadePaginas();
		
		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				buscarUsuariosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnVoltarPagina.setEnabled(false);
		btnVoltarPagina.setBounds(524, 248, 109, 23);
		add(btnVoltarPagina);
		
		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				buscarUsuariosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnAvancarPagina.setBounds(380, 248, 120, 23);
		add(btnAvancarPagina);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuarios();
				atualizarTabelaUsuarios();
			}
		});
		btnBuscarTodos.setBounds(512, 72, 121, 23);
		this.add(btnBuscarTodos);

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
