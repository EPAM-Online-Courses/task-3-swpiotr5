package efs.task.oop;

public class Monsters {
    public static final Monster andariel = new Monster(10,70){
        @Override
        public void takeHit(int damage) {
            this.setHealth(this.getHealth() - damage);
            monstersHealth -= damage;
        }
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }
    };

    public static final Monster blacksmith = new Monster(100,25){
        public void takeHit(int damage) {
            this.setHealth(this.getHealth() - 5 - damage);
            monstersHealth -= (5+damage);
        }
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }
    };

    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

}
