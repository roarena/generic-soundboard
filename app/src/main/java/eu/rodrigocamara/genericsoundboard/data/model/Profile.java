package eu.rodrigocamara.genericsoundboard.data.model;

import org.parceler.Parcel;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */
@Parcel
public class Profile {
    int id;
    String name;
    String imgURL;
    int numberOfSounds;

    public Profile() {

    }

    public Profile(int id, String name, String imgURL, int numberOfSounds) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
        this.numberOfSounds = numberOfSounds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getNumberOfSounds() {
        return numberOfSounds;
    }

    public void setNumberOfSounds(int numberOfSounds) {
        this.numberOfSounds = numberOfSounds;
    }
}
