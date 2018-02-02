package eu.rodrigocamara.genericsoundboard.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by rodri on 01/02/2018.
 */

public class MediaPlayerHelper {
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private Uri mUri;
    private static MediaPlayerHelper instance = null;

    protected MediaPlayerHelper() {
        // Exists only to defeat instantiation.
    }

    public static MediaPlayerHelper getInstance() {
        if (instance == null) {
            instance = new MediaPlayerHelper();
        }
        return instance;
    }

    public void playSound(Context context, int sound) {
        try {
            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
            }

            if (mMediaPlayer.isPlaying()) {
                stopSound();
                mMediaPlayer = new MediaPlayer();
            }

            mUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + sound);
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(context, mUri);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(onPreparedListener());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MediaPlayer.OnPreparedListener onPreparedListener() {
        return new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer.start();
            }
        };
    }

    public void stopSound() {
        mMediaPlayer.stop();
    }

    public void shareAudio(Context context, int sound) {
        String mediaPath = copyResources(context, sound);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("audio/mp3");
        share.putExtra(Intent.EXTRA_STREAM, Uri.parse(mediaPath));
        context.startActivity(Intent.createChooser(share, "Share Sound File"));
    }

    public String copyResources(Context context, int resId) {
        InputStream in = context.getResources().openRawResource(resId);
        String filename = context.getResources().getResourceEntryName(resId) + ".mp3";

        File f = new File(filename);

        if (!f.exists()) {
            try {
                OutputStream out = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName(), filename));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer, 0, buffer.length)) != -1) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                Toast.makeText(context, "Couldn't share", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(context, "Couldn't share", Toast.LENGTH_LONG).show();
            }
        }
        return Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/" + filename;
    }

    public MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }
}
