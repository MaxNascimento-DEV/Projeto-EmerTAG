package br.com.EmerTAG.EmerTAG_APP.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa_protegida")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PessoaProtegida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")  
    private Long idPessoaProtegida;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_criador", nullable = false)
    private Usuario usuarioCriador;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(columnDefinition = "TEXT") 
    private String observacoes;

    @OneToMany(mappedBy = "pessoaProtegida", fetch = FetchType.LAZY)
    @Builder.Default
    private List<ContatoEmergencia> contatosEmergencia = new ArrayList<>();

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

     @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void prePersist() {
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDateTime.now();
    }    
    
    @PreUpdate
    protected void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
