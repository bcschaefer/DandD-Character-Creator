import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class CharClass{
  Scanner input = new Scanner(System.in);
  private String className;
  private int hitDie;
  private int profBonus=2;
  private String[] savingThrows;
  private String[] potentialSkills;
  private ArrayList<String> actualSkills = new ArrayList<String>();
  private String[] proficiencies;
  private String[] features;
  private ArrayList<String> equipment = new ArrayList<String>();
  private Equipment[] chosenEquipment;

  public String getClassName(){
    return this.className;
  }
  
  public int getHitDie(){
    return this.hitDie;
  }

  public int getProfBonus(){
    return profBonus;
  }

  public String[] getSavingThrows(){
    return this.savingThrows;
  }
  
  public String[] getPotentialSkills(){
    return this.potentialSkills;
  }

  public ArrayList<String> getactualSkills(){
    return this.actualSkills;
  }

  public void addSkills(String skill){
    actualSkills.add(skill);
    }

  public String[] getProficiencies(){
    return this.proficiencies;
  }
  
  public String[] getFeatures(){
    return features;
  }
  
  public ArrayList<String> getEquipment(){
    return equipment;
  }

  public void setChosenEquipment(){
    for (int i=0; i<chosenEquipment.length; i++){
      chosenEquipment[i].chooseEquipment();
    }
  }


  public CharClass(String cN, int hD, int pB, String[] sT, String[] pS, String[] aS, String[] prof, String[] feat, String[] equip, Equipment...choiceEquip){
    className = cN;
    hitDie = hD;
    profBonus = pB;
    savingThrows = sT;
    potentialSkills = pS;
    for (String i:aS)
      actualSkills.add(i);
    proficiencies = prof;
    features = feat;
    for (String i:equip){
      equipment.add(i);
    }
    chosenEquipment = choiceEquip;


  }

//adds chosen equipment to equip arraylist
  public void addChosenEquipment(){
    setChosenEquipment();
    for(int i=0; i<chosenEquipment.length; i++){
      equipment.add(chosenEquipment[i].toString());
    }
    
  }

  

//Selects character skills based on potential skills
  public void PickSkills(){ 
  for(int i=0; i<potentialSkills.length; i++)//lists potential skills
    System.out.println(i+1 + ". " +this.potentialSkills[i]);
  for(int i=0; i<actualSkills.size(); i++){
    System.out.print("Select Skill " + (i+1) + ": ");
    int num = input.nextInt()-1;
    actualSkills.set(i,potentialSkills[num]);
    }   
  }
  
  public String toString(){
    return 
  "Class: " + className + "\n"
+ "Saving Throws: " + Arrays.toString(savingThrows) + "\n" 
+ "Proficiencies: " + Arrays.toString(proficiencies) + "\n" 
+ "Skills: " + actualSkills.toString() + "\n"
+ "Features: " + Arrays.toString(features) + "\n"
+ "Equipment: " + equipment.toString();
  }

}