package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idEvento;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String idLocal;
    private String idOrganizador;

     @ManyToOne
    Local local;
}
