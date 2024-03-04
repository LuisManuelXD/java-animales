package view;

import controller.HiloAnimal;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author riost_fq9d95t
 */
public class ViewRunAnimals extends JFrame implements Runnable {

    // tortuga
    private JLabel jLabelAnimal1 = new JLabel();
    // hipopotamo
    private JLabel jLabelAnimal2 = new JLabel();
    // caballo
    private JLabel jLabelAnimal3 = new JLabel();
    FondoPanel fondoPanel = new FondoPanel();

    private ImageIcon imageAnimal1 = new ImageIcon("src/img/tortuga.png");
    private ImageIcon imageAnimal2 = new ImageIcon("src/img/hipopotamo.png");
    private ImageIcon imageAnimal3 = new ImageIcon("src/img/caballo.png");

    HiloAnimal tortuga = new HiloAnimal("Tortuga", 10.5556);
    HiloAnimal hipopotamo = new HiloAnimal("Hipopotamo", 8.333);
    HiloAnimal caballo = new HiloAnimal("Caballo", 13.8889);

    public ViewRunAnimals() {
        this.setContentPane(fondoPanel);

        jLabelAnimal1.setBounds(10, 50, 100, 80);
        Image image1 = imageAnimal1.getImage().getScaledInstance(jLabelAnimal1.getWidth(), jLabelAnimal1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        jLabelAnimal1.setIcon(scaledImageIcon1);

        jLabelAnimal2.setBounds(10, 120, 100, 80);
        Image image2 = imageAnimal2.getImage().getScaledInstance(jLabelAnimal2.getWidth(), jLabelAnimal2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        jLabelAnimal2.setIcon(scaledImageIcon2);

        jLabelAnimal3.setBounds(10, 250, 100, 80);
        Image image3 = imageAnimal3.getImage().getScaledInstance(jLabelAnimal3.getWidth(), jLabelAnimal3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon3 = new ImageIcon(image3);
        jLabelAnimal3.setIcon(scaledImageIcon3);

        add(jLabelAnimal1);
        add(jLabelAnimal2);
        add(jLabelAnimal3);

        tortuga.start();
        hipopotamo.start();
        caballo.start();

        Thread updateHiloTortuga = new Thread(this);
        Thread updateHiloHipopotamo = new Thread(this);
        Thread updateHiloCaballo = new Thread(this);

        updateHiloTortuga.start();
        updateHiloHipopotamo.start();
        updateHiloCaballo.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        try {
            while (true) {
                double distanciaTortuga = tortuga.getRecorrido();
                double distanciaHipopotamo = hipopotamo.getRecorrido();
                double distanciaCaballo = caballo.getRecorrido();

                double posicionX_Tortuga = 10 + distanciaTortuga;
                double posicionX_Hipopotamo = 10 + distanciaHipopotamo;
                double posicionX_Caballo = 10 + distanciaCaballo;

                jLabelAnimal1.setBounds((int) posicionX_Tortuga, 50, 100, 80);
                jLabelAnimal2.setBounds((int) posicionX_Hipopotamo, 120, 100, 80);
                jLabelAnimal3.setBounds((int) posicionX_Caballo, 250, 100, 80);

                Thread.sleep(50);

                if (distanciaHipopotamo >= 800) {
                    Thread.sleep(100);
                    JOptionPane.showMessageDialog(null, tortuga.getGuardarPosiciones());
                    break;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(ViewRunAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}