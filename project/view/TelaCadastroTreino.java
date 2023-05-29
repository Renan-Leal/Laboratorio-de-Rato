package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.vo.NivelTreino;

public class TelaCadastroTreino {

	private JFrame frmCadastroDeTreino;
	private JLabel lblPrazo;
	private JLabel lblNvl;
	private JLabel lblTreino;
	private JTextField txtPrazo;
	private JComboBox cbNvl;
	private JTextPane txtTreino;

	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTreino window = new TelaCadastroTreino();
					window.frmCadastroDeTreino.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTreino() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeTreino = new JFrame();
		frmCadastroDeTreino.setTitle("Cadastro de Treino");
		frmCadastroDeTreino.setBounds(100, 100, 364, 606);
		frmCadastroDeTreino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeTreino.getContentPane().setLayout(null);
		
		lblPrazo = new JLabel("Prazo:");
		lblPrazo.setBounds(37, 26, 46, 14);
		frmCadastroDeTreino.getContentPane().add(lblPrazo);
		
		lblNvl = new JLabel("Nível:");
		lblNvl.setBounds(188, 26, 46, 14);
		frmCadastroDeTreino.getContentPane().add(lblNvl);
		
		cbNvl = new JComboBox(new String[] {"BÁSICO","INTERMEDIÁRIO","AVANÇADO"});
		cbNvl.setBounds(224, 22, 82, 22);
		frmCadastroDeTreino.getContentPane().add(cbNvl);
		
		txtPrazo = new JTextField();
		txtPrazo.setBounds(77, 23, 86, 20);
		frmCadastroDeTreino.getContentPane().add(txtPrazo);
		txtPrazo.setColumns(10);
		
		txtTreino = new JTextPane();
		txtTreino.setBounds(37, 81, 269, 440);
		frmCadastroDeTreino.getContentPane().add(txtTreino);
		
		lblTreino = new JLabel("Treino:");
		lblTreino.setBounds(146, 56, 46, 14);
		frmCadastroDeTreino.getContentPane().add(lblTreino);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(124, 533, 89, 23);
		frmCadastroDeTreino.getContentPane().add(btnCadastrar);
	}
}
