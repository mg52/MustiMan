package musti;

import java.awt.Graphics;
import java.awt.Image;

public class Canavar {

	private Image canavar;
	int canavarYurumeHizi;
	boolean canavaryonu = false;//false sol tarafa doðru. true sað tarafa doðru.
	int canavarbaslamanoktasi;
	int a = 1;
	
	public Canavar(Image canavar, int canavarYurumeHizi) 
	{
		super();
		this.canavar = canavar;
		this.canavarYurumeHizi = canavarYurumeHizi;

		
	}
	public void ciz (Graphics g, int coincoorX, int coincoorY , int x)
	{
		g.drawImage(canavar, canavarbaslamanoktasi-coincoorX-canavarYurumeHizi*a, coincoorY, canavarbaslamanoktasi-coincoorX+50-canavarYurumeHizi*a, coincoorY+50, 0+(x*100),0,100+(x*100),100 , null);
		if(!canavaryonu)a++;
		else a--;

	}
}
