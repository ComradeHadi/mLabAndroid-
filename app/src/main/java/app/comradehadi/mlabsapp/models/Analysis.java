package app.comradehadi.mlabsapp.models;

public class Analysis {

    String id;
    String title;
    String subTitle;
    String text;
    Phrase phrase;

    public Analysis() {
    }

    public Analysis(String id, String title, String subTitle, String text, Phrase phrase) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.text = text;
        this.phrase = phrase;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getText() {
        return text;
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }


    @Override
    public String toString() {
        return "Analysis{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", text='" + text + '\'' +
                ", phrase=" + phrase +
                '}';
    }
}
