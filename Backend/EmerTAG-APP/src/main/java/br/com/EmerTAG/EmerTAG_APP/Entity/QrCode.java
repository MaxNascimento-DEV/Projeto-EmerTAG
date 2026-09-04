package br.com.EmerTAG.EmerTAG_APP.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

 @Entity
 @Table(name= "qr_code")
 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder

public class QrCode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQrCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false, unique = true)
    private PessoaProtegida pessoaProtegida;   

    @Column(nullable = false, unique = true, length = 255)
    private String codigo; 

    @Column(name = "url_acesso", nullable = false, length = 255)
    private String urlAcesso;

    @Column(name = "data_gerada", nullable = false, updatable = false)
    private LocalDateTime dataGerada;
    
    private boolean ativo;

    @PrePersist
    protected void prePersist(){
        this.dataGerada = LocalDateTime.now();
        this.ativo = true;
    }

}
