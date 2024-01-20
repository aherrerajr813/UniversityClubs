// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: The President class describes a President.
//               It also provides their accessor, mutator methods,
//               and toString method.

import java.io.*;

public class President implements Serializable
{
 private String firstName;
 private String lastName;
 private String academicLevel;

 //Constructor method to initialize instance variables.
 public President()
  {
      firstName = new String("?");
      lastName= new String("?");
      academicLevel = new String("?");
  }

 public void copy(President other) {
	 this.setFirstName(other.getFirstName());
	 this.setLastName(other.getLastName());
	 this.setAcademicLevel(other.getAcademicLevel());
 }
 //Accessor method for first name
 public String getFirstName()
  {
   return firstName;
  }

 //Accessor method for last name
 public String getLastName()
  {
   return lastName;
  }

  //Accessor method for academic level
  public String getAcademicLevel()
   {
    return academicLevel;
   }

 //modifier method for first name
 public void setFirstName(String someFirstName)
  {
   firstName = someFirstName;
  }

 //modifier method for last name
 public void setLastName(String someLastName)
  {
   lastName = someLastName;
  }

 //modifier method for academic level
 public void setAcademicLevel(String someAcademicLevel)
  {
   academicLevel = someAcademicLevel;
  }

 //This method return a string containing the attribute information of a President
 public String toString()
  {
   String result;

      result = lastName + "," + firstName + "(" + academicLevel + ")";

   return result;
  }

}
