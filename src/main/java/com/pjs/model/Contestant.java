package com.pjs.model;

import com.pjs.enums.Department;

public class Contestant {

    private String id;
    private String name;
    private Department departmentName;

    public Contestant(String id, String name, Department departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Department departmentName) {
        this.departmentName = departmentName;
    }
}
