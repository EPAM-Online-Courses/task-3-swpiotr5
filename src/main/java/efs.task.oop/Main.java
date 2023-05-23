package efs.task.oop;
public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        Villager gheed = new Villager("Gheed", 50);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
        //Czy na objectDeckardCain lub objectAkara można wywołać metody klasy ExtraordinaryVillager?
        //objectAkara.sayHello();
        //nie można, trzeba rzutować:
        //ExtraordinaryVillager akaraNew = (ExtraordinaryVillager) objectAkara;
        //akaraNew.sayHello();
        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Villager[] villagers = {akara, deckardCain, kashya, gheed, warriv, flawia};

        int currentVillagerIndex = 0;
        int currentMonsterIndex = 0;

        while (Monsters.monstersHealth > 0) {
            Villager currentVillager = villagers[currentVillagerIndex];
            Monster currentMonster;

            if (currentMonsterIndex == 0) {
                currentMonster = Monsters.andariel;
            } else {
                currentMonster = Monsters.blacksmith;
            }

            if (currentVillager.getHealth() > 0) {
                System.out.println("Aktualnie walczacy osadnik to " + currentVillager.getName());
                System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
                currentVillager.attack(currentMonster);
            }
            if(currentMonster.getHealth()>0){
                currentMonster.attack(currentVillager);
            }

            if (currentMonster.getHealth() <= 0) {
                if (currentMonsterIndex == 0) {
                    currentMonsterIndex = 1;
                } else {
                    currentMonsterIndex = 0;
                }
            }

            currentVillagerIndex = (currentVillagerIndex + 1) % villagers.length;
        }

        System.out.println("Obozowisko ocalone!");

        // Przywracanie mocy ExtraordinaryVillager'om
        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        akara.sayHello();
        deckardCain.sayHello();
    }
}
