package programmers.연습문제;

import java.util.*;

class test {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> player = new HashMap<>();
		Map<Integer, String> rank = new HashMap<>();
		for(int i = 0; i < players.length; i++){
			player.put(players[i], i);
			rank.put(i, players[i]);
		}
		for(String curPlayer : callings){
			int curRank = player.get(curPlayer); // 현재 플레이어의 순위
			int frontRank = curRank - 1;         // 앞 플레이어의 순위
			String frontPlayer = rank.get(frontRank); //앞 플레이어 이름

			rank.put(frontRank, curPlayer); // 추월할 선수 이름 앞으로
			rank.put(curRank, frontPlayer); // 추월 당한 선수 뒤로
			player.put(frontPlayer, curRank); // 추월 당한 선수 순위 다운
			player.put(curPlayer, frontRank); // 추월한 선수 순위 업
		}

		String[] answer = new String[players.length];
		int cnt = 0;
		for(String s : rank.values()){
			answer[cnt++] = s;
		}

		return answer;
	}

}