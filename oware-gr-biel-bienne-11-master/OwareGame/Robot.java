package owarere;


public class Robot {
	/**
	 * 
	 * @param playernumber
	 * @return bot choice
	 */
	public static int robotPlay(int playernumber) {//le playernumber choisit quel robot sera utilisé
		int choice =6;
		if(playernumber==1) {//choix 1, va toujour prendre le premier pit disponible
			for(int i=6;i<11;i++) {
				if(OwareApp.board.getPit(i).getNumSeeds()!=0) {
					choice=i;
					break;
					}
				}
			
		}
		if(playernumber==2) {//le 2 choisit toujours le dernier 
			for(int i=11;i>6;i--) {
				
				if(OwareApp.board.getPit(i).getNumSeeds()!=0) {
					choice=i;
					
					break;
					}
				}
			
		}
		if(playernumber==3) {//cherche le pit avec le plus de graines et l'utilise, le plus faible
			int max=0;
			for(int i=6 ;i<11;i++) {
				if(OwareApp.board.getPit(i).getNumSeeds()>max) {
					choice=i;
					max=OwareApp.board.getPit(i).getNumSeeds();
					}
				}
			
		} 
		if(playernumber>3) {//le "meilleur" , va tenter de prendre les graines enemies, de defendre , et si il n'y a ni defence ni offence il jouera comme bot 1
			int broken=0;
			int lastOne=0;
			int goal;
			int reachTo;
			int reachToo;
			int reachTooo;
			int reachToooo;
			int reachTooooo;
			goal=0;
			reachTo=20;
			reachToo=0;
			reachTooo=0;
			reachToooo=0;
			reachTooooo=0;
			
			
			for(int i=0;i<6;i++) {//comptes les pits a 1 du coté joueur, et regarde si il peut les attaquer tous
				if(OwareApp.board.getPit(i).getNumSeeds()==1)
				{
					if(reachTo==20) {
						reachTo=i;
						goal=1;
					}
					else if(reachToo==0) {
						reachToo=i;
						goal=2;
					}
					else if(reachTooo==0) {
						reachTooo=i;
						goal=3;
					}
					else if(reachToooo==0) {
						reachToooo=i;
						goal=4;
					}
					else {
						reachTooooo=i;
						goal=5;
					}
				}
			}
			
				int best=0;
				int besti=0;
				for(int i=6 ;i<12;i++) {				
					if((OwareApp.board.getPit(i).getNumSeeds()+(i-11))>best ) {
						besti=i;
						best=OwareApp.board.getPit(i).getNumSeeds()+(i-11);
						if(goal>=1 && best>=reachTo) {
							if(broken!=1 && OwareApp.board.getPit(choice).getNumSeeds()>=reachTo) {
							choice=besti;
							broken=1;
							}
						}
						if(goal>=2 && best>=reachToo) {
							if(broken!=1 && OwareApp.board.getPit(choice).getNumSeeds()>=reachTo) {
							choice=besti;
							broken=1;}
						}
						if(goal>=3 && best>=reachTooo) {
							if(broken!=1 && OwareApp.board.getPit(choice).getNumSeeds()>=reachTo) {
							choice=besti;
							broken=1;}
						
						}
						if(goal>=4 && best>=reachToooo) {
							if(broken!=1 && OwareApp.board.getPit(choice).getNumSeeds()>=reachTo) {
							choice=besti;
							broken=1;}
						}
						if(goal>=5 && best>=reachTooooo) {
							if(broken!=1 && OwareApp.board.getPit(choice).getNumSeeds()>=reachTo) {
							choice=besti;
							broken=1;}
						}
					}
				}
				if(broken==0) {//compte les pits a 1 de son coté, et si il y en a deux d'affilé, bouge le premier pour avoir 0 2
					for(int j=6 ;j<12;j++) {
					
					if(OwareApp.board.getPit(j).getNumSeeds()==1 ) {
						choice=j;  
						
						if((j-1)==lastOne) {
							choice=lastOne;
							broken=1;
							break; 
						}
						lastOne=j;
						}
					}
			}
			if(broken==0) {//juste le robot 1
				for(int k=6;k<12;k++) {
					if(OwareApp.board.getPit(k).getNumSeeds()!=0) {
						choice=k;
						break;
						}
					}
			}
		}
			

		return choice;
	}

	
	
	
}
