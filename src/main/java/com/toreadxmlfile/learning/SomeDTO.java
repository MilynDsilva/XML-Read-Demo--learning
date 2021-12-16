package com.toreadxmlfile.learning;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="urlset")

public class SomeDTO {
    private String priority;
    private String loc;
    //private String purchasedPackage;

    public SomeDTO() {}

    public String getEmailAddress() {
        return priority;
    }

    public String getName() {
        return loc;
    }

//   //public String getPurchasedPackage() {
//        return purchasedPackage;
//    }

    public void setEmailAddress(String priority) {
        this.priority = priority;
    }

    public void setName(String loc) {
        this.loc = loc;
    }

//    public void setPurchasedPackage(String purchasedPackage) {
//        this.purchasedPackage = purchasedPackage;
//    }

    @Override
    public String toString() {
        return "SomeDTO{" +
                "priority='" + priority + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

}
