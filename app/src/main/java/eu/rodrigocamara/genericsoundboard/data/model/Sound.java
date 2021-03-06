package eu.rodrigocamara.genericsoundboard.data.model;

import org.parceler.Parcel;

/**
 * Created by rodri on 30/01/2018.
 */
@Parcel
public class Sound {
    private int id;
    private String name;
    private int soundURL;
    private String imgURL;

    public Sound() {

    }

    public Sound(int id, String name, int soundURL, String imgURL) {
        this.id = id;
        this.name = name;
        this.soundURL = soundURL;
        this.imgURL = imgURL;
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

    public int getSoundURL() {
        return soundURL;
    }

    public void setSoundURL(int soundURL) {
        this.soundURL = soundURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
