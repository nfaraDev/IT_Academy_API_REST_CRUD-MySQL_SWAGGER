package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlorDTO {
    private long pk_FlorID;
    private String nameFlor;
    private String paisFlor;
    private String tipoFlor;

    private static final List<String> paises = Arrays.asList("Alemania", "Bélgica", "Croacia", "Dinamarca",
            "España", "Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia",
            "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia",
            "Hungría", "Italia", "Lituania", "Portugal", "Rumanía"
    );

    public String getTipoFlor(){
        String ue = "UE";
        String fueraUE = "Fuera UE";
        if (paises.contains(paisFlor)) {
            return ue;
        } else {
            return fueraUE;
        }
    }
}



