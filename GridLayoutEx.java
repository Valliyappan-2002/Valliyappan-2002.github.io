
package Calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridLayoutEx extends JFrame implements ActionListener
{
  JPanel panel;
  JTextField res;
  JButton[] buttons;
  String dataout = " ";
  GridLayoutEx()
  {
     setSize(430,560);
     setLayout(null);
     this.setBackground(Color.white);
     setTitle("Calculator");
     setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     addCalcFrame();
     setVisible(true);
  }

  void addCalcFrame()
  {
     panel = new JPanel(new GridBagLayout());
     panel.setBounds(5,5,400,500);
     panel.setPreferredSize(new Dimension(400,500));
     panel.setBackground(Color.gray);
     panel.setBorder(BorderFactory.createLineBorder(Color.black,2));
     addFields();
     add(panel);
  }

   void addFields()
  {
    int number = 0;
    GridBagConstraints cons = new GridBagConstraints();
   
    buttons  = new JButton[17];
    for(int i = 0; i < 10; i++)
      buttons[i] = new JButton(String.valueOf(i));
    addResultField();
    buttons[10] = new JButton(" + ");
    buttons[11] = new JButton(" - " );
    buttons[12] = new JButton(" * ");
    buttons[13] = new JButton(" / ");
    buttons[14] = new JButton(" % " );
    buttons[15] = new JButton(" Clear " );
    buttons[16] = new JButton(" = "); 
   
    for(int i = 1; i <= 4; i++)
    {
       for(int j = 0; j < 4; j++)
       {
          cons.fill = GridBagConstraints.HORIZONTAL;
          cons.gridx = j;
          cons.gridy = i;
          cons.ipadx  = 45;  cons.ipady  = 47;
          switch(number)
          {
            case 0 : panel.add(buttons[1] ,cons);
                          break;
            case 1 : panel.add(buttons[2],cons);
                          break;
            case 2 : panel.add(buttons[3] ,cons);
                          break;
            case 3 : panel.add(buttons[0],cons);
                          break;
            case 4 : panel.add(buttons[4] ,cons);
                          break;
            case 5 : panel.add(buttons[5],cons);
                          break;
            case 6 : panel.add(buttons[6] ,cons);
                          break;
            case 7 : panel.add(buttons[10],cons);
                          break;
            case 8 : panel.add(buttons[7] ,cons);
                          break;
            case 9 : panel.add(buttons[8],cons);
                          break;
            case 10 : panel.add(buttons[9] ,cons);
                           break;
            case 11 : panel.add(buttons[11],cons);
                          break;
            case 12 : panel.add(buttons[12] ,cons);
                          break;
            case 13 : panel.add(buttons[13],cons);
                          break;
            case 14 : panel.add(buttons[14] ,cons);
                           break;
            case 15 :panel.add(buttons[15],cons);
                         break; 
            default : System.out.println("Error Occured : " );  
                           break;
        }
   number++;
    }
  }
    cons.fill = GridBagConstraints.HORIZONTAL;
    cons.gridx = 0;
    cons.gridy = 6;
    cons.gridwidth = 5;
    panel.add(buttons[16],cons);

    for(int i = 0; i < 17; i++)
       buttons[i].addActionListener(this);
  }       

  void addResultField()
  {
    GridBagConstraints cons = new GridBagConstraints();
    cons.fill = GridBagConstraints.HORIZONTAL;
    cons.gridx = 0;
    cons.gridy = 0;
    cons.gridwidth = 5;
    cons.weighty = 0.2;
    res = new JTextField();
    res.setPreferredSize(new Dimension(0,75));
    panel.add(res,cons);
  }

  public void actionPerformed(ActionEvent ae)
  {
     try { JButton temp = (JButton)ae.getSource();
     if(temp.getLabel().equals(" = "))
     {
         ConvertInfix calc = new ConvertInfix(dataout);
         dataout = String.valueOf(calc.performConversion());
         System.out.println(dataout);
         res.setText(dataout);
     }
     else {
     dataout += temp.getLabel();
     res.setText(dataout); }
     } catch(Exception ex)
     {
        res.setText(" Error " +ex);System.out.println(dataout);
      }
 }

  public static void main(String[] str)
  {
    SwingUtilities.invokeLater(new Runnable(){
    public void run(){
       new GridLayoutEx();
    }});
   }
}
   