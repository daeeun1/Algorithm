class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = brown + yellow-1; i > 0; i--){
            if(sum % i == 0 && (i + (sum / i) - 2)*2 == brown) {
                answer[1] = i;
                answer[0] = sum / i;
            }
        }
        
        return answer;
    }
}