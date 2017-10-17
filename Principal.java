import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {

    private static int[][] carton1 = {
            {69, 57, 43, 28, 14},
            {68, 56, 35, 25, 13},
            {66, 55, 34, 22, 8},
            {64, 52, 32, 21, 7},
            {62, 47, 31, 17, 5}
    };

    private static int[][] carton2 = {
            {62, 47, 31, 17, 5}
    };

    private static int[][] carton3 = {
            {14},
            {13},
            {9},
            {7},
            {5}
    };

    /*
     *  Funcion que muestra por pantalla todos los numeros presentes en un carton de apuesta
     */
    public static void comprobarCarton(int[][] carton){
        StringBuffer texto = new StringBuffer();
        CartonBingo cb = new CartonBingo();
        cb.imprime(carton);
        for(int i=100; i>0; i--)
            if(cb.contiene(carton, i-1)){
                if(texto.length()>0) texto.append(", ");
                texto.append(i-1);
            }
        texto.insert(0, "\tNumeros en el carton: ");
        texto.replace(texto.lastIndexOf(","), texto.lastIndexOf(",")+1, " y");
        System.out.println(texto.toString());
    }

    /*
     *  Funcion que genera un carton de apuesta con <n> filas y <m> columnas
     */
    public static int[][] generarCarton(int n, int m){
        ArrayList<Integer> numerosCarton = new ArrayList<Integer>();
        for(int i=0; i<n*m;){
            int candidato = (int) (Math.random()*100);
            if(!numerosCarton.contains(candidato)){
                numerosCarton.add(candidato);
                i++;
            }
        }
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(numerosCarton, comparador);
        int[][] carton = new int[n][m];
        for(int i=0; i< numerosCarton.size(); i++){
            int f = i/m;
            int c = i%m;
            carton[f][c] = numerosCarton.get(i);
        }
        return carton;
    }

    public static void main(String[] args) {
        comprobarCarton(carton1);
        comprobarCarton(carton2);
        comprobarCarton(carton3);
        comprobarCarton(generarCarton(6,6));
        comprobarCarton(generarCarton(2,6));
        comprobarCarton(generarCarton(6,2));
    }

}
