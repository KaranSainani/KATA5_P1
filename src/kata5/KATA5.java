package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * class Kata5_ part1
 * 
 * @author: Karan Nandpal Sainani
 * @group: 2.20(46)
 * 
*/
public class KATA5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\KATA5.db");
        
        Statement st = con.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = st.executeQuery(query);
        
        while ( rs.next() ) {
            System.out.print("id: " + rs.getInt(1)+ " | ");
            System.out.print("Name: " + rs.getString(2) + " | ");
            System.out.print("Apellidos: " + rs.getString(3) + " | ");
            System.out.println("Departamento: " + rs.getString(4));
        }
        
        query = "CREATE TABLE IF NOT EXISTS MAIL1 ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL)";
        
        st.execute(query);
        
        String fileString = "C:\\Users\\usuario\\Desktop\\emails.txt";
        BufferedReader reader = new BufferedReader (new FileReader (new File(fileString)));
        String Mail;
        
        while ( ( Mail = reader.readLine()) != null ) {
            if ( !Mail.contains("@") ) continue;
        query = "INSERT INTO MAIL1 (Mail) VALUES ('" + Mail + "');";
        st.executeUpdate(query);
        }
        
        rs.close();
        st.close();
        con.close();
        
        query = "select * from emails";
        rs = stmt.executeQuery(query);
         while (rs.next()){           
            int Id = rs.getInt("Id");
            String mails = rs.getString("Mail");
            System.out.println(Id + "\t" + mails);
        }
          
         query = "select count (*) from emails";
         rs = stmt.executeQuery(query);
         while (rs.next()){           
            int num = rs.getInt(1);
            System.out.println(num);
        }
    }
    
    
    
}
