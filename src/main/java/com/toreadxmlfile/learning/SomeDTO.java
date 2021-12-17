package com.toreadxmlfile.learning;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="url")

public class SomeDTO {

    private String loc;
    private String priority;


    public SomeDTO() {}

    public String getLoc() {
        return loc;
    }
    public String getPriority() {
        return priority;
    }


    public void setLoc(String loc) {
        this.loc = loc;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }




    @Override
    public String toString() {
        return "SomeDTO{" +
                "priority='" + priority + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

}
