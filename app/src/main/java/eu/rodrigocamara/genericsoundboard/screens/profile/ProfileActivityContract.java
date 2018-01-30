package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.BaseView;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface ProfileActivityContract {
    interface View extends BaseView<Presenter> {
        void setViewTitle(String title);

        void showSounds(List<Profile> profileList);

        void setLoadingIndicator(int status);

        void changeViewStyle(RecyclerView.LayoutManager layoutManager);
    }

    interface Presenter {
        void loadSounds(boolean shouldUpdate, int filter);

        void onSoundClicked(int profileId);

        void onMenuClicked(MenuItem menuItem);

        void start();
    }
}
