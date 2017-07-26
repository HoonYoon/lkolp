package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */
public class FireSkill extends Skill {


    public FireSkill(String skillName) {
        super(skillName);
    }

    @Override
    public double getDamage() {
        return 5;
    }
}
