import java.awt.*;                // Importa classes do pacote AWT para lidar com elementos gráficos.
import java.awt.event.*;          // Importa classes para manipulação de eventos, como eventos de mouse.
import javax.swing.*;             // Importa classes do Swing para a interface gráfica.

public class MouseTrackerFrame extends JFrame // Define uma classe chamada MouseTrackerFrame que herda de JFrame (janela principal do Swing).
{
   private final JPanel mousePanel;           // Declara um JPanel, que é um contêiner para organizar componentes na interface.
   private final JLabel statusBar;            // Declara um JLabel, que será usado para exibir o status do mouse.

   public MouseTrackerFrame()                 // Construtor da classe MouseTrackerFrame.
   {
      super("Demonstrating Mouse Events");    // Chama o construtor da superclasse JFrame, definindo o título da janela.

      mousePanel = new JPanel();              // Cria um novo painel (JPanel) para capturar eventos de mouse.
      mousePanel.setBackground(Color.WHITE);  // Define a cor de fundo do painel para branco.
      add(mousePanel, BorderLayout.CENTER);   // Adiciona o painel ao centro do layout da janela (JFrame).

      statusBar = new JLabel("Mouse outside JPanel"); // Cria um JLabel com a mensagem inicial "Mouse outside JPanel".
      add(statusBar, BorderLayout.SOUTH);            // Adiciona a barra de status na parte inferior da janela (região SOUTH).

      MouseHandler handler = new MouseHandler();      // Cria uma instância da classe interna MouseHandler (que lida com eventos de mouse).
      mousePanel.addMouseListener(handler);           // Registra o handler para escutar eventos de mouse (cliques, entradas, saídas, etc.).
      mousePanel.addMouseMotionListener(handler);     // Registra o handler para eventos de movimento e arrasto do mouse.
   }

   // Define uma classe interna chamada MouseHandler que implementa MouseListener e MouseMotionListener.
   private class MouseHandler implements MouseListener, MouseMotionListener 
   {
      // Implementação dos métodos do MouseListener e MouseMotionListener:

      @Override
      public void mouseClicked(MouseEvent event) // Método chamado quando o mouse é clicado.
      {
         // Atualiza o statusBar com a posição do clique e as distâncias das bordas esquerda, superior, direita e inferior.
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      @Override
      public void mousePressed(MouseEvent event) // Método chamado quando o mouse é pressionado.
      {
         // Atualiza o statusBar com a posição onde o mouse foi pressionado e as distâncias das bordas.
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      @Override
      public void mouseReleased(MouseEvent event) // Método chamado quando o mouse é liberado.
      {
         // Atualiza o statusBar com a posição onde o mouse foi liberado e as distâncias das bordas.
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      @Override
      public void mouseEntered(MouseEvent event) // Método chamado quando o mouse entra no JPanel.
      {
         // Atualiza o statusBar com a posição onde o mouse entrou e as distâncias das bordas.
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
         mousePanel.setBackground(Color.GREEN);  // Muda a cor de fundo do painel para verde quando o mouse entra.
      }

      @Override
      public void mouseExited(MouseEvent event) // Método chamado quando o mouse sai do JPanel.
      {
         statusBar.setText("Mouse outside JPanel"); // Atualiza o statusBar com a mensagem "Mouse outside JPanel".
         mousePanel.setBackground(Color.WHITE);    // Muda a cor de fundo do painel de volta para branco.
      }

      @Override
      public void mouseDragged(MouseEvent event) // Método chamado quando o mouse é arrastado dentro do JPanel.
      {
         // Atualiza o statusBar com a posição onde o mouse está sendo arrastado e as distâncias das bordas.
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      @Override
      public void mouseMoved(MouseEvent event) // Método chamado quando o mouse é movido dentro do JPanel.
      {
         // Atualiza o statusBar com a posição onde o mouse se moveu e as distâncias das bordas.
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }
   }
}
