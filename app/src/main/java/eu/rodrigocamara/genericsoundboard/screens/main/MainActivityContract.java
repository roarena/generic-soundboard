package eu.rodrigocamara.genericsoundboard.screens.main;

import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

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

        void setLoadingIndicator(int status);

        void changeViewStyle(RecyclerView.LayoutManager layoutManager);
    }

    interface Presenter {
        void loadProfiles(boolean shouldUpdate, int filter);

        void onProfileClicked(int profileId);

        void onMenuClicked(MenuItem menuItem);

        void start();
    }
}
