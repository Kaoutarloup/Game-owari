package owarere;


public class OwareApp {

	static Player player1 = new Player(1);
	static Player player2 = new Player(2);
	static Player activePlayer;
	static Board board = new Board();


	/**
	 * had more to do, but got edited to fit with java fx and buttons instead of scan 
	 */
	public static void turn(){

		activePlayer = player1;

	}
	
	
	

	
	
	/**
	 * 
	 * @return
	 */
	public static boolean isGameOver(){
		boolean answer;
		if((player1.getScore()+player2.getScore()>45))//if true, only 2 seeds left or less
			answer = true;

		else
			answer = false;
		return answer;
	}
	
	/**
	 * 
	 */
	static void switchPlayer(){
		if(activePlayer.getId()==1)
			activePlayer = player2;
		else if (activePlayer.getId()==2)
			activePlayer = player1;
	}






}
