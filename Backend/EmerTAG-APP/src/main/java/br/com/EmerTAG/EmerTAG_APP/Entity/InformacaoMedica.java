package br.com.EmerTAG.EmerTAG_APP.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.EmerTAG.EmerTAG_APP.Enums.CondicaoBiosseguranca;
import br.com.EmerTAG.EmerTAG_APP.Enums.FatorRH;
import br.com.EmerTAG.EmerTAG_APP.Enums.GrupoSanguineo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "informacao_medica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InformacaoMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaProtegida pessoaProtegida;

    @Column(length = 255)
    private String alergias;

    @Column(length = 255)
    private String doencasCronicas;

    @Column(length = 255)
    private String medicamentosDeUsoContinuo;

    @Column(columnDefinition = "TEXT")
    private String historico_cirurgico;

    @Enumerated(EnumType.STRING)
    @Column(name = "grupo_sanguineo", length = 2)
    private GrupoSanguineo grupo_sanguineo;    

    @Enumerated(EnumType.STRING)
    @Column(name = "fator_rh", length = 10)
    private FatorRH fator_rh;

    @Enumerated(EnumType.STRING)
    @Column(name = "condicao_biosseguranca", length = 50)
    private CondicaoBiosseguranca condicaoBiosseguranca;

    @Column(length = 255, columnDefinition = "TEXT")
    private String descricaoInformacaoAdicional;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
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
