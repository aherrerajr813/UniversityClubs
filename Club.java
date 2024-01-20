// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: The class Club represents a Club.

import java.io.*;

public class Club implements Serializable
 {
   private String clubName;
   private int numberOfMembers;
   private String university;
   private President currentPresident;

   //Constructor to initialize all member variables
   public Club()
    {
      clubName = "?";
      university = "?";
      numberOfMembers = 0;
      currentPresident = new President();
    }
   
   public void copy(Club other) {
	   //create a local President variable to use its methods
	   President otherPres = other.getCurrentPresident();
	   this.setClubName(other.getClubName());
	   this.setNumberOfMembers(other.getNumberOfMembers());
	   this.setUniversity(other.getUniversity());
	   this.setCurrentPresident(otherPres.getFirstName(), otherPres.getLastName(), otherPres.getAcademicLevel());
   }

   //Accessor method for club name
   public String getClubName()
    {
      return clubName;
    }

   //Accessor method for university
   public String getUniversity()
    {
      return university;
    }

   //Accessor method for number of members
   public int getNumberOfMembers()
    {
	   return numberOfMembers;
	}

   //Accessor method for current president
   public President getCurrentPresident()
    {
      return currentPresident;
    }

   //Modifier method for club name
   public void setClubName(String someClubName)
    {
     clubName = someClubName;
    }

   //Modifier method for university
   public void setUniversity(String someUniversity)
    {
     university = someUniversity;
    }

   //Modifier method for number of members
   public void setNumberOfMembers(int someNumber)
    {
        numberOfMembers = someNumber;
    }

   //Modifier method for current president
   public void setCurrentPresident(String fname, String lname, String level)
    {
        currentPresident.setFirstName(fname);
        currentPresident.setLastName(lname);
        currentPresident.setAcademicLevel(level);
    }

   //toString() method returns a string containing its name, number of members, university
   //and current president
   public String toString()
    {
      String result = "\nClub Name:\t\t" + clubName
                    + "\nNumber Of Members:\t" + numberOfMembers
                    + "\nUniversity:\t\t" + university
                    + "\nPresident:\t\t"
                    + currentPresident.toString() + "\n\n";
      return result;
     }
  }
