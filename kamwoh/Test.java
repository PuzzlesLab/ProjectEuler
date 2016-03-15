

package projecteuler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Woh
 */
public class Test extends JPanel {

    private int y = 0;
    private boolean turn = true;
    
    public Test()
    {
        this.setPreferredSize(new Dimension(300,300));
        this.setVisible(true);
        //this.getContentPane().setBackground(Color.BLACK);
    }
    
    public static void main(String[] args)
    {
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setLayout(new BorderLayout());
        //j.getContentPane().add(new JButton());
        Test t = new Test();
        j.getContentPane().add(t,BorderLayout.CENTER);
        //j.getContentPane().setBackground(Color.BLACK);
        j.pack();
        j.setVisible(true);
        /*while(true)
        {
            System.out.println("s");
            t.up();
            t.repaint();
        }*/
    }

    public void up()
    {
        System.out.println("y");
        if(turn)
            y++;
        else
            y--;
        
        if(y==this.getHeight())
            turn=false;
        if(y==0)
            turn=true;
    }
    
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        System.out.println("aa");
        //g.setColor(Color.BLACK);
        //g.drawLine(5, 0, this.getWidth(), y);
        g.drawString("sdfsdf", 0, 15);
    }
    
    
    
}
