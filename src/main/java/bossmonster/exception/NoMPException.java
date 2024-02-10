package bossmonster.exception;

public class NoMPException extends RuntimeException {
    public NoMPException() {
        System.out.println("\n[ERROR] MP가 부족합니다. 다른 공격 방법을 선택해주세요.");
    }
}
