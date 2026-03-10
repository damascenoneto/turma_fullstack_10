package br.com.treina.recife.sgp.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treina.recife.sgp.api.model.Usuario;
import java.util.List;
import java.time.LocalDate;





@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByStatus(String status);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    List<Usuario> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Usuario> findByNomeContainingIgnoreCase(String seqCaracteres);
}
