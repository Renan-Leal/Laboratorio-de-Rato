package view;

import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PainelListagemEndereco extends JPanel {
	
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
	
	private EnderecoController controller = new EnderecoController();
	private Endereco enderecoSelecionado;
	private JButton btnBuscarTodos;
	
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
	
	
	public PainelListagemEndereco() {
		
		btnBuscar = new JButton("Buscar COM FILTROS");
		btnBuscar.setBounds(460, 22, 154, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEnderecosComFiltros();
				atualizarTabelaEnderecos();
			}
		});
		setLayout(null);
		this.add(btnBuscar);

		tblEnderecos = new JTable();
		this.limparTabelaEnderecos();
		
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
		tblEnderecos.setBounds(41, 88, 603, 133);
		this.add(tblEnderecos);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(243, 26, 46, 14);
		add(lblCidade);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(86, 23, 140, 20);
		add(txtBairro);
		txtBairro.setColumns(10);
		add(btnBuscar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(141, 282, 65, 23);
		add(btnEditar);
		
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
						resultado = controller.gerarPlanilha(enderecos, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnGerarPlanilha.setBounds(41, 238, 99, 23);
		this.add(btnGerarPlanilha);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(41, 282, 65, 23);
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
		this.add(btnExcluir);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(41, 26, 46, 14);
		add(lblBairro);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(299, 23, 140, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		lblPaginacao = new JLabel("1 / " + totalPaginas);
		lblPaginacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaginacao.setBounds(283, 323, 105, 14);
		add(lblPaginacao);
		
		atualizarQuantidadePaginas();
		
		btnVoltarPagina = new JButton("<< Voltar");
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual--;
				buscarEnderecosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnVoltarPagina.setEnabled(false);
		btnVoltarPagina.setBounds(533, 238, 109, 23);
		add(btnVoltarPagina);
		
		btnAvancarPagina = new JButton("Avançar >>");
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual++;
				buscarEnderecosComFiltros();
				lblPaginacao.setText(paginaAtual + " / " + totalPaginas);
				btnVoltarPagina.setEnabled(paginaAtual > 1);
				btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
			}
		});
		btnAvancarPagina.setBounds(380, 238, 120, 23);
		add(btnAvancarPagina);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.setBounds(460, 22, 154, 23);
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEnderecos();
				atualizarTabelaEnderecos();
			}
		});
		btnBuscarTodos.setBounds(460, 56, 154, 23);
		this.add(btnBuscarTodos);

	}
	
	protected void buscarEnderecos() {
		this.enderecos = (ArrayList<Endereco>) controller.consultarTodos();
		
	}

	protected void buscarEnderecosComFiltros() {
		seletor = new EnderecoSeletor();
		seletor.setLimite(TAMANHO_PAGINA);
		seletor.setPagina(paginaAtual);
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
	//Torna o btnEditar acessível externamente à essa classe
		public JButton getBtnEditar() {
			return this.btnEditar;
		}

		public Endereco getEnderecoSelecionado() {
			return enderecoSelecionado;
		}

}
