package eu.rodrigocamara.genericsoundboard.screens.main;

import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.List;

import eu.rodrigocamara.genericsoundboard.BaseView;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface MainActivityContract {
    interface View extends BaseView<Presenter> {
        void setViewTitle(String title);

        void showProfiles(List<Profile> profileList);

        void setLoadingIndicator(int status);

        void changeViewStyle(RecyclerView.LayoutManager layoutManager);

        void startNewActivity(Profile profile);
    }

    interface Presenter {
        void loadProfiles(boolean shouldUpdate, int filter);

        void onProfileClicked(Profile profile);

        void onMenuClicked(MenuItem menuItem);

        void start();
    }
}
