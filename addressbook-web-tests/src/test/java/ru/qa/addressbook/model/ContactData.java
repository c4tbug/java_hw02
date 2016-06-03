package ru.qa.addressbook.model;

public class  ContactData {

  private  int id = Integer.MAX_VALUE;
  private  String name;
  private  String lastname;
  private  String phone;
  private  String mail;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withMail(String mail) {
    this.mail = mail;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
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

  public String getMail() {
    return mail;
  }

}