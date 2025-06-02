class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[0].length;j++){
                set1.add(mat1[i][j]);
                set2.add(mat2[i][j]);
            }
        }
        int count=0;
        for(int i:set1){
            if(set2.contains(x-i)){
                count++;
            }
        }
        return count;
    }
}