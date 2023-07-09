package easy;

/*
Brie tiene un libro que le gusta mucho. El libro tiene n páginas numeradas consecutivamente del 1 al n. Brie abre siempre el libro por la página 1 cuando comienza a leer. Cada vez que voltea una página, avanza dos páginas a la vez (es decir, pasa de la página x a la página x + 2).

El problema consiste en determinar la cantidad mínima de volteos de páginas que Brie debe realizar para llegar a una página dada p en el libro, ya sea comenzando desde la página 1 o desde el final del libro.

Se te pide implementar la función int pageCount(int n, int p) que devuelve la cantidad mínima de volteos de páginas necesarios para llegar a la página p. Los parámetros de la función son:

n: un número entero que representa el número total de páginas en el libro.
p: un número entero que representa la página a la que se desea llegar.
Formato de entrada
La función pageCount toma dos parámetros enteros n y p.

Restricciones
1 ≤ n ≤ 10^5
1 ≤ p ≤ n
Formato de salida
La función debe devolver un número entero que representa la cantidad mínima de volteos de páginas necesarios para llegar a la página p.
*/

public class DrawingBook {
               
    public static int pageCount(int n, int p) {
    
        if(n % 2 == 0){
            return Math.min((n-p+1)/2, p/2);
        }
        return Math.min((n-p)/2, p/2);    

    }

    public static void main(String[] args) {
        
    }
}
