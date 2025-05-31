package SOLID;

// 1. Abstraction: Create a Switchable interface
public class DIP_01 {

    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    // 2. LightBulb now depends on the interface, not vice versa
    public static class LightBulb implements Switchable {
        public void turnOn() {
            System.out.println("Light is ON!");
        }
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    // 3. Switch now uses the abstraction
    public static class Switch {
        private Switchable device;

        public Switch(Switchable device) {
            this.device = device;
        }

        public void operate() {
            device.turnOn(); // You could add logic to toggle ON/OFF if needed
        }
    }

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb(); // Polymorphism!
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate();
    }
}
