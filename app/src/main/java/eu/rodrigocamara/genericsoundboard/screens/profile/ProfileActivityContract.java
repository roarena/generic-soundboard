package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.BaseView;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface ProfileActivityContract {
    interface View extends BaseView<Presenter> {
        void showSounds(List<Sound> profileList);

        void setLoadingIndicator(int status);
    }

    interface Presenter {
        void loadSounds(boolean shouldUpdate, int filter, int position);

        void onSoundClicked(Sound sound);

        void onSoundLongClicked(Sound sound);

        void onSocialClicked(int socialButton, String socialUrl, Context context);

        void start(int position);
    }
}
