# 📚 기능 목록
## 👨‍🦱 플레이어 정보 - Player
> 플레이어의 정보가 있는 도메인 클래스
- 이름
  - 플레이어의 이름은 5자 이하만 가능하다.
- HP, MP
  - 플레이어의 초기 HP는 1 이상이다.
  - 플레이어의 초기 HP와 MP 합은 200이다.
- 이름, HP, MP를 생성자에서 설정한다. - ``Player``
  - 예외 처리 - ``validatePlayerName``
    - 🚫 플레이어 이름이 공백일 경우
    - 🚫 플레이어 이름이 1자 미만이거나 6자 이상일 경우
  - 예외 처리 - ``validatePlayerStatus``
    - 🚫 플레이어의 초기 HP가 1 미만인 경우
    - 🚫 플레이어의 초기 HP와 MP 합이 200이 아닌 경우
- 보스를 공격한다. - ``attackBossMonster``
  - 예외 처리 - ``canAttack``
    - 🚫 플레이어의 MP가 마법 공격하기에 부족한 경우
- 공격 받는다. - ``attacked``
- 플레이어가 죽었는지 확인한다. - ``isDead``
</br>

## 🐺 보스 몬스터 정보 - BossMonster
> 보스 몬스터의 정보가 있는 도메인 클래스
- HP
  - 보스 몬스터의 초기 HP는 100이상 300이하이다.
- Condition
  - 보스의 생성, 피격, 사망 여부를 구분한다.
- 초기 HP를 생성자에서 설정한다. - ``BossMonster``
  - 예외 처리 - ``validateBossStatus``
    - 🚫 보스의 초기 HP가 100 미만이거나 300 초과인 경우
- 플레이어를 공격한다. - ``attackPlayer``
- 공격 받는다. - ``attacked``
- 보스가 죽었는지 확인한다. - ``isDead``
</br>

## ⚔️ 공격 종류 - AttackType, PhysicalAttack, MagicalAttack
> 플레이어의 공격 종류를 나타내는 도메인 클래스
> ``PhysicalAttack``과 ``MagicalAttack``은 ``AttackType``을 상속받음.
- 공격 종류
  - 1: 물리 공격, 2: 마법 공격
- 대미지
  - 물리 공격: 10, 마법 공격: 20
- MP 변화량
  - 물리 공격: +10, 마법 공격: -30
- 예외 처리 - ``throwAttackTypeException``
  - 🚫 공격 종류 입력값이 1이나 2가 아닌 경우
</br>

## 🗃️ 공격 종류 저장소 - AttackTypeRepository
> 플레이어의 입력에 알맞은 공격 종류 클래스를 반환하는 클래스
- 입력받은 값에 매칭되는 공격 종류를 반환한다. - ``getAttackType``
  - 예외 처리 - ``AttackType.throwAttackTypeException``
    - 🚫 공격 종류 입력값이 1이나 2가 아닌 경우

## 🎮 게임 프로그램 - GameController
> 게임을 진행하는 컨트롤러 클래스
- 게임을 시작한다. - ``play``
- 플레이어와 보스 몬스터의 초기 능력치를 세팅한다. - ``progressInitialSetting``
- 보스의 초기 HP를 세팅한다. - ``progressBossHpSetting``
- 플레이어의 초기값을 세팅한다. - ``progressPlayerInitialSetting``
- 플레이어의 이름을 세팅한다. - ``progressPlayerNameSetting``
- 플레이어의 초기 HP, MP를 세팅한다. - ``progressPlayerStatusSetting``
- 전투를 진행한다. - ``progressBattle``
- 플레이어의 턴을 진행한다. - ``progressPlayerPhase``
- 플레이어의 공격 종류를 반환한다. - ``progressReadAttackType``
- 보스 레이드를 승리했다. - ``endGameByVictory``
- 보스 레이드를 실패했다. - ``endGameByDefeat``
</br>

## 🖥️ 게임 입력 화면 - InputView
> 게임 화면을 출력하며 사용자의 입력을 받는 뷰 클래스
- 보스의 초기 HP를 세팅하는 화면을 출력하고 사용자의 입력을 받는다. - ``readBossMonsterHp``
  - 예외 처리 - ``validateDigit``
    - 🚫 숫자가 아닌 값이 입력되었을 경우
- 플레이어의 이름을 세팅하는 화면을 출력하고 사용자의 입력을 받는다. - ``readPlayerName``
- 플레이어의 초기 HP, MP를 세팅하는 화면을 출력하고 사용자의 입력을 받는다. - ``readPlayerHpAndMp``
  - 예외 처리 - ``validatePlayerStatus``
    - 🚫 콤마(,)로 구분이 안되거나, 숫자가 아닌 값이 입력되었을 경우
- 플레이어의 공격 종류를 선택하는 화면을 출력하고 사용자의 입력을 받는다. - ``readAttackType``
  - 예외 처리 - ``validateAttackType``
    - 🚫 숫자가 아닌 값이 입력되었을 경우
- 플레이어 초기 HP, MP 세팅할 때 받은 문자열을 Integer List로 변환한다. - ``parseToIntegerList``
</br>

## 🖥️ 게임 출력 화면 - OutputView
> 게임 화면을 출력하는 뷰 클래스
- 게임 시작 화면을 출력한다. - ``printBattleStartView``
- 플레이어 턴의 전투 화면을 출력한다. - ``printPlayerPhaseView``
- 보스 턴의 전투 화면을 출력한다. - ``printBossPhaseView``
- 승리 결과 화면을 출력한다. - ``printEndGameByVictoryView``
- 패배 결과 화면을 출력한다. - ``printEndGameByDefeatView``
- 전투 정보 화면을 출력한다. - ``printBattleInfoView``
- 예외 화면을 출력한다. - ``printException``
- 보스 이미지를 출력한다. - ``printBossMonsterView``
</br>
