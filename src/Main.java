package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import static kg.geeks.game.logic.RPG_Game.random;

public class Ludoman extends Hero {
    public Ludoman(int health, int damage, String name)
    {
        super(health, damage, name, SuperAbility.GAMBLE);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int i) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        if (dice1 == dice2) {
            int damage = dice1 * dice2;
            boss.setHealth(boss.getHeal);
            boss.setHealth(boss.getHealth() - damage);
            System.out.println(this.getName() + " бросил кости (" + dice1 + ", " + dice2 + ") и отнял " + damage + " здоровья у " +
                    boss.getName());
        } else {
            int damage = dice1 + dice2;
            Hero randomHero;
            do {
                randomHero = heroes[random.nextInt(heroes.length)];
            } while (randomHero == this);

            randomHero.setHealth(randomHero.getHealth() - damage);
            System.out.println(this.getName() + " бросил кости (" + dice1 + ", " + dice2 + ") и отнял " + damage + " здоровья у "
                    + randomHero.getName());

        }

    }
}




