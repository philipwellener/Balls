import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements Updateable, ActionListener
{
	private WalkingMan man;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public WalkingFrame()
	{
		setBounds(300, 100, 700, 600);
		setLayout(null);

		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		man = new WalkingMan(50,50);
		add(man);
		addKeyListener(new KeyListener()
		{
		    public void keyPressed(KeyEvent e)
		    {
		        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		            man.setDx(3);
		        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
		        	man.setDx(-3);
		        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
		        	man.setDy(3);
		        else if(e.getKeyCode()== KeyEvent.VK_UP)
		        	man.setDy(-3);
		        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		        {
		        	balls.add(new Ball(man.getX()+20 ,man.getY()));
		        	add(balls.get(balls.size()-1)); 
		        }
		    }
		    
		    public void keyReleased(KeyEvent e) 
		    {
		        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		            man.setDx(0);
		        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
		        	man.setDx(0);
		        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
		        	man.setDy(0);
		        else if(e.getKeyCode()== KeyEvent.VK_UP)
		        	man.setDy(0);
		    }
		    
		    public void keyTyped(KeyEvent e)
		    {	
		    }
	    ;});
		Timer t1 = new Timer(1000/60,this);
		t1.start();
		
		
		setVisible(true);
	}
	
	

	public void update() 
	{
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		for(Ball b : balls)
		{
			b.update();
		}
		
		if((balls.get(balls.size())).getX()>=700)
			balls.remove(balls.size());
		if(man.getX() <= 0)
		{
			man.setDx(0);
			man.setLocation(1,man.getY());
		}
		if(man.getX()+31 >= 700)
		{
			man.setDx(0);
			man.setLocation(699-31,man.getY());
		}
		if(man.getY()+56 >=600)
		{
			man.setDy(0);
			man.setLocation(man.getX(),599-56);
		}
		if(man.getY() <=0)
		{
			man.setDy(0);
			man.setLocation(man.getX(), 1);
		}
		man.update();
		repaint();
	}

	
	public static void main(String[] args) 
	{
		new WalkingFrame();
	}







}
