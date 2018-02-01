package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;

public class ProfileActivity extends AppCompatActivity {
    private ProfileActivityContract.Presenter mProfileActivityPresenter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        mProfileActivityPresenter = new ProfileActivityPresenter();

        final Profile currentProfile = Parcels.unwrap(getIntent().getParcelableExtra(C.BUNDLE_PROFILE_TAG));

        Picasso.with(this).load(currentProfile.getImgURL()).into(mIvProfilePicture);
        Picasso.with(this).load(currentProfile.getBackdropURL()).into(mIvBackdropImage);

        mIvTwitterSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProfileActivityPresenter.onSocialClicked(R.id.iv_profile_social_twitter, currentProfile.getTwitter(), getApplicationContext());
            }
        });

        mTvProfileName.setText(currentProfile.getFullName());
        mTvProfileDescription.setText(currentProfile.getDescription());
        mTbProfile.setTitle("");
        setSupportActionBar(mTbProfile);
    }
}
