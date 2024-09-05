import javax.swing.JFrame;

// Classe TextFieldTest que contém o método main para iniciar a aplicação
public class TextFieldTest
{
   public static void main(String[] args)
   { 
      // Cria uma instância da classe TextFieldFrame
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      
      // Define a operação a ser realizada quando a janela for fechada (encerrar a aplicação)
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Define o tamanho da janela (largura: 350, altura: 100)
      textFieldFrame.setSize(350, 100); 
      
      // Torna a janela visível
      textFieldFrame.setVisible(true); 
   } 
}
