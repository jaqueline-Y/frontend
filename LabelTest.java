// Fig. 12.7: LabelTest.java
// Testing LabelFrame.
import javax.swing.JFrame; // Importa a classe JFrame da biblioteca Swing para manipulação de janelas

public class LabelTest // Define a classe LabelTest
{
   public static void main(String[] args) // Método principal que é o ponto de entrada da aplicação
   { 
      LabelFrame labelFrame = new LabelFrame(); // Cria uma instância de LabelFrame, que é a janela que será exibida
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento da janela para encerrar a aplicação quando a janela for fechada
      labelFrame.setSize(360, 280); // Define o tamanho da janela para 360 pixels de largura e 280 pixels de altura
      labelFrame.setVisible(true); // Torna a janela visível na tela
   } 
} // fim da classe LabelTest
