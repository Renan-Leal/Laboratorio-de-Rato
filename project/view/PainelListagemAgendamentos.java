package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.AgendamentoController;
import controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.exception.EnderecoInvalidoException;
import model.vo.Agendamento;
import model.vo.Endereco;
import model.vo.TipoUsuario;
import model.vo.Usuario;
import controller.AgendamentoController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class PainelListagemAgendamentos extends JPanel {

	private ArrayList<Agendamento> agendamentos;
	private String[] nomesColunas = { "Cliente", "Personal", "Hora Inicio", "Hora Final" };
	private JTable tblAgendamentos;
	private JLabel lblUsuario;
	private JComboBox cbUsuario;
	private JButton btnBuscarMeusAgendamentos;
	private JButton btnExcluir;
	private JLabel lblPaginacao;
	private JButton btnAvancarPagina;
	private JButton btnVoltarPagina;
	private JButton btnGerarPlanilha;
	private final int TAMANHO_PAGINA = 5;
	private int paginaAtual = 1;
	private int totalPaginas = 0;

	private AgendamentoController controller = new AgendamentoController();
	private Agendamento agendamentoSelecionado;
	private JButton btnVoltar;
	private JButton btnBuscarTodosAgendamentos;

	private void limparTabelaAgendamentos() {
		tblAgendamentos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaAgendamentos() {
		DateTimeFormatter dataHoraApresentavel = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.limparTabelaAgendamentos();

		DefaultTableModel model = (DefaultTableModel) tblAgendamentos.getModel();

		for (Agendamento a : agendamentos) {
			Object[] novaLinhaDaTabela = new Object[4];
			novaLinhaDaTabela[0] = a.getCliente();
			novaLinhaDaTabela[1] = a.getProfissional();
			novaLinhaDaTabela[2] = a.getDataHoraInicio().format(dataHoraApresentavel);
			novaLinhaDaTabela[3] = a.getDataHoraFinal().format(dataHoraApresentavel);

			model.addRow(novaLinhaDaTabela);
		}
	}

	public PainelListagemAgendamentos(Usuario usuarioAutenticado) {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(183dlu;pref):grow"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(74dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(73dlu;pref):grow"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(36dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(59dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(60dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(57dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.GROWING_BUTTON_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.GROWING_BUTTON_COLSPEC, },
				new RowSpec[] { RowSpec.decode("fill:max(23dlu;pref):grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:max(11dlu;default)"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:max(89dlu;pref):grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:max(23dlu;pref):grow"), }));

		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblUsuario.setForeground(Color.BLACK);
		add(lblUsuario, "14, 7, center, center");

		cbUsuario = new JComboBox(new ArrayList<Usuario>(Collections.singletonList(usuarioAutenticado)).toArray());
		cbUsuario.setForeground(Color.BLACK);
		cbUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(cbUsuario, "16, 7, 5, 1, fill, fill");

		btnBuscarMeusAgendamentos = new JButton("Buscar");
		btnBuscarMeusAgendamentos.setBackground(Color.BLACK);
		btnBuscarMeusAgendamentos.setForeground(Color.WHITE);
		btnBuscarMeusAgendamentos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnBuscarMeusAgendamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendamentos = (ArrayList<Agendamento>) controller
						.buscarAgendamentosUsuarioAutenticado(usuarioAutenticado);
				atualizarTabelaAgendamentos();
			}
		});
		add(btnBuscarMeusAgendamentos, "22, 7, fill, fill");

		tblAgendamentos = new JTable();
		tblAgendamentos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		limparTabelaAgendamentos();
		tblAgendamentos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblAgendamentos.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnExcluir.setEnabled(true);
					agendamentoSelecionado = agendamentos.get(indiceSelecionado - 1);
				} else {
					btnExcluir.setEnabled(false);
				}
			}
		});

		btnBuscarTodosAgendamentos = new JButton("Buscar Todos");
		btnBuscarTodosAgendamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendamentos = (ArrayList<Agendamento>) controller.consultarTodos();
				atualizarTabelaAgendamentos();
			}
		});
		btnBuscarTodosAgendamentos.setForeground(Color.WHITE);
		btnBuscarTodosAgendamentos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnBuscarTodosAgendamentos.setBackground(Color.BLACK);
		add(btnBuscarTodosAgendamentos, "24, 7");

		lblPaginacao = new JLabel("1 / " + totalPaginas);
		lblPaginacao.setForeground(Color.BLACK);
		lblPaginacao.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblPaginacao.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPaginacao, "24, 9");
		add(tblAgendamentos, "14, 11, 11, 1, fill, fill");

		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.setBackground(Color.BLACK);
		btnAvancarPagina.setForeground(Color.WHITE);
		btnAvancarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		add(btnAvancarPagina, "14, 15, fill, fill");

		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltarPagina.setBackground(Color.BLACK);
		btnVoltarPagina.setForeground(Color.WHITE);
		btnVoltarPagina.setEnabled(false);
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		add(btnVoltarPagina, "16, 15, fill, fill");

		btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnGerarPlanilha.setBackground(Color.BLACK);
		btnGerarPlanilha.setForeground(Color.WHITE);
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");
				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					String resultado;
					try {
						resultado = controller.gerarPlanilha(agendamentos, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null,
						"Confirma a exclusão do agendamento selecionado?");
				if (opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(agendamentoSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso!");
						agendamentos = (ArrayList<Agendamento>) controller.consultarTodos();
						atualizarTabelaAgendamentos();
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnExcluir, "24, 15, fill, fill");
		add(btnGerarPlanilha, "14, 17, center, fill");
		atualizarQuantidadePaginas();

		btnVoltar = new JButton("Pagina Inicial");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnVoltar, "16, 17");

		if (usuarioAutenticado.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
			btnBuscarTodosAgendamentos.setVisible(true);
			btnBuscarMeusAgendamentos.setVisible(false);
			btnExcluir.setVisible(true);

		} else if (usuarioAutenticado.getTipoUsuario() == TipoUsuario.PERSONAL_TRAINER) {
			btnBuscarTodosAgendamentos.setVisible(false);
			btnBuscarMeusAgendamentos.setVisible(true);
			btnExcluir.setVisible(true);

		} else if (usuarioAutenticado.getTipoUsuario() == TipoUsuario.CLIENTE) {
			btnBuscarTodosAgendamentos.setVisible(false);
			btnBuscarMeusAgendamentos.setVisible(true);
			btnExcluir.setVisible(false);
		}
	}

	private void atualizarQuantidadePaginas() {
		// Cálculo do total de páginas
		int totalRegistros = controller.contarTotalRegistros(agendamentoSelecionado);

		// QUOCIENTE da divisão inteira
		totalPaginas = totalRegistros / TAMANHO_PAGINA;

		// RESTO da divisão inteira
		if (totalRegistros % TAMANHO_PAGINA > 0) {
			totalPaginas++;
		}
		lblPaginacao.setText(paginaAtual + " / " + totalPaginas);

	}

	public Agendamento getAgendamentoSelecionado() {
		return agendamentoSelecionado;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}
