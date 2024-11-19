package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL)
    private List<Ferme> fermes;

}
