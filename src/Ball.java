import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Ball extends JComponent implements Updateable
{
	private Ellipse2D.Double ball;
	private int dx = 8, dy=0;
	
	public Ball(int x, int y)
	{
		setBounds(x,y,9,9);
		ball = new Ellipse2D.Double(0,0,10,10);
		this.setSize(11,11);
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(ball);
	}

}
