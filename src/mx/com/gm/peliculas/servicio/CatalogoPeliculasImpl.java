
package mx.com.gm.peliculas.servicio;

import mx.com.gm.peliculas.excepciones.*;
import mx.com.peliculas.datos.*;
import mx.com.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = this.datos.existe(NOMBRE_RECURSO);
            this.datos.escrirbir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al acceso a datos");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula:peliculas){
                System.out.println(pelicula);
            }
                   
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
           System.out.println("Error de acceso datos");
           ex.printStackTrace(System.out);
        }
        if(resultado == null)
            System.out.println("Resultado no encontrado");
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            //Reiniciamos el catalogo de peliculas
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo pelicula");
            ex.printStackTrace(System.out);
        }
    }
    
}
