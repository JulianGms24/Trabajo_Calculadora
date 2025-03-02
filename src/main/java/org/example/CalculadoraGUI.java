import javax.swing.*;// Importa la librería Swing para crear la interfaz gráfica de usuario.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends javax.swing.JFrame {
    private double num1, num2, resultado;// Se declaran variables para almacenar los operandos y el resultado de las operaciones.
    private String operador;

    public CalculadoraGUI() {
        initComponents();
    }

    private void initComponents() {// Método para inicializar los componentes de la interfaz gráfica.
        setTitle("Calculadora NetBeans");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new java.awt.GridLayout(5, 4));

        JTextField textField = new JTextField();// Campo de texto donde se mostrarán los números ingresados y los resultados.
        add(textField);

        String[] botones = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+", "%", "^", "√", "|x|", "C->F"};

        for (String text : botones) {
            JButton button = new JButton(text); // Bucle que crea los botones de la calculadora a partir de un arreglo de cadenas.
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.matches("[0-9]") || command.equals(".")) {
                        textField.setText(textField.getText() + command);
                    } else if (command.equals("C")) {
                        textField.setText("");
                        num1 = num2 = resultado = 0;
                    } else if (command.equals("=")) {
                        num2 = Double.parseDouble(textField.getText());
                        switch (operador) { // Estructura de control para realizar la operación matemática correspondiente.
                            case "+": resultado = num1 + num2; break;
                            case "-": resultado = num1 - num2; break;
                            case "*": resultado = num1 * num2; break;
                            case "/": resultado = num2 != 0 ? num1 / num2 : 0; break;
                            case "%": resultado = num1 % num2; break;
                            case "^": resultado = Math.pow(num1, num2); break;
                        }
                        textField.setText(String.valueOf(resultado));
                    } else if (command.equals("√")) {
                        num1 = Double.parseDouble(textField.getText());
                        resultado = Math.sqrt(num1);
                        textField.setText(String.valueOf(resultado));
                    } else if (command.equals("|x|")) {