package br.com.treina.recife.sgp.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.dto.CredenciaisDTO;
import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
import br.com.treina.recife.sgp.api.dto.UsuarioDTO;
import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.service.ProjetoService;
import br.com.treina.recife.sgp.api.service.UsuarioService;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrar(@RequestBody Projeto projeto){
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.cadastrarProjeto(projeto).tDto());
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listar(){
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> obterDadosPeloId(@PathVariable Long id){
        ProjetoDTO projeto = projetoService.obterDadosDoProjeto(id);

        if (Objects.isNull(projeto)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        ProjetoDTO projeto = projetoService.obterDadosDoProjeto(id);

        if (Objects.isNull(projeto)) {
            return ResponseEntity.notFound().build();
        }

        projetoService.excluirProjeto(id);

        return ResponseEntity.noContent().build();
        
    }

    @PutMapping("/{id}")
        public ResponseEntity<ProjetoDTO> atualizar(@PathVariable Long id, @RequestBody Projeto dados){
            ProjetoDTO projeto = projetoService.obterDadosDoProjeto(id);

            if (Objects.isNull(projeto)) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(projetoService.atualiProjeto(id, dados).tDto());
            
        }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Projeto>> consultarProjetodeUsuario(@PathVariable("id") Long idUsuario){
        UsuarioDTO usuario = usuarioService.obterDadosDoUsuario(idUsuario);

        if(Objects.isNull(usuario)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projetoService.listarProjetosDeUmUsuario(idUsuario));
    }
    


}
