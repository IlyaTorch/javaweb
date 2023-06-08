package by.epamtc.jwd.db.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private int userId;
    private String email;
    private String firstName;
    private String lastName;
    private float avgMark;
    public UserDTO() {

    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public UserDTO(int userId, String email, String firstName, String lastName, float avgMark) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgMark = avgMark;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avgMark=" + avgMark +
                '}';
    }
}
