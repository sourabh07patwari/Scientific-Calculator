package calculator;

import java.awt.EventQueue;

public class Cal_Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cal_GUI window = new Cal_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
