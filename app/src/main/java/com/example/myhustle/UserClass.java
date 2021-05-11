package com.example.myhustle;

public class UserClass {
    String name,occupation,location,pNumber,password;

    public UserClass() {

    }

    public UserClass(String name, String occupation,String location, String pNumber, String password) {
        this.name = name;
        this.occupation = occupation;
        this.location=location;
        this.pNumber = pNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location= location;
    }



    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
