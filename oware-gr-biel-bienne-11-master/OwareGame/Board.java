package owarere;
//Used for testing before JavaFX, not used anymore
public class Board
{
	private static Pit[] allPits;
	static
	{
		allPits = new Pit[12];

	}
	/**
	 * 
	 */
	public Board(){
		this.createPits();
		this.setNextPits();
		this.setPreviousPits();
		
	}
	/**
	 * 
	 * @param pitnum
	 * @return allpits
	 */
	public Pit getPit(int pitnum)
	{
		return allPits[pitnum];
	}
	/**
	 * 
	 * @param pitNumber
	 * @param p
	 */
	public void setPit(int pitNumber, Pit p){
		allPits[pitNumber]=p;
	}
	
	/**
	 * 
	 */
	private void createPits(){
		for(int i =0; i<12; i++){
			Pit p = new Pit();
			p.setPitNumber(i);
			allPits[i]=p;
		}
	}
	/**
	 * 
	 */
	private void setPreviousPits() {
		Pit firstPit =  allPits[0];
		Pit lastPit=allPits[11];
		firstPit.setPrevious(lastPit);
		for (int i =1; i<12; i++){
			Pit p = allPits[i];
			p.setPrevious(allPits[i-1]);
		}	
	}
	/**
	 * 
	 */
	private void setNextPits() {
		Pit firstPit =  allPits[0];
		Pit lastPit=allPits[11];
		lastPit.setNext(firstPit);
		for (int i=10; i>=0; i--){
			Pit currentPit = allPits[i];
			Pit nextPit = allPits[i+1];
			currentPit.setNext(nextPit);
		}
		
	}
	
	/**
	 * 
	 */
	public void showBoard(){
		showFirstRow();
		showSecondRow();
	}
	/**
	 * 
	 */
	private void showSecondRow(){
		String fourLines= "----|";
		String rowLine = "|";
		String rowNumberOfSeeds = "|";
		String headerRow ="|";
		for (int i=0; i<=5; i++){
			headerRow +=" P"+ i+ " |" ;
			rowLine +=fourLines;
			if(allPits[i].getNumSeeds()<9)
				rowNumberOfSeeds+=" "+allPits[i].getNumSeeds() +"  |";
			else
				rowNumberOfSeeds+=" "+allPits[i].getNumSeeds() +" |";
		}
		System.out.println(rowLine);
		System.out.println(rowNumberOfSeeds);
		System.out.println(rowLine);
		System.out.println(headerRow);
		
	}
	/**
	 * 
	 */
	private void showFirstRow(){
		String fourLines= "----|";
		String rowLine = "|";
		String rowNumberOfSeeds = "|";
		String headerRow ="|";
		for (int i=11; i>=6; i--){  
			rowLine +=fourLines;
			if (i>9)
				headerRow +=" P"+ i+ "|" ;
			else
				headerRow +=" P"+ i+ " |" ;
			
			if(allPits[i].getNumSeeds()<9)
				rowNumberOfSeeds+=" "+allPits[i].getNumSeeds() +"  |";
				
			else
				rowNumberOfSeeds+=" "+allPits[i].getNumSeeds() +" |";
		}
		System.out.println(headerRow);
		System.out.println(rowLine);
		System.out.println(rowNumberOfSeeds);
		
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Board b= new Board();
		b.showBoard();
	}
	/**
	 * 
	 * @param playerId
	 * @return boolean
	 */
	public boolean isPlayerAbleToMakeMove(int playerId){
		boolean answer = false;
		if (playerId == 1)
			 answer = isPlayer1AbleToMove();
		else
			answer = isPlayer2AbleToMove();
		return answer;
	}
	/**
	 * 
	 * @return boolean
	 */
	private boolean isPlayer1AbleToMove(){
		boolean isAble = false;
		Pit p;
		for(int i=0; i<6; i++){
			p=this.getPit(i);
			isAble=Move.canPitMove(p);//edited command name
			if (isAble)
				break;	
		}	
		return isAble;
	}
	/**
	 * 
	 * @return boolean
	 */
	private boolean isPlayer2AbleToMove(){
		boolean isAble = false;
		Pit p;
		for(int i=6; i<12; i++){
			p=this.getPit(i);
			isAble=Move.canPitMove(p);//edited command name
			if (isAble)
				break;	
		}	
		return isAble;
	}
	

}
