package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.SoundsRepository;
import eu.rodrigocamara.genericsoundboard.data.local.SoundProfileLocalDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;
import eu.rodrigocamara.genericsoundboard.utils.MediaPlayerHelper;

public class ProfileActivity extends AppCompatActivity implements ProfileActivityContract.View {
    private ProfileActivityContract.Presenter mProfileActivityPresenter;
    private ProfileAdapter mProfileAdapter;

    @BindView(R.id.iv_profile_image)
    ImageView mIvProfilePicture;
    @BindView(R.id.iv_backdrop_image)
    ImageView mIvBackdropImage;
    @BindView(R.id.iv_profile_social_twitter)
    ImageView mIvTwitterSocial;

    @BindView(R.id.tv_profile_name)
    TextView mTvProfileName;
    @BindView(R.id.tv_profile_description)
    TextView mTvProfileDescription;
    @BindView(R.id.tb_profile)
    Toolbar mTbProfile;

    @BindView(R.id.rv_sounds)
    RecyclerView mRvSounds;
    Profile mCurrentProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        mCurrentProfile = Parcels.unwrap(getIntent().getParcelableExtra(C.BUNDLE_PROFILE_TAG));

        Picasso.with(this).load(mCurrentProfile.getImgURL()).into(mIvProfilePicture);
        Picasso.with(this).load(mCurrentProfile.getBackdropURL()).into(mIvBackdropImage);
        mTvProfileName.setText(mCurrentProfile.getFullName());
        mTvProfileDescription.setText(mCurrentProfile.getDescription());
        mTbProfile.setTitle("");
        setSupportActionBar(mTbProfile);

        mIvTwitterSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProfileActivityPresenter.onSocialClicked(R.id.iv_profile_social_twitter,
                        mCurrentProfile.getTwitter(), getApplicationContext());
            }
        });

        ProfileAdapter.ListItemClickListener listItemClickListener = new ProfileAdapter.ListItemClickListener() {
            @Override
            public void onListItemClick(Sound sound) {
                mProfileActivityPresenter.onSoundClicked(sound);
            }
        };

        ProfileAdapter.ListItemLongClickListener listItemLongClickListener = new ProfileAdapter.ListItemLongClickListener() {
            @Override
            public void onLongListItemClick(Sound sound) {
                mProfileActivityPresenter.onSoundLongClicked(sound);
            }
        };

        mProfileActivityPresenter = new ProfileActivityPresenter(this, SoundsRepository.
                getInstance(SoundProfileLocalDataSource.getInstance()), this);

        mProfileAdapter = new ProfileAdapter(this, listItemClickListener, listItemLongClickListener);
        mRvSounds.setLayoutManager(new GridLayoutManager(this, 3));
        mRvSounds.setAdapter(mProfileAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProfileActivityPresenter.start(mCurrentProfile.getId());
    }

    @Override
    public void setPresenter(ProfileActivityContract.Presenter presenter) {
        if (presenter == null) {
            throw new NullPointerException("Presenter is null");
        }
        mProfileActivityPresenter = presenter;
    }


    @Override
    public void showSounds(List<Sound> soundList) {
        mProfileAdapter.replaceData(soundList);
    }

    @Override
    public void setLoadingIndicator(int status) {
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (MediaPlayerHelper.getInstance().getMediaPlayer().isPlaying()) {
            MediaPlayerHelper.getInstance().stopSound();
        }
    }
}
