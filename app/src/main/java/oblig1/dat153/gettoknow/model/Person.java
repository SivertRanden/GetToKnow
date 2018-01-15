package oblig1.dat153.gettoknow.model;

/**
 * Created by siver on 15.01.2018.
 */

public class Person {
    private String firstName;
    private String lastName;
    private String pictureFileName;

    public Person(String firstName, String lastName, String pictureFileName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPictureFileName(pictureFileName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }
}
