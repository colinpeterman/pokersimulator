
import java.util.ArrayList;
import java.util.Scanner;
// Utilizes the Card and PokerDeack packages in order to create 
// a black jack hanf which calculates the total value of the 
// 4 cards as well as runs a experiment to see how many 
// hands bust out of 1 million hands. 

public class PokerSimulator {
   public static final int HIGH_CARD = 0;
   public static final int ONE_PAIR = 1;
   public static final int TWO_PAIR = 2;
   public static final int THREE_OF_A_KIND = 3;
   public static final int STRAIGHT = 4;
   public static final int FLUSH = 5;
   public static final int FULL_HOUSE = 6;
   public static final int FOUR_OF_A_KIND = 7;
   public static final int STRAIGHT_FLUSH = 8;
   public static final int ROYAL_FLUSH = 9;
   public static int x;
   
   public static void main(String[] args) {
      Scanner imput = new Scanner(System.in);
      System.out.print("How many poker hands should I deal?");
      x = imput.nextInt();
      long startTime = System.nanoTime();
      displayStats(runSimulations(x));
      long endTime = System.nanoTime();
      System.out.printf("%,d" ,x);
      System.out.printf(" hands were analyzed in %.4f" , (((double) endTime - startTime)/1000000000)); 
      System.out.println(" seconds.");
   }
   
