package subscriptions_management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SettingsHome extends JFrame{
	private JTextField textField;
	Statement stmt;
    Connexion maConnexion= new Connexion();
	
	public SettingsHome() {
		setTitle("Parametres");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 272);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Parametres general ");
		lblNewLabel.setBounds(163, 5, 123, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Capital initial :");
		lblNewLabel_1.setBounds(16, 56, 123, 16);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 46, 294, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			  String requete="INSERT INTO settings(current_initial_capital) VALUE('"+textField.getText().toString()+"')";

		      try{
		            stmt =maConnexion.ObtenirConnexion().createStatement();
		            stmt.executeUpdate(requete);
		            JOptionPane.showMessageDialog(null, "Capital Inital enregistré!");
		      }catch(SQLException | HeadlessException e1){
		            JOptionPane.showMessageDialog(null,e1);
		      }
		      
			}
		});
		btnNewButton.setBounds(169, 187, 117, 29);
		panel.add(btnNewButton);
		
	}
	
	private void updateCI() {
		
	}
}
