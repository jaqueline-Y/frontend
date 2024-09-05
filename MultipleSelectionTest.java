// Fig. 12.26: MultipleSelectionTest.java
// Testing MultipleSelectionFrame.
import javax.swing.JFrame;  // Importa a classe JFrame para criar a janela principal.

public class MultipleSelectionTest  // Define a classe principal que contém o método main.
{
   public static void main(String[] args)  // Método main, ponto de entrada da aplicação.
   { 
      // Cria uma instância de MultipleSelectionFrame, que é a janela principal da aplicação.
      MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame(); 
      
      // Define a operação padrão para quando a janela for fechada.
      // Neste caso, JFrame.EXIT_ON_CLOSE significa que o programa será encerrado ao fechar a janela.
      multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Define o tamanho da janela (largura: 350 pixels, altura: 150 pixels).
      multipleSelectionFrame.setSize(350, 150); 
      
      // Torna a janela visível na tela.
      multipleSelectionFrame.setVisible(true); 
   } 
} // end class MultipleSelectionTest
