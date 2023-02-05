package com.example.demo.Model;

import lombok.Data;
import java.util.*;
import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private Long phoneNo;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)           // reviews written by this user
    private List<String> writtenReviews;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL)           // reviews written about this user  
    private List<String> reviews;


}   
