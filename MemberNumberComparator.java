// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: This class defines the inherited abstract method from Comparator interface "compare" such that 
//				 if the first argument object has its number of members less than that of the second argument, 
//				 an int less than zero is returned. If the first argument object has its
//				 number of members larger than that of the second argument, an int greater than zero is returned.
//				 If their numbers of members are same, then 0 should be returned.

import java.util.*;

public class MemberNumberComparator implements Comparator<Club> {
	
	public int compare(Club first, Club second) {
		int firstMem = first.getNumberOfMembers();
		int secondMem = second.getNumberOfMembers();
		if(firstMem<secondMem)
			return -1;
		else if (firstMem>secondMem)
			return 1;
		else //returns 0 if number of members is the same
			return 0;
	}

}
