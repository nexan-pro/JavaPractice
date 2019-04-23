package Events.task_1;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demonstrator extends JFrame implements Observer {

  private JTextPane editor;
  private JScrollPane editorScrollPane;

  Demonstrator() {

    super("Events");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 330);
    this.getContentPane().setBackground(Color.darkGray);
    createGUI();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void createGUI() {
    try {
      editor = new JTextPane();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    setLayout(new FlowLayout());
    editor.setContentType("text");
    editor.setBackground(Color.BLACK);
    editor.setForeground(Color.green);
    editor.setPreferredSize(new Dimension(150, 250));
    editor.setEditable(false);
    editorScrollPane = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    add(editorScrollPane);

    JButton jBtn = new JButton();
    jBtn.setText("Stop");
    jBtn.setSize(new Dimension(75, 45));
    jBtn.setVisible(true);
    jBtn.setBackground(Color.BLACK);
    jBtn.setForeground(Color.cyan);
    jBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("simple action");
        Calculator.stop();
      }
    });
    add(jBtn);
  }

  private void append(String s) {
    try {
      Document doc = editor.getDocument();
      doc.insertString(doc.getLength(), s, null);
    } catch(BadLocationException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void update(long s, int n, int k) {
    String sStirlingLine = "s(" + n + ", " + k + ") = " + s + "\n";
    append(sStirlingLine);
  }

}
