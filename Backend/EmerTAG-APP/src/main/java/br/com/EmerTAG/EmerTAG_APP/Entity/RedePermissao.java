package br.com.EmerTAG.EmerTAG_APP.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rede_permissao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RedePermissao {

    @EmbeddedId
    private RedePermissaoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRede")
    @JoinColumn(name = "id_rede", nullable = false)
    private RedeCuidado redeCuidado;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPermissao")
    @JoinColumn(name = "id_permissao", nullable = false)
    private Permissao permissao;
}