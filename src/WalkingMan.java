import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;


import javax.swing.JComponent;
import javax.swing.JFrame;

public class WalkingMan extends JComponent implements Updateable
{
	private Ellipse2D.Double head;
	private Rectangle leftArm, rightArm, leftLeg, rightLeg, body;
	private int dx = 0, dy = 0;
	
	public  WalkingMan(int x, int y)
	{
		this.setLocation(x,y);
		this.setSize(31,56);
		
		head = new Ellipse2D.Double(10, 0, 10, 10);
		leftArm = new Rectangle(0, 10, 10, 7);
		rightArm = new Rectangle(20, 10, 10, 7);
		leftLeg = new Rectangle(2, 35, 8, 15);
		rightLeg = new Rectangle(20, 35, 8, 15);
		body  =  new  Rectangle(10, 10, 10, 30);
	}
	
	public void setDx(int x)
	{
		dx = x;
	}
	
	public void setDy(int y)
	{
		dy = y;
	}
	
	public void update()
	{
		setLocation(getX()+dx, getY()+dy);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(body);
		g2.fill(leftArm);
		g2.fill(rightArm);
		g2.fill(leftLeg);
		g2.fill(rightLeg);
		g2.fill(head);
	}

}
