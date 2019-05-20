import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SudokuSolver recurSolver = new RecursiveSolver("src/main/resources/puzzle.sdk");
        System.out.println("\npuzzle is looked like this: \n" + ((RecursiveSolver) recurSolver).getBoard());
        long t1 = System.nanoTime();
        Board result1 = recurSolver.solve();
        long t2 = System.nanoTime();
        System.out.println("\nTime for recursive solver: " + String.valueOf(t2 - t1));
        System.out.println("\nPuzzle is solved as below: \n" + result1);

        SudokuSolver iterSolver = new IterativeSolver("src/main/resources/puzzle.sdk");
        System.out.println("\npuzzle is looked like this: \n" + ((IterativeSolver) iterSolver).getBoard());
        long t3 = System.nanoTime();
        Board result2 = iterSolver.solve();
        long t4 = System.nanoTime();
        System.out.println("\nTime for iterative solver: " + String.valueOf(t4 - t3));
        System.out.println("\nPuzzle is solved as below: \n" + result2);
    }
}

/*
Runtime of solver using depth first search is faster than the one using recursive backtracking; the more blanks the
more obvious of runtime difference. Because in DFS, stack only pushes/pops one Board variable; while in recursive
backtracking, the system stack has to deal with everything related to calling the function itself, therefore it is
more costly.
*/