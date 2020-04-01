package owarere;

public class Storehouse
{
	private int numSeeds;

	public void addCapturedSeeds(int n){
		numSeeds += n;
	}
	
	public int getNumSeeds(){
		return this.numSeeds;
	}

}
