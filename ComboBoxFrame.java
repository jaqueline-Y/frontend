// Fig. 12.21: ComboBoxFrame.java
// Importa as classes necessárias para criar a interface gráfica
import java.awt.*; // Layout para organizar os componentes
import java.awt.event.*; // Interface para lidar com eventos de seleção de itens
import javax.swing.*; // Classes para criar e manipular componentes Swing, como JComboBox e JLabel

// Define a classe ComboBoxFrame que estende JFrame para criar uma janela
public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // ComboBox que armazena os nomes dos ícones
   private final JLabel label; // Rótulo para exibir o ícone selecionado

   // Array de nomes dos arquivos de ícones
   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif" , "OIP.jfif"};

   // Array de ícones correspondentes aos nomes
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])), // Cria um ícone a partir do primeiro arquivo
      new ImageIcon(getClass().getResource(names[1])), // Cria um ícone a partir do segundo arquivo
      new ImageIcon(getClass().getResource(names[2])), // Cria um ícone a partir do terceiro arquivo
      new ImageIcon(getClass().getResource(names[3])),
      new ImageIcon(getClass().getResource(names[4])),  // Cria um ícone a partir do quarto arquivo
   };

   // Construtor da classe ComboBoxFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      // Cria e configura a JComboBox com os nomes dos ícones
      imagesJComboBox = new JComboBox<String>(names);
      imagesJComboBox.setMaximumRowCount(2); // Define o número máximo de linhas visíveis na lista

      // Adiciona um ItemListener para lidar com eventos de seleção de itens na JComboBox
      imagesJComboBox.addItemListener(
         new ItemListener() // Classe interna anônima para ouvir eventos de item
         {
            // Método que lida com eventos de seleção de itens
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // Verifica se o estado do item foi alterado para selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  // Atualiza o ícone no JLabel com base no índice do item selecionado na JComboBox
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } // Fim da classe interna anônima
      ); // Fim da chamada para addItemListener

      // Adiciona a JComboBox à janela
      add(imagesJComboBox);
      
      // Inicializa o JLabel com o primeiro ícone e adiciona à janela
      label = new JLabel(icons[0]); // Exibe o primeiro ícone por padrão
      add(label);

      setSize(350, 350); 
      
      // Torna a janela visível
      setVisible(true);
   } // Fim do construtor ComboBoxFrame
} // Fim da classe ComboBoxFrame
