package subscriptions_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Utils {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static Statement stmt;
	
	public static ResultSet fetchTransactionsByUser(String userId, String date1, String date2) {
		String requeteListeLivre = "SELECT * FROM transactions_table WHERE libelle = 'Crédit' AND date > '"+sdf.format(date1)+"' AND date < '"+sdf.format(date2)+"' + INTERVAL 1 DAY";
		ResultSet resultat = null;
		try{
		   resultat= stmt.executeQuery(requeteListeLivre);
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return resultat;
	}
}
