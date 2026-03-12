package br.com.treina.recife.sgp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoDTO> listarProjetos(){
        List<Projeto> projetos = projetoRepository.findAll();

        List<ProjetoDTO> dtos = new ArrayList<>();

        for (Projeto projeto : projetos){
            dtos.add(projeto.tDto());
        }
        return dtos;
    }

    
    public ProjetoDTO obterDadosDoProjeto(Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);

        if (projeto.isPresent()) {
            return projeto.get().tDto();
        }
        return null;
    }

    public Projeto cadastrarProjeto(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    public Projeto atualiProjeto(Long id, Projeto projeto){
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    public void excluirProjeto(Long id){
        projetoRepository.deleteById(id);
    }

    // SELECT * FROM TB_PROJETOS WHERE usuario_resp_id = ?
    public List<Projeto> listarProjetosDeUmUsuario(Long idUsuario){
        return projetoRepository.findByResponsavel_Id(idUsuario);
    }
}
