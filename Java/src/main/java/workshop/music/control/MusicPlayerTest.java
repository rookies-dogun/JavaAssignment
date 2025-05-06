package workshop.music.control;

import workshop.music.entity.MP3;
import workshop.music.entity.MusicMedia;
import workshop.music.entity.Playable;
import workshop.music.entity.Vinyl;

public class MusicPlayerTest {

    public static void main(String[] args) {
        System.out.println("===== 음악 재생 테스트 ====");

        MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 5, 5);
        System.out.println("--- MP3 테스트 ---");
        mp3.displayInfo();
        mp3.play();
        mp3.stop();

        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        System.out.println("--- Vinyl 테스트 ---");
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        MusicMedia musicMedia = mp3;
        System.out.println("--- 다형성 테스트 ---");
        musicMedia.displayInfo();

        Playable playable = (Playable) mp3;
        System.out.println("--- 캐스팅 설정 ---");
        playable.setVolume(3);
        playable.stop();


    }
}
