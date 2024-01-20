// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: The Sorts class is a utility class that's used to sort a list of Club objects.
//				 The sort method utilizes the compare method of the parameter Comparator object to sort, 
//               is passed an array of clubs as well as the size of clubs in the array. 
//				 Uses Insertion Sort to sort the clubs. 

import java.util.*;

public class Sorts {
	
	public static void sort(Club[] clubList, int size, Comparator<Club> comparator) {
		for (int index =1; index< size; index++) {
			Club key = clubList[index];
			int position = index;
			//uses insertion sort algorithm thats adjusted to work with the comparators 
			while (position>0 && comparator.compare(clubList[position-1], key)>0) {
				clubList[position]= clubList[position-1];
				position--;
			}
			clubList[position]=key;
		} 	
	}

}
