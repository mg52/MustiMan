package musti;

import java.awt.Graphics;
import java.awt.Image;

public class Coin {
	
private Image coin;
boolean yendimi = false;
	
	public Coin(Image coin,boolean yendimi) 
	{
		super();
		this.coin = coin;
		this.yendimi = yendimi;
	}
	
	public void ciz (Graphics g, int coincoorX, int coincoorY , int x)
	{
		if(!yendimi)g.drawImage(coin, coincoorX, coincoorY, coincoorX+22, coincoorY+20, 0+(x*44),0,44+(x*44),40 , null);
	}

} 
