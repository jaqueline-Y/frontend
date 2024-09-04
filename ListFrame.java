import java.awt.*; // Importa todas as classes do pacote java.awt, que contém classes para a criação de interfaces gráficas.
import javax.swing.*; // Importa todas as classes do pacote javax.swing, que contém classes para a construção de GUI usando Swing.
import javax.swing.event.*; // Importa todas as classes do pacote javax.swing.event, usadas para manipulação de eventos em Swing.

public class ListFrame extends JFrame  // Define uma classe chamada ListFrame que herda de JFrame, que é uma classe usada para criar janelas.
{
   private final JList<String> colorJList; // Declara uma lista de Strings chamada colorJList. Essa lista exibirá nomes de cores.
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"}; // Define um array de Strings com os nomes das cores.
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW}; // Define um array de objetos Color correspondentes aos nomes das cores.

   private final JList<String> sizeJList; // Declara uma lista de Strings chamada sizeJList. Essa lista exibirá tamanhos.
   private static final String[] sizeNames = {"Small", "Medium", "Big"}; // Define um array de Strings com os nomes dos tamanhos.

   public ListFrame() // Construtor da classe ListFrame.
   {
      super("List Test"); // Chama o construtor da classe JFrame e define o título da janela como "List Test".
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout, que organiza os componentes em linha.

      colorJList = new JList<String>(colorNames); // Inicializa a lista colorJList com os nomes das cores.
      colorJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista como 5.
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Define o modo de seleção da lista para selecionar um item por vez.
      add(new JScrollPane(colorJList)); // Adiciona a lista colorJList à janela dentro de um JScrollPane para permitir a rolagem.

      sizeJList = new JList<String>(sizeNames); // Inicializa a lista sizeJList com os nomes dos tamanhos.
      sizeJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista como 5.
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Define o modo de seleção da lista para selecionar um item por vez.
      add(new JScrollPane(sizeJList)); // Adiciona a lista sizeJList à janela dentro de um JScrollPane para permitir a rolagem.

      // Adiciona um listener para a lista colorJList que muda a cor de fundo da janela quando uma cor é selecionada.
      colorJList.addListSelectionListener(
         new ListSelectionListener()
         {   
            @Override
            public void valueChanged(ListSelectionEvent event) // Método chamado quando o usuário muda a seleção na lista.
            {
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]); // Define a cor de fundo da janela de acordo com a cor selecionada na lista.
            } 
         } 
      ); 

      // Adiciona um listener para a lista sizeJList que muda o tamanho da janela quando um tamanho é selecionado.
      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {   
            @Override
            public void valueChanged(ListSelectionEvent event) // Método chamado quando o usuário muda a seleção na lista.
            {
               switch (sizeJList.getSelectedIndex()) { // Verifica o índice selecionado na lista de tamanhos.
                  case 0:
                     setSize(350, 150); // Se "Small" for selecionado, define o tamanho da janela para 350x150 pixels.
                     break;

                  case 1:
                     setSize(550, 350); // Se "Medium" for selecionado, define o tamanho da janela para 550x350 pixels.
                     break;

                  case 2:
                     setSize(750, 550); // Se "Big" for selecionado, define o tamanho da janela para 750x550 pixels.
                     break;

                  default:
                     setSize(350, 150); // Se nenhum tamanho válido for selecionado, define o tamanho da janela para 350x150 pixels.
                     break;
               }
            } 
         } 
      ); 

      setSize(350, 150); // Define o tamanho inicial da janela para 350x150 pixels.
      setVisible(true); // Torna a janela visível.

   } 
}
