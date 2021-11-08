package com.korepetycjespring.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
}
