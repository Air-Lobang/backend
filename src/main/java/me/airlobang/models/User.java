package me.airlobang.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user")
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "First name cannot be null")
    @Column(name = "first name")
    private String firstName;

    @NotBlank(message = "Last name cannot be null")
    @Column(name = "last name")
    private String lastName;

    @Pattern(regexp = "(^$|[0-9]{8})", message = "8 digit phone number")
    @Column(name = "phone no.")
    private String phoneNumber;

    @Email(message = "Must be a valid email")
    @NotBlank(message = "Email cannot be null")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Size(min = 16, max = 16)
    @Column(name = "resetPasswordToken")
    private String resetPasswordToken;

    // @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)           // reviews written by this user
    // private List<String> writtenReviews;

    // @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL)           // reviews written about this user  
    // private List<String> reviews;

}
