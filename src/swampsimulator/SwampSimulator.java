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
    private Character chr;
    protected Game game;
    private Order ord;
    public AdminInventory adminInv;
    private loginScreen lgnscreen;
    private AdventureRecord gameArray[] = new AdventureRecord[20];        //store all student records
    private CharacterRecord crArray[] = new CharacterRecord[20]; 
    private int nextRecord = 0;         // location of next empty position in the array
    private int numRecord = 0;         // number of input student records
            
    private String xmlAdId;      // temporary storage for first name from xml
    private String xmlCrId;       //temporary storage for last name from xml
    private String xmlAdName;   //temporary storage for degree status from xml
    private String xmlCrName;          // temporary storage for major from xml
    private int xmlAdValue;
    private int xmlCrValue;
    private int xmlCrInventory;
    private String xmlAdDesc;
    private String xmlAdImg;
    private String xmlGaImg;
    private String xmlCrImg;
    private String xmlCrDesc;
    private String xmlCrGaImg;
    Database myDatabase = new Database();
    //AdventureD ad1;
    String sItem = "";
    public void initialize() throws IOException {
        ss = new JFrame("Swamp Simulator");
        lgnscreen = new loginScreen(this);
        adv = new Adventure(this);
        chr = new Character(this);
        ord = new Order(this);
        adminInv = new AdminInventory(this);

        ss.setSize(1200, 800);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
        ss.add(lgnscreen);
        readAdFile("Adventure.xml");
        readCrFile("Character.xml");
        

//        ss.add(adminInv); // Cam uncomment this.
        
    }

    public void changePanel(String Old, String New) {
        if (Old.equals("login")) {
            ss.remove(lgnscreen);
        }
        if (New.equals("admin")) {
            ss.add(adminInv);
        }
        if (New.equals("adventure")){
            ss.add(adv);
        }
        if (Old.equals("adventure")) {
            ss.remove(adv);
        }
        if (New.equals("character")) {
            ss.add(chr);
        }
        if (Old.equals("character")) {
            ss.remove(chr);
        }
        if (New.equals("order")){
            ss.add(ord);
        }
        if (Old.equals("order")) {
            ss.remove(ord);
        }
        if (New.equals("game")){
            ss.add(chr);
        } if (Old.equals("checkout")) {
            ss.remove(ord);
        }
        
        ss.validate();

    }
    public String getItem() {
        return sItem;
    }
    
   public void setItem(String item) {
        sItem = item;
    }

    public void playGame() throws InterruptedException, IOException {

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
//            System.out.println(game.returnCount());


            Thread.sleep(10);
        }

    }
public void readAdFile(String filename){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            NodeList list = document.getElementsByTagName("Adventure");
           
            //This for loop gathers all the student attributes, puts them in a StudentRecord object
            //then stores that student in the StudentArray
            for(int i = 0; i < list.getLength(); i++)
            { 
                Element element = (Element)list.item(i);
                xmlAdId = getAdId(element);
               // xmlCrId = getCrId(element);
                xmlAdName = getAdName(element);
                xmlAdValue = getAdValue(element);
                xmlAdDesc = getAdDesc(element);
                xmlAdImg = getAdImg(element);
                xmlGaImg = getGaImg(element);
                AdventureRecord record = new AdventureRecord(xmlAdId, xmlAdName, xmlAdValue,xmlAdDesc,xmlAdImg,xmlGaImg);
//                System.out.println(record.toString());
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
public void readCrFile(String filename){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            NodeList list = document.getElementsByTagName("Character");
           
            //This for loop gathers all the student attributes, puts them in a StudentRecord object
            //then stores that student in the StudentArray
            for(int i = 0; i < list.getLength(); i++)
            { 
                Element element = (Element)list.item(i);
                //xmlAdId = getAdId(element);
               xmlCrId = getCrId(element);
               // xmlAdName = getAdName(element);
                //xmlAdValue = getAdValue(element);
                xmlCrName = getCrName(element);
                xmlCrValue = getCrValue(element);
                xmlCrInventory = getCrInventory(element);
                xmlCrDesc = getCrDesc(element);
                xmlCrImg = getCrImg(element);
                xmlCrGaImg = getCrGaImg(element);
                CharacterRecord record = new CharacterRecord(xmlCrId, xmlCrInventory, xmlCrName, xmlCrValue, xmlCrDesc, xmlCrImg, xmlCrGaImg);
                System.out.println(record.toString());
                // store student record in array
                crArray[nextRecord] = record;
                
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
    public int getCrInventory(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterInventory");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());  
    }
    public String getAdDesc(Element parent){ 
        NodeList child = parent.getElementsByTagName("AdventureDescription");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
     public String getAdImg(Element parent){ 
        NodeList child = parent.getElementsByTagName("AdventureImage");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
      public String getGaImg(Element parent){ 
        NodeList child = parent.getElementsByTagName("GameImage");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
      public String getCrGaImg(Element parent){ 
        NodeList child = parent.getElementsByTagName("GameImage");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
      public String getCrImg(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterImage");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
      public String getCrDesc(Element parent){ 
        NodeList child = parent.getElementsByTagName("CharacterDescription");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();  
    }
public static void main(String args[]) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {

    SwampSimulator ss = new SwampSimulator();
//    ss.playGame(); // moved to a method CAMERON
    ss.initialize();

    }

}
