package br.com.treina.recife.sgp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios") // fazendo com que todos os endpoints criados partam daqui
public class UsuarioController {
    

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario); 
    }

}
