package com.book.my.show.bookmyshowonline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private  String createdBy;

    private  String  updatedBy;

}
