package eu.rodrigocamara.genericsoundboard.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.parceler.Parcels;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.SoundsRepository;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View mMainActivityView;
    private SoundsRepository mSoundsRepository;
    private Context mContext;

    public MainActivityPresenter(Context context, @NonNull SoundsRepository soundsRepository, @NonNull MainActivityContract.View moviesView) {

        if (moviesView != null) {
            mMainActivityView = moviesView;
        }
        if (soundsRepository != null) {
            mSoundsRepository = soundsRepository;
        }
        this.mContext = context;
        mMainActivityView.setPresenter(this);
    }

    private SoundDataSource.LoadProfileCallback loadProfileCallback = new SoundDataSource.LoadProfileCallback() {
        @Override
        public void onProfilesLoaded(List<Profile> soundProfileList, int sortType) {
            mMainActivityView.showProfiles(soundProfileList);
            mMainActivityView.setLoadingIndicator(View.GONE);
        }

        @Override
        public void onDataNotAvailable() {
            mMainActivityView.setLoadingIndicator(View.GONE);
            Log.d(C.LOG_TAG, "No Profile Found");
        }
    };

    @Override
    public void loadProfiles(boolean shouldUpdate, int filter) {
        mSoundsRepository.getProfiles(0, loadProfileCallback);
    }

    @Override
    public void onProfileClicked(Profile profile) {
        mMainActivityView.startNewActivity(profile);
    }

    @Override
    public void onMenuClicked(MenuItem menuItem) {
        if (menuItem.getTitle() == mContext.getResources().getString(R.string.menu_grid)) {
            mMainActivityView.changeViewStyle(new GridLayoutManager(mContext, C.GRID_COLUMNS));
            menuItem.setTitle(R.string.menu_horizontal);
            menuItem.setIcon(R.drawable.view_horizontal);
        } else {
            mMainActivityView.changeViewStyle(new LinearLayoutManager(mContext));
            menuItem.setTitle(R.string.menu_grid);
            menuItem.setIcon(R.drawable.view_grid);
        }
    }

    @Override
    public void start() {
        loadProfiles(false, 0);
    }
}
