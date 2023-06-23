package model.gerador;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import model.vo.Agendamento;
import model.vo.Endereco;
import model.vo.Treino;
import model.vo.Usuario;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GeradorPlanilha {
	
	public String gerarPlanilhaEnderecos(List<Endereco> enderecos, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Enderecos");
		
		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Rua");
		linhaCabecalho.createCell(1).setCellValue("Numero");
		linhaCabecalho.createCell(2).setCellValue("CEP");
		linhaCabecalho.createCell(3).setCellValue("Bairro");
		linhaCabecalho.createCell(4).setCellValue("Cidade");
		linhaCabecalho.createCell(5).setCellValue("Estado");
		
		int contadorLinhas = 1;
		for(Endereco e: enderecos) {
			HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
			novaLinha.createCell(0).setCellValue(e.getRua());
			novaLinha.createCell(1).setCellValue(e.getNumero());
			novaLinha.createCell(2).setCellValue(e.getCep());
			novaLinha.createCell(3).setCellValue(e.getBairro());
			novaLinha.createCell(4).setCellValue(e.getCidade());
			novaLinha.createCell(5).setCellValue(e.getEstado());
			contadorLinhas++;
		}
		
		return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	private String salvarNoDisco(HSSFWorkbook planilha, String caminhoArquivo) {
		String mensagem = "";
		FileOutputStream saida = null;
		String extensao = ".xls";

		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			mensagem = "Erro ao tentar salvar planilha (sem acesso): " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro de I/O ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
		return mensagem;
	}

	public String gerarPlanilhaUsuarios(ArrayList<Usuario> usuarios, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Usuarios");
		
		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Nome");
		linhaCabecalho.createCell(1).setCellValue("CPF");
		linhaCabecalho.createCell(2).setCellValue("Telefone");
		linhaCabecalho.createCell(3).setCellValue("Dt Nascimento");
		linhaCabecalho.createCell(4).setCellValue("Tipo");
		linhaCabecalho.createCell(5).setCellValue("Matricula");
		linhaCabecalho.createCell(6).setCellValue("Email");
		linhaCabecalho.createCell(7).setCellValue("ValorHora");
		
		int contadorLinhas = 1;
		for(Usuario u: usuarios) {
			HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
			novaLinha.createCell(0).setCellValue(u.getPessoa().getNome());
			novaLinha.createCell(1).setCellValue(u.getPessoa().getCpf());
			novaLinha.createCell(2).setCellValue(u.getPessoa().getTelefone());
			novaLinha.createCell(3).setCellValue(u.getPessoa().getDtNascimento());
			novaLinha.createCell(4).setCellValue(u.getTipoUsuario().getValor());
			novaLinha.createCell(5).setCellValue(u.getMatricula());
			novaLinha.createCell(6).setCellValue(u.getEmail());
			novaLinha.createCell(7).setCellValue(u.getValorHora());
			contadorLinhas++;
		}
		return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	public String gerarPlanilhaAgendamentos(ArrayList<Agendamento> agendamentos, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Agendamentos");
		
		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Cliente");
		linhaCabecalho.createCell(1).setCellValue("Data Hora Inicio");
		linhaCabecalho.createCell(2).setCellValue("Data Hora Final");
		linhaCabecalho.createCell(3).setCellValue("Aceito");
		linhaCabecalho.createCell(4).setCellValue("Motivo Rejeicao");
		
		int contadorLinhas = 1;
		for(Agendamento a: agendamentos) {
			HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
			novaLinha.createCell(0).setCellValue(a.getCliente().getNome());
			novaLinha.createCell(1).setCellValue(a.getDataHoraInicio());
			novaLinha.createCell(2).setCellValue(a.getDataHoraFinal());
			novaLinha.createCell(3).setCellValue(a.getAceito());
			novaLinha.createCell(4).setCellValue(a.getMotivoRejeicao());
			contadorLinhas++;
		}
		return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	public String gerarPlanilhaTreinos(List<Treino> treinos, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Treinos");
		
		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Cliente");
		linhaCabecalho.createCell(1).setCellValue("Personal");
		linhaCabecalho.createCell(2).setCellValue("Nivel Treino");
		linhaCabecalho.createCell(3).setCellValue("Treino");
		
		int contadorLinhas = 1;
		for(Treino t: treinos) {
			HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
			novaLinha.createCell(0).setCellValue(t.getCliente().getNome());
			novaLinha.createCell(1).setCellValue(t.getProfissional().getNome());
			novaLinha.createCell(2).setCellValue(t.getNivelTreino().getValor());
			novaLinha.createCell(3).setCellValue(t.getTreino());
			contadorLinhas++;
		}
		
		return salvarNoDisco(arquivoExcel, destinoArquivo);
	}

}
