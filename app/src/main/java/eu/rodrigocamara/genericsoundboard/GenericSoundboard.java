package eu.rodrigocamara.genericsoundboard;

import android.app.Application;

import com.squareup.picasso.Picasso;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class GenericSoundboard extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Picasso.with(getApplicationContext()).setIndicatorsEnabled(BuildConfig.DEBUG);
        Picasso.with(getApplicationContext()).setLoggingEnabled(BuildConfig.DEBUG);
    }
}
