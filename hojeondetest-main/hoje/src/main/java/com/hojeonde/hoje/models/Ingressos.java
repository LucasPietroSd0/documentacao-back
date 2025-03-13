package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Ingressos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingressos {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID idIngresso;
    private String Tipo;
    private String valor;
    private String quantidade;
    private String lote;
}
