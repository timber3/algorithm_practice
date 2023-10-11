class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // 세로
        for (int i = 2 ; i < 5000 ; i ++) {
            // 가로
            for (int j = 3 ; j < 5000 ; j ++) {
                if ( i < j )
                    break;
                if ( (i * j) == (brown + yellow) ) {
                    if ( (2*i + 2*j) - 4 == brown )
                        answer = new int[] {i, j};
                }
            }
        }
        
        return answer;
    }
}