
/**
 * In INGCollege class, attributes are declared as instance. A gui is made using
 * JAVA swing and awt. Each textField has its own accessor method to access the 
 * variables of textField. Action listener is used to implement actions to buttons.
 * Try and catch is used for exception handling.
 * @Group C13
 * @author (Aasutosh Rajopadhyaya)
 * @ID (20048802)
 * @version (Java 11.0.2)
 **/

import javax.swing.*;  
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;

public class INGCollege implements ActionListener
{
    //JFrame
    private JFrame mainFrame; 

    //ArrayList Declaration
    public ArrayList<Course> arrayList = new ArrayList<Course>();

    //JButton buttonPanels
    private JButton nacButton, acButton;

    //JPanels academic and nonAcademic
    private JPanel academicCourse,nonAcademicCourse ;

    //Fonts
    private Font title, subtitle;

    //JLabel academicCLass
    private JLabel labelTitle, acTitleAdd, acCourseID,  acDuration, acLevel, acCourseName, acNoAssessments, acCredit,
    titleRegister, racCourseID, racCourseLeader, racLecturerName, racStartingDate, racCompletionDate;

    //JTextField academicClass
    private JTextField acFieldCourseID, acFieldDuration,
    acFieldLevel, acFieldCourseName, acFieldNoAssessments, acFieldCredit, racFieldCourseID,
    racFieldCourseLeader, racFieldLecturerName;

    //JButton academicClass
    private JButton acButtonAdd, registerAcademic, acDisplay, acClear;

    //JComboBox academicClass
    private JComboBox startingDate, startingMonths, startingYear,
    completionDate,  completionMonths, completionYear;

    //JLabel nonAcademicCourse
    private JLabel nacCourseID, labelTitleTwo, nacTitleAdd, nacCourseName, nacDuration, nacPrerequisite, nactitleRegister, 
    rnacCourseID, rnacCourseLeader, rnacInstructorName, rnacStartingDate, rnacCompletionDate, rnacExamDate;

    //JTextField nonAcademicCourse
    private JTextField nacFieldCourseID, nacFieldCourseName, nacFieldDuration, nacFieldPrerequisite, rnacFieldCourseID, 
    rnacFieldCourseLeader, rnacFieldInstructorName;

    //JComboBox nonAcademicCourse
    private JComboBox rnacAllStartingDate, rnacAllStartingMonths, rnacAllStartingYear, rnacAllCompletionDate, rnacAllCompletionMonths,
    rnacAllCompletionYear, rnacAllExamDate, rnacAllExamMonths,rnacAllExamYear;

    //JButton nonAcademicCourse
    private JButton nacButtonAdd, nacDisplay,nacClear, nacRemove, registerNonAcademic;

