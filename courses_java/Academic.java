
/**
 * Academic is a child class of Course class. Construct is used to initialize attribues and each of the the the attributes had their corresponing accessor
 * method. Mutator method was used to change respective the variable. There register, remove and display were the method used in the class.
 *Display method displays details of Academic class.
 * @author (Aasutosh Rajopadhyaya)
 * @version (Java 11.0.2)
 */
public class Academic extends Course

// ----------- Objects Declaration -------------------//
{
   private String CompletionDate;  
   private String Credit;
   private String LecturerName;
   private String Level;
   private int NumberOfAssesments;
   private String StartingDate;
   private boolean isRegistered;
   private boolean removedStatus;
// ----------- Objects Declaration -------------------//   
   
// -------------- Initializing -------------------------//
   Academic(String CourseID, String CourseName,int Duration,String Level, String Credit, int NumberOfAssessments) //Constructor with parameter 
   {
    super(CourseID,CourseName,Duration);
    this.LecturerName = "";
    this.StartingDate = "";
    this.CompletionDate = "";
    this.isRegistered = false;
}
// -------------- Initializing -------------------------//

// --------------Accessor Methods---------- //
public String getCompletionDate(){   //accessor method of CompletionDate
    return this.CompletionDate;
}

public String getCredit(){   //accessor method of Credit
    return this.Credit;
}

public String getLecturerName(){  //accessor method of LecturerName
    return this.LecturerName;
}

public String getLevel(){  //accessor method of Level
    return this.Level;
}

public int getNumberOfAssesments(){  //accessor method of NumberOfAssessment
    return this.NumberOfAssesments;
}

public String getStartingDate(){  //accessor method of StartingDate
    return this.StartingDate;
}

public boolean getisRegistered(){  //accessor method of isRegistered
    return this.isRegistered;
}

public boolean getremovedStatus(){  //accessor method of removedStatus
    return this.removedStatus;
}
// --------------Accessor Methods---------- //

// --------------Mutator Methods---------- //
public void setLecturerName(String LecturerName){  //mutator method of LecturerName
    this.LecturerName = LecturerName;
}

public void setNumberOfAssesments(int NumberOfAssesments){ //mutator method of NumberofAssessments
    this.NumberOfAssesments = NumberOfAssesments;
}
// --------------Mutator Methods---------- //

//---------------Register Method----------//
public void register(String CourseLeader, String LecturerName,String IntructorName, String StartingDate,String CompletionDate){
    if (isRegistered == true){
        System.out.println("This course is already registered!");
        System.out.println("Your Lecturer  Name is: " + LecturerName);
        System.out.println("Course starting date is: " + StartingDate);
        System.out.println("Course completion date is: " + CompletionDate);

}
else if(isRegistered ==false){
    super.setCourseLeader(CourseLeader);
    this.LecturerName = LecturerName;
    this.StartingDate = StartingDate; 
    this.CompletionDate = CompletionDate;
    this.isRegistered = true;
    this.removedStatus = false;
}
}
//---------------Register Method----------//

//-----------Display Method-------------------//
public void display(){
    super.display();
    if(isRegistered == true){
        System.out.println("YourInstructor Name is: " + LecturerName);
        System.out.println("Level: " + Level);
        System.out.println("Credit Hours: " + Credit);
        System.out.println("Course starting date is: " + StartingDate);
        System.out.println("Course completion date is: " + CompletionDate);
        System.out.println("Number of Assessments: " + NumberOfAssesments);
}
//-----------Display Method-------------------//
}
}
