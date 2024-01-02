import java.util.stream.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


  
class Character{
  Scanner input =  new Scanner(System.in);
  private String playerName;
  private String charName;
  private int attributes[];
  private String attributeName[] = {"Strength", "Dexterity", "Constitution", "Intellegence", "Wisdom", "Charisma"};
  private int hitPoints;
  private CharClass playerClass;
  private Race playerRace;





//(Hit Dice, Prof Bonus, {Saving Throws}, {Potential Skills}, {Actual Skills(Empty)}, {Proficiencies}, {Features}, {Given Equipment}, {Chosen Equipment...})

  private CharClass Barbarian = new CharClass("Barbarian", 12, 2, new String[] {"Strength", "Constitution"}, new String[] {"Animal Handling", "Athletics", "Intimidation", "Nature", "Perception", "Survival"}, new String[2], new String[]{"Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"}, new String[] {"Rage", "Unarmored Defence"}, new String[] {"Explorer's Pack", "4 Javelins"}, new Equipment("Greataxe", "Any Martial Melee Weapon"), new Equipment("Two Handaxes", "Any Simple Weapon"));
  
  private CharClass Bard = new CharClass("Bard", 8, 2, new String[] {"Dexterity","Charisma"}, new String[]{"Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "Endurance", "History",
  "Insight","Intimidation", "Investigation", "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand ", "Stealth"}, new String[3], new String[]{"Simple Weapons", "Light Armor"}, new String[]{"Spellcasting", "Bardic Inspiration (d6)"}, new String[] {"Leather Armor", "Dagger"}, new Equipment("Diplomat's Pack", "Entertainer's Pack"), new Equipment("Lute", "other musical instrument"));
  
  private CharClass Cleric = new CharClass("Cleric", 8, 2, new String[] {"Wisdom","Charisma"}, new String[]{"History", "Insight", "Medicine", "Persuasion", "Religion"}, new String[2], new String[]{"Simple Weapons", "Light Armor", "Medium Armor", "Shields"}, new String[]{"Spellcasting", "Divine Domain"}, new String[] {"Sheild", "Holy Symbol"}, new Equipment("Mace", "Warhammer"), new Equipment("Light Crossbow", "Simple Weapon"), new Equipment ("Holy Symbol", "Priest's Pack"));

  private CharClass Druid = new CharClass("Druid", 8, 2, new String[] {"Intelligence", "Wisdom"}, new String[]{"Arcana", "Animal Handling", "Insight", "Medicine", "Nature", "Perception", "Religion", "Survival"}, new String[2], new String[]{"Simple Weapons", "Light Armor", "Shields", "Herbalism Kit"}, new String[]{"Spellcasting", "Druidic"}, new String[] {"Leather Armor", "Explorer's Pack", "Druidic Focus"}, new Equipment("Scimitar", "Simple Weapon"), new Equipment("Wooden Shield", "Simple Weapon")); 

  private CharClass Fighter = new CharClass("Fighter", 10, 2, new String[] {"Strength", "Constitution"}, new String[]{"Acrobatics", "Animal Handling", "Athletics", "History", "Insight", "Intimidation", "Perception", "Survival"}, new String[2], new String[]{"All Armor", "Shields", "Simple Weapons", "Martial Weapons"}, new String[]{"Fighting Style", "Second Wind"}, new String[]{}, new Equipment("Chain Mail", "Leather Armor", "Longbow"), new Equipment("Martial Weapon and Shield", "2 Martial Weapons"), new Equipment("Light Crossbow", "Two Handaxes"), new Equipment("Dungeneer's Pack", "Explorer's Pack")); 

    private CharClass Monk = new CharClass("Monk", 8, 2, new String[] {"Strength", "Dexterity"}, new String[]{"Acrobatics", "Athletics", "History", "Insight", "Religion", "Stealth"}, new String[2], new String[]{"Simple Weapons", "Short Swords", "Two Artisan's Tools of Your Choice"}, new String[]{"Unarmored Defence", "Martial Arts"}, new String[] {"10 Darts"}, new Equipment("Short Sword", "Simple Weapon"), new Equipment("Dungeoneer's Pack", "Explorer's Pack")); 

  private CharClass Paladin = new CharClass("Paladin", 10, 2, new String[] {"Wisdom", "Charisma"}, new String[]{"Athletics", "Insight", "Intimidation", "Medicine", "Persuasion", "Religion"}, new String[2], new String[]{"All Armor", "Shields", "Simple Weapons", "Martial Weapons"}, new String[]{"Divine Sense", "Lay on Hands"}, new String[] {"Chain Mail", "Holy Symbol"}, new Equipment("A Martial Weapon and Shield", "2 Martial Weapons"), new Equipment("Priests's Pack", "Explorer's Pack"), new Equipment("5 Javelins", "Any Simple Weapon"));

