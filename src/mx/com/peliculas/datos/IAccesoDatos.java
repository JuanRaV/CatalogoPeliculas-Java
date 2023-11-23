package mx.com.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.peliculas.domain.Pelicula;

public interface IAccesoDatos {

    //El metodo existe puede arrojar esa excepcion
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escrirbir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;

}
