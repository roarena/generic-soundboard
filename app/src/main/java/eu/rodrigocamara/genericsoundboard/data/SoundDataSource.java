package eu.rodrigocamara.genericsoundboard.data;

import android.support.annotation.NonNull;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.data.model.Profile;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface SoundDataSource {
    interface LoadProfileCallback {
        void onProfilesLoaded(List<Profile> profileList, int sortType);

        void onDataNotAvailable();
    }

    interface LoadSoundsCallback {
        void onSoundsLoaded(List<Sound> soundList, int sortType);

        void onDataNotAvailable();
    }

    void getProfiles(int sortType, @NonNull LoadProfileCallback callback);

    void getSounds(int sortType, @NonNull LoadSoundsCallback callback);
}
