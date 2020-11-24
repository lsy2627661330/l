import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
class MainCanvas extends Canvas implements Runnable
{
	
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int Flag;
    Random rd = new Random();
	Image bossImg;
	Image currentImg;
	Image heroImg[][] = new Image[4][3];//四个方向，每个方向3张图片，1代表left,2代表up,3代表right,0代表down
	
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++)
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			bossImg=Image.createImage("/zuzu000.png");

            heroX=110;
	        heroY=200;

			bossX=0;
			bossY=0;

            Flag=1;
			currentImg = heroImg[0][1];

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

    public void run(){
	while(true){
		int rdnumber =rd.nextInt(10);
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if(rdnumber%3==0){
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;
			}
			else{
				bossY--;
			}
		}
        repaint();
	}  
}

	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);

		if(action == LEFT){
			changePicAndDirection(1);
			heroX-=1;		
		}

        if(action == UP){
			changePicAndDirection(2);
		    heroY-=1;
			}

		if(action == RIGHT){
			changePicAndDirection(3);
			heroX+=1;
			}
		
		if(action == DOWN){
			changePicAndDirection(0);
			heroY+=1;
			}
    }

	void changePicAndDirection(int direction){
		if(Flag==1){
			currentImg = heroImg[direction][0];
			Flag++;
		}
		else if(Flag==2){
            currentImg = heroImg[direction][2];
			Flag--;
		}
	}
}