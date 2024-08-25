public class WordPuzzle {
    
    char[][] puzzle;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        RIGHT_DIAGONAL,
        LEFT_DIAGONAL
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        String[] puzzleStrings = {"PECHEER", "SYYAWME", "IESERUM", "WSDAREO", "DBLGRMT", "BLUBEIB", "TIMIDLB"};
        String[] words = {"BULB", "CARET", "CHEER", "EDGE", "EYE", "LIME", "RADS", "RIB", "SERUM", "TIMID", "TOME", "WISP"};
        WordPuzzle wordPuzzle = new WordPuzzle();
        wordPuzzle.validatePuzzleStrings(puzzleStrings);
        wordPuzzle.makePuzzle(puzzleStrings);
        wordPuzzle.solvePuzzle(words);
    }

    void validatePuzzleStrings(String[] puzzleStrings) {
        System.out.println("All strings need to be of same length");
        int wordLength = puzzleStrings[0].length();
        for (int i = 1; i < puzzleStrings.length; i++) {
            if (puzzleStrings[i].length() != wordLength) {
                throw new Error("Puzzle Strings are of variable length -->" + puzzleStrings[i]);
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
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (word.charAt(0) == puzzle[row][col]) {
                    for (Direction direction : Direction.values()) {
                        solveWordInPuzzleWithDirection(word, 0, direction, row, col, rows, columns);
                    }
                }
            }
        }
    }

    void solveWordInPuzzleWithDirection(String word, int index, Direction direction, int row, int col, int rows, int cols) {
        if (direction == Direction.UP) {
            row = row - 1;
        } else if (direction == Direction.DOWN) {
            row = row + 1;
        } else if (direction == Direction.LEFT) {
            col = col - 1;
        } else if (direction == Direction.RIGHT) {
            col = col + 1;
        } else if (direction == Direction.LEFT_DIAGONAL) {
            row = row - 1;
            col = col - 1;
        } else if (direction == Direction.RIGHT_DIAGONAL) {
            row = row + 1;
            col = col + 1;
        }

        if (row < 0 || col < 0 || row >= rows || col >= cols) return;
        index = index+1;
        if (word.charAt(index) == puzzle[row][col]) {
            if (index == word.length()-1) {
                int[] startingPoint = getStartingPoint(row, col, direction, word.length());
                System.out.println(word + " is solved. Started at " + startingPoint[0] + ", " + startingPoint[1] + ". Direction is " + direction);
                return;
            }
            solveWordInPuzzleWithDirection(word, index, direction, row, col, rows, cols);
        }
    }

    int[] getStartingPoint(int row, int col, Direction direction, int length) {
        length = length-1;
        if (direction == Direction.UP) {
            row = row + length;
        } else if (direction == Direction.DOWN) {
            row = row - length;
        } else if (direction == Direction.LEFT) {
            col = col + length;
        } else if (direction == Direction.RIGHT) {
            col = col - length;
        } else if (direction == Direction.LEFT_DIAGONAL) {
            row = row + length;
            col = col + length;
        } else if (direction == Direction.RIGHT_DIAGONAL) {
            row = row - length;
            col = col - length;
        }

        int[] startingPoint = new int[2];
        startingPoint[0] = row;
        startingPoint[1] = col;
        return startingPoint;
    }
}
