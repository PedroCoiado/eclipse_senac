package br.com.ti0523.patrimonio.telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class CadastrarPatrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSerie;
	private JTextField txtNome;
	private JTextField txtLocalizacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPatrimonio frame = new CadastrarPatrimonio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarPatrimonio() {
		
		setTitle("Cadastrar Patrimônio");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarPatrimonio.class.getResource("/br/com/ti0523/patrimonio/imagens/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 646);
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de Série:");
		lblNewLabel.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblNewLabel.setBounds(244, 23, 242, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoPatrimnio = new JLabel("Nome do Patrimônio:");
		lblNomeDoPatrimnio.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblNomeDoPatrimnio.setBounds(244, 97, 242, 30);
		contentPane.add(lblNomeDoPatrimnio);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblTipo.setBounds(244, 171, 242, 30);
		contentPane.add(lblTipo);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblDescrio.setBounds(244, 245, 242, 30);
		contentPane.add(lblDescrio);
		
		JLabel lblLocalizao = new JLabel("Localização:");
		lblLocalizao.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblLocalizao.setBounds(244, 417, 242, 30);
		contentPane.add(lblLocalizao);
		
		JLabel lblDataFabricao = new JLabel("Data Fabricação:");
		lblDataFabricao.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblDataFabricao.setBounds(244, 491, 242, 30);
		contentPane.add(lblDataFabricao);
		
		JLabel lblDataAquisio = new JLabel("Data Aquisição:");
		lblDataAquisio.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblDataAquisio.setBounds(452, 491, 242, 30);
		contentPane.add(lblDataAquisio);
		
		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtSerie.setBounds(244, 51, 406, 35);
		contentPane.add(txtSerie);
		txtSerie.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(244, 125, 406, 35);
		contentPane.add(txtNome);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtLocalizacao.setColumns(10);
		txtLocalizacao.setBounds(244, 445, 406, 35);
		contentPane.add(txtLocalizacao);
		
		JLabel lblFigura = new JLabel("New label");
		lblFigura.setBounds(0, 0, 222, 595);
		
		lblFigura.setIcon(new ImageIcon
				(new ImageIcon(CadastrarPatrimonio.class.getResource
						("/br/com/ti0523/patrimonio/imagens/background.png"))
						.getImage().getScaledInstance(lblFigura.getWidth(), 
								lblFigura.getHeight(), Image.SCALE_SMOOTH)));
		
		
		
		contentPane.add(lblFigura);
		
		JComboBox cboTipo = new JComboBox();
		cboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Informática", "Moveis"}));
		cboTipo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cboTipo.setBounds(244, 199, 406, 35);
		contentPane.add(cboTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 273, 406, 133);
		contentPane.add(scrollPane);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		MaskFormatter msf = new MaskFormatter();
		try {
			msf.setMask("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		JFormattedTextField txtFabricacao = new JFormattedTextField(msf);
		txtFabricacao.setBounds(244, 519, 198, 35);
		contentPane.add(txtFabricacao);
		
		JFormattedTextField txtAquisicao = new JFormattedTextField(msf);
		txtAquisicao.setBounds(452, 519, 198, 35);
		contentPane.add(txtAquisicao);
		
		JButton btnSalvar = new JButton("Salvar Patrimônio");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ao clicar no botão deverá aparecer na 
				//tela de console todos os dados preenchidos
				//nos campos
				
				
				pat.setSerie(txtSerie.getText());
				pat.setNomepatrimonio(txtNome.getText());
				pat.setTipo(cboTipo.getSelectedItem().toString());
				pat.setDescriçao(txtDescricao.getText());
				pat.setLocalizao(txtLocalizacao.getText());
				pat.setDataFabricacao(txtFabricacao.getText());
				pat.setDataAquisicao(txtAquisicao.getText());
				
				String rs = daopat.cadastrar(pat);
				
				JOptionPane.showMessageDialog(null, rs);
				
				txtSerie.setText("");
				txtNome.setText("");
				txtTipo.setText("");
			}
		});
		btnSalvar.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 16));
		btnSalvar.setBounds(254, 565, 406, 30);
		contentPane.add(btnSalvar);
		
	}
}