   //Prints statistics from multiple trials of evaluated poker hands.
   public static void displayStats(int[] result){
      System.out.println("-----------------------------------");
      System.out.printf("%15s:%,10d %7.4f%%%n" , "High Card" , result[0] , (((double) result[0])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "One pair" , result[1] , (((double) result[1])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Two pair" , result[2] , (((double) result[2])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Three of a kind" , result[3] , (((double) result[3])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Straight" , result[4] , (((double) result[4])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Flush" , result[5] , (((double) result[5])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Full House" , result[6] , (((double) result[6])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Four of a kind" , result[7] , (((double) result[7])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Straight flush" , result[8] , (((double) result[8])/x) * 100);
      System.out.printf("%15s:%,10d %7.4f%%%n" , "Royal flush" , result[9] , (((double) result[9])/x) * 100);
      System.out.println("-----------------------------------");
   }
   
   //Deals a hand of poker from a new, shuffled deck, and returns 
   //an int representing the type of hand that was dealt.
   
   public static int evaluateOnePokerHand(){
      Card[] hand = randomSortedHand();
      if(hasRoyalFlush(hand)){
         return 9;
      }
      else if(hasStraightFlush(hand)){
         return 8;
      }
      else if(hasFourOfAKind(hand)){
         return 7;
      }
      else if(hasFullHouse(hand)){
         return 6;
      }
      else if(hasFlush(hand)){
         return 5;
      }
      else if(hasStraight(hand)){
         return 4;
      }
      else if(hasThreeOfAKind(hand)){
         return 3;
      }
      else if(hasTwoPair(hand)){
         return 2;
      }
      else if(hasOnePair(hand)){
         return 1;
      }
      else{
         return 0;
      }
   }
   
   //returns whether a hand of 5 cards contains a flush (same suit)
   // done
   public static boolean hasFlush(Card[] hand){
      boolean idk = false;
      int firstSuit = hand[0].getSuit();
      for(int i = 0; i < 4; i++){
         if(firstSuit == hand[i+1].getSuit()){
            idk = true;
         }
         else{
            return false;
         }
      }
      return idk;
   }
   
   //returns whether a 5-card hand contains 4 cards that are the same value
   // done
   public static boolean hasFourOfAKind(Card[] hand){
      boolean idk = false;
      boolean idk1 = false;
      for(int i = 1; i < 4; i++){
         if(hand[0].getValue() == hand[i].getValue()){
            idk = true;
         }
         else{
            idk = false;
            break;
         }
      }
      for(int i = 2; i < 5; i++){
         if(hand[1].getValue() == hand[i].getValue()){
            idk1 = true;
         }
         else{
            idk1 = false;
            break;
         }
      }
      if(idk == true || idk1 == true){
         idk = true;
      }
      return idk;
   }
   
   //returns whether a 5-card hand contains a full house 
   //(3 of a kind in one value, and a pair of another value)
   // done
   public static boolean hasFullHouse(Card[] hand){
      if(hand[2].getValue() == hand[4].getValue()){
         if(hand[0].getValue() == hand[1].getValue()){
            return true;
         }
      }
      if(hand[2].getValue() == hand[0].getValue()){
         if(hand[3].getValue() == hand[4].getValue()){
            return true;
         }
      }
      return false;
   }
   
   //returns whether a 5-card hand contains a pair of cards with the same value.
   // done
   public static boolean hasOnePair(Card[] hand){
      boolean idk = false;
      for(int x = 0; x < 5; x++){
         for(int i = 0; i < 4; i++){
            if(hand[i].getValue() == hand[i+1].getValue()){
               return true;
            }
         }
      }
      return idk;
   }
   
   //returns whether a 5-card hand contains a royal flush (an Ace-high straight flush)
   // done
   public static boolean hasRoyalFlush(Card[] hand){
      if(hasFlush(hand) == true){
         if(hand[0].getValue() == 1 && hand[1].getValue() == 10 && hand[2].getValue() == 11 && 
            hand[3].getValue() == 12 && hand[4].getValue() == 13){
            return true;
         }
      }
      return false;
   }
   
   // returns whether a hand of 5 cards contains a straight (5 cards in sequence).
   // Done 
   public static boolean hasStraight(Card[] hand){
      boolean idk = false;
      for(int i = 0; i < 4; i ++){
         if(hand[i].getValue() + 1 == hand[i+1].getValue() || (hand[i].getValue() == 1 && hand[i].getValue() + 9 == hand[i+1].getValue())){
            idk = true;
         }
         else{
            return false;
         }
      }
      return idk;
   }
   
   //returns whether a 5-card hand contains a straight flush (both a straight and a flush)
   // done
   public static boolean hasStraightFlush(Card[] hand){
      if(hasStraight(hand) == true && hasFlush(hand) == true){
         return true;
      }
      else{
         return false;
      }
   }
   
   //returns whether a 5-card hand contains at least 3 cards that are the same value
   // done
   public static boolean hasThreeOfAKind(Card[] hand){
      int count = 0;
      for(int x = 1; x < 14; x++){
         for(int i = 0; i <5; i++){
            if(hand[i].getValue() == x){
               count++;
            }
         }
         if(count == 3){
            return true;
         }
         else{
            count = 0;
         }
      }
      return false;
   }
   
   //returns whether a 5-card hand contains 2 pairs of matching values.
   // done
   public static boolean hasTwoPair(Card[] hand){
      int count = 0;
      for(int i = 0; i < 4; i++){
         if(hand[i].getValue() == hand[i+1].getValue()){
            count++;
         }
      }
      if(count == 2){
         return true;
      }
      return false;
   }
   
   //Returns a space delimited string of the cards in a poker hand, 
   // useful for debugging and testing hands.
   // done
   public static java.lang.String makeString(Card[] hand){
      String cards1 = "";
      for(int i = 0; i < 5; i++){
         cards1 = cards1 + " " + hand[i].toString();
      }
      return cards1;
   }
   
   // Returns one random 5-card poker hand, sorted by value.
   // done.
   public static Card[] randomSortedHand(){
      PokerDeck pd = new PokerDeck();
      pd.shuffle();
      Card[] hand = new Card[5];
      for(int i = 0; i < 5;++i){
         hand[i] = (pd.deal());
      }
      sort(hand);
      return hand;
   }
   
   //Runs n simulations of evaluating poker hands, 
   //returning an array of size 10 that contains the accumulated statistics
   //for those simulations, starting with the number of high-card hands, 
   //one-pair hands, and so on, all the way up to the number of royal-flush hands
   public static int[] runSimulations(int n){
      int[] result = new int[10];
      for(int i = 0; i < n; i++){
         result[evaluateOnePokerHand()]++;
      }
      return result;
   }
   
   // Sorts an array of cards by value, with aces before 2, 3, 4, and so on, and J, Q, K as the three highest values.
   // Works :)
   public static void sort(Card[] hand){
      for(int i = 0; i < 5; i++){
         for(int x = 0; x < 4;x++){
            if(hand[x].getValue() > hand[x+1].getValue()){
               Card variable = hand[x];
               hand[x] = hand[x+1];
               hand[x+1] = variable;
            }
         }
      }
   }
}