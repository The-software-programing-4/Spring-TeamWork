package com.example.bookandmovie.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;

}
