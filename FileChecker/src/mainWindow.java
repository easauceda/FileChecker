import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWindow implements Runnable {
	public mainWindow() throws FileNotFoundException {
		FileStatus check = new FileStatus();
		JFrame mainWindowFrame = new JFrame("AuthFile Check");
		JLabel status = null;
		boolean fileCheck = check.checkFileStatus();
		if (fileCheck == true) {
			status = new JLabel("No problems reported.");
			status.setFont(new Font("Dialog", 1, 30));
			mainWindowFrame.add(new getPicture(fileCheck), BorderLayout.CENTER);
		} else if (fileCheck == false) {
			status = new JLabel("No file Found, DANGER");
			status.setFont(new Font("Dialog", 1, 30));
			status.setForeground(Color.red);
			mainWindowFrame.add(new getPicture(fileCheck), BorderLayout.CENTER);
		}
		mainWindowFrame.add(status, BorderLayout.SOUTH);
		mainWindowFrame.pack();
		mainWindowFrame.setVisible(true);
		mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (fileCheck == false) {
			new Thread(new SendErrorEmail());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		new Thread(new mainWindow());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			new mainWindow();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
