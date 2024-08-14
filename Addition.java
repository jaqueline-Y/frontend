import javax.swing.JOptionPane; // Importa a javax (biblioteca visual), invoca swing (módulo) , invoca JOptionPane (componente)

public class Addition // Aqui é criado a classe Addition
{
   public static void main(String[] args) // Declaração de um método (main) sem retorno, somente para leitura exportável
                                          // que recebe um parâmentro com matriz de args
   {
      // obtain user input from JOptionPane input dialogs
      String firstNumber = // Armazena o primeiro nome respectivamente.
            // Uma String em Java é uma classe que representa uma sequência de caracteres e
            // é imutável. Você pode criar strings com aspas duplas, e elas fornecem métodos
            // úteis
            // para manipulação de texto, como length(), charAt(), e substring(). Strings
            // são comparadas com o método equals(), e a concatenação é feita com o operador
            // +.
            // Para manipulação eficiente de muitas strings, use StringBuilder ou
            // StringBuffer.

            JOptionPane.showInputDialog("Enter first integer"); // ShowInputDialog exibindo uma caixa de dialogo com
                                                                // entradas de dados. Exibe uma caixa de diálogo para o
                                                                // usuário inserir um valor.
      // "Digite um valor:": Mensagem exibida na caixa de diálogo, solicitando a
      // entrada do usuário.
      // Resultado: Retorna uma string com o valor digitado pelo usuário.

      String secondNumber = // Armazena o segundo nome respectivamente.
            JOptionPane.showInputDialog("Enter second integer");

      // convert String inputs to int values for use in a calculation

      int number1 = Integer.parseInt(firstNumber); // Integer.parseInt(firstNumber): Converte a string firstNumber em um
                                                   // valor inteiro e o atribui à variável number1.
      int number2 = Integer.parseInt(secondNumber); // Integer.parseInt(secondNumber): Converte a string secondNumber em
                                                    // um valor inteiro e o atribui à variável number2.
      // Importante: Essas conversões assumem que firstNumber e secondNumber são
      // strings válidas que representam números inteiros. Se as strings não forem
      // válidas (por exemplo,
      // contiverem caracteres não numéricos), um NumberFormatException será lançado.
      int sum = number1 + number2; // int sum: Declara uma variável sum do tipo int e atribui a ela o resultado da
                                   // soma.
      // number1 + number2: Soma os valores inteiros armazenados em number1 e number2.
      // Resultado: A variável sum armazena a soma dos dois inteiros.
      // add numbers

      // display result in a JOptionPane message dialog
      JOptionPane.showMessageDialog(null, "The sum is " + sum, // Quando a "string" vem antes, qualquer coisa que eu
                                                               // concatenar (+) a direita já se converte em string.
            "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   }
}