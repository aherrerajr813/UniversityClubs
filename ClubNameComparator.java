// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: This class defines the inherited abstract method from Comparator interface "compare" such that 
//				 if the first argument object has its club name less than that of the second argument, an int less than zero is returned.
//				 If the first argument object has its club name larger than that of the second argument, 
//				 an int greater than zero is returned. If their club names are same, then 0 should be returned. 


import java.util.*;

public class ClubNameComparator implements Comparator<Club>  {
	
	public int compare(Club first, Club second) {
		String firstClub = first.getClubName();
		String secondClub = second.getClubName();
		if (firstClub.compareTo(secondClub)<0)
			return -1;
		else if(firstClub.compareTo(secondClub)>0)
			return 1;
		else //returns 0 if clubs have same name
			return 0;
	}
}
