package model;

public class Troll extends Character {

    public Troll() {
        weaponBehavior = new AxeBehavior();
    }

    @Override
    public void fight() {
        System.out.println("I am devil troll and fighting with " + weaponBehavior.useWeapon());
    }
}
