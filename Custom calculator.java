import java.util.Scanner;

class InvalidInput extends Exception {
    public InvalidInput(String message) {
        super(message);
    }
}

class MaxInput extends Exception {
    public MaxInput(String message) {
        super(message);
    }
}

class CanNotDivideByZero extends Exception {
    public CanNotDivideByZero(String message) {
        super(message);
    }
}

class MaxMultiplierReached extends Exception {
    public MaxMultiplierReached(String message) {
        super(message);
    }
}

class addition {
    public void sum(double a, double b) {
        try {
            if ((a == 8 && b == 9) || (b == 8 && a == 9)) {
                throw new InvalidInput("combination not allowed");
            }
            if (a > 100000 || b > 100000) {
                throw new MaxInput("Input values cannot be greater than 10,0000.");
            }
            double sum = a + b;
            System.out.println("result is : " + sum);
        } catch (InvalidInput | MaxInput e) {
            System.out.println("invalid input " + e.getMessage());
        }
    }
}

class multiplication {
    public void mul(double a, double b) {
        try {
            if (a > 7000 || b > 7000) {
                throw new MaxMultiplierReached("Input values cannot be greater than 7000.");
            }
            double multi = a * b;
            System.out.println("result: " + multi);
        } catch (MaxMultiplierReached e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}

class division {
    public void divs(double a, double b) {
        try {
            if (b == 0) {
                throw new CanNotDivideByZero("cannot divide by zero");
            }
            if (a > 100000 || b > 100000) {
                throw new MaxInput("Input values cannot be greater than 10,0000.");
            }
            double div = a / b;
            System.out.println("result: " + div);
        } catch (CanNotDivideByZero | MaxInput e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}

class subtraction {
    public void subs(double a, double b) {
        try {
            if (a > 100000 || b > 100000) {
                throw new MaxInput("Input values cannot be greater than 10,0000.");
            }
            double sub = a - b;
            System.out.println("result: " + sub);
        } catch (MaxInput e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("\nChoose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addition add = new addition();
                add.sum(num1, num2);
                break;
            case 2:
                subtraction sub = new subtraction();
                sub.subs(num1, num2);
                break;
            case 3:
                multiplication mul = new multiplication();
                mul.mul(num1, num2);
                break;
            case 4:
                division div = new division();
                div.divs(num1, num2);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
