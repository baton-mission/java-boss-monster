package controller;


import message.PrintMessage;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MainController {
    private final Scanner sc = new Scanner(System.in);
    private final PrintMessage printer = new PrintMessage();
    private static final BossController bossController = new BossController();
    private static final PlayerController playerController = new PlayerController();
    public void run(){
        settings();
        game();
    }

    public void settings(){
        setBoss();
        setPlayerName();
        setPlayerStats();
    }

    public void setBoss(){
        while(true){
            try{
                System.out.println("보스 몬스터의 HP를 입력해주세요.");
                int hp = sc.nextInt();
                if(hp < 100 || hp > 300){
                    throw new IllegalArgumentException("[ERROR] 보스몬스터의 체력은 100 이상 300 이하여야 합니다.");
                }
                bossController.setHp(hp);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setPlayerName(){
        while(true){
            try{
                System.out.println("플레이어의 이름을 입력해주세요.");
                String name = sc.next();
                if(name.isEmpty() || name.length() > 5){
                    throw new IllegalArgumentException("[ERROR] 플레이어의 이름은 5자 이하여야합니다.");
                }
                playerController.setName(name);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setPlayerStats(){
        while(true){
            try{
                System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
                StringTokenizer st = new StringTokenizer(sc.next(), ",");
                int hp = Integer.parseInt(st.nextToken());
                int mp = Integer.parseInt(st.nextToken());
                if(hp + mp != 200){
                    throw new IllegalArgumentException("[ERROR] 플레이어의 HP와 MP의 총 합은 200입니다.");
                }

                if(hp <= 0 || mp < 0){
                    throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP는 1이상, MP는 0이상이어야 합니다.");
                }
                playerController.setStats(hp, mp);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private int setAttackType(){
        while(true){
            try{
                System.out.println("어떤 공격을 하시겠습니까?");
                System.out.println("1. 물리 공격");
                System.out.println("2. 마법 공격");

                int attack_type = sc.nextInt();

                if(attack_type != 1 && attack_type != 2){
                    throw new IllegalArgumentException("[ERROR] 공격하셔야 합니다. 1 또는 2를 입력해주세요");
                }

                if(attack_type == 2 && !playerController.checkMp()){
                    throw new IllegalArgumentException("[ERROR] 마법 공격은 MP가 30이상이 필요합니다.");
                }
                return attack_type;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void game(){
        boolean player_lose = false;
        boolean boss_lose = false;
        int count = 0;

        System.out.println("보스 레이드를 시작합니다!");

        while(!player_lose && !boss_lose){
            printer.printState();
            attack(setAttackType());
            count++;
            boss_lose = bossController.isOver();
            player_lose = playerController.isOver();
        }

        if(player_lose) printer.printState();

        gameOver(boss_lose, player_lose, count);
    }

    private void attack(int attackType){
        playerController.attack(attackType);
        if(!bossController.isOver()){
            bossController.attack();
        }
    }

    public void gameOver(boolean boss_lose, boolean player_lose, int count){
        printer.printResult(boss_lose, player_lose, count);
    }
}
