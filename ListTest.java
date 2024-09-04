import javax.swing.*; // Importa todas as classes do pacote javax.swing, que são usadas para criar interfaces gráficas em Swing.

public class ListTest // Declara uma classe pública chamada ListTest.
{
   public static void main(String[] args) // Método main, ponto de entrada do programa Java.
   { 
      ListFrame listFrame = new ListFrame(); // Cria uma nova instância da classe ListFrame, que representa a janela da aplicação.
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento da janela ao ser fechada. Neste caso, encerra o programa quando a janela é fechada.
   } 
}
