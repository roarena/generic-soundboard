package eu.rodrigocamara.genericsoundboard.screens.main;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.BaseView;
import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface MainActivityContract {
    interface View extends BaseView<Presenter> {
        void setViewTitle(String title);

        void showProfiles(List<SoundProfile> profileList);

        void setLoadingIndicator(boolean status);
    }

    interface Presenter {
        void loadSounds(boolean shouldUpdate, int filter);

        void setFilter(int filter);

        int getFilter();

        void onProfileClicked(int profileId);

        void start();
    }
}
