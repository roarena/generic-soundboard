package eu.rodrigocamara.genericsoundboard.data.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class SoundProfileLocalDataSource implements SoundDataSource {
    private static SoundProfileLocalDataSource instance;

    private SoundProfileLocalDataSource() {

    }

    public static SoundProfileLocalDataSource getInstance() {
        if (instance == null) {
            return new SoundProfileLocalDataSource();
        }
        return instance;
    }

    @Override
    public void getProfiles(int sortType, @NonNull LoadProfileCallback callback) {
        //MOCK LOCAL STUFF
        final List<SoundProfile> soundProfileList = new ArrayList<>();
        SoundProfile soundProfile = new SoundProfile(0, "Rogerinho", "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg", 5);
        soundProfileList.add(soundProfile);
        soundProfile = new SoundProfile(1, "Renan", "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg", 78);
        soundProfileList.add(soundProfile);
        soundProfile = new SoundProfile(2, "Julinho", "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg", 9);
        soundProfileList.add(soundProfile);
        soundProfile = new SoundProfile(3, "Maurílio", "https://media.tenor.com/images/78f66e06e01627aa1720e24e2b52f16c/tenor.png", 13);
        soundProfileList.add(soundProfile);

        if (soundProfileList.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onProfilesLoaded(soundProfileList, sortType);
        }
    }
}
