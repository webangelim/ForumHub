package com.forumhub.forumhub.domain.topico.validadores;

import com.forumhub.forumhub.domain.ValidacaoException;
import com.forumhub.forumhub.domain.topico.DadosCadastroTopico;
import com.forumhub.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTopicoDuplicado implements ValidadorCadastroTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var titulo = dados.titulo();
        var mensagem = dados.mensagem();

        var topico = topicoRepository.getTopicoByTituloAndMensagem(titulo, mensagem);

        if (topico != null) {
            throw new ValidacaoException("Tópico duplicado");
        }
    }

}
