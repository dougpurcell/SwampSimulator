package swampsimulator;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author dougthebicyclist
 * @author cammybaby
 */
public class SwampSimulator {

    private JFrame ss;
    private Login lgn;
    private Adventure adv;

    protected Game game;
    private GameRecord gameArray[] = new GameRecord[20];        //store all student records
    private int nextRecord = 0;         // location of next empty position in the array
    private int numRecord = 0;         // number of input student records
            
    private String xmlAdId;      // temporary storage for first name from xml
    private String xmlCrId;       //temporary storage for last name from xml
    private String xmlAdName;   //temporary storage for degree status from xml
    private String xmlCrName;          // temporary storage for major from xml
    private int xmlAdValue;
    private int xmlCrValue;
    private Database db = new Database();
    public void initialize() throws IOException {
        ss = new JFrame("Swamp Simulator");
        lgn = new Login(this);
        adv = new Adventure(this);

//        game = new Game();

        ss.setSize(1200, 800);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
        ss.add(lgn);
//        adv.openPopup();

    }

    public void changePanel(String Old, String New) {
        if (Old.equals("login")) {
            ss.remove(lgn);
        }
        if (New.equals("adventure")){
            ss.add(adv);
        }
        ss.validate();

    }

public static void main(String args[]) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {

//    SwampSimulator ss = new SwampSimulator();
//    ss.initialize();

        /* C A M E R O N:
            uncomment your shit to work on the game bro.
        */

//         this would be the shit connected to the "checkout" button
        JFrame frame = new JFrame("me swamp");

        Game game = new Game();

        frame.add(game);
        frame.setSize(1200, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (game.returnCount() < 4){
            game.move();
            game.repaint();
            System.out.println(game.returnCount());
            
          
            Thread.sleep(10);
        }
    }
//the method reads info from the input XML file, and then stores it in the studentArray[] 
    public void displayData ()
    {
        for (int i = 0; i<numRecord; i++)
        {
            System.out.println(gameArray[i].toString()+"\n");
        }
 }//end displayData
    
    

public void readFile(String filename){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            NodeList list = document.getElementsByTagName("Item");
           
            //This for loop gathers all the student attributes, puts them in a StudentRecord object
            //then stores that student in the StudentArray
            for(int i = 0; i < list.getLength(); i++)
            { 
                Element element = (Element)list.item(i);
                xmlAdId = getAdId(element);
                xmlCrId = getCrId(element);
                xmlAdName = getAdName(element);
                xmlAdValue = getAdValue(element);
                xmlCrName = getCrName(element);
                xmlCrValue = getCrValue(element);
                GameRecord record = new GameRecord(xmlAdId, xmlCrId, xmlAdName, xmlAdValue, xmlCrName, xmlCrValue);
                
                // store student record in array
                gameArray[nextRecord] = record;
                
                // increment number of student records and move to next position in studentArray
                numRecord++;
                nextRecord++;
                
            }//end for loop loading the studentArray[] with full student records
            
        }//end try block
        catch (ParserConfigurationException parserException)
        {
            parserException.printStackTrace();   
        }//end catch block
        catch (SAXException saxException)
        {
            saxException.printStackTrace();
        }//end catch block
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }//end catch block
       
    }//end readFile()
public String getAdId(Element parent){ 
        NodeList child = parent.getElementsByTagName("AdventureID");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }//end getFirstName
    
   //RETURNS THE LAST NAME OF THE STUDENT    
    public String getCrId(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterID");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }//end getLastName
    
    //RETURNS THE DEGREE STATUS OF THE STUDENT    
    public String getAdName(Element parent){ 
        NodeList child = parent.getElementsByTagName("AdventureName");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }//end getDegreeStatus
    
//RETURNS THE MAJOR OF THE STUDENT    
    public String getCrName(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterName");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }//end getFirstName
    public int getCrValue(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterValue");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());  
    }//end getFirstName
    public int getAdValue(Element parent){ 
        NodeList child = parent.getElementsByTagName("AdventureValue");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());  
    }
     public void storeData ()
  {
      // create table in the database
      db.createTable();
      
      System.out.println("Created table " + numRecord);
      
      // store each Student Record in the table
      for (int i = 0; i<numRecord; i++)
       {
                   db.storeRecord(gameArray[i].getAdId(), 
                   gameArray[i].getCrId(),
                   gameArray[i].getAdName(), 
                   gameArray[i].getAdValue(), 
                   gameArray[i].getCrName(),
                   gameArray[i].getCrValue());
      }
      
  }

}
