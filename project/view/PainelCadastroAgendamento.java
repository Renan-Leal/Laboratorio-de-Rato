package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.AgendamentoController;
import model.controller.TreinoController;
import model.controller.UsuarioController;
import model.exception.CampoInvalidoException;
import model.vo.Agendamento;
import model.vo.Endereco;
import model.vo.TipoUsuario;
import model.vo.Usuario;
import java.awt.Color;
import java.awt.Font;

public class PainelCadastroAgendamento extends JPanel {

	private JLabel lblCliente;
	private JComboBox cbCliente;
	private JButton btnSalvar;
	private JLabel lblDataFinal;
	private JLabel lblDataInicio;
	private JComboBox cbProfissional;
	private JLabel lblPersonal;
	private JButton btnVoltar;
	private DateTimePicker dataHora;
	private DatePickerSettings dateSettings;
	private Agendamento agendamento;

	public PainelCadastroAgendamento(Usuario usuarioAutenticado, Agendamento agendamento) {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;pref):grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(41dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:max(38dlu;pref)"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(134dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(48dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(117dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.GROWING_BUTTON_COLSPEC, },
				new RowSpec[] { RowSpec.decode("fill:max(23dlu;pref):grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:max(11dlu;default)"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("fill:max(23dlu;pref):grow"), }));

		lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblCliente.setForeground(Color.BLACK);
		add(lblCliente, "14, 5, fill, fill");

		cbCliente = new JComboBox(new ArrayList<Usuario>(Collections.singletonList(usuarioAutenticado)).toArray());
		cbCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(cbCliente, "16, 5, 2, 1, fill, fill");

		lblPersonal = new JLabel("Personal:");
		lblPersonal.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblPersonal.setForeground(Color.BLACK);
		add(lblPersonal, "18, 5, center, center");

		cbProfissional = new JComboBox(
				new UsuarioController().consultarPorTipoUsuario(TipoUsuario.PERSONAL_TRAINER.getValor()).toArray());
		cbProfissional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(cbProfissional, "20, 5, 3, 1, fill, fill");

		lblDataInicio = new JLabel("Data Hora:");
		lblDataInicio.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblDataInicio.setForeground(Color.BLACK);
		add(lblDataInicio, "14, 11, fill, fill");

		dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		dataHora = new DateTimePicker(dateSettings, null);
		add(dataHora, "16, 11");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnVoltar, "16, 17, left, default");

		btnSalvar = new JButton("Agendar");
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnSalvar.setForeground(Color.WHITE);
		add(btnSalvar, "18, 17, center, center");
		
		this.agendamento = agendamento;
		if(this.agendamento != null) {
			preencherCamposTela();
		} else {
			this.agendamento = new Agendamento();
		}
	}

	private void preencherCamposTela() {
		this.dataHora.setDateTimePermissive(agendamento.getDataHoraInicio());
		this.cbProfissional.setSelectedItem(agendamento.getProfissional());
		
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void cadastrarAgendamentoTreino() {
		agendamento.setCliente((Usuario) cbCliente.getSelectedItem());
		agendamento.setProfissional((Usuario) cbProfissional.getSelectedItem());
		agendamento.setDataHoraInicio(dataHora.getDateTimePermissive());
		agendamento.setDataHoraFinal(dataHora.getDateTimePermissive().plusHours(1));

		AgendamentoController agendamentoController = new AgendamentoController();
		TreinoController treinoController = new TreinoController();

		try {
			if (agendamento.getId() == null) {
				agendamentoController.inserir(agendamento);
				treinoController.conectarClienteAoProfissional(agendamento);
				JOptionPane.showMessageDialog(null, "Agendamento salvo com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (CampoInvalidoException excecao) {
			JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

}
