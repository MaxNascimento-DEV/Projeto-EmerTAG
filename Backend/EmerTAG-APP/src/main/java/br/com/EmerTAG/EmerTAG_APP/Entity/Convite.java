package br.com.EmerTAG.EmerTAG_APP.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import br.com.EmerTAG.EmerTAG_APP.Enums.StatusConvite;

 @Entity
 @Table(name= "convite")
 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder

public class Convite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idConvite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaProtegida pessoaProtegida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_remetente", nullable = false)
    private Usuario usuarioRemetente;

    @Column(name = "email_destinatario", nullable = false, length = 150)
    private String emailConvidado; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusConvite statusConvite;
    
    @Column(name = "data_envio", nullable = false, updatable = false)
    private LocalDateTime dataEnvio;

    @Column(name = "data_resposta")
    private LocalDateTime dataAceite; 

    @PrePersist
    protected void prePersist(){
        this.dataEnvio = LocalDateTime.now();
        this.statusConvite = StatusConvite.PENDENTE;
    } 
}
