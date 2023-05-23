package efs.task.oop;
public class Villager implements Fighter {
    private String name;
    private int age;
    private int health;
    public Villager(){};
    public Villager(String name, int age){
        this.name = name;
        this.age = age;
        this.health = 100;
    }

    public void sayHello(){
        System.out.println("Greetings traveler... I'm " + this.name + " and I'm " + this.age + " years old");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public void attack(Fighter victim) {
        int damage = (int) ((100 - age * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        this.health -= damage;
    }
}
