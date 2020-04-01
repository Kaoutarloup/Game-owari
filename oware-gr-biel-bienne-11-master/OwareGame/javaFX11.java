package owarere;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.ArrayList;


public class javaFX11 extends Application {//labels and buttons needed later
	static Label score1 = new Label("player2 score="+0);
    static Label score = new Label("player1 score="+0);
    Label gameOver = new Label("GAME OVER");
    Button buttonNone=new Button("2player");
    Button buttonLast=new Button("lastBot");
    Button buttonFirst=new Button("firstBot");
    Button buttonStrong=new Button("strongBot");
    Button buttonWeak=new Button("weakBot");
    Button buttonUnstuck=new Button("Unstuck/cheats");
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
        OwareApp.turn();
    }
    /**
     * cheat or unstuck
     */
    public static void unstuck() {
    	for(int j=0;j<12;j++) {
			btn.get(j).setDisable(false);
		}
    }
    /**
     * updates the board
     */
    public static void updatePoint() {
    	int player1Score=OwareApp.player1.getScore();
    	score.setText("player1 score= "+player1Score);
    	int player2Score=OwareApp.player2.getScore();
    	score1.setText("player2 score= "+player2Score);
    	for(int j=0;j<6;j++) {
    		if(OwareApp.board.getPit(j).getNumSeeds()==0){
				btn.get(j).setDisable(true);
				}else {
					btn.get(j).setDisable(false);
				}
    		}
    	int sum=0;
    	for(int i=0;i<6;i++) {
    		sum=sum+OwareApp.board.getPit(i).getNumSeeds();
    	}
    	if(sum==0) {
    		int playerNumber=Move.playerNumber;
    		Move.makeMove(OwareApp.board.getPit(Robot.robotPlay(playerNumber)));
    	}
    	for (int j=0;j<12;j++) {
			btn.get(j).setText(""+OwareApp.board.getPit(j).getNumSeeds());

				
			}
    	}
    static ArrayList<Button> btn = new ArrayList<Button>();
    
    
    @Override
    /**
     * most of the displaying here
     */
    public void start(Stage primaryStage) {
    	int length=1500;
    	int high=800;
    	int line1=240;
    	int line2=440;
    	int radiu=100;
    	int modifier=200;
    	Group root = new Group();
        @SuppressWarnings("unused")
		ArrayList<Circle> circle = new ArrayList<Circle>();
        for(int i=0;i<12;i++) {
        	Circle circ=new Circle();
        	circ.setRadius(radiu);
        	if(i<6) {
        		circ.setCenterX(150+(i*modifier));
        		circ.setCenterY(line1+10);
        	}else {
        		circ.setCenterX(150+((i-6)*modifier));
        		circ.setCenterY(line2+10);
        	}
        	root.getChildren().add(circ);
        	
        }
        
        for(int i=0;i<12;i++) {
        	Button button=new Button("4");
        	final int number=i;
        	button.setPrefSize(100,100);
        	
        	button.setStyle("-fx-background-color: #000000; -fx-font-size: 4em; -fx-text-fill: #ffffff;");
        	button.setOnAction(e -> click(number));
        	if(i<6) {
        		button.setLayoutX(1100-(i*modifier));
        		button.setLayoutY(line1-40);
        	}else {
        		button.setLayoutX(100+((i-6)*modifier));
        		button.setLayoutY(line2-40);
        	}
        	root.getChildren().add(button);
        	btn.add(button);
        	
        }

        
        buttonUnstuck.setOnAction(e -> unstuck());
        buttonUnstuck.setLayoutX(20);
        buttonUnstuck.setLayoutY(20);
        root.getChildren().add(buttonUnstuck);
        buttonUnstuck.setVisible(false);
        buttonNone.setOnAction(e -> botChoice(0));
        buttonNone.setLayoutX(20);
        buttonNone.setLayoutY(20);
        root.getChildren().add(buttonNone);

        buttonWeak.setOnAction(e -> botChoice(3));
        buttonWeak.setLayoutX(120);
        buttonWeak.setLayoutY(20);
        root.getChildren().add(buttonWeak);

        buttonStrong.setOnAction(e -> botChoice(4));
        buttonStrong.setLayoutX(220);
        buttonStrong.setLayoutY(20);
        root.getChildren().add(buttonStrong);

        buttonFirst.setOnAction(e -> botChoice(1));
        buttonFirst.setLayoutX(420);
        buttonFirst.setLayoutY(20);
        root.getChildren().add(buttonFirst);
        
        buttonLast.setOnAction(e -> botChoice(2));
        buttonLast.setLayoutX(320);
        buttonLast.setLayoutY(20);
        root.getChildren().add(buttonLast);
        score.setStyle("-fx-font-size: 4em; -fx-text-fill: #000000;");
        score.setLayoutX(50);
        score.setLayoutY(50);
        root.getChildren().add(score);
        score1.setStyle("-fx-font-size: 4em; -fx-text-fill: #000000;");
        score1.setLayoutX(550);
        score1.setLayoutY(50);
        root.getChildren().add(score1);
        gameOver.setStyle("-fx-font-size: 4em; -fx-text-fill: #000000;");
        gameOver.setLayoutX(350);
        gameOver.setLayoutY(600);
        root.getChildren().add(gameOver);
        gameOver.setVisible(false);
        

    	
        primaryStage.setTitle("Hello World!");


        primaryStage.setScene(new Scene(root, length, high));
        primaryStage.show();
    }
    
    /**
     * 
     * @param i
     * @return null
     */
	private Object botChoice(int i) {
		Move.changeBot(i);
		if(i!=0) {
			for(int j=6;j<12;j++) {
				btn.get(j).setDisable(true);
				}
		}else {
			for(int j=6;j<12;j++) {
			btn.get(j).setDisable(false);
			}
		}
		return null;
	}
	/**
	 * 
	 * @param i given by a click 
	 */
	public void click(int i) {
		buttonStrong.setVisible(false);
		buttonWeak.setVisible(false);
		buttonFirst.setVisible(false);
		buttonLast.setVisible(false);
		buttonNone.setVisible(false);
		buttonStrong.setDisable(false);
		buttonWeak.setDisable(false);
		buttonFirst.setDisable(false);
		buttonLast.setDisable(false);
		buttonNone.setDisable(false);
		buttonUnstuck.setVisible(true);//prevent both using bots after first move, which can cause bugs, and allows to use unstuck
		Move.makeMove(OwareApp.board.getPit(i));
		int sum=0;

		if(i<6) {
			for(int j=6;j<12;j++) {
				sum=sum+OwareApp.board.getPit(j).getNumSeeds();
				}
			if (sum==0 || Move.playerNumber!=0) {//prevents from playing twice unless other player is unable to play
				//nothing changes
			}
			else {
				for(int j=0;j<6;j++) {
					btn.get(j).setDisable(true);
				}
				for(int j=6;j<12;j++) {
					btn.get(j).setDisable(false);
					if(OwareApp.board.getPit(j).getNumSeeds()==0){
						btn.get(j).setDisable(true);
					}
				}
			}
		}
		if(i>6) {
			for(int j=0;j<6;j++) {
				sum=sum+OwareApp.board.getPit(j).getNumSeeds();
				}
			if (sum==0) {
				//nothing changes
			}
			else {
				for(int j=0;j<6;j++) {
					btn.get(j).setDisable(false);
					if(OwareApp.board.getPit(j).getNumSeeds()==0){
						btn.get(j).setDisable(true);
					}
				}
				for(int j=6;j<12;j++) {
					btn.get(j).setDisable(true);
				}
			}
		}
		if(OwareApp.isGameOver()) {//end the game, all buttons disabled
			for(int j=0;j<12;j++) {
				btn.get(j).setDisable(true);
				gameOver.setVisible(true);
				}
		}
		
		for (int j=0;j<12;j++) {//updates all buttons
			btn.get(j).setText(""+OwareApp.board.getPit(j).getNumSeeds());

				
		}
		//updates scores
		int player1Score=OwareApp.player1.getScore();
		score.setText("player1 score= "+player1Score);
		int player2Score=OwareApp.player2.getScore();
		score1.setText("player2 score= "+player2Score);
		

		
		
	}
	


	
}