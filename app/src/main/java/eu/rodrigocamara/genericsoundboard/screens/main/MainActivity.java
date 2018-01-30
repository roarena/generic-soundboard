package eu.rodrigocamara.genericsoundboard.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.rodrigocamara.genericsoundboard.C;
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

        mMainActivityPresenter = new MainActivityPresenter(SoundsRepository.getInstance(SoundProfileLocalDataSource.getInstance()), this);
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
    public void setLoadingIndicator(boolean status) {
    }
}