  private CharClass Ranger = new CharClass("Ranger", 10, 2, new String[] {"Strength", "Dexterity"}, new String[]{"Animal Handling", "Athletics", "Insight", "Investigation", "Nature", "Perception", "Stealth", "Survival"}, new String[3], new String[]{"Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"}, new String[]{"Favored Enemy", "Natural Explorer"}, new String[] {"Longbow"}, new Equipment("Scale Mail", "Leather Armor"), new Equipment("2 Shortswords", "2 Simple Melee Weapons"), new Equipment("Dungeoneer's Pack", "Explorer's Pack"));

  private CharClass Rogue = new CharClass("Rogue", 10, 2, new String[] {"Dexterity", "Intelligence"}, new String[]{"Acrobatics", "Athletics", "Deception", "Insight", "Intimidation", "Investigation", "Perception", "Performance", "Persuasion", "Sleight of Hand", "Stealth"}, new String[4], new String[]{"Light Armor", "Simple Weapons", "Hand Crossbows", "Longbows", "Rapiers", "Shortswords", "Theives Tools"}, new String[]{"Expertise", "Sneak Attack", "Thieves' Cant"}, new String[] {"Leather Armor", "2 Daggers", "Theives' Tools"}, new Equipment("Burglar's Pack", "Dungeoneer's Pack", "Explorer's Pack"), new Equipment("Rapier", "Shortsword"), new Equipment("Shortbow", "Shortsword"));

  private CharClass Sorcerer = new CharClass("Sorcerer", 6, 2, new String[] {"Constitution", "Charisma"}, new String[]{"Arcana", "Deception", "Insight", "Intimidation", "Persuasion", "Religion"}, new String[2], new String[]{"Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"}, new String[]{"Spellcasting", "Sorcerous Orgin"}, new String[] {"2 Daggers"}, new Equipment("Light Crossbow", "Simple Weapon"), new Equipment("Component Pouch", "Arcane Focus"), new Equipment("Dungeoneer's Pack", "Explorer's Pack"));

  private CharClass Warlock = new CharClass("Warlock", 8, 2, new String[] {"Wisdom", "Charisma"}, new String[]{"Arcana", "Deception", "History", "Intimidation", "Investigation", "Nature", "Religion"}, new String[2], new String[]{"Light Armor", "Simple Weapons"}, new String[]{"Otherworldly Patron", "Pact Magic"}, new String[] {"Leather Armor", "Simple Weapon","2 Daggers"}, new Equipment("Light Crossbow", "Simple Weapon"), new Equipment("Component Pouch", "Arcane Focus"), new Equipment("Dungeoneer's Pack", "Scholar's Pack")); 

  private CharClass Wizard = new CharClass("Wizard", 6, 2, new String[] {"Intellegence", "Wisdom"}, new String[]{"Arcana", "History", "Insight", "Investigation", "Medicine", "Religion"}, new String[2], new String[]{"Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"}, new String[]{"Spellcasting", "Arcane Recovery"}, new String[] {"Spellcasting"}, new Equipment("Quarterstaff", "Dagger"), new Equipment("Component Pouch", "Arcane Focus"), new Equipment("Explorer's Pack", "Scholar's Pack")); 

  private Race Dragonborn = new Race("Dragonborn", new String[]{"Draconic Ancestory", "Breath Weapon", "Damage Resistance", "Draconic Language"}, new String[] {"Strength", "Charisma"}, new int[]{2, 1});

  private Race Dwarf = new Race("Dwarf", new String[]{"Darkvision", "Dwarven Resilience", "Dwarvish Language"}, new String[] {"Constitution"}, new int[]{2});

  private Race Elf = new Race("Elf", new String[]{"Darkvision", "Fey Ancestory", "Elvish Trance"}, new String[] {"Constitution"}, new int[]{2}, "Perception");

  private Race Gnome = new Race("Gnome", new String[]{"Darkvision", "Gnome Cunning"}, new String[] {"Intellegence"}, new int[]{2});

  private Race HalfElf = new Race("Half-Elf", new String[]{"Lucky", "Brave", "Halfling Nimbleness"}, new String[] {"Intellegence", "Wisdom", "Charisma"}, new int[]{1, 1, 2}, "Perception", "Survival");

  private Race Halfling = new Race("Halfling", new String[]{"Darkvision", "Fey Ancestory"}, new String[] {"Dexterity"}, new int[]{2}, "Perception", "Survival");

  private Race HalfOrc = new Race("Half-Orc", new String[]{"Darkvision", "Relentless Endurance", "Savage Attacks"}, new String[] {"Strength", "Constitution"}, new int[]{2, 1}, "Perception", "Survival");
  
  private Race Human = new Race("Human", new String[]{"Free Language of Choice"}, new String[] {"Strength", "Dexterity", "Constitution", "Intellegence", "Wisdom", "Charisma"}, new int[]{1, 1, 1, 1, 1, 1});


//puts every player class into an array
  private ArrayList <CharClass> ClassList = new ArrayList<CharClass>(Arrays.asList(Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, Sorcerer, Warlock, Wizard));

  private ArrayList <Race> RaceList = new ArrayList<Race>(Arrays.asList(Dragonborn, Dwarf, Elf, Gnome, HalfElf, Halfling, HalfOrc, Human));

