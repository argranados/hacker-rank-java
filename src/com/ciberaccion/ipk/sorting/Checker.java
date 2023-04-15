package com.ciberaccion.ipk.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Checker implements Comparator<Player> {

    public static void main(String[] args) {
        Player[] player = { new Player("smith", 20),
                            new Player("jones", 15),
                            new Player("jones", 20)};
        Checker checker = new Checker();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    public int compare(Player a, Player b) {
        int c;

        c = b.score - a.score;
        if (c == 0)
            c = a.name.compareTo(b.name);
        return c;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
