package owarere;

public class Player
{
	private int id;
	private Storehouse playersStorehouse;
	/**
	 * 
	 * @param id
	 */
	Player(int id){
		this.id = id;
		this.playersStorehouse = new Storehouse();
	}

/**
 * 
 * @return id
 */
	public int getId(){
		return this.id;
	}
	/**
	 * 
	 * @param numSeeds
	 */
	public void addSeedsToStoreHouse(int numSeeds){
		playersStorehouse.addCapturedSeeds(numSeeds);
	}
	/**
	 * 
	 * @return
	 */
	public int getScore(){
		return playersStorehouse.getNumSeeds();
	}

}
