// Fig. 12.22: ComboBoxTest.java
// Testa a classe ComboBoxFrame.

import javax.swing.JFrame; // Importa a classe JFrame necessária para criar uma janela

// Define a classe ComboBoxTest, que não estende nenhuma outra classe
public class ComboBoxTest
{
   // Método main que é o ponto de entrada do programa
   public static void main(String[] args)
   { 
      // Cria uma instância da classe ComboBoxFrame
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); 
      
      // Define o comportamento de fechamento da janela
      // Quando a janela for fechada, o programa será encerrado
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Define o tamanho da janela (largura: 350 pixels, altura: 150 pixels)
       
   } 
} // Fim da classe ComboBoxTest

