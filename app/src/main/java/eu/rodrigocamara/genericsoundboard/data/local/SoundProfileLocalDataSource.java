package eu.rodrigocamara.genericsoundboard.data.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class SoundProfileLocalDataSource implements SoundDataSource {
    private static SoundProfileLocalDataSource instance;

    private SoundProfileLocalDataSource() {

    }

    public static SoundProfileLocalDataSource getInstance() {
        if (instance == null) {
            return new SoundProfileLocalDataSource();
        }
        return instance;
    }

    @Override
    public void getProfiles(int sortType, @NonNull LoadProfileCallback callback) {
        //MOCK LOCAL STUFF
        final List<Profile> soundProfileList = new ArrayList<>();
        Profile soundProfile = new Profile(0, "Rogerinho", "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg", 5,"http://localizei.blob.core.windows.net/anuncio/237817_FSR-4747_01.jpg");
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(1, "Renan", "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg", 78,"https://cdn.salaodocarro.com.br/_upload/carros/2016/06/21/asia-towner-1997-azul-5769988ca6607.jpg");
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(2, "Julinho", "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg", 9,"https://http2.mlstatic.com/sprinter-313-cdi-van-executiva-16-lugares-2005-05-branca--D_NQ_NP_19850-MLB20178994616_102014-F.jpg");
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(3, "Maurílio", "https://media.tenor.com/images/78f66e06e01627aa1720e24e2b52f16c/tenor.png", 13,"http://2.bp.blogspot.com/-m-HrWdcBgRg/VqGnYjI1HcI/AAAAAAAAFYI/5A2WuIpNPfI/s1600/Kombi%2BStandard.jpg");
        soundProfileList.add(soundProfile);

        if (soundProfileList.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onProfilesLoaded(soundProfileList, sortType);
        }
    }

    @Override
    public void getSounds(int sortType, @NonNull LoadSoundsCallback callback) {

    }
}
