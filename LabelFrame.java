import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns usadas com Swing
import javax.swing.Icon; // interface usada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens

public class LabelFrame extends JFrame // Define a classe LabelFrame que estende JFrame
{
   private final JLabel label1; // JLabel apenas com texto
   private final JLabel label2; // JLabel construído com texto e ícone
   private final JLabel label3; // JLabel com texto e ícone adicionados

   // Construtor LabelFrame adiciona JLabels ao JFrame
   public LabelFrame()
   {
      super("Testing JLabel"); // Chama o construtor da superclasse JFrame com o título "Testing JLabel"
      setLayout(new FlowLayout()); // Define o layout do frame como FlowLayout

      // Construtor JLabel com um argumento de string
      label1 = new JLabel("Label with text"); // Cria um JLabel com o texto "Label with text"
      label1.setToolTipText("This is label1"); // Define o texto do tooltip que aparece quando o mouse passa sobre o JLabel
      add(label1); // Adiciona label1 ao JFrame

      // Construtor JLabel com string, Icon e argumentos de alinhamento
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // Cria um ícone a partir da imagem "bug1.png" no mesmo pacote da classe
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT); // Cria um JLabel com texto, ícone e alinhamento do ícone à esquerda
      label2.setToolTipText("This is label2"); // Define o texto do tooltip para label2
      add(label2); // Adiciona label2 ao JFrame

      label3 = new JLabel(); // Cria um JLabel sem argumentos
      label3.setText("Label with icon and text at bottom"); // Define o texto para label3
      label3.setIcon(bug); // Define o ícone para label3
      label3.setHorizontalTextPosition(SwingConstants.CENTER); // Define a posição horizontal do texto em relação ao ícone como centralizado
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); // Define a posição vertical do texto em relação ao ícone como na parte inferior
      label3.setToolTipText("This is label3"); // Define o texto do tooltip para label3
      add(label3); // Adiciona label3 ao JFrame
   } 
} // fim da classe LabelFrame
