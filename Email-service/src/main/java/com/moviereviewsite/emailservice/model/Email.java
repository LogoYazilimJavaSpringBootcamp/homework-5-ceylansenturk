package com.moviereviewsite.emailservice.model;



import javax.persistence.*;
import lombok.Data;





@Entity
@Table(name = "movie_email")
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String toEmail;
    @Column
    private String title;
    @Column(name = "email_message")
    private String emailMessage;
}
