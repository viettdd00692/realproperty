package com.example.realproperty.entity;


import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "des")
    private String des;

    public Blog() {
    }

    public Blog(String title , String image , String des){
        this.title = title;
        this.image = image;
        this.des = des;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
