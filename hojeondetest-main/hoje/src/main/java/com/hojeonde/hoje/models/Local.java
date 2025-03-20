package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Locais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
 @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idLocal;
    private String nome;
    private String endereco;
    private String capacidade;

     @OneToMany
    Evento evento;
}
