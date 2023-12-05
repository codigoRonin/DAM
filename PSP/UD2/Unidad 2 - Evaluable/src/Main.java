import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int THREAD_RACE = 1;
    private static final int THREAD_RACE_KILLER = 2;
    private static final int THREAD_RACE_JOIN = 3;
    private static final int MULTIPLIER_THREADS_JOIN = 4;
    private static final int BANK_ACCOUNT_SYNCHRONIZED = 5;
    private static final int BANK_ACCOUNT_SYNCHRONIZED_OBJECT = 6;
    private static final int THREAD_RACE_PRIORITIES = 7;
    private static final int THREAD_RACE_PRIORITIES_RANDOM = 8;
    private static final int DISHWASHER = 9;
    private static final int SALIR = 10;

    public static void main(String[] args) {
        int opcion = -1;
        Scanner stdin = new Scanner(System.in);

        do {
            try {
                opcion = printMenu(stdin);
                doMenu(stdin, opcion);
            } catch (InputMismatchException e) {
                System.err.println(
                        "Debe seleccionar una opción adecuada, un numero entre 1 y 5");
                stdin = new Scanner(System.in);
            }
        } while (opcion != SALIR);

        stdin.close();
    }

    private static void doMenu(Scanner stdin, int opcion) {
        switch (opcion) {
            case THREAD_RACE:
                mainThreadRace();
                pressAnyKeyToContinue();
                break;
            case THREAD_RACE_KILLER:
                mainThreadRaceKilled();
                pressAnyKeyToContinue();
                break;
            case THREAD_RACE_JOIN:
                mainThreadRaceJoin();
                pressAnyKeyToContinue();
                break;
            case MULTIPLIER_THREADS_JOIN:
                mainMultiplierThreadJoin();
                pressAnyKeyToContinue();
                break;
            case BANK_ACCOUNT_SYNCHRONIZED:
                mainBankAccountSynchronized();
                pressAnyKeyToContinue();
                break;
            case BANK_ACCOUNT_SYNCHRONIZED_OBJECT:
                mainBankAccountSynchronizedObject();
                pressAnyKeyToContinue();
                break;
            case THREAD_RACE_PRIORITIES:
                mainThreadRacePriority();
                pressAnyKeyToContinue();
                break;
            case THREAD_RACE_PRIORITIES_RANDOM:
                mainThreadRacePrioritiesRandom();
                pressAnyKeyToContinue();
                break;
            case DISHWASHER:
                mainDishWasher();
                pressAnyKeyToContinue();
                break;

            case SALIR:
                System.out.println("\nHasta pronto!!!");
                break;
            default:
                System.err.println(
                        "Debe seleccionar una opción adecuada, un número entre 1 y 5");
                break;
        }
    }

    private static int printMenu(Scanner stdin) {
        System.out.print(
                "\nAFIANZANDO PROCESOS [Evaluable]\n" +
                        "-------------------------------\n" +
                        "1. Thread Race\n" +
                        "2. Thread Race Killer\n" +
                        "3. Thread Race Join\n" +
                        "4. Multiplier Treads Join\n" +
                        "5. Bank Account Synchronized\n" +
                        "6. Bank Account Synchronized Object\n" +
                        "7. Thread Race Priorities\n" +
                        "8. Thread Race Priorities Random()\n" +
                        "9. DishWasher\n" +
                        "10. Salir\n\n" +
                        "Seleccione una opción (1-10): ");

        return stdin.nextInt();
    }

    private static void pressAnyKeyToContinue() {
        System.out.println("Pulse cualquier tecla para continuar");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mainThreadRace() {
        RunnerThread tA = new RunnerThread("A");
        RunnerThread tB = new RunnerThread("B");
        RunnerThread tC = new RunnerThread("C");

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.print(
                    "Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print(
                    "\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println(
                    "\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }

    private static void mainThreadRaceKilled() {

        RunnerThreadFlag tA = new RunnerThreadFlag("A");
        RunnerThreadFlag tB = new RunnerThreadFlag("B");
        RunnerThreadFlag tC = new RunnerThreadFlag("C");

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            // Ask Thread A to finish when it reaches number 700
            if (tA.getRunnerNumber() >= 700)
                tA.setFinished(true);
            System.out.print("Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print("\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println("\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }

    private static void mainThreadRaceJoin() {

        RunnerThreadJoin tA = new RunnerThreadJoin("A");
        RunnerThreadJoin tB = new RunnerThreadJoin("B", tA);
        RunnerThreadJoin tC = new RunnerThreadJoin("C", tB);

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.print("Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print("\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println("\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }

    private static void mainMultiplierThreadJoin() {

        for (int i = 1; i <= 10; i++) {
            Thread t = new MultiplierThread(i);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        }

    }

    private static void mainBankAccountSynchronized() {
        // Create the bank account
        BankAccount ba = new BankAccount(500);

        // Create the threads
        Thread[] threads = new Thread[40];
        for (int i = 0; i < threads.length / 2; i++)
            threads[i] = new BankThreadSave(ba);
        for (int i = threads.length / 2; i < threads.length; i++)
            threads[i] = new BankThreadSpend(ba);

        // Start the threads
        for (int i = 0; i < threads.length; i++)
            threads[i].start();

    }

    private static void mainBankAccountSynchronizedObject() {
        // Create the bank account
        BankAccountObject ba = new BankAccountObject(500);

        // Create the threads
        Thread[] threads = new Thread[40];
        for (int i = 0; i < threads.length / 2; i++)
            threads[i] = new BankThreadSaveObject(ba);
        for (int i = threads.length / 2; i < threads.length; i++)
            threads[i] = new BankThreadSpendObject(ba);

        // Start the threads
        for (int i = 0; i < threads.length; i++)
            threads[i].start();

    }

    private static void mainThreadRacePriority() {

        RunnerThread tA = new RunnerThread("A");
        RunnerThread tB = new RunnerThread("B");
        RunnerThread tC = new RunnerThread("C");

        // These are the 3 lines that we only need to add to original project
        tA.setPriority(Thread.MAX_PRIORITY);
        tB.setPriority(Thread.NORM_PRIORITY);
        tC.setPriority(Thread.MIN_PRIORITY);

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.print("Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print("\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println("\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }

    private static void mainThreadRacePrioritiesRandom() {

        RunnerThreadRandom tA = new RunnerThreadRandom("A", Thread.MAX_PRIORITY);
        RunnerThreadRandom tB = new RunnerThreadRandom("B", Thread.NORM_PRIORITY);
        RunnerThreadRandom tC = new RunnerThreadRandom("C", Thread.MIN_PRIORITY);

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.print("Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print("\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println("\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }

    private static void mainDishWasher() {

        // Simulate a process with N = 20 dishes
        DishPile dp = new DishPile();
        Washer w = new Washer(20, dp);
        Dryer d = new Dryer(20, dp);
        w.start();
        d.start();

    }
}
