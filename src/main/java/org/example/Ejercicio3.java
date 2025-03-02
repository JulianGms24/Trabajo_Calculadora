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

        boolean respuestaValida = false;
        while (!respuestaValida) {
            try {
                System.out.print("¿Tiene un ticket válido? (si/no): ");
                tieneTicketRespuesta = scanner.next().toLowerCase(); //convierte a minuscula

                if (tieneTicketRespuesta.equals("sí") || tieneTicketRespuesta.equals("si")) {
                    tieneTicket = true;
                    respuestaValida = true;
                } else if (tieneTicketRespuesta.equals("no")) {
                    tieneTicket = false;
                    respuestaValida = true;
                } else {
                    throw new IllegalArgumentException("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (edad >= 18) {
            if (tieneTicket) {
                System.out.println("Acceso permitido al evento.");

                switch (tipoTicket) {
                    case 'V':
                        System.out.println("Usted tiene un ticket VIP. Precio: $" + (precioTicket * 1.5));
                        break;
                    case 'N':
                        System.out.println("Usted tiene un ticket Normal. Precio: $" + precioTicket);
                        break;
                    default:
                        System.out.println("Tipo de ticket no reconocido.");
                        break;
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("¡Bienvenido al evento!");
                }

            } else {
                System.out.println("Acceso denegado. Necesita un ticket válido.");
            }
        } else {
            System.out.println("Acceso denegado. Debe ser mayor de 18 años.");
        }

        scanner.close();

    }

}
