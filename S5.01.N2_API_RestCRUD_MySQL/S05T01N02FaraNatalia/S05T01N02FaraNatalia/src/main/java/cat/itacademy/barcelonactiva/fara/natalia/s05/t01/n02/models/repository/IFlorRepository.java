package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.repository;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.entityDomain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//el repositorio se encarga de interactuar con la base de datos
public interface IFlorRepository extends JpaRepository<Flor,Long> {
}
