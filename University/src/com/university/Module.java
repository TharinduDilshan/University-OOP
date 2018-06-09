/**
 * Created by Tharindu on 7/22/2017.
 */

package com.university;

public class Module {

    private String moduleId; // ID for the module
    private String moduleName; // Name of the module
    private Lecturer moduleLeader; // Owner of the module

    public String getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Lecturer getModuleLeader() {
        return moduleLeader;
    }

    public void setModuleLeader(Lecturer moduleLeader) {
        this.moduleLeader = moduleLeader;
    }

    public Module(String moduleId, String moduleName){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    public Module(String moduleId, String moduleName, Lecturer moduleLeader){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleLeader = moduleLeader;
    }

}
