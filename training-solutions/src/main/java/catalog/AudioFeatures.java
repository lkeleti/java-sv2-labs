package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{
    private String title;
    private int length;
    private List<String> composer = new ArrayList<>();
    private List<String> performers = new ArrayList<>();

    public AudioFeatures(String title, int length, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("The title is empty!");
        }
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("The composer list is empty!");
        }
        if (length < 0) {
            throw new IllegalArgumentException("The length must be greater than zero!");
        }
        this.title = title;
        this.length = length;
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("The title is empty!");
        }
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("The composer list is empty!");
        }
        if (length < 0) {
            throw new IllegalArgumentException("The length must be greater than zero!");
        }
        this.title = title;
        this.length = length;
        this.composer = composer;
        this.performers = performers;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(performers);
        contributors.addAll(composer);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
