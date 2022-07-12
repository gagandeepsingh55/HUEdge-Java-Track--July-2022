package com.example.netfilix.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "NetflixEntity")
public class NetflixEntity {
    @Id
    @Column(name = "showid", length = 1024)
    private String showId;
    @Column(name = "showtype")
    private String showType;
    @Column(name = "title")
    private String title;
    @Column(name = "director")
    private String director;
    @Column(name = "casts", length = 1024)
    private String cast;
    @Column(name = "country")
    private String country;
    @Column(name = "dateadded")
    private Date dateAdded;
    @Column(name = "release_year")
    private String release_year;
    @Column(name = "rating")
    private String rating;
    @Column(name = "duration")
    private String duration;
    @Column(name = "listedin")
    private String listedIn;
    @Column(name = "description", length = 1024)
    private String description;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listedIn;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}