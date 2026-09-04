package br.com.EmerTAG.EmerTAG_APP.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RedePermissaoId implements Serializable {

    @Column(name = "id_rede")
    private Long idRede;

    @Column(name = "id_permissao")
    private Long idPermissao;
}