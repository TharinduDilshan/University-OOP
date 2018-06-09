package com.university;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tharindu on 7/22/2017.
 */

public class Main {

    static final int MAXSTUDENTS  = 10; //maximum number of students to insert
    static final int MAXLECTURERS = 5;  //maximum number of lecturers to insert
    static final int MAXDEGREES   = 10; //maximum number of degrees to insert

    static int lectIndex = 0;   //lecture array index
    static int studIndex = 0;   //student array index
    static int degIndex  = 0;   //degree array index
    static int modIndex=0;      //module array index
    static int markIndex=0;     //marks array index

    static Module modules[] = new Module[10];                   //module array to add modules
    static Student students[]   = new Student[MAXSTUDENTS];   //students array to add students
    static Lecturer lecturers[] = new Lecturer[MAXLECTURERS]; //lecturer array to add lecturers
    static Degree degrees[]     = new Degree[MAXDEGREES];     //degree array to add degrees
    static Mark marks[] = new Mark[10];                        //mark array to add marks

    //declaring variables for Student
    static int studentId;
    static String studentName;
    static String studentAddress;

    //declaring variables for Lecturer
    static String lecturerId;
    static String lecturerName;
    static String lecturerAddress;

    //declaring variables for Degree
    static int degreeId;
    static String degreeName;
    static int maxModules;

    //declaring variables for Module
    static String moduleId;
    static String moduleName;
    static int moduleLeader;

    //declaring variables for Marks
    static double cw;
    static double exam;

    public static void main(String[] args) {

        menu();
    }

    //Main menu- There are 12 options in the Main menu.You can use any of these option.
    static void menu() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("  ");
        System.out.println("\tWELCOME TO UNIVERSITY of WESTMINSTER");
        System.out.println("\t\t\t MENU \n");
        System.out.println("S  - Add a student");
        System.out.println("L  - Add a lecturer");
        System.out.println("D  - Add a degree ");
        System.out.println("M  - Add a module");
        System.out.println("A  - Add marks ");
        System.out.println("CM - Calculate module average");
        System.out.println("SD - Save results");
        System.out.println("VS - View students");
        System.out.println("VL - View lecturers");
        System.out.println("DL - View degrees");
        System.out.println("ML - View modules");
        System.out.println("Q  - Quit");

        input = sc.next();

