package com.hyders.annotations.custom;



public class NonAnnotatedManager extends CompanyAnnotatedEmployee {

    private String department;

    public NonAnnotatedManager(String name, String id, String department){
        super.setId(id);
        super.setName(name);
        this.department = department;

    }

}
