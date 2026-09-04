package br.com.EmerTAG.EmerTAG_APP.Entity;

import br.com.EmerTAG.EmerTAG_APP.Enums.StatusRede;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rede_cuidado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RedeCuidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rede")
    private Long idRede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaProtegida pessoaProtegida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "data_entrada", nullable = false, updatable = false)
    private LocalDateTime dataEntrada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusRede status;

    @PrePersist
    protected void prePersist() {
        this.dataEntrada = LocalDateTime.now();
        this.status = StatusRede.ATIVO;
    }
}