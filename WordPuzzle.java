public class WordPuzzle {
    
    char[][] puzzle;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        RIGHT_DIAGNOAL,
        LEFT_DIAGNOAL
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        String[] puzzleStrings = {};
        String[] words = {};

    }

    void validatePuzzleStrings(String[] puzzleStrings) {
        System.out.println("All strings need to be of same length");
        int wordLength = puzzleStrings[0].length();
        for (int i = 1; i < puzzleStrings.length; i++) {
            if (puzzleStrings[i].length() != wordLength) {
                throw new Error("Puzzle Strings are of variable length");
            }
        }
    }

    void makePuzzle(String[] puzzleStrings) {
        int rows = puzzleStrings.length;
        int columns = puzzleStrings[0].length();
        puzzle = new char[rows][columns];
        for (int i = 0; i < puzzleStrings.length; i++) {
            String puzzleString = puzzleStrings[i];
            for (int j = 0; j < puzzleString.length(); j++) {
                puzzle[i][j] = puzzleString.charAt(j);
            }
        }
    }

    void solvePuzzle(String[] words) {
        for (String word : words) {
            solveWordInPuzzle(word);
        }
    }

    void solveWordInPuzzle(String word) {
        int rows = puzzle.length;
        int columns = puzzle[0].length;
    }
}
