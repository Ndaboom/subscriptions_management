/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptions_management;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author MyLau
 */

@SuppressWarnings("serial")
public class DebiteursReport extends javax.swing.JInternalFrame {

    Statement stmt;
    Connexion maConnexion=new Connexion();
    float cumulTotal = (float) 0.0;
    float capitalInitial = (float) 0.0;
    float capitalActuel = (float) 0.0;
    float totalDebit = (float) 0.0, totalCredit = (float) 0.0;
    DefaultTableModel tableModel;
    JDateChooser jTDateNais_1, jTDateNais_1_1;
    Date selectedDate, selectedDate1;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public DebiteursReport() {
    	
        initComponents();
        // Display credit and debit balance
        detailsLabel.setText("Total debits (D) : ");
        getAllDebitTotal(null,null);
        
        // Get IC 
    	String requeteIC = "select * from settings";
        try {
        	stmt=maConnexion.ObtenirConnexion().createStatement();
			ResultSet resultat= stmt.executeQuery(requeteIC);
			while(resultat.next()) {
				capitalInitial = resultat.getFloat("current_initial_capital");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setLocation(8,32);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste debiteurs"));
        
        // Create the table model & fulfil with data
        
        /** Fetching data **/
        
        java.sql.Statement stmt1;
		try {
			stmt1 = maConnexion.ObtenirConnexion().createStatement();
			String query = "SELECT * FROM transactions_table WHERE libelle = 'Débit'";
	        java.sql.ResultSet resultSet = stmt1.executeQuery(query);
	        
	        // Convert the resultSet to a format that can be used to populate a JTable
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        // Create column names array
	        String[] columnNames1 = new String[columnCount];
	        for (int i = 1; i <= columnCount; i++) {
	            columnNames1[i - 1] = metaData.getColumnName(i);
	        }

	        // Create table data
	        tableModel = new DefaultTableModel(columnNames1, 0);
	        while (resultSet.next()) {
	            Object[] rowData = new Object[columnCount];
	            for (int i = 1; i <= columnCount; i++) {
	                rowData[i - 1] = resultSet.getObject(i);
	            }
	            tableModel.addRow(rowData);
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // Create the table with the table model
        TableEmp = new JTable(tableModel);
        
        /** Fetching data **/
        TableEmp.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setViewportView(TableEmp);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        detailsLabel = new JLabel("Total debits (D) : ");
        
        jTDateNais_1 = new JDateChooser();
        jTDateNais_1.setDateFormatString("yyyy-MM-dd");
        
        jTDateNais_1_1 = new JDateChooser();
        jTDateNais_1_1.setDateFormatString("yyyy-MM-dd");
        
        PropertyChangeListener dateChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Retrieve the selected date from the JDateChooser
                    selectedDate = (Date) evt.getNewValue();
                    
                    // Perform any actions or logic based on the selected date
                    System.out.println("Selected Date: " + selectedDate);
                    
                    if(selectedDate != null && selectedDate1 != null) {
                    	fetchData(sdf.format(selectedDate),sdf.format(selectedDate1));
                    	getAllDebitTotal(sdf.format(selectedDate),sdf.format(selectedDate1));
                    }   
                }
            }
        };
        
        PropertyChangeListener date1ChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Retrieve the selected date from the JDateChooser
                    selectedDate1 = (Date) evt.getNewValue();
                    
                    // Perform any actions or logic based on the selected date
                    System.out.println("Selected Date: " + selectedDate1);
                    
                    if(selectedDate != null && selectedDate1 != null) {
                    	fetchData(sdf.format(selectedDate),sdf.format(selectedDate1));
                    	getAllDebitTotal(sdf.format(selectedDate),sdf.format(selectedDate1));
                    }
                }
            }
        };
        
        jTDateNais_1_1.getDateEditor().addPropertyChangeListener(date1ChangeListener);
        jTDateNais_1.getDateEditor().addPropertyChangeListener(dateChangeListener);
        
        JLabel lblNewLabel_1 = new JLabel("Date 1");
        
        JLabel lblNewLabel_2 = new JLabel("Date 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(480)
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addComponent(jTDateNais_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_2)
        			.addGap(13)
        			.addComponent(jTDateNais_1_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton1)
        			.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
        			.addComponent(detailsLabel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
        			.addGap(69))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jButton1)
        					.addComponent(detailsLabel))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jTDateNais_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jTDateNais_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblNewLabel_1)
        							.addComponent(lblNewLabel_2)))))
        			.addContainerGap(88, Short.MAX_VALUE))
        );
        
        jPanel2.setLayout(jPanel2Layout);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1412, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(19, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1422, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Liste des transactions");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            TableEmp.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }
    //GEN-LAST:event_jButton1ActionPerformed
    
    private void getAllDebitTotal(String string, String string2) {
        try {
            java.sql.Statement stmt1 = maConnexion.ObtenirConnexion().createStatement();
            String query = "";
            if(string != null && string2 != null) {
            	System.out.println("Fetching data from for total purpose between two dates  "+selectedDate+" to "+ selectedDate1);
            	query = "SELECT ROUND(SUM(montant), 2) FROM transactions_table WHERE libelle = 'Débit' AND date > '"+sdf.format(selectedDate)+"' AND date < '"+sdf.format(selectedDate1)+"' + INTERVAL 1 DAY";
            } else {
            	System.out.println("Fetching all debits record for total purpose");
            	query = "SELECT ROUND(SUM(montant), 2) FROM transactions_table WHERE libelle = 'Débit'";
            }
            java.sql.ResultSet resultat = stmt1.executeQuery(query);

            while (resultat.next()) {
                totalDebit = resultat.getFloat(1);
            }
            
            detailsLabel.setText("Total debits (D) : "+totalDebit);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private void fetchData(String string, String string2) {
    	
    	System.out.println("Fetching data from "+string+" to "+ string2);
    	// Clear all rows from the table
    	tableModel.setRowCount(0);
    	
    	java.sql.Statement stmt1;
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Libelle");
		model.addColumn("Montant");        
		model.addColumn("Personne");
		model.addColumn("Type pret");
		model.addColumn("Interet");
		model.addColumn("Cumul interet"); 
		model.addColumn("Date"); 

		String requeteListeLivre = "SELECT * FROM transactions_table WHERE libelle = 'Débit' AND date > '"+sdf.format(selectedDate)+"' AND date < '"+sdf.format(selectedDate1)+"' + INTERVAL 1 DAY";
		cumulTotal = (float) 0.0;
		try{
		    ResultSet resultat= stmt.executeQuery(requeteListeLivre);
		    while(resultat.next()){
		    	cumulTotal = Float.parseFloat(resultat.getString("interet")) + cumulTotal;
		        model.addRow(new Object [] {resultat.getString("libelle"),resultat.getString("montant"),resultat.getString("personne"), resultat.getString("type_pret"),
		            resultat.getString("interet"), cumulTotal, resultat.getDate("date")});
		        detailsLabel.setText("Interet actuel (IA) "+cumulTotal+" + Capital Initial "+capitalInitial+" = C.A "+(cumulTotal+capitalInitial));
		    }
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
		TableEmp.setModel(model);	
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JTable TableEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jPanel2;
    private JLabel detailsLabel;
}
