package gameSnake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Graphics extends JPanel implements ActionListener {

    private Timer t = new Timer(100, this);

    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g){
        t.start();
        state = "START!!";

        game = g;
        s = g.getPlayer();
        f = g.getFood();

        //add a keyListener
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;   //draws stuff in here

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.width * Game.dimention + 5, Game.height * Game.dimention + 5);

        if (state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Press Any Key", Game.width / 2 * Game.dimention - 40, Game.height / 2 * Game.dimention - 20);
        } else if (state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * Game.dimention, f.getY() * Game.dimention, Game.dimention, Game.dimention);

            g2d.setColor(Color.green);

            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        }
        else {
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (s.getBody().size() - 3), Game.width / 2 * Game.dimention - 40, Game.height / 2 * Game.dimention - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //same thing as keyListener
        //animation redrawing background
        repaint();

        game.update();

    }
}
