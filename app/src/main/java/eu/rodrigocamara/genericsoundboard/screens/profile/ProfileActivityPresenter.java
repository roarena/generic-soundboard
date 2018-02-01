package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.SoundsRepository;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by rodri on 30/01/2018.
 */

public class ProfileActivityPresenter implements ProfileActivityContract.Presenter {
    private ProfileActivityContract.View mProfileActivityView;
    private SoundsRepository mSoundsRepository;
    private Context mContext;

    public ProfileActivityPresenter(Context context, @NonNull SoundsRepository soundsRepository, @NonNull ProfileActivityContract.View profileView) {

        if (profileView != null) {
            mProfileActivityView = profileView;
        }
        if (soundsRepository != null) {
            mSoundsRepository = soundsRepository;
        }
        this.mContext = context;
        mProfileActivityView.setPresenter(this);
    }

    @Override
    public void loadSounds(boolean shouldUpdate, int filter, int position) {
        mSoundsRepository.getSounds(0, loadSoundsCallback, position);
    }

    private SoundDataSource.LoadSoundsCallback loadSoundsCallback = new SoundDataSource.LoadSoundsCallback() {
        @Override
        public void onSoundsLoaded(List<Sound> soundList, int sortType) {
            mProfileActivityView.showSounds(soundList);
            mProfileActivityView.setLoadingIndicator(View.GONE);
        }

        @Override
        public void onDataNotAvailable() {
            mProfileActivityView.setLoadingIndicator(View.GONE);
            Log.d(C.LOG_TAG, "No Profile Found");
        }
    };

    @Override
    public void onSoundClicked(Sound sound) {
        Log.i(C.LOG_TAG, sound.getName());
    }

    @Override
    public void onSocialClicked(int socialButton, String socialUrl, Context context) {
        switch (socialButton) {
            case R.id.iv_profile_social_twitter:
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(socialUrl)));
                break;
        }
    }

    @Override
    public void start(int position) {
        loadSounds(false, 0, position);
    }
}
