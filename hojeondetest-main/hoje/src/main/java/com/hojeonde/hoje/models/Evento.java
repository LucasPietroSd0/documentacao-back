package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "evento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID idEvento;
    private String name;
    private String descriçao;
    private String dataInicio;
    private String dataFim;
    private String idLocal;
    private String idOrganizador;
}
