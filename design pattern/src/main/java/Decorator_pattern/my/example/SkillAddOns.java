package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */
public abstract class SkillAddOns extends Skill {

    protected Skill skill;

    public SkillAddOns(String skillName, Skill skill) {
        super(skillName);
        this.skill = skill;
    }

    @Override
    public abstract String getSkillName();
}
