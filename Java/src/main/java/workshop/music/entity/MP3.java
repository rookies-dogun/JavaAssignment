package workshop.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, String format, int fileSize, int volume) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = volume;
    }

    public MP3(String title, String artist, String format) {
        super(title, artist, format);
    }

    @Override
    public void displayInfo() {
        System.out.println("제목: " + this.title + ", 아티스트: " + this.artist);
        System.out.println("포맷: " + this.format);
        System.out.println("파일 크기: " + this.fileSize + "MB");
    }
    @Override
    public void play() {
        System.out.println("MP3 형식의 '"+ this.title +"' 이(가) 디지털로 재생됩니다." + this.volume);
        System.out.println("현재 볼륨: " + this.volume);
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Volume changed to " + level);
        this.volume = level;
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
}
