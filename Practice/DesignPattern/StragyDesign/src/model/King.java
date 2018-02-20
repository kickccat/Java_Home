package model;

public class King extends Character {

    public King() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    public void fight() {
        System.out.println("I am king and fighting with " + weaponBehavior.useWeapon());
    }
}
