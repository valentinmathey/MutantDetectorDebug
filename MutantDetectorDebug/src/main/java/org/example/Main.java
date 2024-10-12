package org.example;

public class Main {
    public static void main(String[] args) {

        SequenceChecker checker = new SequenceChecker();
        char[][] matrix = {
                {'A', 'T', 'G', 'C', 'G', 'A'},
                {'C', 'A', 'G', 'T', 'G', 'C'},
                {'T', 'T', 'A', 'T', 'G', 'T'},
                {'A', 'G', 'A', 'A', 'G', 'G'},
                {'C', 'C', 'C', 'C', 'T', 'A'},
                {'T', 'C', 'A', 'C', 'T', 'G'}
        };

        // Medir tiempo de los métodos
        long startOptimized = System.nanoTime();
        boolean isMutantOptimized = checker.hasSequenceOptimized(matrix);
        long endOptimized = System.nanoTime();
        long durationOptimized = endOptimized - startOptimized;

        // Imprimir resultados
        System.out.println("Result: " + isMutantOptimized);
        System.out.println("Tiempo Optimizado: " + durationOptimized + " ns");


    }
}