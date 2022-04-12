package wangyuandong.model;

import java.util.Date;

public class User {
    private String ID;
    private String username;
    private String passwords;
    private String emails;
    private String gender;
    private java.util.Date birthdate;

    public User(){

    }

    public User(String ID, String username, String passwords, String emails, String gender, Date birthdate) {
        this.ID = ID;
        this.username=username;
        this.passwords=passwords;
        this.emails=emails;
        this.gender=gender;
        this.birthdate=birthdate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", passwords='" + passwords + '\'' +
                ", emails='" + emails + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
