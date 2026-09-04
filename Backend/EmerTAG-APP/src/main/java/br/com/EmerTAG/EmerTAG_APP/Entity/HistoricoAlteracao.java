package br.com.EmerTAG.EmerTAG_APP.Entity;

import br.com.EmerTAG.EmerTAG_APP.Enums.TipoAlteracao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_alteracao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoAlteracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private Long idHistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaProtegida pessoaProtegida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "tabela_alterada", nullable = false, length = 100)
    private String tabelaAlterada;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_alteracao", nullable = false, length = 20)
    private TipoAlteracao tipoAlteracao;

    @Column(name = "data_alteracao", nullable = false, updatable = false)
    private LocalDateTime dataAlteracao;

    @PrePersist
    protected void prePersist() {
        this.dataAlteracao = LocalDateTime.now();
    }
}