package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.dto.FlorDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.entityDomain.Flor;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.services.FlorServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:9001")
@RequestMapping
//los controladores se encarga de manejar las solicitudes HTTP y las respuestas
public class FlorControllers {

    @Autowired
    private FlorServices florServices;

    //método que maneja una solicitud HTTP POST a la ruta= http://localhost:9001/flor/add,
    @PostMapping("/add")
    public ResponseEntity<Flor> add(@RequestBody Flor flor) {

        return new ResponseEntity<>(florServices.addFlor(flor), HttpStatus.CREATED);
    }

    //método que maneja una solicitud HTTP PUT a la ruta= http://localhost:9001/flor/update
    @PutMapping("/update/{id}")
    public ResponseEntity<Flor> update(@PathVariable Long id,@RequestBody Flor flor){

        Flor florModelo = florServices.updateFlor(id,flor);
        return new ResponseEntity<>(florModelo, HttpStatus.OK);
    }


    //método que maneja una solicitud HTTP DELETE a la ruta=http://localhost:9001/flor/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Flor>delete(@PathVariable Long id){

        Flor florBorrada = florServices.deleteFlor(id);
        return new ResponseEntity<>(florBorrada, HttpStatus.OK);
    }


    //método que maneja una solicitud HTTP GET a la ruta= http://localhost:9001/flor/getOne/¨{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO>getOne(@PathVariable Long id, FlorDTO florDTO){

        FlorDTO flor = florServices.getOneFlor(id);
        return new ResponseEntity<>(florDTO, HttpStatus.FOUND);
    }


    //método que maneja una solicitud HTTP GET a la ruta= http://localhost:9001/flor/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List> florDTOList(){

        List<FlorDTO> florDTOList = florServices.getAllFlores();
        return new ResponseEntity<>(florDTOList,HttpStatus.FOUND);

    }

}
   // una anotación @Operation que proporciona información adicional sobre la operación