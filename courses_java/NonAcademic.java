
/**
 * The NonAcademic class is a child class of Course class. Constructor is used to initialize attributes. There's use of getters and setters method to get 
 * and set the objects. Additionally register, remove and display method are used.
 * @author (Aasutosh Rajopadhyaya)
 * @version(Java 11.0.2)
 */

class NonAcademic extends Course
{
//-----------Object Declaration----------
   private String CompletionDate;
   private String ExamDate;
   private String InstructorName;
   private String StartingDate;
   private boolean isRegistered;
   private boolean isRemoved; 
   private String prerequisite;
//-----------Object Declaration----------

//-----------Constructor-----------------
   NonAcademic(String CourseID,String CourseName, int Duration, String prerequisite){ //initializing objects
       super(CourseID, CourseName, Duration);
       this.prerequisite = prerequisite;
       this.StartingDate = "";
       this.CompletionDate = "";
       isRegistered = false;
       isRemoved = false;
       
}
//-----------Constructor-----------------//

// -----------Accessor Method-----------
public String getCompletionDate(){ //accessor method of CompletionDate
    return this.CompletionDate;
}

public String getExamDate(){ //accessor method of ExamDate
    return this.ExamDate;
}

public String getInstructorName(){ //accessor method of InstructorName
    return this.InstructorName;
}

public String getStartingDate(){ //accessor method of StartingDate
    return this.StartingDate;
}

public boolean getisRegistered(){ //accessor method of isRegistered
    return this.isRegistered;
}

public boolean getisRemoved(){ //accessor method of isRemoved
    return this.isRemoved;
}

public String getprerequisite(){ //accessor method of prerequsite
    return this.prerequisite;
}
// -----------Accessor Method-----------

//------------Mutator Method------------
public void setInstructorName(String InstructorName){
    if(isRegistered == false){
        this.InstructorName = InstructorName;
    }
    else if(isRegistered == true){ 
        System.out.println("This course is already regestered. Unable to change instructor name.");
    }
    this.InstructorName = InstructorName;
}
//------------Mutator Method------------

//------------Register Method----------- //To register new NonAcademic course if not registered
void register(String CourseLeader, String InstructorName, String StartingDate, String CompletionDate, String ExamDate){
    if (isRegistered == false){
        setInstructorName(InstructorName);
        isRegistered = true;
        isRemoved = false;
    }
    else if(isRegistered == true){
        System.out.println("This course is already registered!");
}
}
//------------Register Method-----------

//------------Remove Method-------------
public void remove(){ //to check the remove status 
    if(isRemoved == true)
    {
        System.out.println("This course is already removed");
    }
    else if (isRemoved == false)
    {
        super.setCourseLeader("");
        this.InstructorName = "";
        this.StartingDate = "";
        this.CompletionDate = "";
        this.ExamDate = "";
        this.isRegistered = false;
        this.isRemoved = true;
}
}
//------------Remove Method-------------

//------------Display Method-------------
public void display(){ //Displays details of NonAcademic class
    super.display();
    if(isRegistered = true){
        System.out.println("Instructor Name is: " + InstructorName);
        System.out.println("Starting Date is from: " + StartingDate);
        System.out.println("Completion Date is on: " + CompletionDate);
        System.out.println("Exam Date is from: " + ExamDate);
        System.out.println("Prerequsite are: " + prerequisite);
    }
}
//------------Display Method-------------
}