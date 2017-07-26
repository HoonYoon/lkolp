package Decorator_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! Decorator_pattern.my.example
 */

/**
 * The idea is user decorator pattern to implement in skill tree such that, the bonus of the previous level on the tree
 * is transfer to the new skill. To make this example possible in decorator pattern, i would descript a branch of the
 * skill tree where do you have 3 skill but only one can be choose.
 */
public class Main {

    public static void main(String[] args) {
        Skill fire = new FireSkill("Fire");
        Skill fireWithTurbo = new TurboSkillAddOns("turbo", fire);

        System.out.println(fireWithTurbo.getDamage());


    }
}
