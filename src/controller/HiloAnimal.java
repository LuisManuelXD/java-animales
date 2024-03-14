package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class HiloAnimal extends Thread {

    private String animal = "";
    private double velocidad = 0;
    private double recorrido = 0;
    private static int contadorAnimales = 1;
    private static String guardarPosiciones = "";

    public HiloAnimal(String animal, double velocidad) {
        this.animal = animal;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Animal corriendo: " + this.animal + ", distancia recorrida: " + this.recorrido);
                if (this.recorrido >= 800) {
//                    System.out.println("Animal llegó a la meta: " + this.animal + " (Orden de llegada: " + this.contadorAnimales + ")");
                    this.guardarPosiciones += "Animal llegó a la meta: " + this.animal + " (Orden de llegada: " + String.valueOf(this.contadorAnimales) + ")\n";
                    JOptionPane.showMessageDialog(null, "Animal llegó a la meta: " + this.animal + " (Orden de llegada: " + this.contadorAnimales + ")");
                    contadorAnimales++;
                    break;
                } else {
                    recorrido += velocidad;
                }
                sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public String getAnimal() {
        return animal;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getGuardarPosiciones() {
        return guardarPosiciones;
    }

    public static int getContadorAnimales() {
        return contadorAnimales;
    }
}
