/*
____ Implementation of a PlayerStatus class that updates the in game player's status ____
 		- OOP concepts PRACTICE; */


public class PlayerStatus {

	private String nickname;   // player nickname
	private int score;		// player score
	private int lives;	// player lives
	private int health; 	// player health
	private String weaponInHand; // player's weapon in hand
	private double positionX;	// OX player position coordinate on map
	private double positionY;		// OY player position coordinate on map
	public static String gameName = "BattleGround";

	public void initPlayer(String nickname) {	// initializes the player's name
		this.nickname = nickname;
	}

	public void initPlayer(String nickname, int lives) { // initializez "nickname" and "lives" fields
		this.nickname = nickname;
		this.lives = lives;
	}

	public void initPlayer(String nickname, int lives, int score) { // initializes the fields with the same name as the parameters
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}

	public void findArtifact(int artifactCode) { 	// updates the player's status according to the artifact found
		
		if (isPerfect(artifactCode)) {	// if artifact is perfect number -> update score/lives/health
			score += 5000;
			lives += 1;
			health = 100;
		} else if (isPrime(artifactCode)) {		// if artifact is prime number -> update score/lives/health
		  		score += 1000;
		 		lives += 2;
		 		health += 25;
		 		if (health > 100) {
		 			health = 100;
		 		}
		} else if (isEven(artifactCode) && isSum(artifactCode)) {   // if artifact is even number and sum of digits is divisible by 3
			score -= 3000;						// decrements score
			health -= 25;					// decrements health
				if (health == 0) { 	
					lives -= 1;
					health = 100;
				}
		} else {					// any other numbers 
			score += artifactCode;
		}
		

	}
	private boolean isPerfect(int n) {  // verifies if number given is perfect
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum = sum + i;
			}
		}
		return n == sum;
	}
	private boolean isPrime(int n) {  // verifies if number given is prime
		int copy;
		boolean isPrime = true;
		for (int i = 2; i <= n / 2;i++) {
		  		copy = n % i ;
		  		if (copy == 0) {
		  			isPrime = false;
		  			break;
		  		}
		 }
		return isPrime;
	}
	private boolean isEven(int n) { 	// verifies if number given is even
		return n % 2 == 0;
	}
	private boolean isSum(int n) {		// verifies if sum of digits is divisible by 3 and returns it
		 int sumCif = 0;
		  while (n != 0) {
		  		   int uC = n % 10;
		  		   sumCif += uC;
		  		   n /= 10;
		  }
		  return sumCif % 3 == 0;
	}

	public boolean setWeaponInHand(String weaponInHand) {		// changes the weapon in hand used by player
		if (isWeaponValid(weaponInHand) && hasMoneyForWeapon(weaponInHand)) {  //  verifies if weapon is valid and if player has money for it
			this.weaponInHand = weaponInHand;
			updateScore(weaponInHand);		// if condition is true -> set weapon in hand -> update score
			return true;
		} 
			return false;
	}
	
	public String getWeaponInHand() { 	// returns the player's current weapon
		return weaponInHand;
	}
	
	private void updateScore(String weapon) {	// menu with weapons available for purchase(sniper/kalashnikov/knife) 
												
		switch (weapon) {
		 case "knife":
			 score = score - 1000;
			 break;
		 case "sniper":
			 score = score - 10000;
			 break;
		 case "kalashnikov":
			 score = score - 20000;
			 break;
		 default :
			 break;
		}
	}
	
	private boolean hasMoneyForWeapon(String weapon) {		// verifies if player has money for weapon
															// updates the score after purchase
		switch (weapon) {
		 case "knife":
			 return score >= 1000;
		 case "sniper":
			 return score >= 10000;
		 case "kalashnikov":
			 return score >= 20000;
		 default :
			 return false;
		}
	}
	
	private boolean isWeaponValid(String weapon) {   		// verifies if weapon exists
		return weapon.equals("knife") || weapon.equals("sniper") || weapon.equals("kalashnikov");
	}
		
	public double getPositionX() {  // returns the OX coordinate of player on map
		return positionX;
	}

	public void setPositionX(double positionX) {		// set's the OX coordinate of player on map
		this.positionX = positionX;
	}

	public double getPositionY() {	// returns the OY coordinate of player on map
		return positionY;
	}

	public void setPositionY(double positionY) {		// set's the OY coordinate of player on map
		this.positionY = positionY;
	}

	public String getGameName() { 		// returns the name of the game
		return gameName;
	}

	protected void setGameName(String gameName) {		// sets game name
		PlayerStatus.gameName = gameName;
	}

	public void movePlayerTo(double positionX, double positionY) {		// move's playes to given set of double values
		setPositionX(positionX);
		setPositionY(positionY);
	}

	public String getNickName () {   // returns the player's nickname
		return nickname;
	}

	public int getHealth () {   // returns the player's health
		return health;
	}
	
	public int getScore () {	// returns player's score
		return score;
	}
	
	private boolean powerWeaponsForLongDistance (String weapon1, String weapon2) {  // conditions for winning battle in longDistance combat
		
		if (weapon1.equals("sniper") && weapon2.equals("kalashnikov")) return true;
		if (weapon1.equals("sniper") && weapon2.equals("knife")) return true;
		if (weapon1.equals("kalasnikov") && weapon2.equals("knife")) return true;
		if (weapon1.equals("kalashnikov") && weapon2.equals("sniper")) return false;
		if (weapon1.equals("knife") && weapon2.equals("kalashnikov")) return false;
		if (weapon1.equals("knife") && weapon2.equals("sniper")) return false;
		return false;
	}
	
	private boolean powerWeaponsForShortDistance (String weapon1, String weapon2) {	// conditions for winning battle in shortDistance combat
		
		if (weapon1.equals("sniper") && weapon2.equals("kalashnikov")) return false;
		if (weapon1.equals("sniper") && weapon2.equals("knife")) return true;
		if (weapon1.equals("kalasnikov") && weapon2.equals("knife")) return true;
		if (weapon1.equals("kalashnikov") && weapon2.equals("sniper")) return true;
		if (weapon1.equals("knife") && weapon2.equals("kalashnikov")) return false;
		if (weapon1.equals("knife") && weapon2.equals("sniper")) return false;
		return false;
	}
	
	public boolean shouldAttackOpponent(PlayerStatus oponent) {     // simulates a battle between 2 players using Euclidean distance formula
		
		if (weaponInHand.equals(oponent.getWeaponInHand())) {
			int probabilityP1 = (3 * health + score / 1000) / 4;
			int probabilityP2 = (3 * oponent.getHealth() + oponent.getScore() / 1000) / 4;
			return probabilityP1 > probabilityP2;
		} else {
			double distance = Math.sqrt(Math.pow(positionX - oponent.positionX, 2) + Math.pow(positionY - oponent.positionY, 2));
			if (distance > 1000) {
				System.out.println(" Esti la distanta mare de oponent !");
				return powerWeaponsForLongDistance(weaponInHand, oponent.getWeaponInHand());
			} else {
				System.out.println(" Esti aproape de oponent ! ");
				return powerWeaponsForShortDistance(weaponInHand, oponent.getWeaponInHand());
			}
		}
	}
}
