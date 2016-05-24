public class ArraySpiralWU {
    
    private static void printArray(int[][] input) {
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
    
    private static void printSpiral(int[][] input) {
        printSpiral(input, 0, input.length,0, input[0].length);
    }
    
    private static void printSpiral(int[][] input, int iStart, int iEnd, int jStart, int jEnd) {
        if (iStart >= iEnd || jStart >= jEnd) {
            return;
        }
        
        for(int j = jStart; j < jEnd; j++) {
            System.out.print(input[iStart][j] + " ");
        }
        for(int i = iStart+1; i < iEnd; i++) {
            System.out.print(input[i][jEnd-1] + " ");
        }
        for(int j = jEnd-2; j >= jStart; j--) {
            System.out.print(input[iEnd-1][j] + " ");
        }
        for(int i = iEnd-2; i > iStart; i--) {
            System.out.print(input[i][jStart] + " ");
        }
        
        printSpiral(input, iStart+1, iEnd-1, jStart+1, jEnd-1);
    }
    
    
    public static void main(String...strings) {
        
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//      printArray(input);
        printSpiral(input);
    }

}
