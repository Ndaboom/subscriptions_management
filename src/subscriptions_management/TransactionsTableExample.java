package subscriptions_management;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class TransactionsTableExample extends JFrame {
	private JTable table;

    public TransactionsTableExample() {
        setTitle("Transactions Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table model
        String[] columnNames = {"Date", "Id Op", "Libelle", "Debit", "Credit", "Solde"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Connect to the database and retrieve data
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/subscriptions_management", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transactions_table");

            while (resultSet.next()) {
                // Retrieve values from the result set
                String date = resultSet.getString("date");
                int id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");
                float montant = resultSet.getFloat("montant");

                // Calculate Debit, Credit, and Solde based on the Libelle value
                float debit = libelle.equals("Débit") ? montant : 0;
                float credit = libelle.equals("Crédit") ? montant : 0;

                // Add a row to the table model
                Object[] row = {date, id, libelle, debit, credit, 0};  // Placeholder for Solde
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the Solde values in the table model
        float solde = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            float debit = (float) tableModel.getValueAt(i, 3);
            float credit = (float) tableModel.getValueAt(i, 4);
            solde = solde - debit + credit;
            tableModel.setValueAt(solde, i, 5);
        }

        // Create the table with the table model
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransactionsTableExample example = new TransactionsTableExample();
            example.setVisible(true);
        });
    }

}
