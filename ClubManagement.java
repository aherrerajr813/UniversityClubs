// Assignment #: 8
//         Name: Armando Herrera
//    StudentID: 1216812909
//      Lecture: MW 4:35pm-5:50pm
//  Description: The ClubManagement class has a list of Club objects that can be organized at the club management system. 
//               The club management system is a fully encapsulated object. This class also implements the Serializable interface.

import java.io.*;

public class ClubManagement implements Serializable {
	private Club[] clubList;
	private int numberOfClubs;
	private int maxSize;
	
	/**
	 *  A Constructor of the ClubManagement class. Using the
		parameter value, it should initialize the member variable
		maxSize. Then it should instantiate an array of Club
		objects using the maxSize, and initialize each slot of the
		array to null for every index. It should also initialize the
		member variable numberOfClubs to 0.
	 * @param maximumSize
	 */
	public ClubManagement(int maximumSize) {
		maxSize = maximumSize;
		clubList = new Club[maxSize];
		numberOfClubs=0;
	}
	
	/**
	 *  Search for a Club object by clubName and its university,
		and return the index of the object if found. Return -1 if
		not found. The parameters are the club name and the
		university of a Club object.
	 * @param clubName
	 * @param university
	 * @return
	 */
	public int clubExists(String clubName, String university) {
		int returnVal=-1;//assumes club does not exist
		String name=null;
		String uni = null;
		if(numberOfClubs>0){
			for(int i=0; i< numberOfClubs; i++) {
				name = clubList[i].getClubName();
				uni = clubList[i].getUniversity();
				if (name.equals(clubName) && uni.equals(university)) {
					returnVal = 0;//club does exist
					break;//exit for loop
				}//close 2nd if statement
			}//close for loop
		}//close 1st if statement
		return returnVal;
	}
	
	/**
	 *  Search for a Club object in the club list that have the
		same presidents first name, last name, and academic
		level as the parameter values and return the index of
		such object if found. Return -1 if not found.
	 * @param firstName
	 * @param lastName
	 * @param academicLevel
	 * @return
	 */
	public int currentPresidentExists(String firstName, String lastName, String academicLevel) {
		int returnVal=-1;
		
		if(numberOfClubs>0){
			for(int i=0; i< numberOfClubs; i++) {
				if (clubList[i].getCurrentPresident().getFirstName().equals(firstName) && 
						clubList[i].getCurrentPresident().getLastName().equals(lastName) &&
						clubList[i].getCurrentPresident().getAcademicLevel().equals(academicLevel)) {//needs to satisfy three conditions
					returnVal = 0;
					break;//exit for loop
				}//close if statement
			}
		}
		return returnVal;
	}
	
	/**
	 *  Add a Club object to the club list and return true if such
		object was added successfully. Return false if an object
		with the same club name and university already exists
		or numberOfClubs is already same as maxSize, i.e., the
		array is full (the new object is not added).
	 * @param clubName
	 * @param numberOfMembers
	 * @param university
	 * @param firstName
	 * @param lastName
	 * @param academicLevel
	 * @return
	 */
	public boolean addClub(String clubName, int	numberOfMembers, String university,	String firstName, String lastName, String academicLevel) {
		boolean added = true;
		if (numberOfClubs == maxSize)
			added = false;
		else if (clubExists(clubName, university)==0)
			added = false;
		else {
			Club club1 = new Club();
			club1.setClubName(clubName);
			club1.setNumberOfMembers(numberOfMembers);
			club1.setUniversity(university);
			club1.setCurrentPresident(firstName, lastName, academicLevel);
			clubList[numberOfClubs]=club1;
			numberOfClubs++;
		}
		return added;
	}
	
	/**
	 *  Remove a Club object of the parameter clubName and
		the university from the club list. Return true if the object
		was removed successfully. Return false if the object with
		the given club name and university does not exist.
	 * @param clubName
	 * @param university
	 * @return
	 */
	public boolean removeClub(String clubName, String university) {
		boolean removed = false;
		//creates a local array that stores club objects if one is removed
		Club[] clubs = new Club[maxSize];
		String name=null;
		String uni = null;
		for(int i=0; i< numberOfClubs; i++) {
			name = clubList[i].getClubName();
			uni = clubList[i].getUniversity();
			if (name.equals(clubName) && uni.equals(university)) {
				//use a nested for loop to copy each element from clubList into the local one
				//where i is the index of the element that needs to be removed
				for(int j=0; j<numberOfClubs; j++) {
					if (!(i==j))
						clubs[j]= clubList[j];
					else if(i==j) {
						i++;
						clubs[j]= clubList[i];
					}
						
				}
				//assigns clubList to the locally created array 
				clubList = clubs;
				numberOfClubs--;
				removed = true;
				break;
			}
		}//close overarching for loop
		return removed;
	}
	
	/**
	 *  Sort the list of Club objects by club names. This method
		calls the sort method defined in the Sorts class, using
		the clubList, and its maxSize, an object of
		ClubNameComparator class.
	 */
	public void sortByClubNames() {
		ClubNameComparator club = new ClubNameComparator();
		Sorts.sort(clubList, numberOfClubs, club);
	}
	
	/**
	 *  Sort the list of Club objects by their numbers of
		members. This method calls the sort method defined in
		the Sorts class, using the clubList, and its maxSize, an
		object of MemberNumberComparator class.
	 */
	public void sortByMemberNumbers() {
		MemberNumberComparator club = new MemberNumberComparator();
		Sorts.sort(clubList, numberOfClubs, club);
	}
	
	/**
	 *  Sort the list of Club objects by their president
		information including its last names and first names.
		This method calls the sort method defined in the Sorts
		class, using the clubList, and its maxSize, an object of
		CurrentPresidentComparator class.

	 */
	public void sortByCurrentPresidents() {
		CurrentPresidentComparator club = new CurrentPresidentComparator();
		Sorts.sort(clubList, numberOfClubs, club);
	}
	
	/**
	 *  List all Club objects in the club list. The returned string is
		the concatenation of each Club object information in the
		list for the number of numberOfClubs (do not use the
		size of the array here) Hint: you can utilize Club's
		toString method to help you complete this method. If
		there is no object in the list, This method should return
		the string containing "\nno club\n\n".
	 * @return
	 */
	public String listClubs() {
		String list="\n";
		if(numberOfClubs == 0) {
			list= "\nno club\n";
		}
		else {
			for(int i=0; i< numberOfClubs; i++)
				list = list + clubList[i].toString();
		}//close else
		return list+"\n";
	}
	
	/**
	 * 	Closes the club management system by making the
		clubList empty. This can be done by making every slot
		of the clubList array to null, and also by setting
		numberOfClubs to be 0.
	 */
	public void closeClubManagement() {
		for(int i=0; i< clubList.length; i++) {
			clubList[i]=null;
			}
		numberOfClubs =0;
	}
}
