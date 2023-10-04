implementation
----------------
- player, bossmonster 정의하기
  - 죽은 상태, maxHP, maxMP, currentHP, currentMP
- 공격 타입  enum 정의하기
- input 받기, 검증하기 **예외처리**
- player가 공격할때의 method
- player가 공격 받을 때의 method
- bossmonster가 공격할때의 method
- bossmonster가 공격 받을 때의 method
- 기본 bossmonster 출력
- 웃는 bossmonster 출력
- x x bossmonster 출력
- 만들 객체들로 controller 구성하기
--------------------------------------
refactor
-----------
- 검증하는 부분을 InputView에서 검증하게 하기 (validate의 return 값 은 boolean으로)
- OutputView 메서드 이름 수정하기
- OutputView boss character 출력 방식 수정하기
- error handling 할 때 구체적인 error 쓰기
- view & model의 완벽한 분리
- stream?
- player와 boss 상호작용 부분 코드 쪼개기 (반복문?)
- Hp and mana DTO

