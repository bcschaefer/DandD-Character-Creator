import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter Player Name: ");
    String pName = input.nextLine();
    Character.clearScreen();
    
    System.out.print("Enter Character Name: ");
    String cName = input.nextLine();
    Character.clearScreen();

    Character newCharacter = new Character(pName, cName);

    Character.clearScreen();
    newCharacter.createFile();
    System.out.println(newCharacter);
    }
}