package efs.task.oop;

public class ExtraordinaryVillager extends Villager {
    public enum Skill{
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private String villagerInfo;

        Skill(String villagerInfo) {
            this.villagerInfo = villagerInfo;
        }

        public String getVillagerInfo() {
            return villagerInfo;
        }
    }

    private Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);  // Wywołanie konstruktora klasy nadrzędnej Villager
        this.skill = skill;
    }

    @Override
    public void sayHello(){
        System.out.println("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + skill.getVillagerInfo());
    }

    @Override
    public void attack(Fighter victim) {
    }

    @Override
    public void takeHit(int damage) {
        setHealth(0);
    }
}
