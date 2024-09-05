import javax.swing.*; // Importa o pacote Swing, que contém classes para criar interfaces gráficas em Java.

public class MouseTracker // Define a classe principal chamada 'MouseTracker'.
{
   public static void main(String[] args) // Método principal que inicia a execução do programa.
   { 
      // Cria uma instância da classe 'MouseTrackerFrame' (que provavelmente será a janela onde o rastreamento do mouse ocorrerá).
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); 
      
      // Define a ação que será tomada ao fechar a janela. Neste caso, encerra o programa quando a janela for fechada.
      mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      // Define o tamanho da janela em 300x100 pixels.
      mouseTrackerFrame.setSize(300, 100); 
      
      // Torna a janela visível na tela. Se esta linha for omitida, a janela não aparecerá.
      mouseTrackerFrame.setVisible(true); 
   } 
}
