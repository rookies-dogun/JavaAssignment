package workshop.music.entity;

public abstract class DigitalMedia extends MusicMedia {

    String format;
    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    public abstract void play();

    public abstract void displayInfo();
}
