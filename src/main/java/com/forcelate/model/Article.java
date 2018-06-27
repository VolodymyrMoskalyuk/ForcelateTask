package com.forcelate.model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private long id;
    @Column(name = "text")
    private String text;
    @Column(name = "color")
    private Color color;
    @ManyToOne
    @JoinColumn(name="id")
    private User user;

    public Article() {
    }

    public Article(String text, Color color, User user) {
        this.text = text;
        this.color = color;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color=" + color +
                '}';
    }
}
