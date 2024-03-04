package runanimals;

import controller.HiloAnimal;
import view.FondoPanel;
import view.ViewRunAnimals;

/**
 *
 * @author riost_fq9d95t
 */
public class RunAnimals {

    public static void main(String[] args) {
//        FondoPanel fondoPanel = new FondoPanel();
        ViewRunAnimals viewRunAnimals = new ViewRunAnimals();
        viewRunAnimals.setTitle("Carrera de animales");
        viewRunAnimals.setSize(900, 400);
//        viewRunAnimals.setContentPane(fondoPanel);
        viewRunAnimals.setLocationRelativeTo(null);
        viewRunAnimals.setLayout(null);
        viewRunAnimals.setVisible(true);
        
//        HiloAnimal hipopotamo = new HiloAnimal("Hipopotamo", 8.333);
//        HiloAnimal caballo = new HiloAnimal("Caballo", 13.8889);
//        HiloAnimal tortuga = new HiloAnimal("Tortuga", 10.5556);
//
//        hipopotamo.start();
//        caballo.start();
//        tortuga.start();
    }
}
