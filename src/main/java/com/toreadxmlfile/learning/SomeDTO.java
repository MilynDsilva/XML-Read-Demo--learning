package com.toreadxmlfile.learning;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="url")

public class SomeDTO {

    private String loc;
    private String priority;

    public SomeDTO(String loc, String priority) {
        super();
        this.priority = priority;
        this.loc = loc;
    }
    public SomeDTO() {
        super();
    }

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
