package musti;

import java.awt.Graphics;
import java.awt.Image;

public class Top {
	
	private Image top;
	
	public Top(Image top) 
	{
		super();
		this.top = top;
	}
	
	public void ciz (Graphics g, int coordinateX, int coordinateY,int x, int y)
	{
		g.drawImage(top, 225+coordinateX, 175+coordinateY,300+coordinateX,250+coordinateY, x,y,x+144,y+144 , null);
	}

}
