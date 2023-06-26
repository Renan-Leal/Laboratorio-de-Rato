package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.controller.AgendamentoController;
import model.exception.CampoInvalidoException;
import model.vo.Agendamento;
import model.vo.Usuario;
import java.awt.Color;
import java.awt.Font;

public class PainelAgendamentoTreino extends JPanel {
	
	private JLabel lblCliente;
	private JComboBox cbCliente;
	private JLabel lblFinal;
	private JButton btnSalvar;
	private JComboBox cbHoraFinal;
	private JComboBox cbHoraInicio;
	private JLabel lblDataFinal;
	private JComboBox lblHoraFinal;
	private JLabel lblDataInicio;
	private JLabel lblInicio;
	private JComboBox cbProfissional;
	private JLabel lblPersonal;
	private Agendamento agendamento;
	private String[] horarios = {"07:00","08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00" +
			"16:00", "17:00", "18:00", "19:00", "20:00", "21:00"};
	private JButton btnVoltar;
	
	public PainelAgendamentoTreino() {
		setBackground(new Color(108, 255, 108));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;pref):grow"),
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
				ColumnSpec.decode("max(14dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(169dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(156dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:max(23dlu;pref):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(11dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(23dlu;pref):grow"),}));
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblCliente.setForeground(Color.BLACK);
		add(lblCliente, "16, 9, fill, fill");
		
		cbCliente = new JComboBox();
		cbCliente.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(cbCliente, "18, 9, fill, fill");
		
		lblPersonal = new JLabel("Personal:");
		lblPersonal.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblPersonal.setForeground(Color.BLACK);
		add(lblPersonal, "22, 9, fill, center");
		
		cbProfissional = new JComboBox();
		cbProfissional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(cbProfissional, "24, 9, fill, fill");
		
		lblInicio = new JLabel("Inicio -");
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblInicio, "16, 11, fill, fill");
		
		lblFinal = new JLabel("Final -");
		lblFinal.setForeground(Color.BLACK);
		lblFinal.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		add(lblFinal, "22, 11, fill, fill");
		
		lblDataInicio = new JLabel("Data Hora:");
		lblDataInicio.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblDataInicio.setForeground(Color.BLACK);
		add(lblDataInicio, "16, 13, fill, fill");
		
		cbHoraInicio = new JComboBox(horarios);
		cbHoraInicio.setForeground(Color.BLACK);
		cbHoraInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		add(cbHoraInicio, "18, 13, fill, fill");
		
		lblDataFinal = new JLabel("Data Hora:");
		lblDataFinal.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblDataFinal.setForeground(Color.BLACK);
		add(lblDataFinal, "22, 13, fill, fill");
		
		cbHoraFinal = new JComboBox(horarios);
		cbHoraFinal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbHoraFinal.setSelectedIndex(-1);
		add(cbHoraFinal, "24, 13, fill, fill");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnVoltar, "18, 17, left, default");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendamento.setCliente((Usuario) cbCliente.getSelectedItem());
				agendamento.setProfissional((Usuario) cbProfissional.getSelectedItem());
				agendamento.setDataHoraInicio(LocalDateTime.parse((String) cbHoraInicio.getSelectedItem()));
				agendamento.setDataHoraFinal(LocalDateTime.parse((String) cbHoraFinal.getSelectedItem()));
				
				AgendamentoController controller = new AgendamentoController();
			
				try {
					if(agendamento.getId() == null) {
						controller.inserir(agendamento);
					JOptionPane.showMessageDialog(null, "Agendamento salvo com sucesso!", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		add(btnSalvar, "24, 17, right, fill");
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}



}
