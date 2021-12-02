package com.korepetycjespring.jpa_example.entity_example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {
    /**
     * GenerationType.AUTO - globalna sekwencja dla wszystkich tabel korzystajacych z AUTO
     * GenerationType.IDENTITY - sekwencja tworzona w silniki bazy danych (np. auto_increment w mysql)
     * GenerationType.TABLE - hibernate tworzy dedykowana tabele na przechowywanie danych sekwencji
     * GenerationType.SEQUENCE - jeśli silnik bazy danych wspiera sequencje(np. oracle) to hibernate tego używa. Jeśli nie,
     *                          użyje sposobu TABLE.
     */
    @Id
    @GeneratedValue(generator = "SEQ_PERSON", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PERSON", allocationSize = 1)
    private Long id;

    @NotNull //adnotacja z spring-boot-starter-validation, sprawia ze hibernate bedzie wylapywal nulle przed wyslaniem inserta/update do bazy
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @NotNull
    @Column(updatable = false)
    private LocalDateTime creationDate;
}
