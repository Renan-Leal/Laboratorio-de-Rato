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
	
	public PainelAgendamentoTreino() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("125px"),
				ColumnSpec.decode("21px"),
				ColumnSpec.decode("53px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("125px"),},
			new RowSpec[] {
				RowSpec.decode("32px"),
				RowSpec.decode("22px"),
				RowSpec.decode("28px"),
				RowSpec.decode("22px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				RowSpec.decode("35px"),
				RowSpec.decode("23px"),}));
		
		lblCliente = new JLabel("Cliente:");
		add(lblCliente, "2, 2, left, center");
		
		cbCliente = new JComboBox();
		add(cbCliente, "4, 2, 5, 1, fill, top");
		
		lblPersonal = new JLabel("Personal:");
		add(lblPersonal, "2, 4, left, center");
		
		cbProfissional = new JComboBox();
		add(cbProfissional, "4, 4, 5, 1, fill, top");
		
		lblInicio = new JLabel("Inicio -");
		add(lblInicio, "2, 6, left, top");
		
		lblDataInicio = new JLabel("Data Hora:");
		add(lblDataInicio, "2, 8, left, center");
		
		cbHoraInicio = new JComboBox(horarios);
		add(cbHoraInicio, "4, 8, fill, top");
		
		cbHoraFinal = new JComboBox(horarios);
		cbHoraFinal.setSelectedIndex(-1);
		add(cbHoraFinal, "8, 8, fill, top");
		
		lblDataFinal = new JLabel("Data Hora:");
		add(lblDataFinal, "6, 8, left, center");
		
		lblFinal = new JLabel("Final -");
		add(lblFinal, "6, 6, left, top");
		
		btnSalvar = new JButton("Salvar");
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
		add(btnSalvar, "8, 10, right, top");
	}



}
