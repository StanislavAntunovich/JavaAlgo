package ru.geekbrains.lesson5;

public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(pow(0, -2));
    }

    public static double pow(double digit, int power) {
        if (power == 0) {
            return 1;
        }

        if (digit == 0) {
            if (power < 0) {
                throw new IllegalArgumentException(String.format("Power %d is not acceptable for %.0f", power, digit));
            }
            return 0;
        }

        if (power < 0) {
            return 1 / (digit * pow(digit, -power - 1));
        }

        return digit * pow(digit, power - 1);
    }
}
