public class Ejercicio5 {
    public static void main(String[] args) {

        if (args.length < 1){
            System.err.println("Faltan argumentos");
            System.exit(-1);
            
        }
       
        System.out.println(args[0]);
        System.exit(0);
    }

}
