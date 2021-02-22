# firstProject_PlayerStatus

# Project Objective: 

   > Designing and implementation of a PlayerStatus class that keeps updated the status of the player.
 
   > The program has the following features:
   
              => Creates and adds new players with custom names;
              => Players can choose their name and their weapon based on their score and points;
              => Simulates a fight between two players that bump into each other;
              => The fight is based on two major criteria: distance and weapon used by each player;
              => To win in all long distance battle cases the player needs to have a Sniper;
              => To win in all short distance battle cases the player needs to have a Kalashnikov;

# General rules according to which the game is running:

   * Health: 
         -  values between 0 and 100;
         -  if health is 0, number of lives will be decremented(player dies and starts again with 100 health);
         -  if health is >100, the value will be truncated to 100
          
   * Lives:
         - if value of lives is = 0, game is over, print a message for this ! ;
         
   * Weapons: 
         - player can have SNIPER, KALASHNIKOV, KNIFE;
         - Sniper = 10000 points, Kalashnikov = 20000 points, Knife = 1000 points;
         - the player needs a minimum of points that is equal to weapon cost;
         
   * Coordinates of players:
         - Give random coordinates for players( Ox / Oy );
         
   * Conditions for battle mode:
         - distance between two players(calculated using Euclidean Distance Formula);
         
                    - if players have same weapon in hand:
                                - calculates the winning probability using: (3 * health + score / 1000) / 4 
                                - player which has higher probability WINS;
                                
                    - if players have different weapons in hands, the power depends on the distance between them:
                                 - distance > 1000 -> weapon power decreases as follows: sniper > kalashnikov > knife
                                 - distance < 1000 -> weapon power decreases as follows: kalashnikov > sniper > knife 
                                 - 
         - weapons used(weapon in hand used by every player);
    
