
/**
 * Created by david on 10/11/2016.
 */
public class CartonBingo {

    private boolean resultado;

    public void imprime(int[][] matriz) {
        System.out.println("\n\n   ************* CARTON DE APUESTA *************");
        for(int f=0; f<matriz.length; f++){
            for(int c=0; c<matriz[0].length; c++)
                System.out.print("\t"+matriz[f][c]);
            System.out.println();
        }
        System.out.println("   *********************************************\n");
    }

    public boolean contiene(int[][] matriz, int elemento) {
        resultado  = false;
        busqueda(matriz, 0, matriz.length - 1, 0, matriz[0].length - 1, elemento);
        return resultado;
    }

    public void busqueda(int[][] matriz, int filaInicial, int filaFinal, int columnaInicial, int columnaFinal, int elemento) {
        if (!resultado) {
            //Buscamos el elemento del medio
            int filaMedio = filaInicial + (filaFinal - filaInicial) / 2;
            int columnaMedio = columnaInicial + (columnaFinal - columnaInicial) / 2;


            //Miramos la solución trivial, si el elemento del medio == elemento buscado, hemos terminado.
            if (matriz[filaMedio][columnaMedio] == elemento) {
                resultado = true;
            } else {
                if(elemento > matriz[filaMedio][columnaMedio] && filaMedio-1 >= filaInicial) busqueda(matriz, filaInicial, filaMedio-1, columnaMedio, columnaMedio, elemento);
                if(elemento < matriz[filaMedio][columnaMedio] && filaMedio+1 <= filaFinal) busqueda(matriz, filaMedio+1, filaFinal, columnaMedio, columnaMedio, elemento);
                if(columnaMedio-1 >= columnaInicial) busqueda(matriz, filaInicial, filaFinal, columnaInicial, columnaMedio-1, elemento);
                if(columnaMedio+1 <= columnaFinal) busqueda(matriz, filaInicial, filaFinal, columnaMedio+1, columnaFinal, elemento);
            }


        }
    }
}