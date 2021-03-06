package RavButton;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class RavButton extends JButton implements MouseListener
{
    boolean mouseIn = false;

public RavButton(ImageIcon s)
{
	super(s);
       
	setBorderPainted(false);
	addMouseListener(this);
        setFocusable(false);
	setContentAreaFilled(false);

}
public void paintComponent(Graphics g)
{
 	Graphics2D g2 = (Graphics2D)g;
	if (getModel().isPressed())
	{
		g.setColor(Color.WHITE);
		g2.fillRect(3,3,getWidth()-6,getHeight()-6);
	}
	super.paintComponent(g);

	if (mouseIn) g2.setColor(Color.BLACK);
		else     g2.setColor(Color.DARK_GRAY);
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setStroke(new BasicStroke(1.2f));
	g2.draw(new RoundRectangle2D.Double(1,1,(getWidth()-3),(getHeight()-3),12,8));
	g2.setStroke(new BasicStroke(1.5f));
	g2.drawLine(4,getHeight()-3,getWidth()-4,getHeight()-3);

	g2.dispose();
}
public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e)
{
	mouseIn = true;
}
public void mouseExited(MouseEvent e)
{
	mouseIn = false;
}
public void mousePressed(MouseEvent e)
{
}
public void mouseReleased(MouseEvent e)
{
}

}