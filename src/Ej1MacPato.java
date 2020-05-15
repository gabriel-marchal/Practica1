
import java.util.Scanner;
import java.lang.*;

/*
Input:
    Propriedades:
Codigo
Nombre (de propriedad)
Cantidad de cuartos
Provincia
Costo mensual de alquiler

10 propriedades
Almacenar en arreglos con 1 String con todos los inputs

Registrar // Listar
Buscar propriedad
Total recibido mensualmente

Validaciones:
No puede registrar 2 veces misma propriedad


 */

public class Ej1MacPato {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        String[] propriedades = new String[10];

        int opcion = 0;
        do{
            System.out.println("*** MENU ***");
            System.out.println("1. Registrar propriedad.");
            System.out.println("2. Listar todas propriedades.");
            System.out.println("3. Buscar propriedad.");
            System.out.println("4. Total mensual de alquiler.");
            System.out.println("0. Salir.");
            opcion = myObj.nextInt();
            opcion_switch(opcion, propriedades);

        }while (opcion!=0);
    }
    public static void opcion_switch(int opcion, String[] propriedades){
        switch (opcion){
            case 1:
                registrarPropriedad(propriedades);
                break;
            case 2:
                listarPropriedad(propriedades);
                break;
            case 3:
                buscarPropriedad(propriedades);
                break;
            case 4:
                totalAlquiler(propriedades);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void totalAlquiler(String[] propriedades) {
        String[] partesPropriedes = new String[5];
        double total =0;

        for(int i =0; i< propriedades.length; i++){
            if(propriedades[i] != null){
                partesPropriedes = propriedades[i].split(",");
                total += Double.parseDouble(partesPropriedes[4]);
            }
        }
        System.out.println(total);
    }

    public static void buscarPropriedad(String[] propriedades) {
        Scanner myObj = new Scanner(System.in);
        String[] partesPropriedades = new String[5];

        System.out.println("** BUSCAR PROPRIEDAD **");

        System.out.print("Ingrese el Codigo de propriedad: ");
        int codigo = Integer.parseInt(myObj.nextLine());

        for(int i=0; i<propriedades.length ; i++){
            if(propriedades[i] != null){
                partesPropriedades = propriedades[i].split(",");
                if (codigo == Integer.parseInt(partesPropriedades[0])){
                    System.out.println(propriedades[i]);
                }
            }
        }
    }

    public static void listarPropriedad(String[] propriedades) {
        System.out.println("** LISTAR PROPRIEDADES **");
        for(int i =0; i<propriedades.length; i++){
            if(propriedades[i] != null){
                System.out.println(i+1 +": "+propriedades[i]);
            }
        }
    }

    public static void registrarPropriedad(String[] propriedades) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("** REGISTRAR PROPRIEDAD **");

        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(myObj.nextLine());

        System.out.print("Nombre: ");
        String nombre = myObj.nextLine();

        System.out.print("Cantidad de cuartos: ");
        int cuartos = Integer.parseInt(myObj.nextLine());

        System.out.print("Provincia: ");
        String provincia = myObj.nextLine();

        System.out.print("Costo mensual de alquiler: ");
        double costo = Integer.parseInt(myObj.nextLine());

        String propriedad = codigo +","+nombre+","+cuartos+","+provincia+","+costo;

        // VALIDAR PROPRIEDAD EXISTENTE
        boolean validado = validarPropriedad(propriedad, propriedades);

        if (validado == true){
            for (int i = 0; i <propriedades.length; i++){
                if (propriedades[i] == null){
                    propriedades[i] = propriedad;
                    i = propriedades.length;
                }
                System.out.println("Propriedad registrada exitosamente");
            }
        }else{
            System.out.println("! Propriedad ya se encuentra registrada");
        }
    }

    public static boolean validarPropriedad(String propriedad, String[] propriedades) {
        String[] partesPropriedad = new String[5];
        String[] array_propriedades = new String[5];
        partesPropriedad = propriedad.split(",");

        for(int i =0; i<propriedades.length; i++){
            if(propriedades[i] != null){
                array_propriedades = propriedades[i].split(",");
                if(Integer.parseInt(partesPropriedad[0]) == Integer.parseInt(array_propriedades[0])) {
                    return false;
                }
            }
        }
        return true;
    }
}
