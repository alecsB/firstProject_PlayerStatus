import java.util.Scanner;

/*TESTs for PLAYERSTATUS Class
    -> Adding some players with default settings
    -> player name setup
    -> giving some random coordinates
    -> purchasing a weapon from menu
    -> moving players untill they find artifacts
    -> adding artifacts for all posible cases
    -> battle between 2 players
    		-> when they are in longDistance case
    		-> when they are in shortDistance case
   	-> euclidean distance formula */

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String player1;
		int w;
		String move;
		int stats;
		int exit;
		System.out.println();
		System.out.println();
		System.out.println(" \t\t\t\t*** Welcome to BattleGround ***");
		System.out.println();
		PlayerStatus p1 = new PlayerStatus();
		PlayerStatus p2 = new PlayerStatus();
		
		System.out.println(" Introduceti numele jucatorului: ");
		player1 = sc.nextLine();
		
		p1.initPlayer(player1, 3, 20000);
		p1.movePlayerTo(10, 50);
		
		System.out.println(" Bine ai revenit in joc " + p1.getNickName() + "!");
		System.out.println(" Ai fost spawnat la coordonatele: x=" +  p1.getPositionX() + " , y=" + p1.getPositionY() + " insa iti lipseste ceva. ");
		System.out.println();
		System.out.println(" Nu ai nicio arma. Pentru a selecta o arma apasa (1)Kalashnikov/(2)Sniper/(3)Knife ");
		w = sc.nextInt();
		
		if (w == 1) p1.setWeaponInHand("kalashnikov");
		if (w == 2) p1.setWeaponInHand("sniper");
		if (w == 3) p1.setWeaponInHand("knife");
		if (w <= 0 || w > 3) {
			System.out.println("Te rog sa introduci o valoare cuprinsa intre 1 si 3.");
		}
		
		System.out.println(" Ai selectat " + p1.getWeaponInHand() + ". Esti gata de lupta! Fii cu ochii in patru !");
		System.out.println();
		System.out.println(" Deplaseaza jucatorul pe harta folosind comanda (move) in consola: ");
		move = sc.next();
		
		p1.movePlayerTo(50, 100);
		p1.findArtifact(496);
		
		System.out.println(" Felicitari! Ai gasit un artifact! ");
		System.out.println(" Apasa (4) pentru a vedea statusul curent al jucatorului: ");
		stats = sc.nextInt();
		System.out.println();
		p1.movePlayerTo(70, 150);
		System.out.println("Nickname: " + p1.getNickName() + "\nScore: " + p1.getScore() + "\nHealth: " + p1.getHealth() 
							+ " \nWeapon Used: " + p1.getWeaponInHand() + "\nCoords: x= " + p1.getPositionX() + " , y= " + p1.getPositionY());
		System.out.println();
		System.out.println(" Deplaseaza jucatorul folosind comanda (move) in consola: ");
		move = sc.next();
		
		p1.findArtifact(60);
		p1.movePlayerTo(100, 200);
		
		System.out.println(" Ghinion! Ai mai gasit un artifact dar din pacate este o capcana !");
		System.out.println();
		System.out.println("-Statusul tau dupa update este- ");
		System.out.println("Nickname: " + p1.getNickName() + "\nScore: " + p1.getScore() + "\nHealth: " + p1.getHealth() 
							+ " \nWeapon Used: " + p1.getWeaponInHand() + "\nCoords: x= " + p1.getPositionX() + " , y= " + p1.getPositionY());
		System.out.println();
		System.out.println(" Deplaseaza jucatorul folosind comanda (move) in consola: ");
		move = sc.next();
		
		p2.initPlayer("Player2", 1, 20000);
		p2.setWeaponInHand("sniper");
		p2.movePlayerTo(90, 250);
		
		System.out.println(" Il ai in vizor pe: " + p2.getNickName() + " care se afla la coordonatele: x=" 
								+ p2.getPositionX() + " , y=" + p2.getPositionY() + " si foloseste un " + p2.getWeaponInHand());
		System.out.println();
		System.out.println(" \t* WARNING *"); 
		System.out.println();
		if (p1.shouldAttackOpponent(p2)) {
			System.out.println(" Ai sanse sa invingi pentru ca " + p2.getNickName() + " foloseste un " + p2.getWeaponInHand() 
								+ " si tu folosesti un " + p1.getWeaponInHand());
		} else {
			System.out.println(" Vei pierde lupta pentru ca " + p2.getNickName() + " foloseste un " + p2.getWeaponInHand() 
								+ " si tu folosesti un " + p1.getWeaponInHand() + ".");
		}
		System.out.println();
		System.out.println(" Deplaseaza jucatorul folosind comanda (move) in consola: ");
		move = sc.next();
		
		p2.movePlayerTo(2000, 5000);
		p2.setWeaponInHand("sniper");
		
		System.out.println(" Il ai in vizor pe: " + p2.getNickName() + " care se afla la coordonatele: x=" 
				+ p2.getPositionX() + " , y=" + p2.getPositionY() + " si foloseste un " + p2.getWeaponInHand());
		System.out.println();
		System.out.println("\t * WARNING *");
		System.out.println();
		if (p1.shouldAttackOpponent(p2)) {
			System.out.println(" Ai sanse sa invingi pentru ca " + p2.getNickName() + " foloseste un " + p2.getWeaponInHand() + ".");
		} else {
			System.out.println(" Vei pierde lupta pentru ca " + p2.getNickName() + " foloseste un " + p2.getWeaponInHand() 
								+ " si tu folosesti un " + p1.getWeaponInHand() + ".");
		}
		if (p1.getHealth() < 0) {
			System.out.println(" GAME OVER");
		}
		System.out.println();
		System.out.println(" Daca doresti sa salvezi si sa inchizi aplicatia apasa tasta (0): ");
		exit = sc.nextInt();
		if (exit == 0) {
			System.out.println(" La revedere!");
		}
		sc.close();
	}

}
