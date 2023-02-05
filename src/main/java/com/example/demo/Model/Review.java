package com.example.demo.Model;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
 
    private Double rating;
    private String description;
    private Boolean isTraveler;

    @ManyToOne
    @JoinColumn(name = "reviews_written")
    private User reviewer;                          // reviews written by this user

    @ManyToOne
    @JoinColumn(name = "reviews_received")          // reviews written about this user  
    private User reviewee; 
}
