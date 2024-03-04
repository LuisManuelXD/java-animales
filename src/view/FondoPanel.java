package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author riost_fq9d95t
 */
public class FondoPanel extends JPanel {
    private Image fondoImage;

    @Override
    public void paint(Graphics g) {
        fondoImage = new ImageIcon(getClass().getResource("/img/pista.jpg")).getImage();
        g.drawImage(fondoImage, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    } 
}
