// Fig. 12.20: RadioButtonTest.java
// Testando RadioButtonFrame.
import javax.swing.JFrame; // Importa a classe JFrame da biblioteca Swing, que é usada para criar a janela da aplicação.

public class RadioButtonTest  
{
   public static void main(String[] args)
   {
      // Cria uma instância de RadioButtonFrame, que deve ser uma classe que define uma janela com botões de rádio.
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();

      // Define a operação padrão ao fechar a janela, que é encerrar a aplicação.
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Define o tamanho da janela em 300 pixels de largura e 135 pixels de altura.
      radioButtonFrame.setSize(300, 135); 

      // Torna a janela visível na tela.
      radioButtonFrame.setVisible(true); 
   } 
} // fim da classe RadioButtonTest
