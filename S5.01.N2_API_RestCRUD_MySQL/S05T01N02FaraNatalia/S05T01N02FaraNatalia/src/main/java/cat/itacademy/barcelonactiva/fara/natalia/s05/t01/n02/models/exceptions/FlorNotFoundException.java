package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions;

public class FlorNotFoundException extends RuntimeException{
     public FlorNotFoundException() {
    }
    public FlorNotFoundException(String mensaje) {

        super(mensaje);

    }
}
