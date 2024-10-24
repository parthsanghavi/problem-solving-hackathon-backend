package com.pjs.model.builder;

import com.pjs.enums.Department;
import com.pjs.model.Contestant;
import java.util.UUID;

public class ContestantBuilder {

    private String id;
    private String name;
    private Department departmentName;

    public ContestantBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ContestantBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContestantBuilder setDepartmentName(Department departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public Contestant build() {
        return new Contestant(
              this.id,
              this.name,
              this.departmentName
        );
    }

}
