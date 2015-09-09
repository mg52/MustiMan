package musti;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MusPanel extends JPanel implements ActionListener, KeyListener,MouseListener{

	private static boolean[] keyboardState = new boolean[525];
	private Image arkaplan,top,grass1,grass2,grass3,grass4,coin,magma,canavar,baslangic,oyunbittiresim,oyuntamamlandiresim;
	double coorx = 0;
	int grassX = 0,topy = 0,topx = 0, artismiktari = 5,yenencoinsayisi = 0,canavarSprite = 0;
	int stopingSpeed = 1,speedD,speedA,speedY = 15,ivme = 1,adamSpriteSayisi = 0;
	int can = 3,spriteX = 0,spriteY = 0,dusmehizi = 1,ziplamahizi = 15,grasssecim = 0,coinX,coinY,coinSprite = 0;
	boolean oyuntamamlandiiki = false,oyuntamamlandi = false,oyunbitti = false,ziplamaAktif = false,cukuradustu = false,ziplamareleased = true,adamOldu = false,hangitusabasildi = true,oyunbaslangic = true;
	Arkaplan yeniarkaplan,yenigrass1,yenigrass2,yenigrass3,yenigrass4;
	Top yenitop;
	Coin yenicoin,yenicoin2,yenicoin3,yenicoin4,yenicoin5,yenicoin6,yenicoin7,yenicoin8,yenicoin9,yenicoin10,yenicoin11,yenicoin12,yenicoin13,yenicoin14,yenicoin15,yenicoin16,yenicoin17,yenicoin18,yenicoin19;
	Canavar yenicanavar,yenicanavar2,yenicanavar3,yenicanavar4,yenicanavar5;
	
	public MusPanel() 
	{
		super();
		addKeyListener(this);
		addMouseListener(this);
		
		URL mountainsUrl = this.getClass().getResource("/images/clouds.png");
		URL magmaUrl = this.getClass().getResource("/images/magma.png");
		URL grassUrl1 = this.getClass().getResource("/images/grass1.png");
		URL grassUrl2 = this.getClass().getResource("/images/grass2.png");
		URL grassUrl3 = this.getClass().getResource("/images/grass3.png");
		URL grassUrl4 = this.getClass().getResource("/images/grass4.png");
		URL topUrl = this.getClass().getResource("/images/hero.png");
		URL coinUrl = this.getClass().getResource("/images/coin.png");
		URL canavarUrl = this.getClass().getResource("/images/monsterSpriteSheet.png");
		URL baslangicUrl = this.getClass().getResource("/images/baslangic.png");
		URL oyunbittiresimUrl = this.getClass().getResource("/images/oyunbittiresim.png");
		URL oyuntamamlandiresimUrl = this.getClass().getResource("/images/oyuntamamlandiresim.png");
		
		try
		{
			arkaplan = ImageIO.read(mountainsUrl);	
			top = ImageIO.read(topUrl);
			grass1 = ImageIO.read(grassUrl1);
			grass2 = ImageIO.read(grassUrl2);
			grass3 = ImageIO.read(grassUrl3);
			grass4 = ImageIO.read(grassUrl4);
			coin = ImageIO.read(coinUrl);
			magma = ImageIO.read(magmaUrl);
			canavar = ImageIO.read(canavarUrl);
			baslangic = ImageIO.read(baslangicUrl);
			oyunbittiresim = ImageIO.read(oyunbittiresimUrl);
			oyuntamamlandiresim = ImageIO.read(oyuntamamlandiresimUrl);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		yeniarkaplan = new Arkaplan(arkaplan);
		yenigrass1 = new Arkaplan(grass1);
		yenigrass2 = new Arkaplan(grass2);
		yenigrass3 = new Arkaplan(grass3);
		yenigrass4 = new Arkaplan(grass4);
		yenicoin = new Coin(coin,false);
		yenicoin2 = new Coin(coin,false);
		yenicoin3 = new Coin(coin,false);
		yenicoin4 = new Coin(coin,false);
		yenicoin5 = new Coin(coin,false);
		yenicoin6 = new Coin(coin,false);
		yenicoin8 = new Coin(coin,false);
		yenicoin9 = new Coin(coin,false);
		yenicoin10 = new Coin(coin,false);
		yenicoin11= new Coin(coin,false);
		yenicoin12= new Coin(coin,false);
		yenicoin13= new Coin(coin,false);
		yenicoin14= new Coin(coin,false);
		yenicoin15= new Coin(coin,false);
		yenicoin16= new Coin(coin,false);
		yenicoin17= new Coin(coin,false);
		yenicoin18= new Coin(coin,false);
		yenicoin19= new Coin(coin,false);
		yenicoin7 = new Coin(coin,false);
		
		yenicanavar = new Canavar(canavar,2);
		yenicanavar2 = new Canavar(canavar,2);
		yenicanavar3 = new Canavar(canavar,2);
		yenicanavar4 = new Canavar(canavar,2);
		yenicanavar5 = new Canavar(canavar,1);
		
		yenicanavar.canavarbaslamanoktasi = 500;
		yenicanavar2.canavarbaslamanoktasi = 1200;
		yenicanavar3.canavarbaslamanoktasi = 1500;
		yenicanavar4.canavarbaslamanoktasi = 1730;
		yenicanavar5.canavarbaslamanoktasi = 2070;
		
		yenitop = new Top(top);
		
		Timer zaman = new Timer(20,this);
		zaman.start();
	}
	
	public static boolean keyboardKeyState(int key)
	{
	    return keyboardState[key];
	}
	

	
	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(oyunbaslangic && !oyuntamamlandiiki)
		{
			g.drawImage(baslangic, 0, 0, this);
		}
		else if(!oyunbitti && !oyuntamamlandiiki)
		{
		g.drawImage(magma, 0, 0, this);
		yeniarkaplan.ciz(g,coorx,0,200,-500,50,500,250);
		
		if(grasssecim/5 == 0)yenigrass1.ciz(g, grassX,0,350,0,0,500,250);
		else if(grasssecim/5 == 1)yenigrass2.ciz(g, grassX,0,350,0,0,500,250);
		else if(grasssecim/5 == 2)yenigrass3.ciz(g, grassX,0,350,0,0,500,250);
		else if(grasssecim/5 == 3)yenigrass4.ciz(g, grassX,0,350,0,0,500,250);
		//yenigrass1.ciz(g, grassX,0,350,0,0,500,250);
		
		yenicoin.ciz(g,550-grassX,120,coinSprite);
		yenicoin2.ciz(g,600-grassX,120,coinSprite);
		yenicoin3.ciz(g,650-grassX,120,coinSprite);
		yenicoin4.ciz(g,900-grassX,120,coinSprite);
		yenicoin5.ciz(g,950-grassX,120,coinSprite);
		yenicoin6.ciz(g,1000-grassX,50,coinSprite);
		yenicoin7.ciz(g,830-grassX,120,coinSprite);
		yenicoin8.ciz(g,1205-grassX,120,coinSprite);
		yenicoin9.ciz(g,1250-grassX,180,coinSprite);
		yenicoin10.ciz(g,1355-grassX,180,coinSprite);
		yenicoin11.ciz(g,1410-grassX,120,coinSprite);
		yenicoin12.ciz(g,1500-grassX,180,coinSprite);
		yenicoin13.ciz(g,1560-grassX,50,coinSprite);
		yenicoin14.ciz(g,1580-grassX,120,coinSprite);
		yenicoin15.ciz(g,1660-grassX,120,coinSprite);
		yenicoin16.ciz(g,1700-grassX,180,coinSprite);
		yenicoin17.ciz(g,1740-grassX,120,coinSprite);
		yenicoin18.ciz(g,1885-grassX,120,coinSprite);
		yenicoin19.ciz(g,2015-grassX,120,coinSprite);
		
		yenicanavar.ciz(g, grassX, 200, canavarSprite);
		yenicanavar2.ciz(g, grassX, 200, canavarSprite);
		yenicanavar3.ciz(g, grassX, 200, canavarSprite);
		yenicanavar4.ciz(g, grassX, 200, canavarSprite);
		yenicanavar5.ciz(g, grassX, 200, canavarSprite);
		
		//System.out.println("canavarYurumeHizi: "+(500-grassX-yenicanavar.canavarYurumeHizi));
		
		yenitop.ciz(g,topx,topy,spriteX,spriteY);
		
		g.drawString("Altýn : " + yenencoinsayisi , 20, 40);
		g.drawString("Can : " + can , 20, 20);
		
		//System.out.println(yenicanavar2.canavarbaslamanoktasi-yenicanavar2.canavarYurumeHizi*yenicanavar2.a);
		}
		else if(oyunbitti && !oyuntamamlandiiki)
		{
			g.drawImage(oyunbittiresim, 0, 0, this);
		}
		else if(oyuntamamlandiiki)
		{
			g.drawImage(oyuntamamlandiresim, 0, 0, this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyboardState[e.getKeyCode()] = true;
		if(oyunbaslangic)
		{
			if(keyboardKeyState(KeyEvent.VK_ENTER))
			{
				oyunbaslangic = false;
				repaint();
			}
		}
		else
		{
		if(keyboardKeyState(KeyEvent.VK_W))	
		{
			if(ziplamareleased)if(topy == 0 || topy == -79)ziplamaAktif = true;	
			ziplamareleased = false;
		}
		}
		if(keyboardKeyState(KeyEvent.VK_ESCAPE))
		{
			can = 3;
			oyunbitti = false;
			oyunbaslangic = true;
			reset();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyboardState[e.getKeyCode()] = false;
		ziplamareleased = true;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void reset()
	{
		 coorx = 0;
		 grassX = 0;topy = 0;topx = 0; artismiktari = 5;
		 stopingSpeed = 1; speedD = 0;speedA = 0; speedY = 15;ivme = 1;
		 spriteX = 0;spriteY = 0;dusmehizi = 1;
		 ziplamaAktif = false;cukuradustu = false;
		 adamSpriteSayisi = 0;
		 //can = 3;
				 
		 yenicoin.yendimi = false;
		 yenicoin2.yendimi = false;
		 yenicoin3.yendimi = false;
		 yenicoin4.yendimi = false;
		 yenicoin5.yendimi = false;
		 yenicoin6.yendimi = false;
		 yenicoin7.yendimi = false;
		 yenicoin8.yendimi = false;
		 yenicoin9.yendimi = false;
		 yenicoin10.yendimi = false;
		 yenicoin11.yendimi = false;
		 yenicoin12.yendimi = false;
		 yenicoin13.yendimi = false;
		 yenicoin14.yendimi = false;
		 yenicoin15.yendimi = false;
		 yenicoin16.yendimi = false;
		 yenicoin17.yendimi = false;
		 yenicoin18.yendimi = false;
		 yenicoin19.yendimi = false;
		 
		 yenicanavar.canavarYurumeHizi = 2;
		 yenicanavar2.canavarYurumeHizi = 2;
		 yenicanavar3.canavarYurumeHizi = 2;
		 yenicanavar4.canavarYurumeHizi = 2;
		 yenicanavar5.canavarYurumeHizi = 1;
		 
		 yenicanavar.a = 1;
		 yenicanavar2.a = 1;
		 yenicanavar3.a = 1;
		 yenicanavar4.a = 1;
		 yenicanavar5.a = 1;
		 
		 yenicanavar.canavaryonu = false;
		 yenicanavar2.canavaryonu = false;
		 yenicanavar3.canavaryonu = false;
		 yenicanavar4.canavaryonu = false;
		 yenicanavar5.canavaryonu = false;

		 adamOldu = false;
		 hangitusabasildi = true;
		 oyuntamamlandi = false;
		 oyuntamamlandiiki = false;
		 
		 yenencoinsayisi = 0;
		 
		 if(can == 0)
		 {
			 oyunbitti = true;		 
			 repaint();
		 }
		 
	}
	
	public void canavaryonutespiti()
	{
		if(yenicanavar.canavarbaslamanoktasi-yenicanavar.canavarYurumeHizi*yenicanavar.a == 300)
		{
			yenicanavar.canavaryonu = true;
		}
		if(yenicanavar.canavarbaslamanoktasi-yenicanavar.canavarYurumeHizi*yenicanavar.a == yenicanavar.canavarbaslamanoktasi)
		{
			yenicanavar.canavaryonu = false;
		}
		
		if(yenicanavar2.canavarbaslamanoktasi-yenicanavar2.canavarYurumeHizi*yenicanavar2.a == 900)
		{
			yenicanavar2.canavaryonu = true;
		}
		if(yenicanavar2.canavarbaslamanoktasi-yenicanavar2.canavarYurumeHizi*yenicanavar2.a == yenicanavar2.canavarbaslamanoktasi)
		{
			yenicanavar2.canavaryonu = false;
		}
		
		if(yenicanavar3.canavarbaslamanoktasi-yenicanavar3.canavarYurumeHizi*yenicanavar3.a == 1350)
		{
			yenicanavar3.canavaryonu = true;
		}
		if(yenicanavar3.canavarbaslamanoktasi-yenicanavar3.canavarYurumeHizi*yenicanavar3.a == yenicanavar3.canavarbaslamanoktasi)
		{
			yenicanavar3.canavaryonu = false;
		}
		
		if(yenicanavar4.canavarbaslamanoktasi-yenicanavar4.canavarYurumeHizi*yenicanavar4.a == 1640)
		{
			yenicanavar4.canavaryonu = true;
		}
		if(yenicanavar4.canavarbaslamanoktasi-yenicanavar4.canavarYurumeHizi*yenicanavar4.a == yenicanavar4.canavarbaslamanoktasi)
		{
			yenicanavar4.canavaryonu = false;
		}
		
		if(yenicanavar5.canavarbaslamanoktasi-yenicanavar5.canavarYurumeHizi*yenicanavar5.a == 2020)
		{
			yenicanavar5.canavaryonu = true;
		}
		if(yenicanavar5.canavarbaslamanoktasi-yenicanavar5.canavarYurumeHizi*yenicanavar5.a == yenicanavar5.canavarbaslamanoktasi)
		{
			yenicanavar5.canavaryonu = false;
		}
		
		
	}
	
	public void coinyedikmi()
	{
		if(grassX<315 && grassX >285 && topy < -78 && topy > -81)
		{
			if(!yenicoin.yendimi)	yenencoinsayisi++;
			yenicoin.yendimi=true;
		}
		if(grassX<355 && grassX >325 && topy < -78 && topy > -81)
		{
			if(!yenicoin2.yendimi)	yenencoinsayisi++;
			yenicoin2.yendimi=true;
		}
		if(grassX<415 && grassX >385 && topy < -78 && topy > -81)
		{
			if(!yenicoin3.yendimi)	yenencoinsayisi++;
			yenicoin3.yendimi=true;
		}
		if(grassX<665 && grassX >635 && topy < -73 && topy > -85)
		{
			if(!yenicoin4.yendimi)	yenencoinsayisi++;
			yenicoin4.yendimi=true;
		}
		if(grassX<715 && grassX >685 && topy < -73 && topy > -85)
		{
			if(!yenicoin5.yendimi)	yenencoinsayisi++;
			yenicoin5.yendimi=true;
		}
		if(grassX<765 && grassX >735 && topy < -123 && topy > -135)
		{
			if(!yenicoin6.yendimi)	yenencoinsayisi++;
			yenicoin6.yendimi=true;
		}
		if(grassX<595 && grassX >565 && topy < -73 && topy > -85)
		{
			if(!yenicoin7.yendimi)	yenencoinsayisi++;
			yenicoin7.yendimi=true;
		}
		if(grassX<970 && grassX >940 && topy < -73 && topy > -85)
		{
			if(!yenicoin8.yendimi)	yenencoinsayisi++;
			yenicoin8.yendimi=true;
		}
		if(grassX<1015 && grassX >985 && topy < 1 && topy > -2)
		{
			if(!yenicoin9.yendimi)	yenencoinsayisi++;
			yenicoin9.yendimi=true;
		}
		if(grassX<1120 && grassX >1090 && topy < 1 && topy > -2)
		{
			if(!yenicoin10.yendimi)	yenencoinsayisi++;
			yenicoin10.yendimi=true;
		}
		if(grassX<1175 && grassX >1145 && topy < -73 && topy > -85)
		{
			if(!yenicoin11.yendimi)	yenencoinsayisi++;
			yenicoin11.yendimi=true;
		}
		if(grassX<1265 && grassX >1235 && topy < 1 && topy > -2)
		{
			if(!yenicoin12.yendimi)	yenencoinsayisi++;
			yenicoin12.yendimi=true;
		}
		if(grassX<1325 && grassX >1295 && topy < -123 && topy > -135)
		{
			if(!yenicoin13.yendimi)	yenencoinsayisi++;
			yenicoin13.yendimi=true;
		}
		if(grassX<1345 && grassX >1315 && topy < -73 && topy > -85)
		{
			if(!yenicoin14.yendimi)	yenencoinsayisi++;
			yenicoin14.yendimi=true;
		}
		if(grassX<1425 && grassX >1395 && topy < -73 && topy > -85)
		{
			if(!yenicoin15.yendimi)	yenencoinsayisi++;
			yenicoin15.yendimi=true;
		}
		if(grassX<1465 && grassX >1435 && topy < 1 && topy > -2)
		{
			if(!yenicoin16.yendimi)	yenencoinsayisi++;
			yenicoin16.yendimi=true;
		}
		if(grassX<1505 && grassX >1475 && topy < -73 && topy > -85)
		{
			if(!yenicoin17.yendimi)	yenencoinsayisi++;
			yenicoin17.yendimi=true;
		}
		if(grassX<1650 && grassX >1620 && topy < -73 && topy > -85)
		{
			if(!yenicoin18.yendimi)	yenencoinsayisi++;
			yenicoin18.yendimi=true;
		}
		if(grassX<1780 && grassX >1750 && topy < -73 && topy > -85)
		{
			if(!yenicoin19.yendimi)	yenencoinsayisi++;
			yenicoin19.yendimi=true;
		}
		
	}
	
	public void canavaryedimi()
	{
		if(topx == 0)
		{
			if((yenicanavar.canavarbaslamanoktasi - grassX-yenicanavar.canavarYurumeHizi*yenicanavar.a)<250 && (yenicanavar.canavarbaslamanoktasi - grassX-yenicanavar.canavarYurumeHizi*yenicanavar.a)>220 && topy > -15)
			{
				adamOldu = true;
				
			}
			if((yenicanavar2.canavarbaslamanoktasi - grassX-yenicanavar2.canavarYurumeHizi*yenicanavar2.a)<250 && (yenicanavar2.canavarbaslamanoktasi - grassX-yenicanavar2.canavarYurumeHizi*yenicanavar2.a)>220  && topy > -15)
			{
				adamOldu = true;
				
			}
			if((yenicanavar3.canavarbaslamanoktasi - grassX-yenicanavar3.canavarYurumeHizi*yenicanavar3.a)<250 && (yenicanavar3.canavarbaslamanoktasi - grassX-yenicanavar3.canavarYurumeHizi*yenicanavar3.a)>220  && topy > -15)
			{
				adamOldu = true;
				
			}
			if((yenicanavar4.canavarbaslamanoktasi - grassX-yenicanavar4.canavarYurumeHizi*yenicanavar4.a)<250 && (yenicanavar4.canavarbaslamanoktasi - grassX-yenicanavar4.canavarYurumeHizi*yenicanavar4.a)>220 && topy > -15)
			{
				adamOldu = true;
				
			}
			if((yenicanavar5.canavarbaslamanoktasi - grassX-yenicanavar5.canavarYurumeHizi*yenicanavar5.a)<250 && (yenicanavar5.canavarbaslamanoktasi - grassX-yenicanavar5.canavarYurumeHizi*yenicanavar5.a)>220  && topy > -15)
			{
				adamOldu = true;
				
			}
		}
	}
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!oyunbaslangic && !oyunbitti )
		{
			
		grasssecim++;
		if(grasssecim==20)grasssecim = 0;
		
		coinSprite++;
		if(coinSprite == 10)	coinSprite = 0;
		
		canavarSprite++;
		if(canavarSprite == 7)	canavarSprite = 0;
		
		if(!cukuradustu && !adamOldu && !oyuntamamlandi)
		{
		if(keyboardKeyState(KeyEvent.VK_D))
		{
			hangitusabasildi = true;
			topx = topx - topx%5;
			//coorx = coorx - coorx%2;
			grassX = grassX - grassX%5;
		//	System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
			speedD = artismiktari;
			if(grassX<1839 && topx == 0)	{coorx+=1; grassX+=artismiktari;}
			else
			{
				if(topx<200)		topx+=artismiktari;
			}
			if(adamSpriteSayisi%2==0)spriteX += 144;
			if(spriteX>720)	spriteX = 0;
			spriteY = 432;
		}
		else if(speedD>0)
		{
			//System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
			speedD-=stopingSpeed;
			if(grassX<1839 && topx == 0)	{coorx+=speedD/5; grassX+=artismiktari;}
			else
			{
				if(topx<200)		topx+=speedD;
			}
			
			
		}
		if(keyboardKeyState(KeyEvent.VK_A))
		{
			hangitusabasildi = false;
			topx = topx - topx%5;
			//coorx = coorx - coorx%2;
			grassX = grassX - grassX%5;
			//System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
			speedA = artismiktari;
			if(grassX>0 && topx == 0){coorx-=1; grassX -=artismiktari;}
			else
			{
				if(topx>-200)	topx-=artismiktari;
			}
			if(adamSpriteSayisi%2==0)spriteX += 144;
			if(spriteX>720)	spriteX = 0;
			spriteY = 288;/////
		}
		else if(speedA>0)
		{
			//System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
			speedA-=stopingSpeed;
			if(grassX>0 && topx == 0){coorx-=speedA/5; grassX -=artismiktari;}
			else
			{
				if(topx>-200)	topx-=speedA;
			}
			
		}
		System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
		if(ziplamaAktif )
		{
		
			//System.out.println("grassX: "+grassX+" topx: "+topx+" topy: "+topy);
			topy-=speedY;
			speedY--;
			if(speedY == -(ziplamahizi+1))
			{
				ziplamaAktif = false;
				speedY = ziplamahizi;
				if(topy<-1)
				{
					dusmehizi = 15;
				}
			}
			if(hangitusabasildi)
			{
				spriteX = 144;
				spriteY = 144;
			}
			else
			{
				spriteX = 0;
				spriteY = 144;
			}
		
		}
		if(!ziplamaAktif && !keyboardKeyState(KeyEvent.VK_A) && !keyboardKeyState(KeyEvent.VK_D))
		{
			if(hangitusabasildi)
			{
				spriteX = 144;
				spriteY = 0;
			}
			else
			{
				spriteX = 0;
				spriteY = 0;
			}
		}	//adam duruyorken
		
		if(grassX>245 && grassX<470)	//tepe1
		{
			if(topy > -80 && topy<-64)
			{
				topy = -80;
				dusmehizi = 1;
			}
			
		}
		else if(grassX>785 && grassX<895)//tepe2
		{
			if(topy > -80 && topy<-64)
			{
				topy = -80;
				dusmehizi = 1;
			}
			
		}
		else if(grassX>1060 && grassX<1170)//tepe3
		{
			if(topy > -80 && topy<-64)
			{
				topy = -80;
				dusmehizi = 1;
			}
			
		}
		else if(grassX>1315 && grassX<1375)//tepe4
		{
			if(topy > -80 && topy<-64)
			{
				topy = -80;
				dusmehizi = 1;
			}	
		}

		if(!ziplamaAktif && topy<-1)
		{
			if(topy < 0)
			{
				topy += dusmehizi;
				dusmehizi++;
			}
			else 
			{
				dusmehizi = 1;
				topy = 0;
			}	
		}
		
		if(topy>1)
			topy = 0;
		
		if(grassX>1839 && topx>185 && yenencoinsayisi == 19)
		{	
			oyuntamamlandi = true;
		}
		
		coinyedikmi();
		canavaryedimi();
		
		adamSpriteSayisi++;
		//System.out.println(grassX);
		}
		canavaryonutespiti();
		////////////
		if(grassX>580 && grassX<665 && topy > -1)	//çukur
		{
			cukuradustu = true;
			
		}
		else if(grassX>1050 && grassX<1105 && topy > -1)//çukur2
		{
			cukuradustu = true;
			
		}
		else if(grassX>1300 && grassX<1395 && topy > -1)//çukur3
		{
			cukuradustu = true;
			
		}
		else if(grassX>1545 && grassX<1635 && topy > -1)//çukur4
		{
			cukuradustu = true;
			
		}
		else if(grassX>1695 && grassX<1775 && topy > -1)//çukur5
		{
			cukuradustu = true;
			
		}

		if(cukuradustu)
		{
			topy+=5;
			if(topy ==200 || keyboardKeyState(KeyEvent.VK_SPACE))
			{
				can --;
				reset();	
			}
			
		}
		
		if(adamOldu)
		{
			topy-=7;
			if(topy < -280 || keyboardKeyState(KeyEvent.VK_SPACE))
			{
				can --;
				reset();
			}
		}
		
		if(oyuntamamlandi)
		{
			topy-=3;
			if(topy < -99)
			{
				oyuntamamlandiiki = true;
			}
		}
		
		repaint();
	}
	}

}
