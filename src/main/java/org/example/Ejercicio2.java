package org.example; // define el paquete de el proyecto

import java.util.Scanner;//importa la clase scanner para leer los datos del usuario


public class Ejercicio_4 {//definicion de la clase principal

    public static void main(String[] args) {//metodo principal donde inicia la ejecucion principal
        System.out.println("Este programa esta diseñaso con una evaluacion de conocimiento basico");//mensaje inicial
        System.out.println("el cual fue hecho con estructuras de control, if, else, else if , for , switch");
        //se usa un bloque try-whit-resources para manejar el scanner automaticamente
        try (Scanner entrada = new Scanner(System.in)) {
            int PreguntaCorrecta = 0;//contador de respuestas correctas
            // La evaluciacion generada sera sobre cultura general
            // Preguntas y respuestas
            // se inicia un siclo for para hacer 10 preguntas
            for (int i = 1; i <= 10; i++) {
                System.out.println("Pregunta" + i + ":");

                switch (i) {
                    case 1 -> {// pregunta 1
                        System.out.println(" Cual es el pais mas grande del mundo?");
                        System.out.println("1. Rusia");
                        System.out.println("2. Canadá");
                        System.out.println("3. China");
                        System.out.print("Respuesta: ");
                        int Pregunta1 = entrada.nextInt();
                        if (Pregunta1 == 1)// respuesta correcta: Rusia
                            PreguntaCorrecta++;
                    }

                    case 2 -> {//Pregunta 2
                        System.out.println(" Cuantos planetas tiene el sistema solar?");
                        System.out.println("1. 7");
                        System.out.println("2. 8");
                        System.out.println("3. 9");
                        System.out.print("Respuesta: ");
                        int pregunta2 = entrada.nextInt();
                        if (pregunta2 == 2)//respuesta correcta: 8
                            PreguntaCorrecta++;
                    }

                    case 3 -> {//Pregunta 3
                        System.out.println(" Cual es el río mas largo del mundo?");
                        System.out.println("1. Amazonas");
                        System.out.println("2. Nilo");
                        System.out.println("3. Bogota xd");
                        System.out.print("Respuesta: ");
                        int pregunta3 = entrada.nextInt();
                        if (pregunta3 == 1)//respuesta correcta: Amazonas
                            PreguntaCorrecta++;
                    }

                    case 4 -> {//pregunta 4
                        System.out.println(" Quien pinto la Mona Lisa?");
                        System.out.println("1. Miguel Angel");
                        System.out.println("2. Leonardo da Vinci");
                        System.out.println("3. Vincent van Gogh");
                        System.out.print("Respuesta: ");
                        int pregunta4 = entrada.nextInt();
                        if (pregunta4 == 2)//respuesta correcta Leonardo da Vinci
                            PreguntaCorrecta++;
                    }

                    case 5 -> {//pregunta 5
                        System.out.println(" Que gas respiramos?");
                        System.out.println("1. Dioxido de carbono");
                        System.out.println("2. Oxigeno");
                        System.out.println("3. Nitrogeno");
                        System.out.print("Respuesta: ");
                        int pregunta5 = entrada.nextInt();
                        if (pregunta5 == 2)//respuesta correcta: Oxigeno
                            PreguntaCorrecta++;
                    }

                    case 6 -> {//pregunta 6
                        System.out.println(" Cual es el animal terrestre mas rapido?");
                        System.out.println("1. Guepardo");
                        System.out.println("2. Leon");
                        System.out.println("3. Tigre");
                        System.out.print("Respuesta: ");
                        int pregunta6 = entrada.nextInt();
                        if (pregunta6 == 1)//respuesta correcta: Guepardo
                            PreguntaCorrecta++;
                    }

                    case 7 -> {//pregunta 7
                        System.out.println(" Cual es el oceano mas grande?");
                        System.out.println("1. Atlantico");
                        System.out.println("2. Indico");
                        System.out.println("3. Pacifico");
                        System.out.print("Respuesta: ");
                        int pregunta7 = entrada.nextInt();
                        if (pregunta7 == 3)//respuesta correcta: Pacifico
                            PreguntaCorrecta++;
                    }

                    case 8 -> {//pregunta 8
                        System.out.println("En que pais se encuentran las piramides de Giza?");
                        System.out.println("1. Peru");
                        System.out.println("2. Egipto");
                        System.out.println("3. Mexico");
                        System.out.print("Respuesta: ");
                        int pregunta8 = entrada.nextInt();
                        if (pregunta8 == 2)//respuesta correcta: Egipto
                            PreguntaCorrecta++;
                    }

                    case 9 -> {//pregunta 9
                        System.out.println("Cual es el idioma mas hablado en el mundo?");
                        System.out.println("1. Ingles");
                        System.out.println("2. Español");
                        System.out.println("3. Chino mandarín");
                        System.out.print("Respuesta: ");
                        int pregunta9 = entrada.nextInt();
                        if (pregunta9 == 3)//respuesta correcta: Chino Mandarin
                            PreguntaCorrecta++;
                    }

                    case 10 -> {//pregunta 10
                        System.out.println("Cual es la capital de Francia?");
                        System.out.println("1. Paris");
                        System.out.println("2. Londres");
                        System.out.println("3. Roma");
                        System.out.print("Respuesta: ");
                        int pregunta10 = entrada.nextInt();
                        if (pregunta10 == 1)// respuesta correcta: paris
                            PreguntaCorrecta++;
                    }
                }
            }

            // Resultado del quiz
            System.out.println("\nRespuestas correctas: " + PreguntaCorrecta);
            //evaluacion de los resultados
            if (PreguntaCorrecta <= 5) {
                System.out.println("Quiz Reprobado.");
            } else if (PreguntaCorrecta >= 6 && PreguntaCorrecta <= 9) {
                System.out.println(" Quiz Aprobado.");
            } else if (PreguntaCorrecta == 10) {
                System.out.println("¡Felicidades! Eres un genio.");
            }
        }// el scanner se cierra automaticamente gracias a try-with-resources
    }
}