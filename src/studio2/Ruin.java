import java.util.Scanner;
public class Ruin {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("What is the amount of money that you wan to start with? ");
        int startAmount = in.nextInt();
        System.out.print("What is the probability that you win a single play? ");
        double winChance = in.nextDouble();
        System.out.print("What is the win limint it that if you reach this amount of money you had a successful day and leave? ");
        int winLimit = in.nextInt();
        System.out.print("What is the total numbers of days that you want to simulate? ");
        int totalSimulations = in.nextInt();
        int days = 0;
        int amounMoney = startAmount;
        int success = 0;
        int losses = 0;
        double expectedRuinRates;
        double alphaStartAmount = (1.0-startAmount)/startAmount;
        double alphaWinLimit = (1.0-winLimit)/winLimit;
        if(winChance == 0.5){
            expectedRuinRates = 1-(startAmount*1.0)/winLimit;
        } else{
            expectedRuinRates = (alphaStartAmount-alphaWinLimit)/(1-alphaWinLimit);
        }
        for(int i = 0; i<totalSimulations; i++){
        int timesOfPlay = 0;
        while(startAmount<winLimit && startAmount!=0){
            timesOfPlay++;
            if(Math.random()<winChance){
                startAmount++;
            } else{
                startAmount--;
            }
        }
        days++;
        if(startAmount == winLimit){
            System.out.println("Day: " + days + ", Success! Total plays: " + timesOfPlay);
            success++;
        } else {
            System.out.println("Day: " + days + ", Ruin! Total plays: " + timesOfPlay);
            losses++;
        }
        startAmount = amounMoney;

    }
    double actualRuinRate = losses*1.0/totalSimulations;
    System.out.println("Lossess: " + losses + ". Simulations: " + totalSimulations);
    System.out.println("Expected ruin rate: " + expectedRuinRates);
    System.out.println("Actual ruin rate: " + actualRuinRate);
}
}
