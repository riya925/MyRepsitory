package com.example.project.ui.home;

public class PartiesBeanClass
{
    String company_name;
    String company_ceo;


    PartiesBeanClass()
    {}

    public PartiesBeanClass(String company_name, String company_ceo) {
        this.company_name = company_name;
        this.company_ceo = company_ceo;

    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_ceo() {
        return company_ceo;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setCompany_ceo(String company_ceo) {
        this.company_ceo = company_ceo;
    }
}
