// Author: Tommy Soh
// Grades calculator
/*
	Before the grades are released on Oasis (an SMU Portal), they release a grade point which is a sum of grades from all your individual modules
	This program helps to generate the possibilities of your individual modules from grade point which is awesome. \nBy Tommy 
*/
import java.util.*;

public class Grade{
	public static float[] grades;
	public static HashMap<Float,String> gradesMap;
	public static float your_grade_point = 0.0f; // total grade
	public static int numberOfModulesTaken = 5; // number of modules taken
	public static HashSet<String> results;
	static {
		grades = new float[]{1.0f, 1.3f, 1.7f, 2.0f, 2.3f, 2.7f, 3.0f, 3.3f, 3.7f, 4.0f, 4.3f};
		gradesMap = new HashMap<Float,String>();
		results = new HashSet<String>();

		gradesMap.put(4.3f, "A+");
		gradesMap.put(4.0f, "A");
		gradesMap.put(3.7f, "A-");
		gradesMap.put(3.3f, "B+");
		gradesMap.put(3.0f, "B");
		gradesMap.put(2.7f, "B-");
		gradesMap.put(2.3f, "C+");
		gradesMap.put(2.0f, "C");
		gradesMap.put(1.7f, "C-");
		gradesMap.put(1.3f, "D+");
		gradesMap.put(1.0f, "D");
	}

	public static void main(String[] args){
		System.out.print("Before the grades are released on Oasis (an SMU Portal), they release a grade point which is a sum of grades from all your individual modules");
		System.out.print("This program helps to generate the possibilities of your individual modules from grade point which is awesome. \nBy Tommy ");
		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter current Semester's Grade point : ");
		your_grade_point = reader.nextFloat();

		System.out.print("Please enter the number of modules you are taking this sem: ");
		numberOfModulesTaken =reader.nextInt(); 

		addModuleGradeAndCheck(new ArrayList<Float>());

		System.out.println("Possibilities");
		for(String res: results){
			System.out.println(res);
		}
	}
	/*
		addModuleGradeAndCheck is a recursive method by depth and exits if calls itself more than numberOfModulesTaken
		Could potentially count at every point if size of resulttoprint already exceed gradepoint which then should exit. but I think it may have a longer run time to calculate that way 
		Potentially bad if numberOfModulesTaken is large, but it isn't... students probably can't take so many modules but thats an assumption which is not handled
	*/
	public static void addModuleGradeAndCheck(ArrayList<Float> resultToPrint){
		// exit if more than numberOfModulesTaken already added to arraylist
		if(resultToPrint.size()>=numberOfModulesTaken){
			float total = 0.0f;
			for(float f:resultToPrint){
				total +=f;
			}
			if(total==your_grade_point){ // a possibility is found
				Collections.sort(resultToPrint); // sort and sorted into a hashset to handle duplicate
				String res = "";
				for(float f:resultToPrint){
					res += gradesMap.get(f)+" ";
				}
				results.add(res);
			}
			return;
		}
		// goes through all possible grades and calls them
		for(float f: grades){
			ArrayList<Float> temp = (ArrayList<Float>)resultToPrint.clone();
			temp.add(f);
			addModuleGradeAndCheck(temp);
		}
	}
}
