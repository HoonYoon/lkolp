package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */
public class TurboSkillAddOns extends SkillAddOns {
    public TurboSkillAddOns(String skillName, Skill skill) {
        super(skillName, skill);
    }

    @Override
    public String getSkillName() {
        return this.skill.getSkillName() + " with " +this.skillName;
    }

    @Override
    public double getDamage() {
        return this.skill.getDamage() + 10;
    }
}
