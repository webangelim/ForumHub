package com.forumhub.forumhub.domain.topico;

import com.forumhub.forumhub.domain.curso.CursoRepository;
import com.forumhub.forumhub.domain.topico.validadores.ValidadorCadastroTopico;
import com.forumhub.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorCadastroTopico> validadores;

    public TopicoDTO cadastrar(DadosCadastroTopico dados, String email) {

        validadores.forEach(v -> v.validar(dados));

        var usuario = usuarioRepository.getUsuarioByEmail(email);
        var topico = new Topico(dados, usuario);

        topicoRepository.save(topico);

        var topicoDto = new TopicoDTO(topico);


        return topicoDto;
    }
}
