package Polimorphism.Coil;

public class Coils {
        private double diameter;
        // поля
        public Coils(double diameter) {
            super();
            initDiameter(diameter); // обращение к final-методу
        }

        public final void initDiameter(double value) { // можно public final заменить на private
            if (value > 0) {
                diameter = value;
            } else {
                System.out.println("Oтрицательный диаметр!");
            }
        }
// методы

}

