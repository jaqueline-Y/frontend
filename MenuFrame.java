import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame 
{
   // Array de cores para o menu
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};   
   private final JRadioButtonMenuItem[] colorItems; // Itens do menu de cores
   private final JRadioButtonMenuItem[] fonts; // Itens do menu de fontes
   private final JRadioButtonMenuItem[] tamanhos; // Itens do menu de tamanhos
   private final JCheckBoxMenuItem[] styleItems; // Itens do menu de estilo
   private final JLabel displayJLabel; // Label para exibir texto formatado
   private final ButtonGroup fontButtonGroup; // Grupo de botões para seleção de fonte
   private final ButtonGroup colorButtonGroup; // Grupo de botões para seleção de cor
   private final ButtonGroup tamanhoButtonGroup; // Grupo de botões para seleção de tamanho
   private int style; // Estilo da fonte (negrito, itálico, etc.)
   private int tamanhoAtual = 72; // Tamanho atual da fonte

   public MenuFrame()
   {
      super("Using JMenus"); // Título da janela

      // Criando o menu "File"
      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F'); // Atalho de teclado

      // Item "About"
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A');
      fileMenu.add(aboutItem);
      aboutItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // Mostra uma mensagem sobre o aplicativo
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\\n\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 

      // Item "Exit"
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x');
      fileMenu.add(exitItem);
      exitItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // Fecha o aplicativo
               System.exit(0);
            } 
         }
      ); 

      // Adicionando o menu "File" à barra de menu
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      bar.add(fileMenu);

      // Criando o menu "Format"
      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r');

      // Criando o submenu "Color"
      String[] colors = {"Black", "Blue", "Red", "Green", "Yellow"};
      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');

      // Inicializando itens de cores
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler(); // Manipulador de eventos

      // Criando e adicionando itens de cores ao menu
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = new JRadioButtonMenuItem(colors[count]);
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]);
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // Seleciona a cor preta por padrão

      formatMenu.add(colorMenu); // Adiciona o menu de cores ao menu de formato
      formatMenu.addSeparator(); // Adiciona um separador

      // Criando o submenu "Font"
      String[] fontNames = {"Serif", "Monospaced", "SansSerif", "Arial"};
      JMenu fontMenu = new JMenu("Font");
      fontMenu.setMnemonic('n');

      // Inicializando itens de fonte
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup();

      // Criando e adicionando itens de fontes ao menu
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]);
         fonts[count].addActionListener(itemHandler);
      } 

      fonts[0].setSelected(true); // Seleciona a fonte "Serif" por padrão
      fontMenu.addSeparator(); // Adiciona um separador

      // Criando itens de estilo (negrito, itálico, sublinhado)
      String[] styleNames = {"Bold", "Italic", "Underline"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler();

      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
         fontMenu.add(styleItems[count]);
         styleItems[count].addItemListener(styleHandler);
      }

      formatMenu.add(fontMenu); // Adiciona o menu de fontes ao menu de formato

      formatMenu.addSeparator(); // Adiciona um separador

      // Criando o submenu "Tamanho"
      int[] tamanhoint = {72, 52, 22}; 
      JMenu tamanhoMenu = new JMenu("Tamanho"); 
      tamanhoMenu.setMnemonic('T'); 

      tamanhos = new JRadioButtonMenuItem[tamanhoint.length]; 
      tamanhoButtonGroup = new ButtonGroup(); 

      // Criando e adicionando itens de tamanho ao menu
      for (int count = 0; count < tamanhos.length; count++) 
      {
         tamanhos[count] = new JRadioButtonMenuItem(String.valueOf(tamanhoint[count])); 
         tamanhoMenu.add(tamanhos[count]); 
         tamanhoButtonGroup.add(tamanhos[count]); 
         tamanhos[count].addActionListener(itemHandler); 
      }

      tamanhos[0].setSelected(true); // Seleciona o tamanho 72 por padrão
      formatMenu.add(tamanhoMenu); // Adiciona o menu de tamanhos ao menu de formato

      // Configurando a label para exibir o texto
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]); // Define a cor inicial
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, tamanhoAtual)); // Define a fonte inicial

      // Configurando o fundo da janela
      getContentPane().setBackground(Color.CYAN);
      add(displayJLabel, BorderLayout.CENTER); // Adiciona a label ao centro da janela
   }

   // Classe interna para manipular eventos de itens de menu
   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // Atualiza a cor do texto com base na seleção
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // Atualiza a fonte com base na seleção
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, tamanhoAtual));
            }
         }

         // Atualiza estilo e tamanho do texto
         negritoItalico();
         sublinharTexto();
         tamanhoTexto();
         repaint(); // Redesenha a interface
      } 
   }

   // Classe interna para manipular eventos de estilo
   private class StyleHandler implements ItemListener 
   {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         // Atualiza estilo e tamanho do texto
         negritoItalico();
         sublinharTexto();
         tamanhoTexto();
         repaint(); // Redesenha a interface
      }
   }

   // Atualiza o estilo da fonte (negrito/itálico)
   public void negritoItalico() {
      String name = displayJLabel.getFont().getName();
      Font font;

      if (styleItems[0].isSelected() && 
           styleItems[1].isSelected())
         font = new Font(name, Font.BOLD + Font.ITALIC, tamanhoAtual);
      else if (styleItems[0].isSelected())
         font = new Font(name, Font.BOLD, tamanhoAtual);
      else if (styleItems[1].isSelected())
         font = new Font(name, Font.ITALIC, tamanhoAtual);
      else
         font = new Font(name, Font.PLAIN, tamanhoAtual);

      displayJLabel.setFont(font); // Aplica a nova fonte
   }

   // Atualiza o texto para sublinhado
   public void sublinharTexto() {
      if (styleItems[2].isSelected()) {
         displayJLabel.setText("<html><u>" + displayJLabel.getText() + "</u></html>"); // Aplica sublinhado
      }
   }

   // Atualiza o tamanho da fonte com base na seleção
   public void tamanhoTexto() {
      for (int count = 0; count < tamanhos.length; count++) 
      {
         if (
