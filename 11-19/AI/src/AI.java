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
	
	int x,y;
	int leftFlag,upFlag,rightFlag,downFlag;
	Image currentImg;

	Image heroLeftImg[] = new Image[3];
	Image heroRightImg[] = new Image[3];
	Image heroUpImg[] = new Image[3];
	Image heroDownImg[] = new Image[3];
	
	public MainCanvas(){
		try
		{
			/*
			img00 = Image.createImage("/sayo00.png");
			img10 = Image.createImage("/sayo10.png");
            img20 = Image.createImage("/sayo20.png");
			*/
			for(int i=0;i<3;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}

			/*
			img02 = Image.createImage("/sayo02.png");
			img12 = Image.createImage("/sayo12.png");
			img22 = Image.createImage("/sayo22.png");
			*/

			for(int i=0;i<3;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}

			/*
            img04 = Image.createImage("/sayo04.png");
			img14 = Image.createImage("/sayo14.png");
            img24 = Image.createImage("/sayo24.png");
			*/

			for(int i=0;i<3;i++){
                heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");				
			}

			/*
            img06 = Image.createImage("/sayo06.png");
			img16 = Image.createImage("/sayo16.png");
            img26 = Image.createImage("/sayo26.png");
			*/

			for(int i=0;i<3;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
	

            x=110;
	        y=200;
            leftFlag=1;
			upFlag=1;
			rightFlag=1;
			downFlag=1;
			currentImg = heroDownImg[1];
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
				
			if(leftFlag==1){
				currentImg = heroLeftImg[0];
			    leftFlag++;
			}
			else if(leftFlag==2){
                currentImg = heroLeftImg[2];
			    leftFlag--;
			}

			System.out.println("向左转");		
			x-=1;
			repaint();
		

		}

        if(action == UP){

			if(upFlag==1){
				currentImg = heroUpImg[0];
			    upFlag++;
			}
			else if(upFlag==2){
                currentImg = heroUpImg[2];
			    upFlag--;
			}

			System.out.println("向上转");
		    y-=1;
			
			repaint();
			}

		if(action == RIGHT){

			if(rightFlag==1){
				currentImg = heroRightImg[0];
			    rightFlag++;
			}
			else if(rightFlag==2){
                currentImg = heroRightImg[2];
			    rightFlag--;
			}

			System.out.println("向右转");
			x+=1;
			repaint();
			}
		
		if(action == DOWN){

			if(downFlag==1){
				currentImg = heroDownImg[0];
			    downFlag++;
			}
			else if(downFlag==2){
                currentImg = heroDownImg[2];
			    downFlag--;
			}

			System.out.println("向下转");
			y+=1;
			repaint();
			}
    }
}