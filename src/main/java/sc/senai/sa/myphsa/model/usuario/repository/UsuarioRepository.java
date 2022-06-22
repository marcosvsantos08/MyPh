package sc.senai.sa.myphsa.model.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import sc.senai.sa.myphsa.model.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByEmail(String email);
}
