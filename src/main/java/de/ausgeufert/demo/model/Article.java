package de.ausgeufert.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Article {
    public final int teaserMaxLength = 100;

    @Id
    @GeneratedValue
    private Long id;
    private String headline;
    private String content;
    private String author;
    private Date createdAt;

    public Article() {
    }

    public Article(String headline, String content, String author, Date createdAt) {
        this.setHeadline(headline);
        this.setContent(content);
        this.setAuthor(author);
        this.setCreatedAt(createdAt);
    }

    public String getTeaser() {
        if (content.length() < teaserMaxLength) return content;
        return content.substring(0, teaserMaxLength - 1) + "...";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;
        return Objects.equals(this.id, article.id) && Objects.equals(this.headline, article.headline)
                && Objects.equals(this.content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.headline, this.content);
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + this.id + ", headline='" + this.headline + '\'' + ", content='" + this.content + '\'' + ", createdAt=" + this.createdAt + "}";
    }
}
