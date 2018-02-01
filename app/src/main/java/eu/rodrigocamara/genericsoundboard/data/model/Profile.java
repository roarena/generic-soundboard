package eu.rodrigocamara.genericsoundboard.data.model;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */
@Parcel
public class Profile {
    int id;
    String name;
    String twitter;
    String fullName;
    String description;
    String imgURL;
    String backdropURL;
    int numberOfSounds;
    List<Sound> soundList;

    public Profile() {

    }

    public Profile(int id, String name, String twitter, String fullName, String description, String imgURL, String backdropURL, int numberOfSounds, List<Sound> soundList) {
        this.id = id;
        this.name = name;
        this.twitter = twitter;
        this.fullName = fullName;
        this.description = description;
        this.imgURL = imgURL;
        this.backdropURL = backdropURL;
        this.numberOfSounds = numberOfSounds;
        this.soundList = soundList;
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

    public String getBackdropURL() {
        return backdropURL;
    }

    public void setBackdropURL(String backdropURL) {
        this.backdropURL = backdropURL;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sound> getSoundList() {
        return soundList;
    }

    public void setSoundList(List<Sound> soundList) {
        this.soundList = soundList;
    }
}
