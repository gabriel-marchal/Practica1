import java.util.Scanner;

public class Practica1 {
    Scanner myObj = new Scanner(System.in);

    public static void main(String[] args) {

        String libros[] = new String [10];
        String autores[] = new String[10];

        boolean continuar = true;

        crearMenu(continuar, autores, libros);
    }
    public static void crearMenu(boolean continuar , String[] autores, String[] libros){
        Scanner myObj = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Registrar Autor.");
            System.out.println("2. Registrar Libro.");
            System.out.println("3. Imprimir Autor.");
            System.out.println("4. Imprimir Libro");
            System.out.println("5. Salir");
            opcion = Integer.parseInt(myObj.nextLine());
            procesarOpcion(opcion, autores, libros);
        }
        while (opcion != 5);
    }
    public static void procesarOpcion(int opcion, String[] autores, String[] libros){
        switch (opcion){
            case 1:
                registrarAutor(autores);

                break;
            case 2:
                registrarLibro(libros, autores);

                break;
            case 3:
                imprimirAutor(autores);
                break;
            case 4:
                imprimirLibro(libros);
                break;
            case 5:
                //System.exit();
                break;
            default:
                System.out.println("Digite una opcion valida.");

        }
    }
    public static void registrarAutor(String[] autores){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nombre del Autor: ");
        String nombre = myObj.nextLine();
        System.out.println("Nacionalidad: ");
        String nacionalidad = myObj.nextLine();
        System.out.println("Pseudonimo: ");
        String pseudonimo = myObj.nextLine();

        String autor = nombre + ", "+ nacionalidad + ", "+ pseudonimo;

        for(int i=0; i<autores.length; i++){
            if (autores[i] == null){
                autores[i] =autor;
                i = autores.length;
            }
        }
        System.out.println("Autor registrado exitosamente.");

    }
    public static void registrarLibro(String[] libros, String[] autores){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nombre del Libro: ");
        String nombre = myObj.nextLine();
        System.out.println("ISBN: ");
        int isbn = Integer.parseInt(myObj.nextLine());
        System.out.println("Ano de publicacion: ");
        int publicacion = Integer.parseInt(myObj.nextLine());
        System.out.println("Nombre Autor: ");
        String nombreAutor = myObj.nextLine();
        System.out.println("Precio: ");
        double precio = Double.parseDouble(myObj.nextLine());

        String libro = isbn +", "+nombre+ ", " +publicacion+ ", "+nombreAutor+ ", "+precio;

        boolean existeAutor = validarAutor(nombreAutor, autores);

        if(existeAutor){
            for(int i=0; i<libros.length; i++){
                if (libros[i] == null){
                    libros[i] =libro;
                    i = libros.length;
                }
            }
            System.out.println("Libro registrado exitosamente.");
        }

    }

    private static boolean validarAutor(String nombreAutor, String[] autores) {
        String[] partesAutores;
        for(int i =0; i<autores.length; i++){
            if(autores[i] != null){
                partesAutores= autores[i].split(",");
                if(nombreAutor.equals(autores[i])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void imprimirLibro(String[] libros){
        System.out.println("Lista de Libros: ");
        for (int i = 0; i < libros.length ; i++) {
            System.out.println(libros[i]);
        }
    }

    public static void  imprimirAutor(String[] autores){
        System.out.println("Lista de Autores");
        for(int i=0; i<autores.length; i++){
            System.out.println(autores[i]);
        }
    }
}
