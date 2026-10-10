package encapsulation.assigment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        health = Math.max(health - amount, 0);          // calculate, then clamp at 0
    }

    public void heal(int amount) {
        health = Math.min(health + amount, maxHealth);  // calculate, then clamp at max
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After takeDamage(30): health = " + c.getHealth());
        c.heal(50);
        System.out.println("After heal(50): health = " + c.getHealth() + " (capped)");
        c.takeDamage(150);
        System.out.println("After takeDamage(150): health = " + c.getHealth() + " (floored)");
    }
}
