package com.korepetycjespring.jpa_example.onetoone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column
    private String street;

    @Column
    private String buildingNumber;

    @Column
    private String flatNumber;

    @OneToOne(mappedBy = "address")
    private User user;
}
