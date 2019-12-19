/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

/**
 *
 * @author Gautam7
 */
public class CharacterRecord {
     private String adID;       // first name of Student
    private String crID;        // last name of Student
    private String adName;    // degree status of student
    private String crName;           // student major
    private int adValue;
    private int crInventory;
    private int crValue; // StudentID, (contains position of student in the Array within the Applet)
    private String crDesc;
    private String crImg;
    private String gaImg;
    public CharacterRecord(){}
    /** Creates a new instance of StudentRecord */
    public CharacterRecord(String cId, int cInventory, String cName, int cValue, String cDesc, String cImg, String gImg) {
        //adID = aId;
        crID = cId;
//        adName = aName;
        crName = cName;
        crInventory = cInventory;
//        adValue = aValue;
        crValue = cValue;
        crDesc = cDesc;
        crImg = cImg;
        gaImg = gImg;
    }
    
    
//ACCESSORS
    //retrieves first name
    public String getAdId(){
        return adID;
    }//end getFirstName()
    
    //retrieves last name
    public String getCrId(){
        return crID;
    }//end getLastName()
    
    //retrieves degree status
    public String getAdName(){
        return adName;
    }//end getDegreeStatus()
    
    //retrieves major
    public String getCrName(){
        return crName;
    }//end getMajor()
    
    public int getAdValue(){
        return adValue;
    }//end getStudentID() 
    public int getCrValue(){
        return crValue;
    }
    public int getCrInventory(){
        return crInventory;
    }
        public String getCrDesc(){
        return crDesc;
    }//end getMajor()
    public String getCrImg(){
        return crImg;
    }//end getMajor()
     public String getGImg(){
        return gaImg;
    }//end getMajor()
    
//MUTATORS 
    //sets first name
    public void setAdId(String aId){
        adID = aId;
    }//end setFirstName()
    
    //sets last name
    public void setCrId(String cId){
        crID = cId;
    }//end setLastName()
    
    //sets degree status
    public void setAdName(String aName){
        adName= aName;
    }//end setDegreeStatus()
    
    //sets major
    public void setCrName(String cName){
        crName = cName;
    }//end setMajor()
    
    //sets Student ID, but it's really this students spot in the array
    public void setAdValue(int aValue){
        adValue = aValue;
    }//end setID()
    public void setCrValue(int cValue){
        crValue = cValue;
    }//end setID()
   public void setCrInventory(int cInventory){
        crInventory = cInventory;
    }
    
    public String toString(){
        return crID + "  " + " " + crInventory + " " + crName + " " + crValue + " " + crDesc + " " + crImg + " " + gaImg ;
    }
    
    
}
