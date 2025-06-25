package pe.edu.upeu.chavez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.chavez.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
