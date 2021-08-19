package faminha;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class consultandoClientes extends JFrame {

	private JPanel contentPane;
	private JTextField nome_pessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultandoClientes frame = new consultandoClientes();
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
	public consultandoClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nome_pessoa.getText();

				conexaosql conexao = new conexaosql();
				String consulta = "SELECT nome, email FROM clientes WHERE nome = " + "'" + nome + "'";
				ResultSet consultar = conexao.executaBusca(consulta);
				try {
				 consultar.next();
					
					JOptionPane.showMessageDialog(null, "NOME DO CLIENTE: " + consultar.getString("nome") + " | " + "EMAIL DO CLIENTE: " + consultar.getString("email"));
				
			}
			catch( Exception a ){
				a.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(45, 143, 168, 43);
		contentPane.add(btnNewButton);
		
		nome_pessoa = new JTextField();
		nome_pessoa.setBounds(45, 100, 168, 32);
		contentPane.add(nome_pessoa);
		nome_pessoa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME DO CLIENTE");
		lblNewLabel.setBounds(45, 68, 105, 14);
		contentPane.add(lblNewLabel);
	}

}
