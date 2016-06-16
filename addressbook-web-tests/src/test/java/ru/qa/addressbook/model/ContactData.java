package ru.qa.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column (name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column (name = "firstname")
    private String name;
    @Expose
    @Column (name = "lastname")
    private String lastname;

    @Expose
    @Transient
    private String group;

    @Expose
    @Column (name = "home")
    @Type(type = "text")
    private String phone;
    @Expose
    @Column (name = "email")
    @Type(type = "text")
    private String mail;
    @Expose
    @Column (name = "email2")
    @Type(type = "text")
    private String secondEmail;
    @Expose
    @Column (name = "email3")
    @Type(type = "text")
    private String thirdEmail;
    @Expose
    @Transient
    private String allEmails;
    @Expose
    @Column (name = "mobile")
    @Type(type = "text")
    private String mobilephone;
    @Expose
    @Column (name = "work")
    @Type(type = "text")
    private String workphone;
    @Transient
    private String allPhones;
    @Expose
    @Column (name = "address")
    @Type(type = "text")
    private String address;
    @Transient
    private String data;
    @Transient
    private String photo = "" ;


    public File getPhoto() {
        if (photo == null){
            photo = "";
        }
        return new File (photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (secondEmail != null ? !secondEmail.equals(that.secondEmail) : that.secondEmail != null) return false;
        if (thirdEmail != null ? !thirdEmail.equals(that.thirdEmail) : that.thirdEmail != null) return false;
        if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;
        if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
        if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
        if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return photo != null ? photo.equals(that.photo) : that.photo == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (secondEmail != null ? secondEmail.hashCode() : 0);
        result = 31 * result + (thirdEmail != null ? thirdEmail.hashCode() : 0);
        result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
        result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
        result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
        result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }



    public String getData() {
        return data;
    }

    public ContactData withData(String data) {
        this.data = data;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public ContactData withThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withMobilePhone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getMail() {
        return mail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }


    public String getAddress() {
        return address;
    }
}