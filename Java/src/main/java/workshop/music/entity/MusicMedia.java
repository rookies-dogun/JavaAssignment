package workshop.music.entity;



public abstract class MusicMedia {
    String title;
    String artist;


    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public abstract void displayInfo();

    public abstract void play();
}