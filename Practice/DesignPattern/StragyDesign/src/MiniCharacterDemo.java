import model.Character;
import model.King;
import model.Knight;
import model.SwordBehavior;

public class MiniCharacterDemo {

    public static void main(String[] args) {
        Character king = new King();
        king.fight();

        Character knight = new Knight();
        knight.fight();
        knight.setWeaponBehavior(new SwordBehavior());
        knight.fight();
    }
}
