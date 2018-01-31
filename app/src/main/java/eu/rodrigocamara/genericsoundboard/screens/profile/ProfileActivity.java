package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    @BindView(R.id.iv_profile_image)
    ImageView mIvProfilePicture;
    //@BindView(R.id.tv_profile_name)
    //TextView mTvProfileName;

    @BindView(R.id.tb_profile)
    Toolbar mTbProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Profile currentProfile = Parcels.unwrap(getIntent().getParcelableExtra(C.BUNDLE_PROFILE_TAG));

        Picasso.with(this).load(currentProfile.getImgURL()).into(mIvProfilePicture);
       // mTvProfileName.setText();
        mTbProfile.setTitle(currentProfile.getName());
        setSupportActionBar(mTbProfile);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
