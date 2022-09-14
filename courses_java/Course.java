/**
 * In Course class there are four attributes. Attributes are initialized 
 *using a constructor by being assigned the value of constructor's parameter.
 *Each attributes has accesssor method and one attributes has a setter method.
 *Details about the course is displayed using a method. 
 * @author (Aasutosh Rajopadhyaya)
 * @version (Java 11.0.2)
 */
public class Course {
//----------Declaring Objects----------
    private String CourseID;
    private String CourseName;
    private String CourseLeader;
    private int Duration;
 //----------Declaring Objects----------
 
 //----------Constructor----------
    Course(String CourseID,String CourseName, int Duration)
    {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CourseLeader = "";
        this.Duration = Duration;
    }
//----------Constructor----------

//----------Accessor Method------
    public String getCourseID() //accessor method of CourseID
    {
        return this.CourseID;
    }
    
    public String getCourseLeader() //accessor method of CourseLeader
    {
        return CourseLeader;
    }
    
    public String getCourseName() //accessor method of CourseName
    {
        return this.CourseName;
    }
    
    public int getDuration() //accessor method of Duration
    {
        return this.Duration;
    }
//----------Accessor Method------

//----------Mutator Method-------        
     public void setCourseLeader(String CourseLeader) //setter method of CourseLeader
    {
        this.CourseLeader= CourseLeader;
    }
//----------Mutator Method-------   

//----------Display Method-------
    public void display()
    {
    System.out.println("Course ID is: " + CourseID);
    System.out.println("CourseName is: " + CourseName);
    {
        if (getCourseLeader() != "")
        System.out.println("Courseleader is: " + CourseLeader);
    }
    System.out.println("Course Duration is: " + Duration);
}
//----------Display Method------
}