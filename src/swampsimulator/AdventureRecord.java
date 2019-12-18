/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

/**
 *
 * @author gvp5180
 */
public class AdventureRecord {
    
    private String adID;       // first name of Student
    private String crID;        // last name of Student
    private String adName;    // degree status of student
    private String crName;           // student major
    private int adValue;
    private int crValue; // StudentID, (contains position of student in the Array within the Applet)
    public AdventureRecord(){}
    /** Creates a new instance of StudentRecord */
    public AdventureRecord(String aId, String aName, int aValue) {
        adID = aId;
//        crID = cId;
        adName = aName;
//        crName = cName;
        adValue = aValue;
//        crValue = cValue;
    }
    
    
//ACCESSORS
    //retrieves first name
    public String getAdId(){
        return adID;
    }//end getFirstName()
    
    //retrieves degree status
    public String getAdName(){
        return adName;
    }//end getDegreeStatus()

    public int getAdValue(){
        return adValue;
    }//end getStudentID() 
    
//MUTATORS 
    //sets first name
    public void setAdId(String aId){
        adID = aId;
    }//end setFirstName()
    
    //sets last name
    public void setAdName(String aName){
        adName= aName;
    }//end setDegreeStatus()
    //sets Student ID, but it's really this students spot in the array
    public void setAdValue(int aValue){
        adValue = aValue;
    }//end setID()
    
    public String toString(){
        return adID + "  " +  adName + " " + adValue;
    }
    
}
