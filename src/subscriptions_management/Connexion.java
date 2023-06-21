/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptions_management;
import java.sql.*;
/**
 *
 * @author The_Pirate
 */
public class Connexion {
    String urlPilote="com.mysql.jdbc.Driver";
    String urlBaseDonnees="jdbc:Mysql://localhost:3306/subscriptions_management";//Chemin de connexion a la base des donnees
    Connection con;
        public Connexion(){
    try{
    Class.forName(urlPilote);
    System.out.println("Chargement du pilote de réussi");
    
}catch(ClassNotFoundException ex){
    System.out.println(ex);
}
    try{
        con=DriverManager.getConnection(urlBaseDonnees,"root","");
        System.out.println("Connexion à la base de données réussi");
    
}catch(SQLException ex){
    System.out.println(ex);
}
}
        Connection ObtenirConnexion(){
        return con;
    }

    Statement prepareStatement(String requete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
