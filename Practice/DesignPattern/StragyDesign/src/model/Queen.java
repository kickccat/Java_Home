package model;

public class Queen extends Character {

    public Queen() {
        weaponBehavior = new KnifeBehavior();
    }

    @Override
    public void fight() {
        System.out.println("I am queen and fighting with " + weaponBehavior.useWeapon());
    }
}
