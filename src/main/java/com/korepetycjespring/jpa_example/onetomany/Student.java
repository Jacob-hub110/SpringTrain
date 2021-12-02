package com.korepetycjespring.jpa_example.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
