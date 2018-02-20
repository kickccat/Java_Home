package model;

public abstract class Character {

    WeaponBehavior weaponBehavior;

    public Character() {
    }

    public abstract void fight();

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
