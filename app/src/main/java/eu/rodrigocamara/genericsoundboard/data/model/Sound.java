package eu.rodrigocamara.genericsoundboard.data.model;

import org.parceler.Parcel;

/**
 * Created by rodri on 30/01/2018.
 */
@Parcel
public class Sound {
    private int id;
    private String name;
    private String soundURL;

    public Sound() {

    }

    public Sound(int id, String name, String soundURL) {
        this.id = id;
        this.name = name;
        this.soundURL = soundURL;
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

    public String getSoundURL() {
        return soundURL;
    }

    public void setSoundURL(String soundURL) {
        this.soundURL = soundURL;
    }
}
