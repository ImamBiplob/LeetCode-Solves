import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public boolean isValidSudokuBetterSoln(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> smallSqr = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            row.clear();
            column.clear();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if ((r != '.' && !row.add(r)) || (c != '.' && !column.add(c))) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                smallSqr.clear();
                int rows = i + 3;
                int cols = j + 3;
                for (int k = i; k < rows; k++) {
                    for (int l = j; l < cols; l++) {
                        char c = board[k][l];
                        if (c != '.' && !smallSqr.add(c)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
