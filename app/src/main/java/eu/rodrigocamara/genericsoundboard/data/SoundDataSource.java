package eu.rodrigocamara.genericsoundboard.data;

import android.support.annotation.NonNull;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface SoundDataSource {
    interface LoadProfileCallback {
        void onProfilesLoaded(List<SoundProfile> soundProfileList, int sortType);

        void onDataNotAvailable();
    }

    void getProfiles(int sortType, @NonNull LoadProfileCallback callback);
}
