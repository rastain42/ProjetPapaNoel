import java.sql.ResultSet;
import java.sql.SQLException;

import Connectors.ConnMySql ;



public class Main{
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    try {
        ConnMySql conn = new ConnMySql("db_project_java");
        ResultSet result = conn.select("SELECT * from clients_table");
        System.out.println(result);
        while(result.next()){
          System.out.println(result.getString("user_name"));
          
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.err.println(e.getMessage());
        
      }


   
}


}