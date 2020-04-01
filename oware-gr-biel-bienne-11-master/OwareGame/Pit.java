package owarere;
public class Pit
{
	private int pitNumber;
	private int ownerPlayerID;
	private int numSeeds;
	private Pit next;
	private Pit previous;
	
	//private Pit currentPit;
	/**
	 * 
	 */
	public Pit(){
		numSeeds = 4;
		previous = null; 
		next = null;
	}
	/**
	 * 
	 * @param numSeeds
	 */
	public Pit(int numSeeds){
		previous = null; 
		next = null;
		this.numSeeds = numSeeds;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumSeeds()
	{
		return this.numSeeds;
	}
	/**
	 * 
	 * @param num
	 */
	public void setNumSeeds(int num)
	{
		this.numSeeds = num;
	}
	/**
	 * 
	 * @param p
	 */
	public void setPrevious(Pit p){
		previous = p;
	}
	/**
	 * 
	 * @param p
	 */
	public void setNext(Pit p){
		next = p;
	}
	/**
	 * 
	 * @return
	 */
	public Pit getPrevious(){
		return previous;
	}
	/**
	 * 
	 * @return
	 */
	public Pit getNext(){
		return  next;
	}
	/**
	 * 
	 * @param rn
	 */
	public void setPitNumber(int rn){
		pitNumber = rn;
	}
	/**
	 * 
	 */
	public void addSeed(){
		numSeeds++;
	}
	/**
	 * 
	 */
	public void removeSeed() {
		numSeeds-=2;
	}
	/**
	 * 
	 * @return int pit number
	 */
	public int getPitNumber(){
		return pitNumber;
	}
	/**
	 * 
	 * @return player ID
	 */
	public int getOwnerPlayerID(){
		return this.ownerPlayerID;
	}
	
	

}
