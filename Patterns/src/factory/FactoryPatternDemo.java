package factory;

public class FactoryPatternDemo {

    public static interface ElectricVehicle {
        void charge();
        void drive();
    }
    public static class CyberTruck implements ElectricVehicle {
        public void charge() {
            System.out.println("CyberTruck is charging!");
        }

        public void drive() {
            System.out.println("Driving the CyberTruck!");
        }
    }

    public static class ModelS implements ElectricVehicle {
        public void charge() {
            System.out.println("Model-S is charging!");
        }

        public void drive() {
            System.out.println("Driving the Model-X!");
        }
    }

    public static class ModelX implements ElectricVehicle {
        public void charge() {
            System.out.println("Model-X is charging!");
        }

        public void drive() {
            System.out.println("Driving the Model-X!");
        }
    }

    public static class TeslaFactory {
        public static ElectricVehicle getVehicle(String type) {
            if (type == null || type.length() == 0) {
                System.out.println("Input shouldn't be empty!");
                return null;
            }
            switch (type) {
                case "cybertruck":
                    return new CyberTruck();
                case "models":
                    return new ModelS();
                case "modelx":
                    return new ModelX();
                default:
                    System.out.println("Type is not available : " + type);
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        ElectricVehicle cybertruck = TeslaFactory.getVehicle("cybertruck");
        cybertruck.charge();
        cybertruck.drive();
        ElectricVehicle models = TeslaFactory.getVehicle("models");
        models.charge();
        models.drive();
        ElectricVehicle modelx = TeslaFactory.getVehicle("modelx");
        modelx.charge();
        modelx.drive();
        /*
            output :
            CyberTruck is charging!
            Driving the CyberTruck!
            Model-S is charging!
            Driving the Model-X!
            Model-X is charging!
            Driving the Model-X!
         */
    }
}



