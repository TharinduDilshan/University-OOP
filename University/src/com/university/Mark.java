package com.university;

/**
 * Created by Tharindu on 7/22/2017.
 */
public class Mark {

    private String moduleId; // ID for the module
    private String moduleName; // Name for the module
    private String studentId;
    private String studentName; // Name of the student
    private double cw; // cw mark
    private double exam; //exam mark
    private double average;
    private String feedback;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getCw() {
        return cw;
    }

    public void setCw(double cw) {
        this.cw = cw;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Mark(String moduleId, String moduleName,String studentName,double cw,double exam){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.studentName = studentName;
        this.cw = cw;
        this.exam = exam;
    }

    public Mark(String moduleId, String moduleName,String studentName,double cw,double exam,double average){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.studentName = studentName;
        this.cw = cw;
        this.exam = exam;
        this.average = average;
    }
    
}
