package subscriptions_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Utils {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static Statement stmt;
	static Connexion maConnexion=new Connexion();
	
	public static ResultSet fetchTransactionsByUser(String userId, String date1, String date2) {
		String requeteListeLivre = "";
		if(date1 != null && date2 != null) {
			requeteListeLivre = "SELECT * FROM transactions_table WHERE personne_id = '"+userId+"' AND date > '"+sdf.format(date1)+"' AND date < '"+sdf.format(date2)+"' + INTERVAL 1 DAY";	
		} else {
			requeteListeLivre = "SELECT * FROM transactions_table WHERE personne_id = '"+userId+"'";
		}
		
		ResultSet resultat = null;
		try{
			stmt = maConnexion.ObtenirConnexion().createStatement();
		   resultat= stmt.executeQuery(requeteListeLivre);
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return resultat;
	}
}