  //clears screen; stole from internet
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  

  public ArrayList<CharClass> getClassList(){
    return ClassList;
  }

  public CharClass getPlayerClass(){
    return playerClass;
  }

  public void setCharClass(){
    this.playerClass = this.ChooseClass();
  }

  public void setCharRace(){
    this.playerRace = this.ChooseRace();
  }
  
  public String getCharName(){
    return this.charName;
  }
  
  public void setCharName(String charName){
    this.charName = charName;
  }

  public String getPlayerName(){
    return this.playerName;
  }
  
  public void setPlayerName(String playerName){
    this.playerName = playerName;
  }

  public int getHitPoints(){
    return this.hitPoints;
  }

  public void setHitPoints(int hitDie, int con){
    this.hitPoints = hitDie+con;
  }


  
//roll 4 6-sided dice, drop the lowest, called in setAttributes
  public int rollStats(){
    clearScreen();
    int dice[] = new int[4];
    for (int i = 0; i < dice.length; i++){ 
      //get 4 random dice rolls
      dice[i]=(int)(Math.random()*6+1);
      }
    int lowest=0;
    for (int i=0; i < dice.length; i++){ 
      //find and drop lowest dice
      if (dice[i]<dice[lowest]){
        dice[i]=dice[lowest];
      lowest++;
      }   
    }
    dice[lowest]=0;
    return IntStream.of(dice).sum();
 }

  //sets strength, constitution, ect.
  public void setAttributes(){
ArrayList<Integer> diceStats= new  ArrayList<Integer>(); //get empty array of dice rolls
    int diceTotal = 0;
    for (int i = 0; i<6; i++){
      diceStats.add(null);
    }
    //reroll dice until sum of dice > 70
    while (diceTotal < 60){
      diceTotal = 0;
      for (int i=0; i<6; i++){
        diceStats.set(i, rollStats());
        diceTotal+=diceStats.get(i);
    }
      }
    //user sets attributes based on dice score
    attributes = new int[6];
    for (int i=0; i<6; i++){
      System.out.println("Avalible numbers: " + diceStats + "\n");
      System.out.print("Select value for " + attributeName[i] + ": ");
      int selectedStat = input.nextInt();
      if (diceStats.contains(selectedStat)){
        attributes[i]=selectedStat;
        diceStats.remove(diceStats.indexOf(selectedStat));
        clearScreen();
      }
      else{
        i--; //go through same iteration if stat isn't in array
        clearScreen();
      }
      }
    }

//picks class from array of possible classes
  public CharClass ChooseClass(){ 
    for(int i=0; i<ClassList.size(); i++)
      System.out.println(i+1 + ". " +  ClassList.get(i).getClassName());
    System.out.print("Pick a class: ");
    int num = input.nextInt()-1;
    return ClassList.get(num);
    }

//picks race from array of possible races
  public Race ChooseRace(){
    for(int i=0; i<RaceList.size(); i++){
      System.out.print(i+1 + ". " +  RaceList.get(i).getRaceName() + "\n");
      }
    System.out.print("Pick a race: ");
    int num = input.nextInt()-1;
    return RaceList.get(num);
    }

//adds race skills to playerClass skills array
  public void addToSkills(){
    if (this.playerRace.getRaceSkills().length>0){
      for (int i = 0 ; i<this.playerRace.getRaceSkills().length; i++){
        //checks if player already has skill
        if (!this.playerClass.getactualSkills().contains(this.playerRace.getRaceSkills()[i]))
          this.playerClass.addSkills(playerRace.getRaceSkills()[i]);
      }
    }
  }

//generates character sheet
  Character(String pName, String cName){
    this.setCharClass();
    clearScreen();
    this.setCharRace();
    clearScreen();
    this.playerName = pName;
    this.charName = cName;
    playerClass.PickSkills();
    this.setAttributes();
    this.setHitPoints(attributes[2],  playerClass.getHitDie());
    playerClass.addChosenEquipment();
    playerRace.addModifiers(attributeName, attributes);
    this.addToSkills();
  }


  
//turns attribute class into string
  public String attributeString(){
    String attributeString = "";
    for (int i = 0; i < attributes.length; i++){
        attributeString = attributeString + attributeName[i] + ": " + attributes[i] + "\n";
    }
    return attributeString;
  }

  //creates file of character
  public void createFile(){
    try {
      FileWriter classFile = new FileWriter(charName);
      classFile.write(
        "Player Name: " + playerName + "\n"
      + "Character Name: " + charName + "\n"
      + "Hit Points: " + this.getHitPoints() + "\n"
      + this.attributeString() + "\n"
      + playerClass + "\n"
      + playerRace.getRaceName() + "\n"   
      + playerRace.getRaceFeatures());
      classFile.close();
      }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public String toString(){
    return "Player Name: " + this.playerName + "\n"
      + "Character Name: " + this.charName + "\n"
      + "Hit Points: " + this.getHitPoints() + "\n"
      + playerClass + "\n" 
      + playerRace + "\n\n"
      + this.attributeString();
  }
  }
