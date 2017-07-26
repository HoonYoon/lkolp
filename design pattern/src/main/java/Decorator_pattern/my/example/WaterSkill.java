package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */
public class WaterSkill extends Skill {
    public WaterSkill(String skillName) {
        super(skillName);
    }

    @Override
    public double getDamage() {
        return 5;
    }
}
