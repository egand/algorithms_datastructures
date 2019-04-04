package editdistance;

/**
 * Implement the Edit Distance Algorithm.
 * Given two strings s1 and s2, this algorithm determine the minimum number of operations
 * required to transform s1 into s2.
 * The operations permitted are:
 * 1. Deletion of a character
 * 2. Insertion of a character
 */
public class EditDistance {

    /**
     * Naive recursive algorithm that implement the edit distance algorithm
     * @param s1 The string to be transformed
     * @param s2 The string for which s1 must be transformed
     * @return The minimum number of operation to transform s1 in s2
     */
    public static int editDistanceRec(String s1, String s2) {
        if(s1.length() == 0)
            return s2.length();
        if(s2.length() == 0)
            return s1.length();

        int distNoOp, distDel, distIns;
        if(s1.charAt(0) == s2.charAt(0))
            distNoOp = editDistanceRec(s1.substring(1),s2.substring(1));
        else
            distNoOp = Integer.MAX_VALUE;

        distDel = 1 + editDistanceRec(s1, s2.substring(1));
        distIns = 1 + editDistanceRec(s1.substring(1),s2);

        return Math.min(Math.min(distNoOp, distDel), distIns);
    }

    /**
     * Algorithm that implement the edit distance algorithm using dynamic programming
     * @param s1 The string to be transformed
     * @param s2 The string for which s1 must be transformed
     * @return The minimum number of operation to transform s1 in s2
     */
    public static int editDistanceDyn(String s1, String s2) {
        int[][] matrix = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {

                if(i == 0)
                    matrix[i][j] = j;
                else if(j == 0)
                    matrix[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                else matrix[i][j] = 1 + Math.min(matrix[i][j-1], matrix[i-1][j]);
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
