package musti;

import java.awt.Graphics;
import java.awt.Image;

public class Arkaplan {
	
	private Image arkaplanimage;
	int height;
	
	public Arkaplan(Image arkaplanimage) 
	{
		super();
		this.arkaplanimage = arkaplanimage;
		height = arkaplanimage.getHeight(null);
	}
	
	public void ciz (Graphics g,double coordinateX,int CY1, int CY2,int a,int b,int c, int d)
	{
		g.drawImage(arkaplanimage, a, b,c,d, 0+(int)coordinateX,CY1,500+(int)coordinateX ,CY2 , null);
	}

}
