package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.services;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.dto.FlorDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.entityDomain.Flor;

import java.util.List;

//*la creación de una interfaz de métodos CRUD en el paquete de servicios en Spring Boot ayuda a separar
// responsabilidades, reutilizar código(pra entidades diferentes que requieren operaciones CRUD similares,
// puedes implementar la interfaz en cada una de ellas y evitar duplicar código), proporcionar flexibilidad(si decides
// cambiar de una db relacional(MySQL) a una db NoSQL(Mongo),necesitarías actualizar la implementación de la interfaz
// de servicios sin afectar al controlador  y facilitar las pruebas unitarias(para cada uno de los métodos CRUD)*/
public interface IFlorService {
    Flor addFlor(Flor flor);
    Flor updateFlor(Long id, Flor flor);
    Flor deleteFlor(Long id);
    FlorDTO getOneFlor(Long id);
    List<FlorDTO> getAllFlores();
}
