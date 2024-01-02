import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class Race{
  Scanner input =  new Scanner(System.in);
  private String raceName;
  private String[] raceFeatures;
  private String[] raceModifierName;
  private int[] raceModifiers;
  private String[] raceSkills;

  public String getRaceName(){
    return this.raceName;
  }

  public void setRaceName(String raceName){
    this.raceName = raceName;
  }

  public String getRaceFeatures(){
    return Arrays.toString(raceFeatures);
  }

  public String[] getRaceModifierName(){
    return this.raceModifierName;
  }

  public int[] getRaceModifiers(){
    return this.raceModifiers;
  }

  public String[] getRaceSkills(){
    return this.raceSkills;
  }

  Race(String r, String[] rF, String[] rMN, int[] rM, String... rS){
    this.raceName = r;
    this.raceFeatures = rF;
    this.raceModifierName = rMN;
    this.raceModifiers = rM;
    this.raceSkills = rS;
  }

  public void addModifiers(String[] attName, int[] attributes){
    System.out.println(raceModifierName.length);
    for (int i = 0; i < raceModifierName.length; i++){
      for (int j=0; j< attName.length; j++){
        if (attName[j]==raceModifierName[i])
          attributes[j] += raceModifiers[i];
      }
    }
  }

  // public String pickAttributes(int i){
  //   String[] attributes = {"Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "Endurance", "History",
  // "Insight","Intimidation", "Investigation", "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand ", "Stealth"};
  //   String[] chosenAttributes = new String[i];
  // for(int j=0; i<attributes.length; i++)//lists potential skills
  //   System.out.println(i+1 + ". " + attributes[i]);
  // for(int skill=0; skill<chosenAttributes.length; skill++){
  //   System.out.print("Select Skill " + (i+1) + ": ");
  //   int num = input.nextInt()-1;
  //   Array.set(chosenAttributes, i,attributes[skill]);
  //   }   
  // }

  public String modString(){
    String modString = "";
    for (int i = 0; i < raceModifiers.length; i++){
        modString = modString + raceModifierName[i].substring(0, 3) + "+" + raceModifiers[i] + "\n";
  }
    return modString;
    }



  public String toString(){
    return "\nRace Name " + this.raceName + "\n"
      + "Race Features: " 
      + Arrays.toString(this.raceFeatures) + "\n"
      + modString() + "\n";
    }
}