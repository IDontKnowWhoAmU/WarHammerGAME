package game40k;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class pole extends JPanel
	{
		public int shizn = 3;
		private Image shapka;
		private Image fon;
		public int x = 400;
		private int slogn;
		private podar[] gamePodar;
		private Image end_game;
		public Timer timerUpdate,timerDraw;
		
		
		
		public pole(int slogn)
		{
			this.slogn = slogn;
			
			try
			{
				shapka = ImageIO.read(new File("E:\\image\\game java\\Marine (4).png"));
			}
			catch(IOException ex) {}
			
			try
			{
				fon = ImageIO.read(new File("E:\\image\\game java\\2022-03-13_18-38-51.png"));
			}
			catch(IOException ex) {}
			try
			{
				end_game = ImageIO.read(new File("E:\\image\\game java\\gameover (2).png"));
			}
			catch(IOException ex) {}
			gamePodar = new podar[7];
			for(int i = 0; i<7;i++)
			{
				try
				{
					gamePodar[i] = new podar(ImageIO.read(new File("E:\\image\\game java\\ork.png")));
				}
			catch(IOException ex) {}
			}
			timerUpdate = new Timer(2000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				updateStart();
			}
				});
				timerUpdate.start();

			
			timerDraw = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
				 });
				timerDraw.start();
		}

				public void paintComponent(Graphics gr)
				{
					super.paintComponent(gr);
					gr.drawImage(fon, 0, 0, null);
					gr.drawImage(shapka, x, 465, null);
				for (int i=0;i<7;i++)
				{
					gamePodar[i].draw(gr);
					if(gamePodar[i].act==true)
						if ((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=500)
//							shizn-=1;
						if(Math.abs(gamePodar[i].x-x)> 75)
						{
//							if(shizn<1)
//							{
								gr.drawImage(end_game, 0, 0, null);
								timerDraw.stop();
								timerUpdate.stop();
								break;
//							}
								
						}
					else gamePodar[i].act = false;
						}
					}
					
	
				private void updateStart()
				{
					int kol=0;
					for (int i=0;i<7;i++)
					{
					if(gamePodar[i].act==false)
					{
					if(kol<slogn)
					{
					gamePodar[i].start();
					break;	
					}
					}
					else kol++;
					}
				
				
				}
	}
	