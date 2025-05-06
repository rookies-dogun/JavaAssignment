package workshop.music.entity;

public class Vinyl extends MusicMedia{

    int rpm;
    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }
    public void play() {

        System.out.println("바이닐 레코드 '" + this.title + "'이(가) " + this.rpm + "rpm으로 재생됩니다." );
    }
    public void displayInfo() {
        System.out.println("제목: " + this.title + ", 아티스트: " + this.artist);
        System.out.println("회전 속도: " + this.rpm + " rpm");
    }

    public void clean(){
        System.out.println("바이닐 레코드를 청소합니다.");
    }
}
