package owarere;

public class Move
{
	static int playerNumber=0;//0=no bots, by default
	static int capturedSeed=0;//the seeds total
	static int captureSeed=0;//seeds this turn
	/**
	 * 
	 * @param p
	 * @return active pit
	 */
	public static Pit makeMove(Pit p){//make move from pit p
		int startingPointPitNumber = p.getPitNumber();
		int playingNumberOfSeeds = p.getNumSeeds();
		int player=1;
		int sum;
		Pit activePit = p;
		p.setNumSeeds(0);
		if(p.getPitNumber()<6) //only p1 plays those
		{
			player=1;
			OwareApp.activePlayer=OwareApp.player1;

		}
		else {//only p2 plays those
			player=2;
			OwareApp.activePlayer=OwareApp.player2;
		}
		while(playingNumberOfSeeds>0){//as long as you got seeds in your hand
			activePit= activePit.getNext();//move to next pit
			if(activePit.getPitNumber()!=startingPointPitNumber && activePit.getNumSeeds()!=1){//if not capturing and not on the same spot
				activePit.addSeed();//transfer from hand to pit
				playingNumberOfSeeds--;
				
			}else {//added a condition to the if, and made the second 
				activePit.addSeed();
				playingNumberOfSeeds--;
				if(((activePit.getPitNumber()%12)>5 &&  player==1)||((activePit.getPitNumber()%12)<5 &&  player==2)){//in enemy territory, with 1 seed
				captureSeed();//add 2 to score
				activePit.removeSeed();//remove 2
				}
			}
		}
		int capturedSeeds = capturedSeed();
		OwareApp.activePlayer.addSeedsToStoreHouse(capturedSeeds);
		sum=0;
		if (OwareApp.activePlayer==OwareApp.player1) {//another check to see if other player can play
			for(int i=6;i<12;i++) {
				sum=sum+OwareApp.board.getPit(i).getNumSeeds();
			}
			
		}
		else {
			for(int i=0;i<6;i++) {
				sum=sum+OwareApp.board.getPit(i).getNumSeeds();
			}
		}
		if(sum!=0) {
			OwareApp.switchPlayer();
		}
		
		if(playerNumber!=0 && OwareApp.activePlayer==OwareApp.player2) {//if the robot can play, then robot will play
			makeMove(OwareApp.board.getPit(Robot.robotPlay(playerNumber)));

			
		}
		
		return activePit;
	}
	/**
	 * 
	 * @param int i
	 */
	public static void changeBot(int i) {//select either 0 for no bot, or one of the 4 bots
		playerNumber=i;
		
	}
	/**
	 * 
	 * @param pit p
	 * @return next pit
	 */
	public static Pit seedNextPit(Pit p){
		Pit nextPit = p.getNext();
		nextPit.addSeed();
		return nextPit;
	}
	/**
	 * 
	 * @param pit p
	 * @return false, always
	 */
	public static boolean isMoveValid(Pit p){
		return false;
	}
/**
 * 
 * @param pit
 * @return boolean true or false
 */
	public static boolean canPitMove(Pit pit){//edited to fit our rules
		boolean answer = false;
		if (pit.getNumSeeds()>0) {
			answer = true;
		}
		
		return answer;
	}
	/**
	 * 
	 * @param playerId
	 * @param pitNumber
	 * @return
	 */
	public static boolean isThisPitPlayers(int playerId, int pitNumber){
		boolean answer = false;
		if((playerId==1) && (pitNumber>=0) && (pitNumber<=5))
			answer= true;
		else if ((playerId==2) && (pitNumber>=6) && (pitNumber<=11))
			answer= true;
		return answer;
	}
	
	
	/**
	 * 
	 */
	public static void captureSeed(){
		captureSeed+=2;
		
	}
	/**
	 * 
	 * @return int count of seeds
	 */
	public static int capturedSeed() {
		int count=captureSeed;
		captureSeed=0;
		return count;
	}
}
