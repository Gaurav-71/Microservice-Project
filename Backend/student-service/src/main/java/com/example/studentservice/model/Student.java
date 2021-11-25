package com.example.studentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class Student {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String department;
	public Student()
	{
		
	}
    public Student(String string, String string2, String string3) {
        id=string;
		name=string2;
		department=string3;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

