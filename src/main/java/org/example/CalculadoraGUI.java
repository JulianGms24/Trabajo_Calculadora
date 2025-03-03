package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    private JTextField pantalla;
    private JButton[] botonesNumeros;
    private JButton[] botonesOperaciones;
    private JButton botonIgual, botonClear, botonRaiz, botonPotencia, botonModulo, botonConvertir;

    // Variables para almacenar los valores y la operación
    private double num1 = 0, num2 = 0, resultado = 0;
    private char operacion;

    // Constructor
    public CalculadoraGUI() {
        setTitle("Calculadora Basica");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar la pantalla
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);

        // Aumentar el tamaño de la fuente y el tamaño del cuadro de texto
        pantalla.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente más grande
        pantalla.setPreferredSize(new Dimension(400, 60)); // Tamaño más grande del cuadro de texto
        add(pantalla, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5)); // Espaciado entre botones

        // Inicializar los botones numéricos
        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            botonesNumeros[i].addActionListener(this);
            botonesNumeros[i].setFont(new Font("Arial", Font.BOLD, 18)); // Fuente más grande para los botones
        }

        // Inicializar los botones de operaciones
        botonesOperaciones = new JButton[4];
        botonesOperaciones[0] = new JButton("+");
        botonesOperaciones[1] = new JButton("-");
        botonesOperaciones[2] = new JButton("*");
        botonesOperaciones[3] = new JButton("/");

        for (JButton boton : botonesOperaciones) {
            boton.addActionListener(this);
            boton.setFont(new Font("Arial", Font.BOLD, 18)); // Fuente más grande para los botones
        }

        // Botones adicionales
        botonIgual = new JButton("=");
        botonClear = new JButton("C");
        botonRaiz = new JButton("√");
        botonPotencia = new JButton("^");
        botonModulo = new JButton("%");
        botonConvertir = new JButton("°C a °F");

        botonIgual.addActionListener(this);
        botonClear.addActionListener(this);
        botonRaiz.addActionListener(this);
        botonPotencia.addActionListener(this);
        botonModulo.addActionListener(this);
        botonConvertir.addActionListener(this);

        // Aumentar el tamaño de la fuente de los botones adicionales
        botonIgual.setFont(new Font("Arial", Font.BOLD, 18));
        botonClear.setFont(new Font("Arial", Font.BOLD, 18));
        botonRaiz.setFont(new Font("Arial", Font.BOLD, 18));
        botonPotencia.setFont(new Font("Arial", Font.BOLD, 18));
        botonModulo.setFont(new Font("Arial", Font.BOLD, 18));
        botonConvertir.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente un poco más pequeña para este botón

        // Organizar los botones como un teclado numérico
        panelBotones.add(botonClear);      // Fila 1, Columna 1
        panelBotones.add(botonRaiz);       // Fila 1, Columna 2
        panelBotones.add(botonPotencia);   // Fila 1, Columna 3
        panelBotones.add(botonesOperaciones[3]); // Fila 1, Columna 4 (División)

        panelBotones.add(botonesNumeros[7]); // Fila 2, Columna 1 (7)
        panelBotones.add(botonesNumeros[8]); // Fila 2, Columna 2 (8)
        panelBotones.add(botonesNumeros[9]); // Fila 2, Columna 3 (9)
        panelBotones.add(botonesOperaciones[2]); // Fila 2, Columna 4 (Multiplicación)

        panelBotones.add(botonesNumeros[4]); // Fila 3, Columna 1 (4)
        panelBotones.add(botonesNumeros[5]); // Fila 3, Columna 2 (5)
        panelBotones.add(botonesNumeros[6]); // Fila 3, Columna 3 (6)
        panelBotones.add(botonesOperaciones[1]); // Fila 3, Columna 4 (Resta)

        panelBotones.add(botonesNumeros[1]); // Fila 4, Columna 1 (1)
        panelBotones.add(botonesNumeros[2]); // Fila 4, Columna 2 (2)
        panelBotones.add(botonesNumeros[3]); // Fila 4, Columna 3 (3)
        panelBotones.add(botonesOperaciones[0]); // Fila 4, Columna 4 (Suma)

        panelBotones.add(botonesNumeros[0]); // Fila 5, Columna 1 (0)
        panelBotones.add(botonModulo);       // Fila 5, Columna 2 (%)
        panelBotones.add(botonIgual);        // Fila 5, Columna 3 (=)
        panelBotones.add(botonConvertir);    // Fila 5, Columna 4 (°C a °F)

        // Añadir el panel de botones a la ventana
        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método para manejar las acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // Manejo de números
        for (int i = 0; i < 10; i++) {
            if (comando.equals(String.valueOf(i))) {
                pantalla.setText(pantalla.getText() + i);
            }
        }

        // Manejo de operaciones básicas
        if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = comando.charAt(0);
            pantalla.setText("");
        }

        // Manejo de la operación de módulo
        if (comando.equals("%")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = '%';
            pantalla.setText("");
        }

        // Manejo de la operación de potenciación
        if (comando.equals("^")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = '^';
            pantalla.setText("");
        }

        // Manejo de la operación de igual
        if (comando.equals("=")) {
            num2 = Double.parseDouble(pantalla.getText());

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    resultado = num1 / num2;
                    break;
                case '%':
                    resultado = (int) num1 % (int) num2; // Convertir a int para el módulo
                    break;
                case '^':
                    resultado = Math.pow(num1, num2); // Usar Math.pow para potenciación
                    break;
            }

            pantalla.setText(String.valueOf(resultado)); // Muestra el resultado
        }

        // Manejo de la operación de raíz cuadrada
        if (comando.equals("√")) {
            num1 = Double.parseDouble(pantalla.getText());
            resultado = Math.sqrt(num1);
            pantalla.setText(String.valueOf(resultado));
        }

        // Manejo de la conversión de Celsius a Fahrenheit
        if (comando.equals("°C a °F")) {
            num1 = Double.parseDouble(pantalla.getText());
            resultado = (num1 * 9 / 5) + 32;
            pantalla.setText(String.valueOf(resultado));
        }

        // Manejo de la operación de limpiar
        if (comando.equals("C")) {
            pantalla.setText("");
            num1 = 0;
            num2 = 0;
            resultado = 0;
        }
    }

    // Método principal
    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}