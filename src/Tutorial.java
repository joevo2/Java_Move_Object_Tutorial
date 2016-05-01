import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Joel on 01/05/2016.
 */
public class Tutorial extends JPanel implements ActionListener, KeyListener{
    int x = 0, y = 0, velX = 0, velY = 0;
    Timer tm = new Timer(5, this);

    public Tutorial() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 0) {
            velX = 0;
            x = 0;
        }

        if (x > 530) {
            velX = 0;
            x = 530;
        }

        if (y < 0) {
            velY = 0;
            y = 0;
        }

        if (y > 330) {
            velY = 0;
            y = 330;
        }

        x = x + velX;
        y = y + velY;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT) {
            velX = -1;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -1;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 1;
            velY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velX = 0;
        velY = 0;
    }

    public static void main(String[] args) {
        Tutorial t = new Tutorial();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
}
