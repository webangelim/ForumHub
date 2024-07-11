package com.forumhub.forumhub.domain.topico;

import com.forumhub.forumhub.domain.resposta.Resposta;
import com.forumhub.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();

    private String curso;

    public Topico(DadosCadastroTopico dados, Usuario usuario) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = true;
        this.autor = usuario;
        this.curso = dados.curso();
    }

    public void atualizar(DadosAtualizarTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.status = true;
        this.curso = dados.curso();
    }

    public void excluir() {
        this.status = false;
    }
}
