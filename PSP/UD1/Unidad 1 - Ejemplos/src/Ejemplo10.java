public class Ejemplo10 {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("No disponemos de los argumentos correctos");
            System.exit(1);
        }
        
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int resultado = sumar(n1, n2);
        System.out.println("La Suma es: "+ resultado);

    }

    public static int sumar(int n1, int n2) {
        return n1 + n2;
    }
}
