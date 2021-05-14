package Assignment2;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;


/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Shuyi Shi
Student Number: 216816555
Course Section: B
*/


/**
* This class generates a transcript for each student, whose information is in the text file.
* 
*
*/

/**
 * @author shuyi
 *
 */
public class Transcript {
	private ArrayList<Object> grade = new ArrayList<Object>();
	private File inputFile;
	private String outputFile;
	
	/**
	 * This the the constructor for Transcript class that 
	 * initializes its instance variables and call readFie private
	 * method to read the file and construct this.grade.
	 * @param inFile is the name of the input file.
	 * @param outFile is the name of the output file.
	 */
	public Transcript(String inFile, String outFile) {
		inputFile = new File(inFile);	
		outputFile = outFile;	
		grade = new ArrayList<Object>();
		this.readFile();
	}// end of Transcript constructor

	/** 
	 * This method reads a text file and add each line as 
	 * an entry of grade ArrayList.
	 * @exception It throws FileNotFoundException if the file is not found.
	 */
	//It is a method that reads the input file and stores each line of the file in the grade attribute of class Transcript.
	private void readFile() {
		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				grade.add(sc.nextLine());
	        }      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}		
	} 
	// end of readFile
	
	public static void main(String[] args) {
		Transcript t = new Transcript("input.txt", "output.txt");
		ArrayList<Student> students = t.buildStudentArray();
		t.printTranscript(students);
	}
	
	/**
	 * This method creates and returns an ArrayList, whose element is 
	 * an object of class Student. The object at each element is created 
	 * by aggregating ALL the information, that is found for one student 
	 * in the grade Arraylist of class Transcript.
	 * 
	 * @return an ArrayList of students
	 */
	public ArrayList<Student> buildStudentArray(){
		ArrayList<Student> output = new ArrayList<>(); 
		// create a list for the students
		for(Object row : grade) {
			String[] elements = row.toString().split(","); 
			// separate each element in the input text file by splitting them between each comma
			ArrayList<Double> marks = new ArrayList<>(); 
			// create a list to store marks of each assignment
			ArrayList<Assessment> assignments = new ArrayList<>(); 
			// create a list to store the assignments
			ArrayList<Integer> weights = new ArrayList<>(); // create a list of weight for assignments distribution
			
			String courseCode = elements[0]; 
			// the first element of each row is the course code
			int credit = Integer.parseInt(elements[1]); 
			// the second element of is the number of credit of the course
			String studentID = elements[2]; 
			// the third element of each row is the student id of each student
			for(int i = 0; i < elements.length - (3 + 1); i++) {// to loop through the elements until reach the name of the student(last element of the row)
				String[] distribution = elements[3 + i].split("[()]"); // this string array is used to store assignment type, weight and mark of the assignment 
				char itemType = distribution[0].charAt(0); // the first letter of assignment which is the type
				int weight = Integer.parseInt(distribution[0].substring(1)); // store the number after the letter as the weight
				double mark = Double.parseDouble(distribution[1]); // store the number inside the bracket as mark of the course
				weights.add(weight); // store the weight in the ArrayList of weight
				marks.add(mark); // store the mark in the ArrayList of mark
				assignments.add(Assessment.getInstance(itemType, weight)); // store the assignment with the type and the weight 
				
			}
			Course course = new Course(courseCode, assignments, credit); // set the course code, assignment and the number of credit of the course
			String name = elements[elements.length - 1]; // store the last element as the name of the student
			
			Student currentStudent = output.stream().filter(student -> student.getStudentID().equals(studentID)).findAny().orElse(null); // To find the student with the same student id, otherwise null. Which make the student unique 
			if(currentStudent == null) { // if there is no such student which means find a new student, add the new student to the output collection
				Student nextStudent = new Student(studentID, name, new ArrayList<>());
				nextStudent.addCourse(course);
				nextStudent.addGrade(marks, weights);
				output.add(nextStudent);
			}
			else { // if the same student add the course and grade
				currentStudent.addCourse(course);
				currentStudent.addGrade(marks, weights);
			}
		}
		return output;
	}
	
	/**
	 * This is the method that prints the transcript to the given file (i.e. outputFile attribute)
	 * @param studentList - the list of information about each student
	 */
	public void printTranscript(ArrayList<Student> studentList){ // print the transcript in required format
		try (PrintWriter writer = new PrintWriter(new File(outputFile))) {
			for(Student s : studentList) {
				writer.write(s.getName() + "\t" + s.getStudentID());
				writer.write("\n");
				writer.write("-------------------"); // the 20 dash
				writer.write("\n");
				ArrayList<Course> courseTaken = s.getCourseTaken(); // add all the course taken by the student
				for(int i = 0; i < courseTaken.size(); i++) {
					writer.write(courseTaken.get(i).getCode() + "\t" + s.getFinalGrade().get(i));
					writer.write("\n");
				}
				writer.write("-------------------"); // the 20 dash
				writer.write("\n");
				writer.write("GPA: " + s.weightedGPA());
				writer.write("\n");
				writer.write("\n");
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * This student class have four attributes studentID, name, courseTaken, finalGrade.
 */
class Student {
	private String studentID;
	private String name;
	private ArrayList<Course> courseTaken;
	private ArrayList<Double> finalGrade;
	
	/**
	 * default constructor
	 */
	public Student() {
		courseTaken = new ArrayList<>();
		finalGrade = new ArrayList<>();
	}//end of student constructor
	
	/**
	 * custom constructor
	 * This constructor initialized the studentID, name and courseTaken of each student on input file.
	 * 
	 * @param studentID - student number of the student
	 * @param name - the name of the student 
	 * @param courseTaken - the courses that have been taken by the student 
	 */
	public Student(String studentID, String name, ArrayList<Course> courseTaken) {
		this.studentID = studentID;
		this.name = name;
		this.courseTaken = new ArrayList<Course>();
		this.finalGrade =  new ArrayList<>();
		for(Course c : courseTaken) {
			this.courseTaken.add(new Course(c));
			finalGrade.add(0.0);
		}
	}
	/**
	 * This method gets an array list of the grades and their weights, 
	 * computes the true value of the grade based on its weight and add it 
	 * to finalGrade attribute. If the sum of the weight was not 100, 
	 * or the sum of grade was greater 100, it throws InvalidTotalException.
	 * 
	 * @param grades - list of grade of the course
	 * @param weights - list of the distribution of the course
	 * @throws InvalidTotalException - when the sum of grade is greater than 100
	 * or the the total distribution is not 100.
	 */
	public void addGrade(ArrayList<Double> grades, ArrayList<Integer> weights) {
		int totalWeight = 0;
		double grade = 0;
		for(int i = 0; i < grades.size(); i++) {
			int weight = weights.get(i);
			totalWeight += weight;
			grade += grades.get(i) * weight / 100;
		}
		if(totalWeight != 100) {
			throw new InvalidTotalException("Total weight is not 100");
		}
		if(grade > 100) {
			throw new InvalidTotalException("The sum of grade is greater than 100");
		}
		finalGrade.add(Math.round(grade * 10) / 10.0);
	}
	
	/**
	 * InvalidTotalException: This is the exception that is thrown 
	 * if the total weight of the assessments does not add up to 100, 
	 * or of the total grade of a student is more than 100.
	 */
	class InvalidTotalException extends RuntimeException{
		public InvalidTotalException(String message) {
			System.out.println(message);
		}
	}
	
	/**
	 * It is the method that computes the GPA of the student.
	 * 
	 * @return the GPA and rounded to one decimal place
	 */
	public double weightedGPA() {
		double totalPoint = 0.0;
		double credits = 0.0;
		for(int i = 0; i < courseTaken.size(); i++) {
			int gradePoint;
			double grade = finalGrade.get(i);
			if(grade >= 90.0) {
				gradePoint = 9;
			}
			else if(grade >= 80.0) {
				gradePoint = 8;
			}
			else if(grade >= 75.0) {
				gradePoint = 7;
			}
			else if(grade >= 70.0) {
				gradePoint = 6;
			}
			else if(grade >= 65.0) {
				gradePoint = 5;
			}
			else if(grade >= 60.0) {
				gradePoint = 4;
			}
			else if(grade >= 55.0) {
				gradePoint = 3;
			}
			else if(grade >= 50.0) {
				gradePoint = 2;
			}
			else if(grade >= 47.0) {
				gradePoint = 1;
			}
			else {
				gradePoint = 0;
			}
			double credit = courseTaken.get(i).getCredit();
			totalPoint += credit * gradePoint;
			credits += credit;
		}
		return Math.round((totalPoint / credits) * 10)/ 10.0;
	}
	
	/**
	 * get a course object as an input and add it to courseTaken.
	 * 
	 * @param course - a course object 
	 */
	public void addCourse(Course course) {
		courseTaken.add(new Course(course));
		
	}
	/**
	 * access the student id
	 * 
	 * @return the studentID of the student
	 */
	public String getStudentID() {
		return studentID;
	}
	
	/**
	 * set the student id of the student
	 * 
	 * @param studentID - the student number of the student
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * access the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the student
	 * 
	 * @param name - the name of the student
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * access the courses been taken by the student
	 * 
	 * @return the list of courses have been taken by student
	 */
	public ArrayList<Course> getCourseTaken() {
		ArrayList<Course> result = new ArrayList<Course>();
		for(Course c : courseTaken) {
			result.add(new Course(c));
		}
		return result;
	}
	
	/**
	 * set a new list of course taken
	 * 
	 * @param courseTaken - the list of course taken by the student
	 */
	public void setCourseTaken(ArrayList<Course> courseTaken) {
		this.courseTaken = new ArrayList<Course>();
		for(Course c : courseTaken) {
			this.courseTaken.add(new Course(c));
		}
	}
	
	/**
	 * return the list of final grade of the student
	 * 
	 * @return the list of final grade of the student
	 */
	public ArrayList<Double> getFinalGrade() {
		return finalGrade;
	}
	
	/**
	 * set a new list of final grade of the student
	 * 
	 * @param finalGrade - a list of final grade
	 */
	public void setFinalGrade(ArrayList<Double> finalGrade) {
		this.finalGrade = finalGrade;
	}
}

/**
 * class course contains three attributes, code, and the list of assignments and the number of credit 
 * 
 *
 */
class Course {
	private String code;
	private ArrayList<Assessment> assignment;
	private double credit;
	
	/**
	 * default constructor of class course
	 */
	public Course() {
		
	}
	
	/**
	 * custom constructor of class course, initialized course code, the assignments, and the credit of each course
	 * @param code - course code of course taken
	 * @param assignment - a list of assignment
	 * @param credit - the number of credit of a course
	 */
	public Course(String code, ArrayList<Assessment> assignment, double credit) {
		this.code = code;
		this.assignment = new ArrayList<Assessment>();
		for(Assessment a : assignment) {
			this.assignment.add(a);
		}
		this.credit = credit;
	}
	
	/**
	 * copy constructor, initialized this course by copying another course
	 * 
	 * @param course - a new course object 
	 */
	public Course(Course course) {
		this.code = course.code;
		this.assignment = new ArrayList<Assessment>();
		for(Assessment a : course.assignment) {
			this.assignment.add(a);
		}
		this.credit = course.credit;
	}
	
	/**
	 * generates hashcode
	 * 
	 * @return hashcode of the object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(assignment, code, credit);
	}

	/**
	 * This overriden method defines the rules of equality between objects,
	 * 
	 * @param an object to compare with too see if it's equal or not
	 * @return <code>true</code> if the object is equal to <code>obj</code>;
	 *        <code>false</code> otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(assignment, other.assignment) && Objects.equals(code, other.code)
				&& Double.doubleToLongBits(credit) == Double.doubleToLongBits(other.credit);
	}
	
	/**
	 * return the credit of the course
	 * 
	 * @return the credit of the course
	 */
	public double getCredit() {
		// TODO Auto-generated method stub
		return this.credit;
	}
	
	/**
	 * return the list of the assignment of the course
	 * 
	 * @return the list of the assignment of the course
	 */
	public ArrayList<Assessment> getAssignment() {
		ArrayList<Assessment> result = new ArrayList<Assessment>();
		for(Assessment a : assignment) {
			result.add(a);
		}
		return result;
	}
	
	/**
	 * return the course code
	 * 
	 * @return the code of the course
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * set the list of assessments 
	 */
	public void setAssignment(ArrayList<Assessment> assignment) {
		ArrayList<Assessment> result = new ArrayList<Assessment>();
		for(Assessment a : assignment) {
			result.add(a);
		}
	}
	
	/**
	 * return the new credit of the course
	 * 
	 * @param credit - the number of credit of the course
	 */
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	
	/**
	 * return the course code
	 * 
	 * @param code - the code of the course
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
/**
 * class assessment contains type of assessment and the distribution of assessment 
 *
 */
class Assessment {
	private char type;
	private int weight;
	
	/**
	 * the default constructor of assessment class
	 */
	private Assessment() {
		
	}
	
	/**
	 * custom constructor
	 * initialized the type and weight
	 * 
	 * @param type - the type of assessment
	 * @param weight - the weight distribution of assessment
	 */
	private Assessment(char type, int weight) {
		this.type = type;
		this.weight = weight;
	}
	
	/**
	 * This is a static factory method for class Assessment
	 * 
	 * @param type - the type of assessment
	 * @param weight - the weight distribution of assessment
	 * @return the assessment with the type and the weight
	 */
	public static Assessment getInstance(char type, int weight) {
		return new Assessment(type, weight);
	}
	
	/** generate a hash code for object
	 * @return the hash code of the object
	 */
		@Override
	public int hashCode() {
		return Objects.hash(type, weight);
	}
	
	/**
	 * This overriden method defines the rules of equality between objects,
	 * 
	 * @param an object to compare with too see if it's equal or not
	 * @return <code>true</code> if the object is equal to <code>obj</code>;
	 *         <code>false</code> otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assessment other = (Assessment) obj;
		return type == other.type && weight == other.weight;
	}
	
	/**
	 * return the type of the assessment
	 * 
	 * @return the type of the assessment
	 */
	public char getType() {
		return this.type;
	}
	
	/**
	 * return the weight of the assessment
	 * 
	 * @return the weight of the assessment
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * set the type of the assessment
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * set the weight of the assessment
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}// end of Transcript

