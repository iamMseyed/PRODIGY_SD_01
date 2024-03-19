package prodigy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter temperature value: ");
                double temperature = scanner.nextDouble();

                System.out.print("""
                        ====== Enter the unit ======\n
                        C: for Celsius\n
                        F: for Fahrenheit\n
                        K: for Kelvin\n
                        X: to exit
                        """);
                String unit = scanner.next().toUpperCase();

                double celsius = 0, fahrenheit = 0, kelvin = 0;

                switch (unit) {
                    case "C":
                        celsius = temperature;
                        fahrenheit = (temperature * 9 / 5) + 32;
                        kelvin = temperature + 273.15;
                        break;
                    case "F":
                        fahrenheit = temperature;
                        celsius = (temperature - 32) * 5 / 9;
                        kelvin = (temperature + 459.67) * 5 / 9;
                        break;
                    case "K":
                        kelvin = temperature;
                        celsius = temperature - 273.15;
                        fahrenheit = (temperature * 9 / 5) - 459.67;
                        break;
                    case "X":
                        System.out.println("Program execution ended!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.err.println("Invalid unit!\n");
                }
                    System.out.println("Celsius: " + celsius + " °C");
                    System.out.println("Fahrenheit: " + fahrenheit + " °F");
                    System.out.println("Kelvin: " + kelvin + " K\n" );
            } catch (InputMismatchException ime) {
                System.err.println("Please enter correct input!\n");
                scanner.nextLine(); 
            }
        }
    }
}
