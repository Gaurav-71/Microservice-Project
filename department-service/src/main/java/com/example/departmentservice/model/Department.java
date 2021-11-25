package com.example.departmentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class Department {

    @Id
    private String id;
    @Column
    private String name;

	public Department()
	{
		
	}
    public Department(String string, String string2) {
        id=string;
		name=string2;		
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

}

