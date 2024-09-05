// Fig. 12.25: MultipleSelectionFrame.java
// JList that allows multiple selections.
import java.awt.FlowLayout;                // Importa o layout FlowLayout para organizar os componentes.
import java.awt.event.ActionListener;      // Importa a interface para tratar eventos de ação, como cliques de botão.
import java.awt.event.ActionEvent;         // Importa a classe ActionEvent, que representa um evento de ação.
import javax.swing.JFrame;                 // Importa a classe JFrame para criar a janela principal da aplicação.
import javax.swing.JList;                  // Importa a classe JList para criar listas de itens.
import javax.swing.JButton;                // Importa a classe JButton para criar botões.
import javax.swing.JScrollPane;            // Importa a classe JScrollPane para adicionar barras de rolagem à lista.
import javax.swing.ListSelectionModel;     // Importa a classe para definir o modo de seleção da lista.

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList; // Declara um JList para exibir nomes de cores.
   private final JList<String> copyJList;  // Declara outro JList para exibir as cores copiadas.
   private JButton copyJButton;            // Declara um JButton para permitir a cópia das seleções.
   private static final String[] colorNames = {"Black", "Blue", "Cyan", // Array com os nomes das cores.
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   // Construtor da classe MultipleSelectionFrame
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");    // Define o título da janela.
      setLayout(new FlowLayout());          // Define o layout da janela como FlowLayout.

      colorJList = new JList<String>(colorNames); // Inicializa o JList com o array de nomes de cores.
      colorJList.setVisibleRowCount(5);           // Define o número de linhas visíveis na lista como 5.
      colorJList.setSelectionMode(               // Define o modo de seleção para múltiplos intervalos.
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList));           // Adiciona o JList ao JFrame dentro de um JScrollPane (barra de rolagem).

      copyJButton = new JButton("Copy >>>");      // Cria um botão com o texto "Copy >>>".
      copyJButton.addActionListener(              // Adiciona um ActionListener ao botão.
         new ActionListener() // Classe interna anônima para tratar eventos de clique do botão.
         {  
            // Método chamado quando o botão é clicado.
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // Copia os itens selecionados de colorJList para copyJList.
               copyJList.setListData(                    // Define os dados de copyJList.
                  colorJList.getSelectedValuesList().toArray( // Converte os itens selecionados em um array de Strings.
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); // Adiciona o botão de cópia ao JFrame.

      copyJList = new JList<String>();            // Inicializa o JList para exibir os itens copiados.
      copyJList.setVisibleRowCount(5);            // Define o número de linhas visíveis na lista como 5.
      copyJList.setFixedCellWidth(100);           // Define a largura fixa das células como 100 pixels.
      copyJList.setFixedCellHeight(15);           // Define a altura fixa das células como 15 pixels.
      copyJList.setSelectionMode(                 // Define o modo de seleção para um único intervalo.
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList));            // Adiciona o JList ao JFrame dentro de um JScrollPane.
   } 
} // fim da classe MultipleSelectionFrame
