/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptions_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

/**
 *
 * @author MyLau
 */
public final class AvanceHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeHome
     */
    public boolean dataStatu;
    public void getData(){
        try{

            java.sql.Statement stmt1=maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT code, nom, prenom, sexe, nif, salaire, anposte, "
                    + " montant, dateavance FROM AVANCE");
            jTable1.setModel(DbUtils.resultSetToTableModel(resultat));
	
	
       }catch(SQLException e){
	
	
       }
    }
    

    public AvanceHome() {
        initComponents();
        jTId.setVisible(false);
        //jTAvance.setEditable(true);
        
        setLocation(8,32);
        
        getData();
        dataStatu= true;
         SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
       
      }
      
    });
         pack();
    }
    Statement stmt;
    Connexion maConnexion= new Connexion();
    String table1_click;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "CallToPrintStackTrace"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLNom = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLMontant = new javax.swing.JLabel();
        jTMontant = new javax.swing.JTextField();
        jLDateEmb = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jBSauver = new javax.swing.JButton();
        jBNouveau = new javax.swing.JButton();
        jBQuitter = new javax.swing.JButton();
        jSupprimer = new javax.swing.JButton();
        jBImprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTSearch = new javax.swing.JTextField();
        jLTel1 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES TRANSACTIONS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Détails sur le membre"));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selectionner membre"));

        jLNom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNom.setForeground(new java.awt.Color(255, 102, 102));
        jLNom.setText("MEMBRES");
        
        jCMembres = new JComboBox();
        jCMembres.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addComponent(jLNom, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
        			.addComponent(jCMembres, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLNom, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCMembres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations sur la transaction"));

        jLMontant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLMontant.setForeground(new java.awt.Color(0, 51, 255));
        jLMontant.setText("MONTANT");

        jTMontant.setText(" ");
        jTMontant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvanceActionPerformed(evt);
            }
        });
        jTMontant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvanceKeyTyped(evt);
            }
        });

        jLDateEmb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLDateEmb.setForeground(new java.awt.Color(0, 51, 255));
        jLDateEmb.setText("LIBELLE");
        
        jCLibelle = new JComboBox();
        jCLibelle.setModel(new DefaultComboBoxModel(new String[] {"Crédit", "Débit"}));
        jCLibelle.setEditable(false);
        
        JLabel lblTypeRetrait = new JLabel();
        lblTypeRetrait.setText("TYPE PRET");
        lblTypeRetrait.setForeground(new Color(0, 51, 255));
        lblTypeRetrait.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        jCTypesPret = new JComboBox();
        jCTypesPret.setModel(new DefaultComboBoxModel(new String[] {"Express", "Ordinaire"}));
        jCTypesPret.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblTypeRetrait, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLDateEmb, Alignment.LEADING)
        				.addComponent(jLMontant, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(jPanel3Layout.createSequentialGroup()
        						.addComponent(jCLibelle, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        						.addContainerGap())
        					.addComponent(jTMontant))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jCTypesPret, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLMontant, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTMontant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(14)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLDateEmb, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCLibelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTypeRetrait, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCTypesPret, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opérations"));

        jBSauver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_save.png"))); // NOI18N
        jBSauver.setText("Sauver");
        jBSauver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSauverActionPerformed(evt);
            }
        });

        jBNouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/all_new.png"))); // NOI18N
        jBNouveau.setText("Nouveau");
        jBNouveau.setMaximumSize(new java.awt.Dimension(101, 23));
        jBNouveau.setMinimumSize(new java.awt.Dimension(101, 23));
        jBNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNouveauActionPerformed(evt);
            }
        });

        jBQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/use_exit.png"))); // NOI18N
        jBQuitter.setText("Sortir");
        jBQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitterActionPerformed(evt);
            }
        });

        jSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_delete.png"))); // NOI18N
        jSupprimer.setText("Supprimer");
        jSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSupprimerActionPerformed(evt);
            }
        });

        jBImprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_print.png"))); // NOI18N
        jBImprimer.setText("Imprimer");
        jBImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jBNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSauver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSupprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBImprimer)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSauver)
                    .addComponent(jBNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBQuitter)
                    .addComponent(jSupprimer)
                    .addComponent(jBImprimer))
                .addGap(62, 62, 62))
        );

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche d'un employé"));

        jTSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTSearchKeyReleased(evt);
            }
        });

        jLTel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel1.setForeground(new java.awt.Color(0, 51, 255));
        jLTel1.setText("ENTRER LE PRENOM");

        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTel1)
                    .addComponent(jTId))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6Layout.setHorizontalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel7, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6.setLayout(jPanel6Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jPAppli");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvanceActionPerformed

    private void jTAvanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvanceKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTAvanceKeyTyped

    private void jBSauverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSauverActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        
        String libelleRecup = jCLibelle.getSelectedItem().toString();
        String montantRecup = jTMontant.getText().trim();
        String personneRecup = jCMembres.getSelectedItem().toString();
        String typesRecup = jCTypesPret.getSelectedItem().toString();
        
        
        if(jTMontant.getText().trim().length()>0 && jCLibelle.getSelectedItem().toString().trim().length()>0
            && jCMembres.getSelectedItem().toString().trim().length()>0 && jCTypesPret.getSelectedItem().toString().trim().length()>0 && 
                jTMontant.getText().trim().length()>0){

        if(dataStatu==true){

            try{
            String requete="INSERT INTO transactions_table (libelle, montant, personne, personne_id, type_pret)value "
                    + "('"+libelleRecup+"','"+montantRecup+"','"+personneRecup+"','"+typesRecup+"')";
            stmt=maConnexion.ObtenirConnexion().createStatement();
            stmt.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"Enregistrement réussi!");
            getData();
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null,e);
                JOptionPane.showMessageDialog(null, "Veuillez vérifier l'id!");   
            }
       
      }else{
            
      try{
            stmt =maConnexion.ObtenirConnexion().createStatement();
            String requete="UPDATE transactions_table  SET libelle='"+libelleRecup+"',montant='"+montantRecup+"' where id='"+table1_click+"'";

      try{
            stmt =maConnexion.ObtenirConnexion().createStatement();
            stmt .executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Modification réussie!");
            getData();
        } catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        }
      catch(SQLException ex){
            System.err.println(ex);
        }
        }
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
        }   
       
    }//GEN-LAST:event_jBSauverActionPerformed

    private void jBNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNouveauActionPerformed
        // TODO add your handling code here:
        dataStatu=true;
        
        jTMontant.setText("");
        jCLibelle.setSelectedItem("Crédit");
        jCTypesPret.setSelectedItem("Express");
      
        getData();

        
    }//GEN-LAST:event_jBNouveauActionPerformed

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        dataStatu=false;
        try{
            int row=jTable1.getSelectedRow();
            table1_click=(jTable1.getModel().getValueAt(row,0).toString());
            java.sql.Statement stmt1=maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM transactions_table WHERE id='"+table1_click+"'");

            if(resultat.next()){
                jTId.setText(resultat.getString("id"));
                jTMontant.setText(resultat.getString("montant"));
                jCMembres.setSelectedItem(resultat.getString("personne"));
                jCLibelle.setSelectedItem(resultat.getString("libelle"));                
                jCTypesPret.setSelectedItem(resultat.getString("type_pret"));
            }

        }catch(SQLException e){

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupprimerActionPerformed
        // TODO add your handling code here:
        if(jTMontant.getText().trim().length()>0 && jCLibelle.getSelectedItem().toString().trim().length()>0
            && jCMembres.getSelectedItem().toString().trim().length()>0 && jCTypesPret.getSelectedItem().toString().trim().length()>0 && 
                jTMontant.getText().trim().length()>0 ){ 
            String requete="DELETE FROM transactions_table WHERE id='"+table1_click+"'";
        try{
            stmt=maConnexion.ObtenirConnexion().createStatement();
            stmt.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Suppresion réussie!");
           
               
      }                                           
      catch(SQLException ex){
            System.err.println(ex);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une avance!");  
        }
        jTMontant.setText("");
        jCLibelle.setSelectedItem("Crédit");
        jCTypesPret.setSelectedItem("Express");        
        getData();
    }//GEN-LAST:event_jSupprimerActionPerformed

    private void jTSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyReleased
        // TODO add your handling code here:

        //String requete="select* from EMPLOYE where prenom LIKE '" + jTNom.getText() + "%'";
        dataStatu=false;
        
        try{
            java.sql.Statement stmt1=maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM transactions_table where personne LIKE '" + jTSearch.getText().trim() + "%'");
	    jTable1.setModel(DbUtils.resultSetToTableModel(resultat));
	
          }catch(Exception e){
	
	
}
        
    }//GEN-LAST:event_jTSearchKeyReleased

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdActionPerformed

    private void jBImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimerActionPerformed
        // TODO add your handling code here:
        int detteRecup=0;
        String requete="SELECT SUM(montant) AS nbMontant FROM transactions_table WHERE id='"+table1_click+"' ";
        try{
            stmt=maConnexion.ObtenirConnexion().createStatement();
            ResultSet resultat= stmt.executeQuery(requete);

                while(resultat.next()){

                    detteRecup=resultat.getInt("nbMontant");
     
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String dateRecup;
        dateRecup = sdf.format(new Date());
        //final String dated=sdf.format(jTDateDebut.getDate());
        final String TOTAL=Integer.toString(detteRecup);

        
        if(jTMontant.getText().trim().length()>0 && jCLibelle.getSelectedItem().toString().trim().length()>0
            && jCMembres.getSelectedItem().toString().trim().length()>0 && jCTypesPret.getSelectedItem().toString().trim().length()>0 && 
                jTMontant.getText().trim().length()>0){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
 
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        int marge=30;
        int x = (int)pageFormat.getImageableX();
        int y = (int)pageFormat.getImageableY();
                 
        graphics.setFont(new Font("Times new roman", Font.BOLD, 20));
        graphics.setColor(Color.BLACK);
        graphics.drawString("                      DETAILS TRANSACTIONS\n", x + marge, y + marge);
 
        graphics.drawLine(100, 40, 470, 40);    
    
        graphics.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        graphics.drawString(" *Libelle", 130, 80);        
        graphics.drawString(jCLibelle.getSelectedItem().toString(), 350, 80);
        
        graphics.drawString(" *Prénom", 130, 110);
        graphics.drawString(jTPrenom.getText(), 350, 110);
        
        graphics.drawString(" *Sexe", 130, 140);
        graphics.drawString(jCSexe.getSelectedItem().toString(), 350, 140);
        
        graphics.drawString(" *NIF", 130, 170);
        graphics.drawString(jFTNIF.getText(), 350, 170);      
                
        graphics.drawString(" *Salaire", 130, 200);
        graphics.drawString(jTSalaire.getText()+" Gdes.", 350, 200);
        
        graphics.drawString(" *Montant dû", 130, 230);
        graphics.drawString((String) TOTAL+" Gdes.", 350, 230);
        
        graphics.drawString(" *Poste", 130, 270);
        graphics.drawString(jTAposte.getText().trim(), 350, 270);
        
        graphics.drawString(" *Date de l'impression", 130, 300);
        graphics.drawString(dateRecup, 350, 300);
             
        //graphics.drawString(" *Type Congé", 130, 330);
        //graphics.drawString((String) jCTypeConge.getSelectedItem(), 350, 330);
        
        //graphics.drawString(" *Nbre. de Jours", 130, 360);
        //graphics.drawString(s1, 350, 360);

        return PAGE_EXISTS;
            }
 
        });
boolean doPrint = job.printDialog();
if(doPrint) {
    try {
         
        job.print();
    }
    catch (PrinterException e1) {
            JOptionPane.showMessageDialog(null, e1);
    }
}}else{
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un employé!");
        }
    }//GEN-LAST:event_jBImprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimer;
    private javax.swing.JButton jBNouveau;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jBSauver;
    private javax.swing.JLabel jLDateEmb;
    private javax.swing.JLabel jLMontant;
    private javax.swing.JLabel jLNom;
    private javax.swing.JLabel jLTel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSupprimer;
    private javax.swing.JTextField jTMontant;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JTable jTable1;
    private JComboBox jCLibelle;
    private JComboBox jCMembres;
    private JComboBox jCTypesPret;
}
