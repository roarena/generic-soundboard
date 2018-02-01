package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;

import eu.rodrigocamara.genericsoundboard.R;

/**
 * Created by rodri on 30/01/2018.
 */

public class ProfileActivityPresenter implements ProfileActivityContract.Presenter {
    @Override
    public void loadSounds(boolean shouldUpdate, int filter) {

    }

    @Override
    public void onSoundClicked(int profileId) {

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
    public void onMenuClicked(MenuItem menuItem) {

    }

    @Override
    public void start() {

    }
}
