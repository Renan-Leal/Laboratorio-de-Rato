package view;

import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.exception.EnderecoInvalidoException;
import model.seletor.EnderecoSeletor;
import model.vo.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class PainelListagemEnderecos extends JPanel {
	
	private ArrayList<Endereco> enderecos;
	private String[] nomesColunas = { "Rua", "Numero", "CEP", "Bairro", "Cidade", "Estado" };

	private JButton btnEditar;
	private JTable tblEnderecos;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JButton btnBuscar;
	private JLabel lblCidade;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JLabel lblBairro;
	private JLabel lblPaginacao;
	private JButton btnAvancarPagina;
	private JButton btnVoltarPagina;
	private final int TAMANHO_PAGINA = 5;
	private int paginaAtual = 1;
	private int totalPaginas = 0;
	private EnderecoSeletor seletor = new EnderecoSeletor();
	private String[] estados = {"","PR", "RS", "SC"};
	
	private EnderecoController controller = new EnderecoController();
	private Endereco enderecoSelecionado;
	private JButton btnBuscarTodos;
	private JButton btnVoltar;
	private JLabel lblEstado;
	private JComboBox cbEstado;
	private JLabel lblCep;
	private JTextField txtCep;
	private MaskFormatter mascaraTxtCep;
	private String cepSemMascara;
	
	private void limparTabelaEnderecos() {
		tblEnderecos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaEnderecos() {
		this.limparTabelaEnderecos();

		DefaultTableModel model = (DefaultTableModel) tblEnderecos.getModel();

		for (Endereco e : enderecos) {
			Object[] novaLinhaDaTabela = new Object[6];
			novaLinhaDaTabela[0] = e.getRua();
			novaLinhaDaTabela[1] = e.getNumero();
			novaLinhaDaTabela[2] = e.getCep();
			novaLinhaDaTabela[3] = e.getBairro();
			novaLinhaDaTabela[4] = e.getCidade();
			novaLinhaDaTabela[5] = e.getEstado();

			model.addRow(novaLinhaDaTabela);
		}
	}
	
	
	public PainelListagemEnderecos(){
		
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(249dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(0dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(104dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(68dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(81dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(65dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(6dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("fill:max(61dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(23dlu;pref):grow"),
				RowSpec.decode("fill:pref:grow"),}));
		
		tblEnderecos = new JTable();
		tblEnderecos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		limparTabelaEnderecos();
		tblEnderecos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblEnderecos.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					enderecoSelecionado = enderecos.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
				
				lblCep = new JLabel("CEP:");
				lblCep.setForeground(Color.BLACK);
				lblCep.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				add(lblCep, "12, 7, center, default");
				
				
				txtCep = new JFormattedTextField(mascaraTxtCep);
				txtCep.setColumns(10);
				add(txtCep, "14, 7, 3, 1, fill, default");
				
				lblBairro = new JLabel("Bairro:");
				lblBairro.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				lblBairro.setForeground(Color.BLACK);
				add(lblBairro, "12, 9, center, fill");
				
				txtBairro = new JTextField();
				add(txtBairro, "14, 9, 3, 1, fill, fill");
				txtBairro.setColumns(10);
				
				lblCidade = new JLabel("Cidade:");
				lblCidade.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				lblCidade.setForeground(Color.BLACK);
				add(lblCidade, "12, 11, center, fill");
				
				txtCidade = new JTextField();
				add(txtCidade, "14, 11, 3, 1, fill, fill");
				txtCidade.setColumns(10);
				
				lblEstado = new JLabel("Estado:");
				lblEstado.setForeground(Color.BLACK);
				lblEstado.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				add(lblEstado, "12, 13, center, default");
				
				cbEstado = new JComboBox(estados);
				cbEstado.setForeground(Color.WHITE);
				cbEstado.setBackground(Color.DARK_GRAY);
				cbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				add(cbEstado, "14, 13, 3, 1, fill, default");
				
				btnBuscar = new JButton("Buscar Com Filtros");
				btnBuscar.setBackground(Color.BLACK);
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buscarEnderecosComFiltros();
						atualizarTabelaEnderecos();
					}
				});
				add(btnBuscar, "14, 15, fill, fill");
		
				btnBuscarTodos = new JButton("Buscar Todos");
				btnBuscarTodos.setBackground(Color.BLACK);
				btnBuscarTodos.setForeground(Color.WHITE);
				btnBuscarTodos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				btnBuscarTodos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buscarEnderecosComFiltros();
						atualizarTabelaEnderecos();
					}
				});
				add(btnBuscarTodos, "16, 15, fill, fill");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(btnVoltar, "16, 25, fill, fill");
		add(tblEnderecos, "12, 18, 9, 4, fill, fill");
		
		
		
		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.setBackground(Color.BLACK);
		btnAvancarPagina.setForeground(Color.WHITE);
		btnAvancarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				buscarEnderecosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		
		lblPaginacao = new JLabel("1 / " + totalPaginas);
		lblPaginacao.setForeground(Color.BLACK);
		lblPaginacao.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblPaginacao.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPaginacao, "12, 23");
		add(btnAvancarPagina, "12, 25, fill, fill");
		
		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltarPagina.setBackground(Color.BLACK);
		btnVoltarPagina.setForeground(Color.WHITE);
		btnVoltarPagina.setEnabled(false);
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				buscarEnderecosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		add(btnVoltarPagina, "14, 25, fill, fill");
		
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.BLACK);
		btnEditar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnEditar.setEnabled(false);
		add(btnEditar, "12, 27, fill, fill");
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do endereço selecionado?");
				
				if(opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(enderecoSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Endereço excluído com sucesso");
						enderecos = (ArrayList<Endereco>) controller.consultarTodos();
						atualizarTabelaEnderecos();
					} catch (EnderecoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnExcluir, "14, 27, fill, fill");
		
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
						resultado = controller.gerarPlanilha(enderecos, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add(btnGerarPlanilha, "16, 27, fill, fill");
		atualizarQuantidadePaginas();

	}
	
	protected void buscarEnderecos() {
		this.enderecos = (ArrayList<Endereco>) controller.consultarTodos();
		
	}

	protected void buscarEnderecosComFiltros(){
		seletor = new EnderecoSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
		seletor.setCep(txtCep.getText());
		seletor.setEstado((String)cbEstado.getSelectedItem());
		seletor.setBairro(txtBairro.getText());
		seletor.setCidade(txtCidade.getText());

		enderecos = (ArrayList<Endereco>) controller.consultarComFiltros(seletor);
		atualizarTabelaEnderecos();
		atualizarQuantidadePaginas();
		
	}

	private void atualizarQuantidadePaginas() {
		//Cálculo do total de páginas (poderia ser feito no backend)
				int totalRegistros = controller.contarTotalRegistrosComFiltros(seletor);
				
				//QUOCIENTE da divisão inteira
				totalPaginas = totalRegistros / TAMANHO_PAGINA;
				
				//RESTO da divisão inteira
				if(totalRegistros % TAMANHO_PAGINA > 0) { 
					totalPaginas++;
				}
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
		
	}
		public JButton getBtnEditar() {
			return this.btnEditar;
		}

		public Endereco getEnderecoSelecionado() {
			return enderecoSelecionado;
		}
		
		public JButton getBtnVoltar() {
			return this.btnVoltar;
		}

}
