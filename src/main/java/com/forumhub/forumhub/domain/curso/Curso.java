package com.forumhub.forumhub.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(DadosAtualizarCurso dados) {

        if (this.nome != null) {
            this.nome = dados.nome();
        }
        if (this.categoria != null) {
            this.categoria = dados.categoria();
        }

    }
}
