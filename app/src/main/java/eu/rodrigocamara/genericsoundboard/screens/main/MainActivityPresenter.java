package eu.rodrigocamara.genericsoundboard.screens.main;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.SoundsRepository;
import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View mMainActivityView;
    private SoundsRepository mSoundsRepository;

    public MainActivityPresenter(@NonNull SoundsRepository soundsRepository, @NonNull MainActivityContract.View moviesView) {

        if (moviesView != null) {
            mMainActivityView = moviesView;
        }
        if (soundsRepository != null) {
            mSoundsRepository = soundsRepository;
        }
        mMainActivityView.setPresenter(this);
    }

    private SoundDataSource.LoadProfileCallback loadProfileCallback = new SoundDataSource.LoadProfileCallback() {
        @Override
        public void onProfilesLoaded(List<SoundProfile> soundProfileList, int sortType) {
            mMainActivityView.showProfiles(soundProfileList);
            mMainActivityView.setLoadingIndicator(false);
        }

        @Override
        public void onDataNotAvailable() {
            mMainActivityView.setLoadingIndicator(false);
            Log.d(C.LOG_TAG, "No Profile Found");
        }
    };

    @Override
    public void loadSounds(boolean shouldUpdate, int filter) {
        mSoundsRepository.getProfiles(0, loadProfileCallback);
    }

    @Override
    public void setFilter(int filter) {

    }

    @Override
    public int getFilter() {
        return 0;
    }

    @Override
    public void onProfileClicked(int profileId) {

    }

    @Override
    public void start() {
        loadSounds(false, 0);
    }
}
