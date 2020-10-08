package com.bcb.user.bareillycollegebareilly;

public class Student {

    private String dname;
    private String Image;

    public Student(){

    }

    public Student(String dname, String Image){

        this.dname=dname;
        this.Image=Image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String Dname) {
        dname = Dname;
    }

    public Student(String dname){

        this.dname = dname;
    }



}



