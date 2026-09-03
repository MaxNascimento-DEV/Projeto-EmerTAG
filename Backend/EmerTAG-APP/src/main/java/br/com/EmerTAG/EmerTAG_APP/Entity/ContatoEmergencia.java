package br.com.EmerTAG.EmerTAG_APP.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name= "contato_emergencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContatoEmergencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato_emergencia", nullable = false)   
    private Long idContatoEmergencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaProtegida pessoaProtegida;

    @Column(nullable = false, length = 100)
    private String nomeContato;

    @Column(nullable = false, length = 20)
    private String telefoneContato;

    @Column(length = 50)
    private String parentescoContato;

    @Column(nullable = false)
    private int prioridadeContato;

}
