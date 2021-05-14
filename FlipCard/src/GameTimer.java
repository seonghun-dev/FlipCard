import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class GameTimer extends Maingame{
	
	public GameTimer() {
    Timer jobScheduler = new Timer();
	TimerTask Timerjob = new TimerTask() {
		int Timertime = 10;
		@Override
		public void run() {
			String showTimertime = Integer.toString(Timertime);
			if(Timertime > -1) {
				Timershow.setText(showTimertime);
				Timertime--;
			}
			else{
				Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			}
		}
	};
      jobScheduler.scheduleAtFixedRate(Timerjob, 1000, 1000);
	}

}
