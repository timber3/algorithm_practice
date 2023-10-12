class Solution {
    static int result;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0, 0, numbers, target);
        
        answer = result;
        return answer;
    }
    
    void dfs(int cnt, int sum, int[] numbers, int target) {
        if (cnt == numbers.length) {
            if (sum == target){
                result ++;
            }
            return;
        }
        
        
        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        
        
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);

    }
}

