/*Добавить счетчик и разных орков, а так же фракции и жизни*/

package game40k;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class podar {

public Image img;
public int x, y;
public Boolean act;
Timer timerUpdate;
	public podar(Image img)
	{
		timerUpdate = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vniz();
			}
		});
		this.img = img;
		act = false;
			}
	public void start()
	{
		timerUpdate.start();
		y=0;
		x = (int)(Math.random()*700);
		act = true;
	}
	public void vniz()
	{
		if(act==true)
		{
			y+=6;
		}
		if((y+img.getHeight(null))>=600)
		{
			timerUpdate.stop();
		}
	}
	public void draw(Graphics gr)
	{
		if(act==true)
		{
			gr.drawImage(img, x, y, null);
		}
	}
	
}
