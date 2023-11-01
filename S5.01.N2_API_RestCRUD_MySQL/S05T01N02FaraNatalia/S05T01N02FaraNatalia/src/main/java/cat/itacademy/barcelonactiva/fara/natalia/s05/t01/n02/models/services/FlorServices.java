package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.services;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.dto.FlorDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.entityDomain.Flor;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNoData;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNotListFoundException;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.repository.IFlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//en la clase de servicios va la lógica del CRUD y se manejan las excepciones
public class FlorServices implements IFlorService{
    @Autowired
    private final IFlorRepository florRepository;

    public FlorServices(IFlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public FlorDTO convertToDTO(Flor flor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNameFlor(flor.getNameFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        return florDTO;

    }
    private Flor convertToEntity(FlorDTO florDTO) {
        Flor florNuevaEntity = new Flor();
        florNuevaEntity.setPk_FlorID(florDTO.getPk_FlorID());
        florNuevaEntity.setNameFlor(florDTO.getNameFlor());
        florNuevaEntity.setPaisFlor(florDTO.getPaisFlor());
        return florNuevaEntity;

    }
    @Override
    public Flor addFlor(Flor flor)  {
        Flor florNueva = florRepository.save(new Flor());
        System.out.println("P-200 " + HttpStatus.CREATED);
        return florNueva;
    }
    @Override
    public Flor updateFlor(Long id, Flor flor) {
        FlorDTO florA = getOneFlor(id);
        if(florA == null){
            throw new FlorNotFoundException("No se encuentra la flor con ese numero de ID");
        }
        Flor florModelo = new Flor();
        florModelo.setPk_FlorID(florA.getPk_FlorID());
        florModelo.setNameFlor(florA.getNameFlor());
        florModelo.setPaisFlor(florA.getPaisFlor());
        if(florA.getPk_FlorID()< 1 && florA.getNameFlor() == null && florA.getPaisFlor()== null){
            throw new FlorNoData("Los datod son incorrectos");
        }else{
            florRepository.save(florModelo);
            System.out.println("P-200" + HttpStatus.CREATED);
        }
        return florModelo;
    }
    @Override
    public Flor deleteFlor(Long id) {
        FlorDTO florDTO = getOneFlor(id);
        if(florDTO == null){
            throw new FlorNotFoundException("No se encuentra la flor con ese numero de ID");
        }else {
            florRepository.delete(convertToEntity(florDTO));
            System.out.println("P-200" + HttpStatus.OK);
        }
        return(convertToEntity(florDTO));
    }
    @Override
    public FlorDTO getOneFlor(Long id) {
        FlorDTO florDatoDTO = florRepository.findById(id).map(this::convertToDTO).orElseThrow(()->
                new FlorNotFoundException("No se encuentra la flor con ese numero de ID"));
        if(florDatoDTO == null){
            throw new FlorNotFoundException();
        }else{
            System.out.println("P-200" + HttpStatus.OK);
        }
        return florDatoDTO;
    }
    @Override
    public List<FlorDTO> getAllFlores(){
        List<FlorDTO> florDatoDTOList = florRepository.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
        if(florDatoDTOList.isEmpty()){
            throw new FlorNotListFoundException("Flor no encontrada");
        }else {
            System.out.println("P-200" + HttpStatus.OK);
        }
        return florDatoDTOList;
    }

}
