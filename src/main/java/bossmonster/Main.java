package bossmonster;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static final int 물리_공격 = 1;
    static final int 마법_공격 = 2;

    static int 보스몬스터_최대_HP;
    static int 보스몬스터_현재_HP;

    static String 플레이어_이름;
    static int 플레이어_최대_HP;
    static int 플레이어_최대_MP;
    static int 플레이어_HP;
    static int 플레이어_MP;

    static final int 보스_일반_얼굴 = 0;
    static final int 보스_아픈_얼굴 = 1;
    static final int 보스_이긴_얼굴 = 2;

    static int 반복_회수 = 0;

    public static void main(String[] args) {
        보스_몬스터_정보_입력();
        플레이어_정보_입력();
        게임_시작();
        게임_결과();
    }

    static void 보스_몬스터_정보_입력() {
        while (true) {
            try {
                System.out.println("보스 몬스터의 HP를 입력해주세요.");
                보스몬스터_최대_HP = sc.nextInt();
                보스몬스터_현재_HP = 보스몬스터_최대_HP;
                sc.nextLine();
                if (보스몬스터_최대_HP < 100 || 보스몬스터_최대_HP > 300) {
                    throw new IllegalArgumentException("[ERROR] 보스몬스터의 체력은 100 이상 300 이하여야 합니다.");
                }
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void 플레이어_정보_입력() {
        while (true) {
            try {
                System.out.println("플레이어의 이름을 입력해주세요");
                플레이어_이름 = sc.nextLine();
                if (플레이어_이름.isEmpty() || 플레이어_이름.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 플레이어의 이름은 없어서는 안되며, 5글자 이상이어야 합니다.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
                String[] 플레이어_HP_MP = sc.nextLine().split(",");
                플레이어_최대_HP = Integer.parseInt(플레이어_HP_MP[0]);
                플레이어_HP = 플레이어_최대_HP;
                플레이어_최대_MP = Integer.parseInt(플레이어_HP_MP[1]);
                플레이어_MP = 플레이어_최대_MP;

                if (플레이어_최대_HP + 플레이어_최대_MP != 200) {
                    throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP와 MP 합은 200이다.");
                }
                if (플레이어_최대_HP < 0 || 플레이어_최대_MP <= 0) {
                    throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP는 1 이상, MP는 0 이상이어야 합니다.");
                }
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void 게임_시작() {
        int 보스_현재_상태 = 보스_일반_얼굴;
        System.out.println("보스 레이드를 시작합니다!\n");
        do {
            보스와_플레이어_상태_출력(보스_현재_상태);
            int 입력받은_공격_기술 = 공격_입력받기();
            공격하기(입력받은_공격_기술);
            보스_현재_상태 = 보스_아픈_얼굴;
            보스의_공격();
            반복_회수++;
        } while (양측이_모두_살아있는_경우());
    }

    static void 보스와_플레이어_상태_출력(int 보스_현재_상태) {
        System.out.println("============================");
        보스_체력_출력();
        보스_얼굴_출력(보스_현재_상태);
        플레이어_체력_출력();
        System.out.println("============================");
    }

    static void 보스_체력_출력() {
        System.out.println("BOSS HP [" + 보스몬스터_현재_HP + "/" + 보스몬스터_최대_HP + "]");
    }

    static void 보스_얼굴_출력(int 보스_현재_상태) {
        System.out.println("____________________________");
        switch (보스_현재_상태) {
            case 보스_일반_얼굴: {
                System.out.println("   ^-^");
                System.out.println(" / 0 0 \\");
                System.out.println("(   \"   )");
                System.out.println(" \\  -  /");
                System.out.println("  - ^ -");
                break;
            }
            case 보스_아픈_얼굴: {
                System.out.println("   ^-^");
                System.out.println(" / x x \\");
                System.out.println("(   \"\\  )");
                System.out.println(" \\  ^  /");
                System.out.println("  - ^ -");
                break;
            }
            case 보스_이긴_얼굴: {
                System.out.println("   ^-^");
                System.out.println(" / ^ ^ \\");
                System.out.println("(   \"   )");
                System.out.println(" \\  3  /");
                System.out.println("  - ^ -");
                break;
            }
            default: {
                throw new RuntimeException("없는 얼굴");
            }
        }
        System.out.println("____________________________\n");
    }

    static void 플레이어_체력_출력() {
        System.out.println(
                플레이어_이름 + " HP [" + 플레이어_HP + "/" + 플레이어_최대_HP + "] MP [" + 플레이어_MP + "/" + 플레이어_최대_MP + "]"
        );
    }

    static int 공격_입력받기() {
        while (true) {
            try {
                System.out.println();
                System.out.println("어떤 공격을 하시겠습니까?");
                System.out.println("1. 물리 공격");
                System.out.println("2. 마법 공격");
                int 입력 = sc.nextInt();
                sc.nextLine();
                if (입력 != 물리_공격 && 입력 != 마법_공격) {
                    throw new IllegalArgumentException("[ERROR] 1번 혹은 2번을 입력해주세요.");
                }
                return 입력;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void 공격하기(int 입력받은_공격_기술) {
        System.out.println();
        switch (입력받은_공격_기술) {
            case 물리_공격: {
                물리_공격();
                break;
            }
            case 마법_공격: {
                마법_공격();
                break;
            }
            default: {
                System.out.println("그런 공격은 없어용");
            }
            System.out.println();
        }
    }

    private static void 물리_공격() {
        System.out.println("물리 공격을 했습니다. (입힌 데미지: 10)");
        보스몬스터_현재_HP = 스테미나_차감(플레이어_MP, 10);
        플레이어_MP = 스테미나_상승(플레이어_MP, 10, 플레이어_최대_MP);
    }

    private static void 마법_공격() {
        if (플레이어_MP < 30) {
            System.out.println("마나가 부족하여 마법공력을 할 수 없습니다. 대신 물리 공격을 진행합니다.");
            물리_공격();
            return;
        }
        System.out.println("마법 공격을 했습니다. (입힌 데미지: 20)");
        보스몬스터_현재_HP = 스테미나_차감(보스몬스터_현재_HP, 20);
        플레이어_MP = 스테미나_차감(플레이어_MP, 30);
    }

    static void 보스의_공격() {
        int 랜덤_데미지 = (int) (Math.random() * 21);
        System.out.println("보스가 공격 했습니다. (입힌 데미지: " + 랜덤_데미지 + ")\n");
        플레이어_HP = 스테미나_차감(플레이어_HP, 랜덤_데미지);
    }

    static int 스테미나_차감(int 기존_스테미나, int 차감량) {
        return Math.max(기존_스테미나 - 차감량, 0);
    }

    static int 스테미나_상승(int 기존_스테미나, int 상승량, int 최대_스테미나) {
        return Math.min(기존_스테미나 + 상승량, 최대_스테미나);
    }

    static boolean 양측이_모두_살아있는_경우() {
        return 플레이어_HP > 0 && 보스몬스터_현재_HP > 0;
    }

    private static void 게임_결과() {
        if (플레이어_HP <= 0) {
            System.out.println(플레이어_이름 + "의 HP가 0이 되었습니다.");
            System.out.println("보스 레이드에 실패했습니다.");
            보스와_플레이어_상태_출력(보스_이긴_얼굴);
            return;
        }
        if (보스몬스터_현재_HP <= 0) {
            System.out.println(플레이어_이름 + " 님이 " + 반복_회수 + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
        }
    }
}
