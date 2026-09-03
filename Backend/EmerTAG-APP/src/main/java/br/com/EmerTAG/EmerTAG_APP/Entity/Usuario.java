package br.com.EmerTAG.EmerTAG_APP.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.EmerTAG.EmerTAG_APP.Enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senhaHash;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false, length = 20) 
    private TipoUsuario tipoUsuario;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "usuarioCriador", fetch = FetchType.LAZY)
    @Builder.Default
    private List<PessoaProtegida> pessoasProtegidas = new ArrayList<>();

    @PrePersist
    protected void prePersist(){
        this.dataCadastro = LocalDate.now(); 
    }


}
