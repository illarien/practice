package Museum;

public class Runner {

    private static Position[][] getMuseum(char[][] original) {
        Position[][] result = new Position[original.length][original[0].length];
        for(int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                if (original[i][j] == 'o') {
                    result[i][j] = new OpenPosition(i, j);
                }
                if (original[i][j] == 'g') {
                    result[i][j] = new Guard(i, j);
                }
                if (original[i][j] == 'w') {
                    result[i][j] = new Wall(i, j);
                }
            }
        }
        
        return result;
    }
    
    private static void printMuseum(Position[][] museum) {
        for(int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[i].length; j++) {
                if (museum[i][j] instanceof OpenPosition) {
                    System.out.print(((OpenPosition)museum[i][j]).dist + " ");
                }
                if (museum[i][j] instanceof Wall) {
                    System.out.print("W ");
                }
                if (museum[i][j] instanceof Guard) {
                    System.out.print("G ");
                }
            }
            System.out.println();
        }
    }
    
    private static void evaluate(Position[][] museum) {
        for(int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[i].length; j++) {
                museum[i][j].evaluate(museum);
            }
        }
    }
    
//    private static void checkMuseum(Position[][] museum) {
//        for(int i = 0; i < museum.length; i++) {
//            for (int j = 0; j < museum[i].length; j++) {
//                museum[i][j].checkNeigth(museum);
//            }
//        }
//    }

    public static void main (String[] args) {
        char [][] original = {{'o','g','o'},{'o','w','g'},{'o','o','o'}};
        Position[][] museum = getMuseum(original);
        printMuseum(museum);
        System.out.println();
        evaluate(museum);
        printMuseum(museum);
        System.out.println();
        
//        checkMuseum(museum);
        printMuseum(museum);
    }

}
