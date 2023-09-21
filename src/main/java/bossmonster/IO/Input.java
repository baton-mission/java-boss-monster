package bossmonster.IO;

import bossmonster.Player;

import java.util.Scanner;

public class Input {
    public void playerName(Player player){
        String name;

        Scanner scanner = new Scanner(System.in);
        System.out.println("플레이어의 이름을 입력해주세요");
        name = scanner.next();
        player.createName(name);
    }
}
