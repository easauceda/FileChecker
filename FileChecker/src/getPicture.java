import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class getPicture extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage img;

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public getPicture(boolean fileIsThere) {
		if (fileIsThere == true){
			try {
				img = ImageIO.read(new File("bigCheck.png"));
			} catch (IOException e) {
				System.out.println("ERROR");
			}
		}
		if (fileIsThere == false) {
			try {
				img = ImageIO.read(new File("bigX.png"));
			} catch (IOException e) {
				System.out.println("ERROR");
			}
		}
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}

}