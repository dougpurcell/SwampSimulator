package swampsimulator;

/*
 * Database.java
 *
 */
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


//Database Class
public class Database {
    
//Declaration of variables    
String myConnectString = 
     "jdbc:ucanaccess://D:/IST 311/SwampSimulator-master/ShrekSim.accdb";

//createTable() drops the current table and creates a new one
    public void createTable() {
        
       try
        {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         Statement stmt = con.createStatement();
         
         //this code may need to be commented out because an exception will be thrown
         //if this table doesn't exist in the database
         stmt.execute("DROP TABLE Item");
         
         stmt.execute("CREATE TABLE Item" + 
                         "(AdventureID varchar(255), CharacterID varchar(255)," +
                         " AdventureName varchar(255), " + 
                         "AdventureValue number, CharacterName varchar(255), CharacterValue number)");
        
         System.out.println("Created Item table");
         
         stmt.close();
         con.close();
        }
       // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }//end catch block
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }//end catch block
        
   }//end createTable()
    

    
//this method accepts the student data as input and stores it to the database 
    public void storeRecord(String aId, String cId, String aName, int aValue, String cName, int cValue){
       
        try {
         
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();
         //this Insert statement puts student info in the database
         stmt.executeUpdate("INSERT INTO Item VALUES ("+aId+",'"+cId+",'"+aName+"','" +aValue+"','" +cName+"','"+cValue+"')");
         
         stmt.close();
         con.close();
        }//end try
        catch(Exception e) 
        {
                e.printStackTrace();
        }//end catch

    }//end storeRecord()
    public void storeCustomerRecord(String uId, String aName, String cName, double total){
       
        try {
         
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();
         //this Insert statement puts student info in the database
         stmt.executeUpdate("INSERT INTO User VALUES ("+uId+"','" +aName+"','"+cName+"','"+total+"')");
         
         
         stmt.close();
         con.close();
        }//end try
        catch(Exception e) 
        {
                e.printStackTrace();
        }//end catch

    }//end storeRecord()
      
    public GameRecord[] getQueryData ()
    {
        GameRecord gameArray[] = new GameRecord[20];
        int numRecords = 0;
        
        try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Item");

          while (rs.next())
          {
              String rsAdID = rs.getString("AdventureID");
              String rsCrID = rs.getString("CharacterID");
              String rsAdName = rs.getString("AdventureName");
              int rsAdValue = rs.getInt("AdventureValue");
              String rsCrName = rs.getString("CharacterName");
              int rsCrValue = rs.getInt("CharacterValue");

              gameArray[numRecords] = new GameRecord(rsAdID, rsCrID, rsAdName, rsAdValue, rsCrName, rsCrValue);
              numRecords++;
              System.out.println(rsAdName + " " + rsCrName);
          }

          stmt.close();

          con.close();

       }
       // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }      
       finally{
           return gameArray;
       }
   }
}// end Database class
    

