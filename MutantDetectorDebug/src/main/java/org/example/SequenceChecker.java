package org.example;

public class SequenceChecker {

    // Método Optimizado con Conteo de Secuencias
    public boolean hasSequenceOptimized(char[][] matrix) {
        int n = matrix.length;
        int[][][] dp = new int[n][n][4]; // 0: horizontal, 1: vertical, 2: diag1, 3: diag2
        int sequenceCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char current = matrix[i][j];

                // Horizontal
                dp[i][j][0] = (j > 0 && current == matrix[i][j - 1]) ? dp[i][j - 1][0] + 1 : 1;
                if (dp[i][j][0] >= 4) {
                    sequenceCount++;
                }

                // Vertical
                dp[i][j][1] = (i > 0 && current == matrix[i - 1][j]) ? dp[i - 1][j][1] + 1 : 1;
                if (dp[i][j][1] >= 4) {
                    sequenceCount++;
                }

                // Diagonal Principal
                dp[i][j][2] = (i > 0 && j > 0 && current == matrix[i - 1][j - 1]) ? dp[i - 1][j - 1][2] + 1 : 1;
                if (dp[i][j][2] >= 4) {
                    sequenceCount++;
                }

                // Diagonal Secundaria
                dp[i][j][3] = (i > 0 && j < n - 1 && current == matrix[i - 1][j + 1]) ? dp[i - 1][j + 1][3] + 1 : 1;
                if (dp[i][j][3] >= 4) {
                    sequenceCount++;
                }

                // Información de depuración (Comentar para ver el tiempo optimizado real)
                System.out.println("At position (" + i + ", " + j + "): ");
                System.out.println("Current character: " + current);
                System.out.println("Horizontal: " + dp[i][j][0]);
                System.out.println("Vertical: " + dp[i][j][1]);
                System.out.println("Diagonal Principal: " + dp[i][j][2]);
                System.out.println("Diagonal Secundaria: " + dp[i][j][3]);
                System.out.println("Sequence Count: " + sequenceCount);
                System.out.println();

                // Comprobar si sequenceCount llegó a 2
                if (sequenceCount > 1) {
                    // Imprimir depuración final antes de devolver true
                    System.out.println("Final values at position (" + (i+1) + ", " +(j+1) + "): ");
                    System.out.println("Current character: " + current);
                    System.out.println("Horizontal: " + dp[i][j][0]);
                    System.out.println("Vertical: " + dp[i][j][1]);
                    System.out.println("Diagonal Principal: " + dp[i][j][2]);
                    System.out.println("Diagonal Secundaria: " + dp[i][j][3]);
                    System.out.println("Sequence Count: " + sequenceCount);
                    return true;
                }
            }
        }
        return false;
    }

}
