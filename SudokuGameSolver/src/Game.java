import java.util.Random;

public class Game {

    public Game(String difMode,Sudoku sudoku) {
        sudoku.ChooseDiff(difMode);
    }

    public void printSudoku(Sudoku sudoku) {
        System.out.println("Title: " + sudoku.getTitle());
        System.out.println("Difficult Mode : " + sudoku.getDiffMode());
        System.out.println("Status: " + sudoku.getStatus());
        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            if ( i == 0 || (i % Math.sqrt(sudoku.getSudoku().length) == 0)) {
                System.out.print(" ");
                for (int j = 0; j < sudoku.getSudoku().length+(Math.sqrt(sudoku.getSudoku().length) + 1); j++) {
                    System.out.print("- ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                if (j == 0) {
                    System.out.print(" | " + sudoku.getSudoku()[i][j] + " ");
                } else if (((j+1) % Math.sqrt(sudoku.getSudoku().length)) == 0 ) {
                    System.out.print(sudoku.getSudoku()[i][j] + " | ");
                } else {
                    System.out.print(sudoku.getSudoku()[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.print(" ");
        for (int j = 0; j < sudoku.getSudoku().length+(Math.sqrt(sudoku.getSudoku().length) + 1); j++) {
            System.out.print("- ");
        }
        System.out.println(" ");
    }

    public boolean isAvailable(Sudoku sudoku, int row, int col, int num) {
        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            if (sudoku.getSudoku()[row][i] == num) {
                return false;
            }
        }

        for (int k = 0; k < sudoku.getSudoku().length; k++) {
            if (sudoku.getSudoku()[k][col] == num) {
                return false;
            }
        }

        int box = (int) Math.sqrt(sudoku.getSudoku().length);
        int startRowBox = row - row % box;
        int startColBox = col - col % box;

        for (int j = startColBox;j < startColBox + box; j++) {
            for (int l = startRowBox; l < startRowBox + box; l++) {
                if (sudoku.getSudoku()[l][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solvedSudoku(Sudoku sudoku) {
        sudoku.setTitle("Solved Sudoku Set");
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                if (sudoku.getSudoku()[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= sudoku.getSudoku().length; num++) {
            if (isAvailable(sudoku,row,col,num)){
                sudoku.getSudoku()[row][col] = num;
                if (solvedSudoku(sudoku)) {
                    sudoku.setStatus("solved");
                    return true;
                } else {
                    sudoku.getSudoku()[row][col] = 0;
                }
            }
        }
        
        sudoku.setStatus("unsolved");
        return false;
    }

    public Sudoku randSudoku(Sudoku sudoku){
        sudoku.setTitle("Generated Random Sudoku Set");
        sudoku.setStatus("new Sudoku Set");

        Random rand = new Random();

        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                int randomNumber = (int) ((Math.random() * (sudoku.getSize() - 1)) + 1);
                float random = rand.nextFloat();
                if (isAvailable(sudoku,i,j,randomNumber) & random > 0.5) {
                    sudoku.getSudoku()[i][j] = randomNumber;
                }
            }
        }

        return sudoku;
    }
}