    //Dates array
    private String dates[] = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };

    private String months[] = 
        { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };

    private String years[]= { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022","2023", "2024","2025"}; 
    //Dates Array

    private Academic academicObject;
    private NonAcademic nonAcademicObject;
    private String addAcademicCourseID;
    private String addAcademicCourseName;
    private int addAcademicCourseDuration;
    private String addAcademicCourseLevel;
    private String addAcademicCourseCredit;
    private int addAcademicCourseNoAssessments;
    private boolean validation;

    private JOptionPane addNonAcademicCourse;
    private JOptionPane addNonAcademicCourseAdded;
    private JOptionPane addAcademicCourse;
    private JOptionPane addAcademicCourseAdded;

    private JOptionPane registerAcademicCourse;
    private JOptionPane registerAcademicCourseAdded;
    private JOptionPane registerNonAcademicCourse;
    private JOptionPane registerNonAcademicCourseAdded;
    private JOptionPane messageInvalid;
    private JOptionPane messageRemoved;

   

    public void GUI()
    {
        /**
         * All the codes to create a user interface is written in this method.
         * There is one frame which contains two panels. academicCourse consista all the elements to 
         * add and register academic course and panel nonAcademicCourse consists all the elements to add, register and remove non-acadmeic course.
         */
        //JFrame --> MainFrame
        mainFrame = new JFrame("Course Registration");

        //JButton <-- AcademicCourse
        acButton = new JButton("Academic Course");
        acButton.setBounds(200,20,175,30);
        acButton.addActionListener(this);   

        //JButton <-- NonAcademicCourse
        nacButton = new JButton("Non-Academic Course");
        nacButton.setBounds(400 ,20, 175,30);
        nacButton.addActionListener(this);

        //JPanel <-- Academic Course
        academicCourse = new JPanel();
        academicCourse.setLayout(null);
        academicCourse.setBounds(0,0,800,900);
        academicCourse.setBackground(new Color(130, 159, 207));
        academicCourse.setVisible(true);

        //JPanel <-- nonAcademic Course
        nonAcademicCourse = new JPanel();
        nonAcademicCourse.setLayout(null);
        nonAcademicCourse.setBounds(0,0,800,900);
        nonAcademicCourse.setBackground(new Color(242, 196, 196));
        nonAcademicCourse.setVisible(false);

        //Fonts
        title = new Font("Helvetica ", Font.BOLD, 30);
        subtitle = new Font("Arial", Font.BOLD, 20);
        //Fonts

        //--------- Academic-----------------
        //JLabel <-- Title--Academic
        labelTitle = new JLabel("Academic Course!");
        labelTitle.setBounds(150,60,300,60);
        labelTitle.setFont(title);
        academicCourse.add(labelTitle);

        //----------Add-------------
        //JLabel <-- acTitleAdd
        acTitleAdd = new JLabel("Add Course: ");
        acTitleAdd.setBounds(20,120,150,30);
        acTitleAdd.setFont(subtitle);
        academicCourse.add(acTitleAdd);

        //JLabel <-- CourseID--Academic 
        acCourseID = new JLabel("Course ID: ");
        acCourseID.setBounds(25, 160, 95, 25 );
        academicCourse.add(acCourseID);

        //JTextField <-- CourseID--Academic
        acFieldCourseID = new JTextField();
        acFieldCourseID.setBounds(150,155,150,30);
        academicCourse.add(acFieldCourseID);

        //JLabel <-- Duration--Academic
        acDuration = new JLabel("Duration: ");
        acDuration.setBounds(25,220, 95, 25);
        academicCourse.add(acDuration);

        //JTextField <-- Duration--Academic
        acFieldDuration = new JTextField();
        acFieldDuration.setBounds(150, 215, 150,30);
        academicCourse.add(acFieldDuration);

        //JLabel <-- Level --Academic
        acLevel = new JLabel("Level: ");
        acLevel.setBounds(25,280, 110,25);
        academicCourse.add(acLevel);

        //JTextField <-- Level--Academic
        acFieldLevel = new JTextField();
        acFieldLevel.setBounds(150,275,150,30);
        academicCourse.add(acFieldLevel);

        //JLabel <-- CourseName--Academic
        acCourseName = new JLabel("Course Name: ");
        acCourseName.setBounds(320,160, 95,25);
        academicCourse.add(acCourseName);

        //JTextField <-- CourseName--Academic
        acFieldCourseName = new JTextField();
        acFieldCourseName.setBounds(420,155, 150,30);
        academicCourse.add(acFieldCourseName);

        //JLabel <-- No of Assessments --Academic
        acNoAssessments = new JLabel("No.Assessments:");
        acNoAssessments.setBounds(320, 220,100,25);
        academicCourse.add(acNoAssessments);

        //JTextField <-- No of Assessements--Academic
        acFieldNoAssessments = new JTextField();
        acFieldNoAssessments.setBounds(420,215,150,30);
        academicCourse.add(acFieldNoAssessments);

        //JLabel <-- Credit--Academic
        acCredit = new JLabel("Credit: ");
        acCredit.setBounds(320,280,95,25);
        academicCourse.add(acCredit);

        //JTextField <--Credit--Academic
        acFieldCredit = new JTextField();
        acFieldCredit.setBounds(420, 275,150,30);
        academicCourse.add(acFieldCredit);

        //JButton <-- Add--Academic
        acButtonAdd = new JButton("Add");
        acButtonAdd.setBounds(25, 335, 90,40);
        acButtonAdd.setFont(subtitle);
        acButtonAdd.addActionListener(this);
        academicCourse.add(acButtonAdd);

        //----------End Add-------------

        //----------Register------------------------------------------------------------------------------------------
        //JLabel <-- RegisterTitle
        titleRegister = new JLabel("Register Course: ");
        titleRegister.setBounds(25,400,200,30);
        titleRegister.setFont(subtitle);
        academicCourse.add(titleRegister);    

        //JLabel <-- CourseID
        racCourseID = new JLabel("Course ID: ");
        racCourseID.setBounds(25, 440, 95, 25 );
        academicCourse.add(racCourseID);

        //JTextField <- CourseID
        racFieldCourseID = new JTextField();
        racFieldCourseID.setBounds(150,435,150,30);
        academicCourse.add(racFieldCourseID);

        //JLabel <-- CourseLeader
        racCourseLeader = new JLabel("Course Leader: ");
        racCourseLeader.setBounds(25, 500, 95, 25 );
        academicCourse.add(racCourseLeader);

        //JTextField <-- CourseLeader
        racFieldCourseLeader = new JTextField();
        racFieldCourseLeader.setBounds(150, 495, 150,30 );
        academicCourse.add(racFieldCourseLeader);

        //JLabel <-- LecturerName
        racLecturerName = new JLabel("Lecturer Name: ");
        racLecturerName.setBounds(25, 560, 95, 25 );
        academicCourse.add(racLecturerName);

        //JTextField <-- LecturerName
        racFieldLecturerName = new JTextField();
        racFieldLecturerName.setBounds(150, 555, 150,30 );
        academicCourse.add(racFieldLecturerName); 

        //JLabel <-- StartingDate
        racStartingDate = new JLabel("Starting Date: ");
        racStartingDate.setBounds(25, 620, 95, 25 );
        academicCourse.add(racStartingDate); 

        //JComboBox <--Starting(Date - Month - Year)
        //Date
        startingDate = new JComboBox(dates);
        startingDate.setBounds(150,615,80,30);
        academicCourse.add(startingDate);
        //Months
        startingMonths = new JComboBox(months);
        startingMonths.setBounds(240,615,80,30);
        academicCourse.add(startingMonths);
        //Years
        startingYear = new JComboBox(years);
        startingYear.setBounds(330,615,80,30);
        academicCourse.add(startingYear);

        //JLabel <-- CompletionDate
        racCompletionDate = new JLabel("Completion Date: ");
        racCompletionDate.setBounds(25, 680, 120, 25 );
        academicCourse.add(racCompletionDate); 

        //JComboBox <-- Completion(Date - Month - Year)
        //Date
        completionDate = new JComboBox(dates);
        completionDate.setBounds(150,675,80,30);
        academicCourse.add(completionDate);
        //Months
        completionMonths = new JComboBox(months);
        completionMonths.setBounds(240,675,80,30);
        academicCourse.add(completionMonths);
        //Year
        completionYear = new JComboBox(years);
        completionYear.setBounds(330,675,80,30);
        academicCourse.add(completionYear);

        //Register Button:
        registerAcademic = new JButton("Register");
        registerAcademic.setBounds(25,720,90,40);
        registerAcademic.addActionListener(this); 
        academicCourse.add(registerAcademic);
        //----------End Register-------------------------------------------------------------------------------------

        //JButton Display
        acDisplay = new JButton("Display");
        acDisplay.setFont(subtitle);
        acDisplay.setBounds(500,440,120,40);
        acDisplay.addActionListener(this); 
        academicCourse.add(acDisplay);

        //JButton Clear
        acClear = new JButton("Clear");
        acClear.setFont(subtitle);
        acClear.setBounds(500,500,120,40);
        acClear.addActionListener(this); 
        academicCourse.add(acClear);
        //--------- End - Academic-----------------------------------------------------------------------------------

        //--------- Non-Academic-------------------------------------------------------------------------------------
        //JLabel <-- Title -- Non-Academic
        labelTitleTwo = new JLabel("Non-Academic Course!");
        labelTitleTwo.setBounds(150,60,350,60);
        labelTitleTwo.setFont(title);
        nonAcademicCourse.add(labelTitleTwo);

        //JLabel <-- nacTitleAdd
        nacTitleAdd = new JLabel("Add Course: ");
        nacTitleAdd.setBounds(20,120,150,30);
        nacTitleAdd.setFont(subtitle);
        nonAcademicCourse.add(nacTitleAdd);

        //JLabel <-- CourseID -- Non-Academic
        nacCourseID = new JLabel("Course ID: ");
        nacCourseID.setBounds(25, 160, 95, 25 );
        nonAcademicCourse.add(nacCourseID);

        //JTextField <-- CourseID -- Non-Academic
        nacFieldCourseID = new JTextField();
        nacFieldCourseID.setBounds(150,155,150,30);
        nonAcademicCourse.add(nacFieldCourseID);

        //JLabel <-- CourseName -- NonAcademic
        nacCourseName = new JLabel("Course Name: ");
        nacCourseName.setBounds(25,220, 95, 25);
        nonAcademicCourse.add(nacCourseName);

        //JLabel <-- CourseNameField -- Non-Academic
        nacFieldCourseName = new JTextField();
        nacFieldCourseName.setBounds(150, 215, 150,30);
        nonAcademicCourse.add(nacFieldCourseName);

        //JLabel <-- Duration -- Non-Academic
        nacDuration = new JLabel("Duration: ");
        nacDuration.setBounds(320, 220,95,25);
        nonAcademicCourse.add(nacDuration);

        //JTextField <-- Duration -- Non-Academic
        nacFieldDuration = new JTextField();
        nacFieldDuration.setBounds(420,215,150,30);
        nonAcademicCourse.add(nacFieldDuration);

        //JLabel <-- Prerequisite -- Non-Academic
        nacPrerequisite = new JLabel("Prerequisite: ");
        nacPrerequisite.setBounds(320,160, 95,25);
        nonAcademicCourse.add(nacPrerequisite);

        //JTextField <-- Prerequisite -- Non-Academic
        nacFieldPrerequisite = new JTextField();
        nacFieldPrerequisite.setBounds(420,155, 150,30);
        nonAcademicCourse.add(nacFieldPrerequisite);

        //JButton <-- Add--Academic
        nacButtonAdd = new JButton("Add");
        nacButtonAdd.setFont(subtitle);
        nacButtonAdd.setBounds(25, 300, 90,40);
        nacButtonAdd.addActionListener(this); 
        nonAcademicCourse.add(nacButtonAdd);
        //----------------ADD----------------

        //----------------Register-----------
        //JLabel <-- RegisterTitle
        nactitleRegister = new JLabel("Register Course: ");
        nactitleRegister.setBounds(25,400,200,30);
        nactitleRegister.setFont(subtitle);
        nonAcademicCourse.add(nactitleRegister);    

        //JLabel <-- CourseID
        rnacCourseID = new JLabel("Course ID: ");
        rnacCourseID.setBounds(25, 440, 95, 25 );
        nonAcademicCourse.add(rnacCourseID);

        //JTextField <- CourseID
        rnacFieldCourseID = new JTextField();
        rnacFieldCourseID.setBounds(150,435,150,30);
        nonAcademicCourse.add(rnacFieldCourseID);

        //JLabel <-- Instructor Name
        rnacCourseLeader = new JLabel("Course Leader: ");
        rnacCourseLeader.setBounds(25, 500, 95, 25 );
        nonAcademicCourse.add(rnacCourseLeader);

        //JTextField <-- CourseLeader
        rnacFieldCourseLeader = new JTextField();
        rnacFieldCourseLeader.setBounds(150, 495, 150,30 );
        nonAcademicCourse.add(rnacFieldCourseLeader);

        //JLabel <-- InstructorName
        rnacInstructorName = new JLabel("Instructor Name: ");
        rnacInstructorName.setBounds(25, 560, 100, 25 );
        nonAcademicCourse.add(rnacInstructorName);

        //JTextField <-- InstructorName
        rnacFieldInstructorName = new JTextField();
        rnacFieldInstructorName.setBounds(150, 555, 150,30 );
        nonAcademicCourse.add(rnacFieldInstructorName);

        //JLabel StartingDate 
        rnacStartingDate = new JLabel("Starting Date: ");
        rnacStartingDate.setBounds(320,440,95,25);
        nonAcademicCourse.add(rnacStartingDate);

        //Dates
        rnacAllStartingDate = new JComboBox(dates);
        rnacAllStartingDate.setBounds(460,435,80,30);
        nonAcademicCourse.add(rnacAllStartingDate);
        //Months
        rnacAllStartingMonths = new JComboBox(months);
        rnacAllStartingMonths.setBounds(560,435,80,30);
        nonAcademicCourse.add(rnacAllStartingMonths);
        //Years
        rnacAllStartingYear = new JComboBox(years);
        rnacAllStartingYear.setBounds(660,435,80,30);
        nonAcademicCourse.add(rnacAllStartingYear);

        //JLabel <--CompletionDate 
        rnacCompletionDate = new JLabel("Completion Date: ");
        rnacCompletionDate.setBounds(320,500,150,25);
        nonAcademicCourse.add(rnacCompletionDate);

        //Dates
        rnacAllCompletionDate = new JComboBox(dates);
        rnacAllCompletionDate.setBounds(460,495,80,30);
        nonAcademicCourse.add(rnacAllCompletionDate);
        //Months
        rnacAllCompletionMonths = new JComboBox(months);
        rnacAllCompletionMonths.setBounds(560,495,80,30);
        nonAcademicCourse.add(rnacAllCompletionMonths);
        //Years
        rnacAllCompletionYear = new JComboBox(years);
        rnacAllCompletionYear.setBounds(660,495,80,30);
        nonAcademicCourse.add(rnacAllCompletionYear);

        //JLabel ExamDate
        rnacExamDate = new JLabel("Exam Date: ");
        rnacExamDate.setBounds(320,560,95,25);
        nonAcademicCourse.add(rnacExamDate);

        //Dates
        rnacAllExamDate = new JComboBox(dates);
        rnacAllExamDate.setBounds(460,555,80,30);
        nonAcademicCourse.add(rnacAllExamDate);
        //Months
        rnacAllExamMonths = new JComboBox(months);
        rnacAllExamMonths.setBounds(560,555,80,30);
        nonAcademicCourse.add(rnacAllExamMonths);
        //Years
        rnacAllExamYear = new JComboBox(years);
        rnacAllExamYear.setBounds(660,555,80,30);
        nonAcademicCourse.add(rnacAllExamYear);

        //Buttons
        //Register Button:
        registerNonAcademic = new JButton("Register");
        registerNonAcademic.setBounds(25,720,90,40);
        registerNonAcademic.addActionListener(this);
        nonAcademicCourse.add(registerNonAcademic);

        //JButton Display
        nacDisplay = new JButton("Display");
        nacDisplay.setFont(subtitle);
        nacDisplay.setBounds(300,720,150,40);
        nacDisplay.addActionListener(this);
        nonAcademicCourse.add(nacDisplay);

        //JButton Remove
        nacRemove = new JButton("Remove");
        nacRemove.setFont(subtitle);
        nacRemove.setBounds(500,720,150,40);
        nacRemove.addActionListener(this);
        nonAcademicCourse.add(nacRemove);

        //JButton Clear
        nacClear = new JButton("Clear");
        nacClear.setBounds(120,720,90,40);
        nacClear.addActionListener(this); 
        nonAcademicCourse.add(nacClear);
        //----------End Register-------------------------------------------------------------------------------------

        //--------- Non-Academic-----------------
        //JButton
        mainFrame.add(nacButton);
        mainFrame.add(acButton);
        mainFrame.add(academicCourse);
        mainFrame.add(nonAcademicCourse);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setBounds(0,0,800,900);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE); //Created objected is dumped when program is terminated
    }

    
    //Accessor Methods For Academic Course
    public String getaddAcademicCourseID(){
        return this.acFieldCourseID.getText();
    }

    public String getaddAcademicCourseName(){
        return this.acFieldCourseName.getText();
    }

    public int getaddAcademicCourseDuration(){
        return Integer.parseInt(this.acFieldDuration.getText()); //Converts string to int 
    }

    public String getaddAcademicCourseLevel(){
        return this.acFieldLevel.getText(); 
    }

    public String getaddFieldCredit(){
        return this.acFieldCredit.getText();
    }

    public int getaddAcademicCourseNoAssessments(){
        return Integer.parseInt(this.acFieldNoAssessments.getText()); //Converts string to int 
    }

    //Accessor Methods for Academic Register:

    public String getRegisterAcademicCourseLeader()
    {
        return this.racFieldCourseLeader.getText();
    }

    public String getRegisterAcademicCourseID()
    {
        return this.racFieldCourseID.getText();
    }

    public String getRegisterAcademicLecturerName()
    {
        return this.racFieldLecturerName.getText();
    }

    public String getRegisterAcademicStartingDate()
    {
         /**
         * There are multiple combo box, to attain a single date first the values obtained from combobox is concatenated and passed to
         * a variable to attain a single date.
           */
        String academicStartingDate = startingDate.getSelectedItem().toString() +"/" +startingMonths.getSelectedItem().toString()+"/" + startingYear.getSelectedItem().toString();
        return academicStartingDate;
    }

    public String getRegisterAcademicCompletionDate()
    {
       
        String academicComepltionDate = completionDate.getSelectedItem().toString() +"/"+ completionMonths.getSelectedItem().toString()+"/" + completionYear.getSelectedItem().toString();
        return academicComepltionDate;
    }

    //Accessor Methods For Non-Academic Course
    public String getaddNonAcademicCourseID(){
        return this.nacFieldCourseID.getText();
    }

    public String getaddNonAcademicCourseName(){
        return this.nacFieldCourseName.getText();
    }

    public int getaddNonAcademicDuration(){
        return Integer.parseInt(this.nacFieldDuration.getText()); //Converts string to int 
    }

    public String getaddNonAcademicPrerequsite(){
        return this.nacFieldPrerequisite.getText();
    }

    //Acessor Methods for Non-Academic Course Register
    public String getRegisterNonAcademicCourseLeader()
    {
        return this.rnacFieldCourseLeader.getText();
    }

    public String getRegisterNonAcademicCourseID()
    {
        return this.rnacFieldCourseID.getText();
    }

    public String getRegisterNonAcademicLecturerName()
    {
        return this.rnacFieldInstructorName.getText();
    }

    public String getRegisterNonAcademicStartingDate()
    {
        String nonAcademicStartingDate = rnacAllStartingDate.getSelectedItem().toString() +"/" +rnacAllStartingMonths.getSelectedItem().toString()+"/" 
            + rnacAllStartingYear.getSelectedItem().toString();
        return nonAcademicStartingDate;
    }

    public String getRegisterNonAcademicCompletionDate()
    {
        String nonAcademicCompletionDate = rnacAllCompletionDate.getSelectedItem().toString() +"/"+ rnacAllCompletionMonths.getSelectedItem().toString()+"/" 
            + rnacAllCompletionYear.getSelectedItem().toString();
        return nonAcademicCompletionDate;
    }

    public String getRegisterNonAcademicExamDate()
    {
        String nonAcademicExamDate = rnacAllExamDate.getSelectedItem().toString() +"/"+ rnacAllExamMonths.getSelectedItem().toString()+"/" 
            + rnacAllExamYear.getSelectedItem().toString();
        return nonAcademicExamDate;
    }

    //ActionListener -- JButton(academic and nonAcademic) 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==nacButton){ 
            // Helps user to switch between two panels.
            nonAcademicCourse.setVisible(true);
            academicCourse.setVisible(false);
        }
        else if(e.getSource()==acButton){
            // Helps user to switch between two panels.
            academicCourse.setVisible(true);
            nonAcademicCourse.setVisible(false);
        } 

        //Button --------- ADD
        else if(e.getSource()== acButtonAdd)
        {
            int a = 0;
            if(a==0)
            {
                if(getaddAcademicCourseID().equals("") || getaddAcademicCourseLevel().equals("") || getaddAcademicCourseName().equals("") 
                || getaddFieldCredit().equals("") )  
                {
                    JOptionPane.showMessageDialog(mainFrame, "Please input values in the fields.", "Alert!!!",JOptionPane.WARNING_MESSAGE);
                    a = 1;
                }
                if(a ==0) {
                    /**
                       If single try catch is used, it displays 2 dialog box.
                       Thus to avoid this nested try catch is used.*/
                    try{
                        getaddAcademicCourseNoAssessments();
                        try{
                            getaddAcademicCourseDuration();
                        }
                        catch(NumberFormatException f)
                        {
                            JOptionPane.showMessageDialog(mainFrame,"Please enter valid number in duration!!", "Alert!!!", JOptionPane.WARNING_MESSAGE);
                            a=1;
                        }
                    }
                    catch(NumberFormatException f){
                        JOptionPane.showMessageDialog(mainFrame,"Please enter valid number in No of assessments!!", "Alert!!!", JOptionPane.WARNING_MESSAGE);
                        a=1;
                    }

                }

            }
            if(a == 0)
            {

                validation = false;
                for(Course array :arrayList)
                {

                    if(array.getCourseID().equals(getaddAcademicCourseID())){
                        validation = true;
                        break;
                    }

                } 
                if(validation == false)
                {
                    academicObject = new Academic(getaddAcademicCourseID(),getaddAcademicCourseName(),
                        getaddAcademicCourseDuration(),getaddAcademicCourseLevel(),getaddFieldCredit(), getaddAcademicCourseNoAssessments());
                    arrayList.add(academicObject);
                    addAcademicCourse = new JOptionPane();
                    String academicMsgCourseAdded = "Congratulations!!! \n The academic course is sucessfully added.\n " + "CourseID is: " + getaddAcademicCourseID() + 
                        "\n CourseName is: " + getaddAcademicCourseName() + "\n Level is: " + getaddAcademicCourseLevel() +
                        "\n Duration is: " +getaddAcademicCourseDuration() + "\n Credit is: " + getaddFieldCredit() + "\n No of Assesments is: " 
                        +getaddAcademicCourseNoAssessments();
                    addAcademicCourse.showMessageDialog(mainFrame,academicMsgCourseAdded);
                } 

                else if(validation == true){
                    addAcademicCourseAdded = new JOptionPane();
                    addAcademicCourseAdded.showMessageDialog(mainFrame,"This course is already added!!!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        else if (e.getSource() == nacButtonAdd){
            int a= 0;
            if(a==0)
            {
                if(getaddNonAcademicCourseID().equals("") || getaddNonAcademicCourseName().equals("") || getaddNonAcademicPrerequsite().equals("") )  
                {
                    JOptionPane.showMessageDialog(mainFrame, "Please input values in the fields.", "Alert!!!",JOptionPane.WARNING_MESSAGE);
                    a = 1;
                }
                if(a ==0) {
                    try{
                        getaddNonAcademicDuration();
                    }
                    catch(NumberFormatException f){
                        JOptionPane.showMessageDialog(mainFrame,"Please enter valid number in Duration!!", "Alert!!!", JOptionPane.WARNING_MESSAGE);
                        a=1;
                    }

                }

            }

            if(a==0)
            {
                validation = false;
                for(Course array :arrayList)
                {

                    if(array.getCourseID().equals(getaddNonAcademicCourseID())){
                        validation = true;
                        break;
                    }

                }

                if(validation == false)
                {
                    nonAcademicObject = new NonAcademic(getaddNonAcademicCourseID(),getaddNonAcademicCourseName(),
                        getaddNonAcademicDuration(),getaddNonAcademicPrerequsite());
                    arrayList.add(nonAcademicObject);
                    addNonAcademicCourse = new JOptionPane();
                    String nonAcademicMsgCourseAdded = "Congratulations. \n The non-academic course is sucessfully added.\n " + "CourseID is: " +
                        getaddNonAcademicCourseID() + "\n CourseName is: " + getaddNonAcademicCourseName() + "\n Duration is: " + getaddNonAcademicDuration() +
                        "\n Prerequsite is: " + getaddNonAcademicPrerequsite(); 
                    addNonAcademicCourse.showMessageDialog(mainFrame,nonAcademicMsgCourseAdded);
                } 
                else if(validation == true){
                    addNonAcademicCourseAdded = new JOptionPane();
                    addNonAcademicCourseAdded.showMessageDialog(mainFrame,"This course is already added!!!", "Alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

        //Button ----------- Register
        else if (e.getSource() == registerAcademic)
        {
            int a= 0;
            if(a==0)
            {
                if(getRegisterAcademicCourseID().equals("") || getRegisterAcademicCourseLeader().equals("") || getRegisterAcademicLecturerName().equals("") )  
                {
                    JOptionPane.showMessageDialog(mainFrame, "Please input values in the fields.", "Alert!!!",JOptionPane.WARNING_MESSAGE);
                    a = 1;
                }

            }
            {
                validation = false;
                for(Course array :arrayList)
                {
                    if(array.getCourseID().equals(getRegisterAcademicCourseID()))
                    {
                        validation = true;
                        if(validation = true)
                        {
                            if(array instanceof Academic)
                            {

                                academicObject = (Academic) array; //downcasting
                                if(academicObject.getisRegistered() == true)
                                {
                                    //Message dialog box
                                    registerAcademicCourseAdded = new JOptionPane();
                                    registerAcademicCourseAdded.showMessageDialog(mainFrame, "This course has already registered! \n"
                                        + "Your LecturerName is: " + academicObject.getLecturerName() + "\nCourse starting date is: " 
                                        + academicObject.getStartingDate() + "Course completion date is: " + academicObject.getCompletionDate());
                                }
                                else if(academicObject.getisRegistered() == false)
                                {
                                    academicObject.register(getRegisterAcademicCourseID(), getRegisterAcademicCourseLeader(), getRegisterAcademicLecturerName(),
                                        getRegisterAcademicStartingDate(),getRegisterAcademicCompletionDate());
                                    //New course registered dialogbox
                                    registerAcademicCourse = new JOptionPane();
                                    registerAcademicCourse.showMessageDialog(mainFrame,"The academic course is registered sucessfully. \n"+ "CourseID is: " 
                                        + getRegisterAcademicCourseID() + "\nCourse Leader is: " + getRegisterAcademicCourseLeader()
                                        + "\nLecturer Name is: " + getRegisterAcademicLecturerName() + "\nStarting date is: "+  getRegisterAcademicStartingDate() + 
                                        "\nCompletion Date is: "  + getRegisterAcademicCompletionDate());
                                }
                            }
                        }
                    }
                }
                if(validation == false)
                {
                    JOptionPane messageInvalid = new JOptionPane();
                    messageInvalid.showMessageDialog(mainFrame,"Please enter a valid courseID");
                }
            }
        }

        //Register ----------------- NonAcademic
        else if (e.getSource() == registerNonAcademic)
        {
            int a= 0;
            if(a==0)
            {
                if(getRegisterNonAcademicCourseID().equals("") || getRegisterNonAcademicCourseLeader().equals("") || getRegisterNonAcademicLecturerName().equals("") )  
                {
                    JOptionPane.showMessageDialog(mainFrame, "Please input values in the fields.", "Alert!!!",JOptionPane.WARNING_MESSAGE);
                    a = 1;
                }

            }
            validation = false;
            for(Course array :arrayList)
            {
                if(array.getCourseID().equals(getRegisterNonAcademicCourseID()))
                {
                    validation = true;
                    if(validation = true)
                    {
                        if(array instanceof NonAcademic)
                        {
                            nonAcademicObject = (NonAcademic) array; //downcasting
                            if(nonAcademicObject.getisRegistered() == true)
                            {
                                //Message dialog box
                                registerNonAcademicCourse = new JOptionPane();
                                registerNonAcademicCourse.showMessageDialog(mainFrame, "This course has already registered!");
                            }

                            else if(nonAcademicObject.getisRegistered() == false)
                            {
                                nonAcademicObject.register(getRegisterNonAcademicCourseLeader(), getRegisterAcademicLecturerName(),
                                    getRegisterNonAcademicStartingDate(), getRegisterNonAcademicCompletionDate(), getRegisterNonAcademicExamDate());
                                //New course registered dialogbox
                                registerAcademicCourse = new JOptionPane();
                                registerAcademicCourse.showMessageDialog(mainFrame,"The academic course is registered sucessfully. \n"+ "CourseID is: " 
                                    + getRegisterNonAcademicCourseID() + "\nCourse Leader is: " + getRegisterNonAcademicCourseLeader()
                                    + "\nLecturer Name is: " + getRegisterAcademicLecturerName() + "\nStarting date is: "+  getRegisterNonAcademicStartingDate() + 
                                    "\nCompletion Date is: "  + getRegisterNonAcademicCompletionDate() + "\n Exam Date is: " + getRegisterNonAcademicExamDate());
                            }
                        }
                    }
                }
            }
            if(validation == false)
            {
                messageInvalid = new JOptionPane();
                messageInvalid.showMessageDialog(mainFrame,"Please enter a valid courseID");
            }
        }

        //Clear ------------- Academic
        else if (e.getSource() == acClear)
        {
            /**
             * set text of all text field to empty string.
             * i.e it clears the form
             */
            acFieldCourseID.setText("");
            acFieldCourseName.setText("");
            acFieldCredit.setText("");
            acFieldDuration.setText("");
            acFieldLevel.setText("");
            acFieldNoAssessments.setText("");
            racFieldCourseID.setText("");
            racFieldCourseLeader.setText("");
            racFieldLecturerName.setText("");
            startingDate.setSelectedIndex(0);
            startingMonths.setSelectedIndex(0);
            startingYear.setSelectedIndex(0);
            completionDate.setSelectedIndex(0);
            completionMonths.setSelectedIndex(0);
            completionYear.setSelectedIndex(0);
        }

        else if (e.getSource() == nacClear)
        {
            nacFieldCourseID.setText("");
            nacFieldCourseName.setText("");
            nacFieldDuration.setText("");
            nacFieldPrerequisite.setText("");
            rnacFieldCourseID.setText("");
            rnacFieldCourseLeader.setText("");
            rnacFieldInstructorName.setText("");
            rnacAllCompletionDate.setSelectedIndex(0);
            rnacAllCompletionMonths.setSelectedIndex(0);
            rnacAllCompletionYear.setSelectedIndex(0);
            rnacAllExamDate.setSelectedIndex(0);
            rnacAllExamMonths.setSelectedIndex(0);
            rnacAllExamYear.setSelectedIndex(0);
            rnacAllStartingDate.setSelectedIndex(0);
            rnacAllStartingMonths.setSelectedIndex(0);
            rnacAllStartingYear.setSelectedIndex(0);
        }

        else if (e.getSource() == acDisplay)
        {
            for(Course array: arrayList)
            {
                if(array instanceof Academic)
                {
                    academicObject = (Academic) array;
                    academicObject.display();
                    System.out.println("");
                }
            }
        }
        else if (e.getSource() == nacDisplay)
        {
            for(Course array: arrayList)
            {
                if(array instanceof NonAcademic)
                {
                    nonAcademicObject = (NonAcademic) array;
                    nonAcademicObject.display();
                    System.out.println("");
                }
            }
        }

        else if(e.getSource() == nacRemove)
        {
            validation = false;
            for(Course array : arrayList)
            {

                if(array.getCourseID().equals(getRegisterNonAcademicCourseID()))
                {
                    validation = true;
                    if(validation==true)
                    {
                        if(array instanceof NonAcademic)
                        {
                            nonAcademicObject = (NonAcademic) array;
                            //nonAcademicObject.remove();

                            if(nonAcademicObject.getisRemoved() == true)
                            {
                                messageRemoved = new JOptionPane();
                                messageRemoved.showMessageDialog(mainFrame,"This course has been already removed!!!");
                            }
                            else if(nonAcademicObject.getisRemoved() == false){
                                nonAcademicObject.remove();
                                messageRemoved = new JOptionPane();
                                messageRemoved.showMessageDialog(mainFrame,"This Course has been removed sucessfully!!!");
                            }
                        }
                    }

                }

            }

            if(validation == false)
            {
                messageInvalid = new JOptionPane();
                messageInvalid.showMessageDialog(mainFrame,"Please enter a valid courseID");
            }
        }
    }
    
    //Main method
     public static void main(String args[])
    {
        //calls gui method using object of INGCollege class
        INGCollege register = new INGCollege();
        register.GUI();
    }
}

