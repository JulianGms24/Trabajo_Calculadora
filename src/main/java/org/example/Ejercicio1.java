package org.example; // define el paquete de el proyecto
import java.util.Scanner; // importa la clase Scanner para leer los datos de el usuario
public class Ejercicio1 { // definicion de la clase principal

    public static void main(String[] args) { //metodo donde inicia la clase principal
        System.out.println("En este codigo vamos a escoger un numero y el programa, nos dira si es primo o si no lo es");//mensaje inicial
        System.out.println("Usando estructuras de control como if, else, etc..."); //mensaje inicial

        Scanner scanner = new Scanner(System.in);// crear un objeto Scanner para leer la entrada del usuario

        int numero;//Variable para almacenar el numero ingresado
        boolean esPrimo = true;// vairable si booleana que indicara si el numero es primo o no

        System.out.println("Ingrese un número entero");//pide al usuario que ingrese un numero
        numero = scanner.nextInt();//lee el numero ingresado por el usuario
        //verifica si el numero es menor o igual a 1, ya que estos no son primos
        if(numero<=1){
            esPrimo = false; // lo marca como no primo

        } else {
            //bucle que recorre desde la mitad del numero (numero/2)
            for(int i = 2; i <= numero/2;i++){
                if(numero % i ==0){// verifica si es divisible por algun numero distinto de 1 y de el mismo
                    esPrimo = false;//no es primo
                    break;//se rompe el blucle ya que sabemos que no es primo
                }
            }

        }

        //estructura de control con if-else, muestra el resultado
        if(esPrimo){
            System.out.println( numero + " es número primo");//mensaje si es primo

        } else {
            System.out.println( numero  +  " no es número primo");//mensaje si no es primo
        }

        scanner.close();// Cierra el objeto scanner para liberar recursos
    }
}