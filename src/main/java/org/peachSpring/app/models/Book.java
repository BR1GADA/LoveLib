package org.peachSpring.app.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    private final static int CURRENT_YEAR = 2023;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @Size(min = 2, max = 100, message = "Invalid size of name")
    private String name;
    @Column(name = "year")
    @Positive(message = "year should be greater than 0")
    @Max(value = CURRENT_YEAR, message = " Year should be less than " + CURRENT_YEAR)
    private int year;
    @Column(name = "author")
    @Size(min = 2, max = 50, message = "Invalid size of name")
    @Pattern(regexp = "[a-zA-Zа-яА-Я `.\\-]+" , message = " Authors name should contains only letters")
    private String author;


    @Column(name = "isapproved")
    private boolean isApproved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre", referencedColumnName = "id")
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "users_books",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;


    @Column(name = "image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Book(String name, int year, String author, Genre genre) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.genre = genre;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
