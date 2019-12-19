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
//String myConnectString = 
//     "jdbc:ucanaccess://C:/Users/Gauta/Downloads/SwampSimulator/ShrekSim.accdb"; // GAUTAM'S DB
    String myConnectString = "jdbc:ucanaccess:///Users/doug/Google Drive/College/IST-311_OOD-SoftwareDev/MasterContenderProject/SwampSimulator/ShrekSim.accdb"; // DOUG'S DB
//    String myConnectString = "jdbc:ucanaccess://G:/Fall 2019/IST 311/project/New folder/swampsimulator/ShrekSim.accdb"; // CAM'S DB
//createTable() drops the current table and creates a new one
    public void createAdTable() {
        
       try
        {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         Statement stmt = con.createStatement();
         
         //this code may need to be commented out because an exception will be thrown
         //if this table doesn't exist in the database
         stmt.execute("DROP TABLE Adventure");
         
         stmt.execute("CREATE TABLE Adventure" + 
                         "(AdventureID varchar(255)," +
                         "AdventureName varchar(255), " + 
                         "AdventureValue number)");
        
         System.out.println("Created Adventure table");
         
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
    
    public void createCrTable() {
        
       try
        {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         Statement stmt = con.createStatement();
         
         //this code may need to be commented out because an exception will be thrown
         //if this table doesn't exist in the database
         stmt.execute("DROP TABLE Character");
         
         stmt.execute("CREATE TABLE Character" + 
                         "(CharacterID varchar(255)," +
                         "(CharacterInventory number," +
                         " CharacterName varchar(255), " + 
                         "CharacterValue number)");
        
         System.out.println("Created Character table");
         
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
    public void storeAdRecord(String aId, String aName, int aValue){
       
        try {
         
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();
         //this Insert statement puts student info in the database
         stmt.executeUpdate("INSERT INTO Adventure VALUES ("+aId+",'"+aName+"','" +aValue+"')");
         
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
    
    public AdventureRecord getAdventure (String adName)
    {
        AdventureRecord adv = new AdventureRecord();
       
        
        try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Adventure WHERE AdventureName = '"+adName +"'");

          while (rs.next())
          {
              String rsAdName = rs.getString("AdventureName");
              String rsAdId = rs.getString("AdventureId");
              int rsAdValue = rs.getInt("AdventureValue");
              

              adv = new AdventureRecord(rsAdName, rsAdId, rsAdValue);
              
              System.out.println(rsAdName + " " + rsAdId + " " + rsAdValue);
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
           return adv;
       }
    }
      
    public CharacterRecord getCharacter (String crName)
    {
        CharacterRecord cr = new CharacterRecord();
       
        
        try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Character WHERE CharacterName = '"+crName +"'");

          while (rs.next())
          {
              String rsCrId = rs.getString("CharacterID");
              int rsCrIn = rs.getInt("CharacterInventory");
              String rsCrName = rs.getString("CharacterName");
              int rsCrValue = rs.getInt("CharacterValue");
              

              cr = new CharacterRecord(rsCrId, rsCrIn, rsCrName, rsCrValue);
              
              System.out.println(rsCrId + " " + rsCrIn + " " + rsCrName + " " + rsCrValue);
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
           return cr;
       }
    }
    public AdventureRecord[] getQueryData ()
    {
        AdventureRecord gameArray[] = new AdventureRecord[6];
        int numRecords = 0;
        
        try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Adventure");

          while (rs.next())
          {
              String rsAdID = rs.getString("AdventureID");
              String rsAdName = rs.getString("AdventureName");
              int rsAdValue = rs.getInt("AdventureValue");

              gameArray[numRecords] = new AdventureRecord(rsAdID,rsAdName,rsAdValue);
              numRecords++;
              System.out.println(rsAdName);
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
        public CharacterRecord[] getCrData ()
    {
        CharacterRecord crArray[] = new CharacterRecord[20];
        int numRecords = 0;
        
        try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(myConnectString);
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Character");

          while (rs.next())
          {
              String rsCrID = rs.getString("CharacterID");
              int rsCrIn = rs.getInt("CharacterInventory");
              String rsCrName = rs.getString("CharacterName");
              int rsCrValue = rs.getInt("CharacterValue");

              crArray[numRecords] = new CharacterRecord(rsCrID, rsCrIn, rsCrName, rsCrValue);
              numRecords++;
              System.out.println(rsCrName);
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
           return crArray;
       }
   }
        public String[][] getOrderStats(){
         String[][] orderData = new String[4][4];
        try {
        // load database driver class
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
        // connect to database
        Connection con = DriverManager.getConnection(myConnectString);
        Statement stmt = con.createStatement();
        
        // query the database - select all from characters
        ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
        
        // variable holding count of orders
        int orderCount = 0;
        // counting the rows for order table
        while (rs.next()){
            orderCount++;           
        }
        
        // initiate the order array
        orderData = new String[orderCount][5];
        
        // reset result set
        rs = stmt.executeQuery("SELECT * FROM Order");
        
        // reset order count variable for efficiency
        orderCount = 0;
        
        // write to the order array
        while (rs.next()){
            orderData[orderCount][0] = rs.getString(5);
            orderData[orderCount][1] = rs.getString(1);
            orderData[orderCount][2] = rs.getString(2);
            orderData[orderCount][3] = rs.getString(3);
            orderData[orderCount][4] = rs.getString(4);
            orderCount++;
        }
        
        // close statement
        stmt.close();
        // close connection
        con.close();
        return orderData;
       }
        // detect problems interacting with the database
       catch ( SQLException sqlException ) {
          JOptionPane.showMessageDialog( null, 
             sqlException.getMessage(), "Database Error",
             JOptionPane.ERROR_MESSAGE );
          System.out.println(JOptionPane.ERROR_MESSAGE);
          System.exit( 1 );
       }

        // detect problems loading database driver
        catch ( ClassNotFoundException classNotFound ) {
            JOptionPane.showMessageDialog( null, 
               classNotFound.getMessage(), "Driver Not Found",
               JOptionPane.ERROR_MESSAGE );
               System.out.println(JOptionPane.ERROR_MESSAGE);
            System.exit( 1 );
        } finally{
            
        }
        return orderData;
    }
    
    public int[][] getChartData(){
        String[][] chartData = new String[4][4];
        int[][] chCount = new int[12][2];
        try {
        // load database driver class
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
        // connect to database
        Connection con = DriverManager.getConnection(myConnectString);
        Statement stmt = con.createStatement();
        
        // query the database - select all from characters
        ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
        
        // variable holding count of orders
        int orderCount = 0;
        // counting the rows for order table
        while (rs.next()){
            orderCount++;           
        }
        
        // initiate the order array
        chartData = new String[orderCount][4];
        
        // reset result set
        rs = stmt.executeQuery("SELECT Characters FROM Order");
        
        // reset order count variable for efficiency
        orderCount = 0;
        
        // write to the order array
        while (rs.next()){
            String[] characters = rs.getString(1).split(",");
            
            // writes to new array for counting, also trimming spaces
            chartData[orderCount][0] = characters[0].trim();
            chartData[orderCount][1] = characters[1].trim();
            chartData[orderCount][2] = characters[2].trim();
            chartData[orderCount][3] = characters[3].trim();
            
            // iterates through array
            orderCount++;
        }
        // array for calculating character counts
        
        
        // for each 
        for (int i = 0; i < orderCount; i++){
            for (int k = 0; k < 4; k++){
                
                // switch for counting
                switch (chartData[i][k]) {
                    case "Shrek":
                        chCount[0][1] = chCount[0][1] + 1;
                        break;
                    case "Donkey":
                        chCount[1][1] = chCount[1][1] + 1;
                        break;
                    case "Fiona":
                        chCount[2][1] = chCount[2][1] + 1;
                        break;
                    case "Dragon":
                        chCount[3][1] = chCount[3][1] + 1;
                        break;
                    case "Gingerbread Man":
                        chCount[4][1] = chCount[4][1] + 1;
                        break;
                    case "Puss in Boots":
                        chCount[5][1] = chCount[5][1] + 1;
                        break;
                    case "Big Bad Wolf":
                        chCount[6][1] = chCount[6][1] + 1;
                        break;
                    case "Farquaad":
                        chCount[7][1] = chCount[7][1] + 1;
                        break;
                    case "Three Lil Piggies":
                        chCount[8][1] = chCount[8][1] + 1;
                        break;
                    case "Pinocchio":
                        chCount[9][1] = chCount[9][1] + 1;
                        break;
                    case "Three Blind Mice":
                        chCount[10][1] = chCount[10][1] + 1;
                        break;
                    case "Fairy Godmother":
                        chCount[11][1] = chCount[11][1] + 1;
                        break;
                    default:
                        break;
                }
                
                System.out.print(chartData[i][k]);
            }
            System.out.println();
        }
        
        for (int d = 0; d < 12; d++){
            System.out.println(chCount[d][1]);
        }
        
        // close statement
        stmt.close();
        // close connection
        con.close();
        return chCount;
       }
        // detect problems interacting with the database
       catch ( SQLException sqlException ) {
          JOptionPane.showMessageDialog( null, 
             sqlException.getMessage(), "Database Error",
             JOptionPane.ERROR_MESSAGE );
          System.out.println(JOptionPane.ERROR_MESSAGE);
          System.exit( 1 );
       }

        // detect problems loading database driver
        catch ( ClassNotFoundException classNotFound ) {
            JOptionPane.showMessageDialog( null, 
               classNotFound.getMessage(), "Driver Not Found",
               JOptionPane.ERROR_MESSAGE );
               System.out.println(JOptionPane.ERROR_MESSAGE);
            System.exit( 1 );
        } finally{
            return chCount;
        }
        
    }
    
    // stuff for pulling admin inventory info - cam
    public String[][] getAdminStats(){
        // holds character table data
        String[][] characterTable = new String[18][7];
        // character iterator declaration / iteration
        int characterCount = 0;
        try {
        // load database driver class
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
        // connect to database
        Connection con = DriverManager.getConnection(myConnectString);
        Statement stmt = con.createStatement();
        
        // query the database - select all from adventures
        ResultSet aRS = stmt.executeQuery("SELECT * from Adventure");
        
        while (aRS.next()){
            
            // save info from table
            String aName = aRS.getString("AdventureName");
            String aCoin = aRS.getString("AdventureValue");
            String aDes = aRS.getString("AdventureDescription");
            String aImage = aRS.getString("AdventureImage");
            String aGame = aRS.getString("GameImage");
            String aInventory = "1";
            
            // write to array
            characterTable[characterCount][0] = "Adventure";
            characterTable[characterCount][1] = aName;
            characterTable[characterCount][2] = aCoin;
            characterTable[characterCount][3] = aDes;
            characterTable[characterCount][4] = aImage;
            characterTable[characterCount][5] = aGame;
            characterTable[characterCount][6] = aInventory;
            
            // iterator for data array
            characterCount++;
        }
        // query the database - select all from characters
        ResultSet rs = stmt.executeQuery("SELECT * from Character");
        
        while (rs.next()){
            
            // save info from table
            String Name = rs.getString("CharacterName");
            String Image = rs.getString("CharacterImage");
            String chDes = rs.getString("CharacterDescription");
            String Inventory = Integer.toString(rs.getInt("CharacterInventory"));
            String gameImage = rs.getString("GameImage");
            String shrekCoin = rs.getString("CharacterValue");
            
            // write to array
            characterTable[characterCount][0] = "Character";
            characterTable[characterCount][1] = Name;
            characterTable[characterCount][2] = shrekCoin;
            characterTable[characterCount][3] = chDes;
            characterTable[characterCount][4] = Image;
            characterTable[characterCount][5] = gameImage;
            characterTable[characterCount][6] = Inventory;
            
            // iterator for character array
            characterCount++;
        }
        
        // close statement
        stmt.close();
        // close connection
        con.close();

       }
        // detect problems interacting with the database
       catch ( SQLException sqlException ) {
          JOptionPane.showMessageDialog( null, 
             sqlException.getMessage(), "Database Error",
             JOptionPane.ERROR_MESSAGE );
          System.out.println(JOptionPane.ERROR_MESSAGE);
          System.exit( 1 );
       }

        // detect problems loading database driver
        catch ( ClassNotFoundException classNotFound ) {
            JOptionPane.showMessageDialog( null, 
               classNotFound.getMessage(), "Driver Not Found",
               JOptionPane.ERROR_MESSAGE );
               System.out.println(JOptionPane.ERROR_MESSAGE);
            System.exit( 1 );
        }      
        return characterTable;
    }
}// end Database class
    