        switch (input.toUpperCase()) {
            case "S":
               AddStudent();
                break;
            case "L":
                AddLecturer();
                break;
            case "D":
                AddDegree();
                break;
            case "M":
                AddModule();
                break;
            case "A":
                AddMarks();
                break;
            case "CM":
                Calculate();
                break;
            case "SD" :
               Save();
                break;
            case "VS":
                ViewStudents();
                break;
            case "VL":
                ViewLecturers();
                break;
            case "DL":
                ViewDegrees();
                break;
            case "ML":
                ViewModules();
                break;
            case "Q":
                Quit();
                break;
            default:
                System.out.println("invalid input");
                menu();
        }
    }

    //Add Student Method. If you want to add students you have to go to this method.
    static void AddStudent(){
        //Student student;
        try {
            FileWriter fw = new FileWriter("Student.dat",true);
        Scanner sc = new Scanner(System.in);
        System.out.println("  ");
        System.out.println("\t\t    Add Student Details \n");
        System.out.println("Student ID: ");
        studentId = sc.nextInt();

            for (int i=0; i<studIndex; i++) {
            int x= students[i].getStudentId();
                if(x== studentId){
                    System.out.println("Invalid input");
                    System.out.println("You have entered " + studentId);
                    AddStudent();
                }
            }

        System.out.println("Student Name: ");
        studentName = sc.next();
        System.out.println("Student Address: ");
        studentAddress = sc.next();

        Student student = new Student(studentId, studentName, studentAddress);
            students[studIndex] = student;
            studIndex++;

            fw.write(studentId +"\t\t\t"+ studentName +"\t\t\t"+ studentAddress+ "\n");
            fw.close();

        } catch (Exception e) {
            System.out.println("Invalid input try again");
            System.out.println("   ");
            AddStudent();
        }

        menu();
    }

    //Add Lecturer Method- If you want to add lecturers, you have to go to this method.
    static void AddLecturer(){

        try {
            FileWriter fw = new FileWriter("Lecturer.dat",true);
            Scanner sc = new Scanner(System.in);
            System.out.println("  ");
            System.out.println("\t\t    Add Lecturer Details \n");
            System.out.println("Lecturer ID: ");
            lecturerId = sc.next();

            for (int i=0; i<lectIndex; i++) {
                String x= lecturers[i].getLecturerId();
                if(x == lecturerId){
                    System.out.println("Invalid input");
                    System.out.println("You have entered " + lecturerId);
                    AddLecturer();
                }
            }

            System.out.println("Lecturer Name: ");
            lecturerName = sc.next();

            System.out.println("Lecturer Address: ");

            lecturerAddress = sc.next();

            Lecturer lecturer = new Lecturer(lecturerId, lecturerName, lecturerAddress);
            lecturers[lectIndex] = lecturer;
            lectIndex++;

            fw.write(lecturerId +"\t\t\t"+ lecturerName +"\t\t\t"+ lecturerAddress+ "\n");
            fw.close();

        }catch (Exception e) {
                System.out.println("Invalid input try again");
                System.out.println("   ");
                AddLecturer();
            }

        menu();
    }

    //Add Degree Method - If you want to add a degree, you have to go to this method.
    static void AddDegree() {

        try {
            FileWriter fw = new FileWriter("Degree.dat",true);
            Scanner lsc = new Scanner(System.in);
            System.out.println("  ");
            System.out.println("\t\t    Add Degree Details \n");
            System.out.println("Degree Id");
            degreeId = lsc.nextInt();

            for (int i=0; i<degIndex; i++) {
                int x= degrees[i].getDegreeId();
                if(x== degreeId){
                    System.out.println("Invalid input");
                    System.out.println("You have entered" + degreeId);
                    AddDegree();
                }
            }

            System.out.println("Degree Name");
            degreeName = lsc.next();

            System.out.println("Max Modules");
            maxModules = lsc.nextInt();

            Degree deg = new Degree(degreeId, degreeName, maxModules);

            degrees[degIndex] = deg;
            degIndex++;

            fw.write(degreeId +"\t\t\t"+ degreeName +"\t\t\t"+ maxModules+ "\n");
            fw.close();
        }catch (Exception e) {
            System.out.println("Invalid input try again");
            System.out.println("   ");
            AddDegree();
        }

        menu();

    }

    //Add Module Method- If you want to add a module, you have to go to this method.
    static void AddModule() {

        try {
            FileWriter fw = new FileWriter("Module.dat", true);
            System.out.println("\t\t    Add Module Details \n");
            Scanner lsc = new Scanner(System.in);

            for (int i=0; i<degIndex; i++) {
                System.out.println("\t\t Degree No " + (i + 1));
                System.out.println("Degree Id     : " + degrees[i].getDegreeId());
                System.out.println("Degree Name   : " + degrees[i].getDegreeName());
                System.out.println("No.of Modules : " + degrees[i].getMAX_MODULES());
                System.out.println("");
            }
            System.out.println("Degree No");
            degreeId = lsc.nextInt();

           int z = degrees[degreeId-1].getMAX_MODULES();
           for (int i = 0; i < z; i++) {

                System.out.println("Module Id");
                moduleId = lsc.next();

                for (int j = 0; j < modIndex; j++) {
                    String x = modules[j].getModuleId();
                    if (x == moduleId) {
                        System.out.println("Invalid input");
                        System.out.println("You have entered " + degreeId);
                        AddModule();
                    }
                }

                System.out.println("Module Name");
                moduleName = lsc.next();

                for (int k=0; k<lectIndex; k++) {
                    System.out.println("\t\t Lecture No" + (k + 1));
                    System.out.println("LecturerId      : " + lecturers[k].getLecturerId());
                    System.out.println("");
                }

                System.out.println("Select Module Leader No");
                moduleLeader = lsc.nextInt();

                Module mod = new Module(moduleId, moduleName, lecturers[moduleLeader]);
               modules[modIndex] = mod;
               modIndex++;

                fw.write(moduleId + "\t\t\t" + moduleLeader + "\t\t\t" + moduleName + "\n");
            }
            fw.close();

        } catch (Exception e) {
            System.out.println("Invalid input try again");
            System.out.println("   ");
            AddModule();
        }

        menu();
    }

    //Add Marks Method- If you want to add marks for the students, tou have to go to this method.
    static void AddMarks(){

        try {
            System.out.println("\t\t    Add Marks \n");
            Scanner lsc = new Scanner(System.in);

                for (int h = 0; h < modIndex; h++) {
                    System.out.println("\t\t Module No " + (h + 1));
                    System.out.println("Id   : " + modules[h].getModuleId());
                    System.out.println("Name : " + modules[h].getModuleName());
                    System.out.println("");
                }

                System.out.println("Select the Module No");
                int newmoduleId = lsc.nextInt();

                for (int i = 0; i < studIndex; i++) {
                    System.out.println("\t\t Student No " + (i + 1));
                    System.out.println("Id   : " + students[i].getStudentId());
                    System.out.println("Name : " + students[i].getName());
                    System.out.println("");
                }

                System.out.println("Select the student No");
                studentId = lsc.nextInt();
                studentName = students[studentId-1].getName();

                System.out.println("CW mark");
                cw = lsc.nextInt();

                System.out.println("Examination mark");
                exam = lsc.nextInt();

                String a = modules[newmoduleId - 1].getModuleId();
                String b = modules[newmoduleId - 1].getModuleName();

                double avg = (cw + exam) / 2;

                Mark mark = new Mark(a, b, studentName, cw, exam, avg);

                markIndex=studentId-1;
            marks[markIndex]=mark;
                markIndex++;

        } catch (Exception e) {
            System.out.println("Invalid input try again");
            System.out.println("   ");
            AddMarks();
        }

        menu();
    }

    //Calculate Method- If you want to see the marks average of the students, you have to go to this method.
    static void Calculate(){

        System.out.println("\t\t    Students Marks for the Module \n");
        System.out.println("Name\t\t\tCW\t\t\tExamination\t\t\tAverage\n");

        for(int i=0;i<markIndex;i++) {
            String x = marks[i].getStudentName();
            double cw= marks[i].getCw();
            double exam=marks[i].getExam();
            double avg=marks[i].getAverage();
            System.out.println(x+"\t\t\t"+cw+"\t\t\t"+exam+"\t\t\t"+avg);

        }

        menu();
    }

    //Save method- If you want to save the marks of the students, you have to go to this method.
    static void Save() {
        try {
            FileWriter fw = new FileWriter("Marks.dat");

            fw.write("\t\t    Students Marks for the Module \n");
            fw.write(" ");
            fw.write("Name\t\t\tCW\t\t\tExamination\t\t\tAverage\n");
            fw.write("");
            for (int i = 0; i < markIndex; i++) {
                String x = marks[i].getStudentName();
                double cw = marks[i].getCw();
                double exam = marks[i].getExam();
                double avg = marks[i].getAverage();
                fw.write(x + "\t\t\t" + cw + "\t\t\t" + exam + "\t\t\t" + avg+"\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("Invalid input try again");
            System.out.println("   ");
            menu();
        }
        System.out.println("\t\t    The marks of students have been successfully saved to Mark.dat file  \n");
        menu();
    }

    //View Studets Method- If you want to view Students, you have to go to this method.
    static void ViewStudents() {

        System.out.println("\t\t\tSTUDENT DETAILS\n");
        System.out.println("ID\t\t\tName\t\t\tADDRESS\n");
        System.out.println("");
        for (int i = 0; i < studIndex; i++){
            System.out.println(students[i].getStudentId() +"\t\t\t"+ students[i].getName()+"\t\t\t" + students[i].getAddress()+"\n");
    }

    menu();;

        /*
        try {
            //Read all the lines at once
            List<String> list = Files.readAllLines(Paths.get("Student.dat"), StandardCharsets.US_ASCII);
            for(String l:list)
                System.out.println(l);
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
        }
        menu();*/
    }

    //View Lectures Method- If you want to view Lecturers, you have to go to this method.
    static void ViewLecturers() {

        System.out.println("\t\t\tSTUDENT DETAILS\n");
        System.out.println("ID\t\t\tName\t\t\tADDRESS\n");
        System.out.println("");
        for (int i = 0; i < lectIndex; i++) {
            System.out.println(lecturers[i].getLecturerId() + "\t\t\t" + lecturers[i].getName() + "\t\t\t" + lecturers[i].getAddress()+"\n");
        }
        menu();
    }

    //View Degree Method- If you want to view Degrees, you have to go to this method.
    static void ViewDegrees() {

        System.out.println("\t\t\tDEGREE DETAILS\n");
        System.out.println("ID\t\t\tNAME\t\t\tNO of MODULES\n");
        System.out.println("");
        for (int i = 0; i < degIndex; i++) {
            System.out.println(degrees[i].getDegreeId() + "\t\t\t" + degrees[i].getDegreeName() + "\t\t\t" + degrees[i].getMAX_MODULES()+"\n");
        }
        menu();
    }

    //View Modules Method- If you want to view Modules, you have to go to this method.
    static void ViewModules() {

        System.out.println("\t\t\tMODULE DETAILS\n");
        System.out.println("ID\t\t\tNAME\t\t\tMODULE LEADER\n");
        System.out.println("");
        for (int i = 0; i < modIndex; i++) {
            System.out.println(modules[i].getModuleId() + "\t\t\t" + modules[i].getModuleName() + "\t\t\t" + modules[i].getModuleLeader()+"\n");
        }
        menu();
    }

    //Quit Method - If you want to exit from this program, You have to go to this method.
    static void Quit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t Do you really want to quit game?");
        System.out.println("\t\t Y- Yes OR N-No");
        String inputExit;
        inputExit = sc.next();
        switch (inputExit.toUpperCase()){
            case "Y":
                System.out.println("\t\t   Thank you. Have a nice day!\n");
                break;
            case "N":
                menu();
                break;
            default:
                System.out.println("invalid input");
                System.out.println("  ");
                Quit();
                break;
        }
    }
}




