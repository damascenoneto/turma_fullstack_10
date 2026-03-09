package br.com.treina.recife.sgp.api.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.service.ProjetoService;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> cadastrar(@RequestBody Projeto projeto){
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.cadastrarProjeto(projeto));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listar(){
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> obterDadosPeloId(@PathVariable Long id){
        Optional<Projeto> projeto = projetoService.obterDadosDoProjeto(id);

        if (projeto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projeto.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        Optional<Projeto> projeto = projetoService.obterDadosDoProjeto(id);

        if (projeto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        projetoService.excluirProjeto(id);

        return ResponseEntity.noContent().build();
        
    }

    @PutMapping("/{id}")
        public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody Projeto dados){
            Optional<Projeto> projeto = projetoService.obterDadosDoProjeto(id);

            if (projeto.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(projetoService.atualiProjeto(id, dados));
            
        }
    


}
