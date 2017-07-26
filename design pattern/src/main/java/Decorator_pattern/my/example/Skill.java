package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */
public abstract class Skill {
    protected final String skillName;
    protected double damage;

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName(){
        return this.skillName;
    }

    public abstract double getDamage();
}
