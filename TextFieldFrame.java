import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Classe TextFieldFrame que herda de JFrame, criando uma janela com campos de texto e senha
public class TextFieldFrame extends JFrame 
{
   // Campos de texto e senha
   private final JTextField textField1;
   private final JTextField textField2;
   private final JTextField textField3;
   private final JPasswordField passwordField;

   // Construtor da classe TextFieldFrame
   public TextFieldFrame()
   {
      super("Testing JTextField and JPasswordField");  // Define o título da janela
      setLayout(new FlowLayout());  // Define o layout da janela como FlowLayout

      // Inicializa o primeiro campo de texto e adiciona à janela
      textField1 = new JTextField(10); 
      add(textField1);

      // Inicializa o segundo campo de texto com um texto inicial e adiciona à janela
      textField2 = new JTextField("Enter your text here now");
      add(textField2);

      // Inicializa o terceiro campo de texto com texto inicial e define-o como não editável
      textField3 = new JTextField("Uneditable text field", 21);
      textField3.setEditable(false);
      add(textField3);

      // Inicializa o campo de senha com texto inicial e adiciona à janela
      passwordField = new JPasswordField("Hidden text");
      add(passwordField);

      // Cria um handler para tratar eventos nos campos de texto e senha
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);  // Adiciona o handler ao textField1
      textField2.addActionListener(handler);  // Adiciona o handler ao textField2
      textField3.addActionListener(handler);  // Adiciona o handler ao textField3
      passwordField.addActionListener(handler);  // Adiciona o handler ao passwordField
   }

   // Classe interna para tratar eventos de ação nos campos de texto e senha
   private class TextFieldHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = "";  // String para armazenar a mensagem a ser exibida
         
         // Verifica qual campo gerou o evento e formata a mensagem com o texto do campo
         if (event.getSource() == textField1)
            string = String.format("textField1: %s",
               event.getActionCommand());

         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // Exibe uma caixa de diálogo com a mensagem formatada
         JOptionPane.showMessageDialog(null, string);
      }
   }
}
