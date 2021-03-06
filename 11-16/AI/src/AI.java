import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display = Display.getDisplay(this);
		mc = new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImg,img00,img10,img20,img02,img12,img22,
		img04,img14,img24,img06,img16,img26;
	int x,y;
	int leftFlag,upFlag,rightFlag,downFlag;
	
	public MainCanvas(){
		try
		{
			img00 = Image.createImage("/sayo00.png");
			img10 = Image.createImage("/sayo10.png");
            img20 = Image.createImage("/sayo20.png");
			img02 = Image.createImage("/sayo02.png");
			img12 = Image.createImage("/sayo12.png");
			img22 = Image.createImage("/sayo22.png");
            img04 = Image.createImage("/sayo04.png");
			img14 = Image.createImage("/sayo14.png");
            img24 = Image.createImage("/sayo24.png");
            img06 = Image.createImage("/sayo06.png");
			img16 = Image.createImage("/sayo16.png");
            img26 = Image.createImage("/sayo26.png");
	

            x=110;
	        y=200;
            leftFlag=1;
			upFlag=1;
			rightFlag=1;
			downFlag=1;
			currentImg = img10;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);

		if(action == LEFT){

			currentImg = img12;	
			if(leftFlag==1){
				currentImg = img02;
			    leftFlag++;
			}
			else if(leftFlag==2){
                currentImg = img22;
			    leftFlag--;
			}

			System.out.println("向左转");		
			x-=1;
			repaint();
		

		}

        if(action == UP){

			currentImg = img14;
			if(upFlag==1){
				currentImg = img04;
			    upFlag++;
			}
			else if(upFlag==2){
                currentImg = img24;
			    upFlag--;
			}

			System.out.println("向上转");
		    y-=1;
			
			repaint();
			}

		if(action == RIGHT){

			currentImg = img16;
			if(rightFlag==1){
				currentImg = img06;
			    rightFlag++;
			}
			else if(rightFlag==2){
                currentImg = img26;
			    rightFlag--;
			}

			System.out.println("向右转");
			x+=1;
			repaint();
			}
		
		if(action == DOWN){

			currentImg = img10;
			if(downFlag==1){
				currentImg = img00;
			    downFlag++;
			}
			else if(downFlag==2){
                currentImg = img20;
			    downFlag--;
			}

			System.out.println("向下转");
			y+=1;
			repaint();
			}
    }
}