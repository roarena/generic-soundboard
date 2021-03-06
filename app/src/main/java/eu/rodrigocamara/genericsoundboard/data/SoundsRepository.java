package eu.rodrigocamara.genericsoundboard.data;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.data.local.SoundProfileLocalDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class SoundsRepository implements SoundDataSource {
    private SoundProfileLocalDataSource mLocalDataSource;
    private static SoundsRepository instance;

    private SoundsRepository(SoundProfileLocalDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static SoundsRepository getInstance(SoundProfileLocalDataSource mLocalDataSource) {
        if (instance == null) {
            instance = new SoundsRepository(mLocalDataSource);
        }
        return instance;
    }

    @Override
    public void getProfiles(final int sortType, @NonNull final LoadProfileCallback callback) {
        mLocalDataSource.getProfiles(sortType, new LoadProfileCallback() {

            @Override
            public void onProfilesLoaded(List<Profile> soundProfiles, int sortType) {
                callback.onProfilesLoaded(soundProfiles, sortType);
            }

            @Override
            public void onDataNotAvailable() {
                Log.d(C.LOG_TAG, "No sounds found");
            }
        });
    }

    @Override
    public void getSounds(int sortType, @NonNull final LoadSoundsCallback callback, int position) {
        mLocalDataSource.getSounds(sortType, new LoadSoundsCallback() {
            @Override
            public void onSoundsLoaded(List<Sound> soundList, int sortType) {
                callback.onSoundsLoaded(soundList, sortType);
            }

            @Override
            public void onDataNotAvailable() {

            }
        }, position);
    }
}
