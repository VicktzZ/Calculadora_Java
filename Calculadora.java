// Importações de pacotes

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {

    // Declaração de variáveis

    JFrame janela;
    JTextField campoDeTexto;
    JButton[] numeros = new JButton[10];
    JButton[] funcoes = new JButton[8];
    JButton somaBotao, subBotao, mulBotao, divBotao;
    JButton decBotao, igualBotao, delBotao, limpBotao;
    JPanel painel;
 
    double num1=0, num2=0, resultado=0;
    char operador;

    // Método Construtor

    Calculadora() {
        janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(420, 550);
        janela.setLayout(null);
        
        campoDeTexto = new JTextField();
        campoDeTexto.setBounds(50, 25, 300, 50);
        campoDeTexto.setEditable(false);

        somaBotao = new JButton("+");
        subBotao = new JButton("-");
        mulBotao = new JButton("*");
        divBotao = new JButton("/");
        decBotao = new JButton(".");
        igualBotao = new JButton("=");
        delBotao = new JButton("Deletar");
        limpBotao = new JButton("Limpar");

        funcoes[0] = somaBotao;
        funcoes[1] = subBotao;
        funcoes[2] = mulBotao;
        funcoes[3] = divBotao;
        funcoes[4] = decBotao;
        funcoes[5] = igualBotao;
        funcoes[6] = delBotao;
        funcoes[7] = limpBotao;

        for (int i = 0; i < funcoes.length; i++) {
            funcoes[i].addActionListener(this);
            // funcoes[i].setFont(minhaFonte);
            funcoes[i].setFocusable(false);
        }

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = new JButton(String.valueOf(i));
            numeros[i].addActionListener(this);
            // numeros[i].setFont(minhaFonte);
            numeros[i].setFocusable(false);
        }

        delBotao.setBounds(50, 430, 145, 50);
        limpBotao.setBounds(205, 430, 145, 50);

        painel = new JPanel();
        painel.setBounds(50, 100, 300, 300);
        painel.setLayout(new GridLayout(4, 4, 10, 10));

        painel.add(numeros[1]);
        painel.add(numeros[2]);
        painel.add(numeros[3]);
        painel.add(somaBotao);
        painel.add(numeros[4]);
        painel.add(numeros[5]);
        painel.add(numeros[6]);
        painel.add(subBotao);
        painel.add(numeros[7]);
        painel.add(numeros[8]);
        painel.add(numeros[9]);
        painel.add(mulBotao);
        painel.add(decBotao);
        painel.add(numeros[0]);
        painel.add(igualBotao);
        painel.add(divBotao);

        janela.add(painel);
        janela.add(delBotao);
        janela.add(limpBotao);
        janela.add(campoDeTexto);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();


    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        for (int i = 0; i < 10; i++) {

            // Adicionar números ao visor

            if (e.getSource() == numeros[i]) {
                campoDeTexto.setText(campoDeTexto.getText().concat(String.valueOf(i)));
            }
        }
            // Operadores

        if (e.getSource() == decBotao) {
            campoDeTexto.setText(campoDeTexto.getText().concat("."));
        }
        if (e.getSource() == somaBotao) {
            num1 = Double.parseDouble(campoDeTexto.getText());
            operador = '+';
            campoDeTexto.setText("");
        }
        if (e.getSource() == subBotao) {
            num1 = Double.parseDouble(campoDeTexto.getText());
            operador = '-';
            campoDeTexto.setText("");
        }
        if (e.getSource() == mulBotao) {
            num1 = Double.parseDouble(campoDeTexto.getText());
            operador = '*';
            campoDeTexto.setText("");
        }
        if (e.getSource() == divBotao) {
            num1 = Double.parseDouble(campoDeTexto.getText());
            operador = '/';
            campoDeTexto.setText("");
        }
        if (e.getSource() == igualBotao) {
            num2 = Double.parseDouble(campoDeTexto.getText());
            
            // Cálculo

            switch (operador) {
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
                }

            campoDeTexto.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if (e.getSource() == limpBotao) {
            campoDeTexto.setText("");
        }
        if (e.getSource() == delBotao) {
            String string = campoDeTexto.getText();
            campoDeTexto.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                campoDeTexto.setText(campoDeTexto.getText()+string.charAt(i));
            }
        }
    }
}
