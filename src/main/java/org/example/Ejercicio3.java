package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[]args){
        int edad = 0;
        double precioTicket = 50.0;
        char tipoTicket = 'V'; //V para VIP,N para Normal
        String tieneTicketRespuesta;
        boolean tieneTicket = false;

        Scanner scanner = new Scanner(System.in);

        boolean edadValida = false;
        while (!edadValida) {
            try {
                System.out.print("Ingrese su edad: ");
                edad = scanner.nextInt();
                if (edad <= 0) {
                    throw new IllegalArgumentException("La edad debe ser un número positivo.");
                }
                edadValida = true; //si no hay error, la edad es valida
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido para la edad.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

}
