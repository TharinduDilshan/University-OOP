/**
 * Created by Tharindu on 7/22/2017.
 */

package com.university;

public class Degree {

    private int degreeId;
    private String degreeName;
    private Module[] modules;

    private final int MAX_MODULES;
    private static int currentIndex = 0;

    public Degree(int degreeId, String degreeName, int maxModules){
        MAX_MODULES = maxModules;
        this.degreeId = degreeId;
        this.degreeName = degreeName;

        modules = new Module[MAX_MODULES];
    }

    public void AddModules(Module[] modules){
        this.modules = modules;
        this.currentIndex = modules.length;
    }

    public void AddModule(Module module){
        if (currentIndex < MAX_MODULES) {
            modules[currentIndex] = module;
            currentIndex++;
        }
    }

    //region getters and setters

    public int getMAX_MODULES() {
        return MAX_MODULES;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
    //endregion
}


