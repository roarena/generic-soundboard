package eu.rodrigocamara.genericsoundboard.data.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.SoundDataSource;
import eu.rodrigocamara.genericsoundboard.data.model.Profile;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class SoundProfileLocalDataSource implements SoundDataSource {
    private static SoundProfileLocalDataSource instance = null;
    List<Profile> soundProfileList;

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
        soundProfileList = new ArrayList<>();
        Profile soundProfile = new Profile(0,
                "Rogerinho",
                "https://twitter.com/caitomainier",
                "Rogerinho do Ingá",
                "Sprinter Azul/Vermelha",
                "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg",
                "http://localizei.blob.core.windows.net/anuncio/237817_FSR-4747_01.jpg",
                6,
                createRogerinhoList());
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(1,
                "Renan",
                "https://twitter.com/danielsfurlan",
                "Renan", "Towner Azul Bebê",
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg",
                "https://cdn.salaodocarro.com.br/_upload/carros/2016/06/21/asia-towner-1997-azul-5769988ca6607.jpg",
                5,
                createRenanList());
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(2,
                "Julinho",
                "https://twitter.com/ramos_leandro",
                "Julinho da van",
                "Sprinter Branca",
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg",
                "https://http2.mlstatic.com/sprinter-313-cdi-van-executiva-16-lugares-2005-05-branca--D_NQ_NP_19850-MLB20178994616_102014-F.jpg",
                5,
                createJulinhoList());
        soundProfileList.add(soundProfile);
        soundProfile = new Profile(3,
                "Maurílio",
                "https://twitter.com/raulchequer",
                "Maurílio",
                "Kombi Branca 94",
                "https://media.tenor.com/images/78f66e06e01627aa1720e24e2b52f16c/tenor.png",
                "http://2.bp.blogspot.com/-m-HrWdcBgRg/VqGnYjI1HcI/AAAAAAAAFYI/5A2WuIpNPfI/s1600/Kombi%2BStandard.jpg",
                2,
                createMaurilioList());
        soundProfileList.add(soundProfile);

        if (soundProfileList.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onProfilesLoaded(soundProfileList, sortType);
        }
    }

    @Override
    public void getSounds(int sortType, @NonNull LoadSoundsCallback callback, int position) {
        if (soundProfileList.get(position).getSoundList().isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onSoundsLoaded(soundProfileList.get(position).getSoundList(), sortType);
        }
    }

    private List<Sound> createMaurilioList() {
        List<Sound> soundList = new ArrayList<>();
        Sound sound = new Sound(0,
                "Boa noite amantes do cinema...",
                R.raw.maurilio_boa_noite,
                "https://media.tenor.com/images/78f66e06e01627aa1720e24e2b52f16c/tenor.png");
        soundList.add(sound);
        sound = new Sound(1,
                "A justiça é muito injustça",
                R.raw.maurilio_justica,
                "https://media.tenor.com/images/78f66e06e01627aa1720e24e2b52f16c/tenor.png");
        soundList.add(sound);
        return soundList;
    }

    private List<Sound> createJulinhoList() {
        List<Sound> soundList = new ArrayList<>();
        Sound sound = new Sound(0,
                "Boa noite companheiros motoristas...", R.raw.julinho_seriedade,
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg");
        soundList.add(sound);
        sound = new Sound(1,
                "Me da aquela moralzinha?", R.raw.julinho_moralzinha,
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg");
        soundList.add(sound);
        sound = new Sound(2,
                "Vou ser obrigado a concordar com o...", R.raw.julinho_concordar,
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg");
        soundList.add(sound);
        sound = new Sound(3,
                "Todo mundo sabe que cinema é...", R.raw.julinho_explosao,
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg");
        soundList.add(sound);
        sound = new Sound(4,
                "Falo com tranquilidade", R.raw.julinho_tranquilidade,
                "https://pbs.twimg.com/profile_images/800892278470537216/eejoSRRh.jpg");
        soundList.add(sound);
        return soundList;
    }

    private List<Sound> createRogerinhoList() {
        List<Sound> soundList = new ArrayList<>();
        Sound sound = new Sound(0,
                "Achou errado otário",
                R.raw.rogerinho_acho_errado,
                "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        sound = new Sound(1,
                "Encontrou porra!", R.raw.rogerinho_encontrou,
                "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        sound = new Sound(2,
                "Otário!", R.raw.rogerinho_otario,
                "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        sound = new Sound(3,
                "Tem que acabar a justiça!",
                R.raw.rogerinho_acabar_justica, "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        sound = new Sound(4,
                "Você é um guerreiro!",
                R.raw.rogerinho_guerreiro_renan, "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        sound = new Sound(5,
                "Hulk quiser agredir uma idosa...!",
                R.raw.rogerinho_hulk_idosa, "https://pbs.twimg.com/profile_images/800701598582407168/3dKHpeEJ.jpg");
        soundList.add(sound);
        return soundList;
    }

    private List<Sound> createRenanList() {
        List<Sound> soundList = new ArrayList<>();
        Sound sound = new Sound(0,
                "Uma criança linda, agora um adulto esquisito",
                R.raw.renan_adulto_esquisito,
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg");
        soundList.add(sound);
        sound = new Sound(1,
                "Eu vejo o filme pra não ter que ler o livro!",
                R.raw.renan_filme_livro,
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg");
        soundList.add(sound);
        sound = new Sound(2,
                "Ele é meu guerrerinho!",
                R.raw.renan_guerrerinho,
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg");
        soundList.add(sound);
        sound = new Sound(3,
                "Ele tem talento pra isso!",
                R.raw.renan_tem_talento,
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg");
        soundList.add(sound);
        sound = new Sound(4,
                "Sósia nem tão parecido com ele mesmo",
                R.raw.renan_sosia,
                "https://pbs.twimg.com/media/DTQy9Z4XcAA6yO9.jpg");
        soundList.add(sound);
        return soundList;
    }
}
