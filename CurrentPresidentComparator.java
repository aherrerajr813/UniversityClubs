// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: This class defines the inherited abstract method from Comparator interface "compare" such that if the 
//				 first argument object has its last name less than that of the second argument, an int less than zero is returned. 
//				 first argument object has its last name larger than that of the second argument, an int greater than zero is returned. 
//				 If their last names are same, then their first names should be compared. (if the first argument object has its first name smaller 
//				 (in alphabetical order -- compareTo method of the String class), then it should return a negative integer. 
//				 If the first argument object has its first name larger, then it should return a positive integer.
//               If their last names and first names are same, then 0 should be returned.


import java.util.*;

public class CurrentPresidentComparator implements Comparator<Club> {
	


	public int compare(Club first, Club second) {
		String lastName_1 = first.getCurrentPresident().getLastName();
		String lastName_2 = second.getCurrentPresident().getLastName();
		String firstName_1 = first.getCurrentPresident().getFirstName();
		String firstName_2 = second.getCurrentPresident().getFirstName();
		
		if (lastName_1.compareTo(lastName_2)<0)
			return -1;
		else if (lastName_1.compareTo(lastName_2)>0)
			return 1;
		else //checks first name if last name is the same
			if (firstName_1.compareTo(firstName_2)<0)
				return -1;
			else if(firstName_1.compareTo(firstName_2)>0)
				return 1;
			else 
				return 0;
	}
}
