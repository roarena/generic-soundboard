package eu.rodrigocamara.genericsoundboard.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.SoundsRepository;
import eu.rodrigocamara.genericsoundboard.data.local.SoundProfileLocalDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityContract.Presenter mMainActivityPresenter;
    private MainActivityAdapter mMainActivityAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.rv_sound_profile)
    RecyclerView mRecyclerView;
    @BindView(R.id.pb_profile_loading)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setViewTitle(getResources().getString(R.string.app_name));

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        MainActivityAdapter.ListItemClickListener listItemClickListener = new MainActivityAdapter.ListItemClickListener() {
            @Override
            public void onListItemClick(int clickedItemIndex) {
                mMainActivityPresenter.onProfileClicked(clickedItemIndex);
            }
        };

        mMainActivityAdapter = new MainActivityAdapter(this, listItemClickListener);
        mRecyclerView.setAdapter(mMainActivityAdapter);

        mMainActivityPresenter = new MainActivityPresenter(this, SoundsRepository.getInstance(SoundProfileLocalDataSource.getInstance()), this);
        runLayoutAnimation(mRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mMainActivityPresenter.onMenuClicked(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainActivityPresenter.start();
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        if (presenter == null) {
            throw new NullPointerException("Presenter is null");
        }
        mMainActivityPresenter = presenter;
    }

    @Override
    public void setViewTitle(String title) {
        setTitle(title);
    }

    @Override
    public void showProfiles(List<SoundProfile> profileList) {
        mMainActivityAdapter.replaceData(profileList);
    }

    @Override
    public void setLoadingIndicator(int status) {
        mProgressBar.setVisibility(status);
    }

    @Override
    public void changeViewStyle(RecyclerView.LayoutManager layoutManager) {
        mRecyclerView.setLayoutManager(layoutManager);
        runLayoutAnimation(mRecyclerView);
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
