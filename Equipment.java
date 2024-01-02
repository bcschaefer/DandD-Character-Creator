import java.util.Scanner;
class Equipment{
  private String name;
  private String[] choice;

  Scanner input = new Scanner(System.in);
  
  Equipment(String... choice){
    this.choice = choice;
  }

  public void chooseEquipment(){
        for (int i = 0; i < choice.length; i++){
      System.out.println((i+1) + ". " + choice[i]);
    }
    System.out.print("Select an equipment: ");
    this.name = choice[input.nextInt()-1];
    Character.clearScreen();
  }

  public String toString(){
    return this.name;
  }
}