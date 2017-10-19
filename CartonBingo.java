/**
 * Created by david on 10/11/2016.
 */
public class CartonBingo {

    private boolean resultado;
	
    /*
	 *  Funcion que imprime por patalla un carton de apuestas
	 */
    public void imprime(int[][] matriz) {
        System.out.println("\n\n   ************* CARTON DE APUESTA *************");
        for(int f=0; f<matriz.length; f++){
            for(int c=0; c<matriz[0].length; c++)
                System.out.print("\t"+matriz[f][c]);
            System.out.println();
        }
        System.out.println("   *********************************************\n");
    }

    /*
	 *  Funcion que indica si un numero dado se encuentra en un carton de apuestas
	 *    parametros: <matriz> representacion de carton de apuestas como int[][]
	 *                <elemento> numero a buscar
	 */
    public boolean contiene(int[][] matriz, int elemento) {
        resultado  = false;
        busqueda(matriz, 0, matriz.length - 1, 0, matriz[0].length - 1, elemento);
        return resultado;
    }
    /*
    *   Función que realiza la búsqueda del elemento indicado mediante el algoritmo de Divide y Vencerás.
    *       Parámetros: <matriz> representación del cartón de apuestas como int[][]
    *                   <filaInicial> fila desde la que queremos iniciar la búsqueda
    *                   <filaFinal> fila hasta la que queremos realizar la búsqueda
    *                   <columnaInicial> columna desde la que queremos iniciar la búsqueda
    *                   <columnaFinal> columna hasta la que queremos realizar la búsqueda
    *                   <elemento> número a buscar
     */
    private void busqueda(int[][] matriz, int filaInicial, int filaFinal, int columnaInicial, int columnaFinal, int elemento) {
        if (!resultado) {
            //Buscamos el elemento del medio
            int filaMedio = filaInicial + (filaFinal - filaInicial) / 2;
            int columnaMedio = columnaInicial + (columnaFinal - columnaInicial) / 2;


            //Miramos la solución trivial, si el elemento del medio == elemento buscado, hemos terminado.
            if (matriz[filaMedio][columnaMedio] == elemento) {
                resultado = true;
            } else {
                //Si el elemento es MAYOR que el medio, buscamos en tres sectores de la matriz.
                if(elemento > matriz[filaMedio][columnaMedio]){
                    //Búsqueda en su misma columna, submatriz superior.
                    if(filaMedio-1 >= filaInicial) busqueda(matriz, filaInicial, filaMedio-1, columnaMedio, columnaMedio, elemento);
                    //Búsqueda en la submatriz superior derecha, siempre y cuando no se haya obtenido la solución en la búsqueda anterior.
                    if(filaMedio-1 >= filaInicial && columnaMedio+1 <= columnaFinal && !resultado) busqueda(matriz, filaInicial, filaMedio-1, columnaMedio+1, columnaFinal, elemento);
                    //Búsqueda en la submatriz vertical izquierda, siempre y cuando no se haya obtenido la solución en las búsquedas anteriores.
                    if(columnaMedio-1 >= columnaInicial && !resultado) busqueda(matriz, filaInicial, filaFinal, columnaInicial, columnaMedio-1, elemento);
                }
                //Si el elemento es MENOR que el medio, buscamos en tres sectores, pero no los mismos de antes.
                else{
                    //Búsqueda en su misma columna, submatriz inferior.
                    if(filaMedio+1 <= filaFinal) busqueda(matriz, filaMedio+1, filaFinal, columnaMedio, columnaMedio, elemento);
                    //Búsqueda en la submatriz inferior izquierda, siempre y cuando no se haya obtenido la solución en la búsqueda anterior..
                    if(columnaMedio-1 >= columnaInicial && filaMedio+1 <= filaFinal && !resultado) busqueda(matriz, filaMedio+1, filaFinal, columnaInicial, columnaMedio-1, elemento);
                    //Búsqueda en la submatriz vertical derecha, siempre y cuando no se haya obtenido la solución en la búsqueda anterior..
                    if(columnaMedio+1 <= columnaFinal && !resultado) busqueda(matriz, filaInicial, filaFinal, columnaMedio+1, columnaFinal, elemento);
                }


            }


        }
    }
}