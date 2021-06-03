package Patterns.Behavioral.State.Ex1;

import java.util.Date;

public class DocumentImpl implements Document, Stateful {
    private Author author;
    private Date date;
    private String text;

    private DocumentState documentState;

    public DocumentImpl(Author author, Date date, String text) {
        this.author = author;
        this.date = date;
        this.text = text;
        documentState = new OnEditState(this);
    }

    public void publish(User user) {
        documentState.publish(user);
    }

    public void render(User user) {
        documentState.render(user);
    }

    @Override
    public void changeState(DocumentState state) {
        this.documentState = state;
    }


    public DocumentState getDocumentState() {
        return documentState;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
