package com.hojeonde.hoje.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "Users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
 @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

      @OneToMany
    Ingressos ingressos;
}
