package activitytracker;

public class Image {

    private long id;
    private String filename;
    private byte[] content;

    public Image(long id, String filename, byte[] content) {
        this.id = id;
        this.filename = filename;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }
}
