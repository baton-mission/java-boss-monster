# 과정
1. 기초 정보 입력
- 보스 몬스터
    - HP: 100 이상, 300 이하
- 플레이어
    - 이름: 5자 이하
    - HP, MP: 합 200

2. 보스 레이드 시작
- 플레이어 공격
    - 공격 방법 입력(1: 물리공격, 2: 마법공격)
    - 물리공격: 10의 데미지, 10MP 회복(최대치 이상 회복 불가)
    - 마법공격: 20의 데미지, 30MP 소모
- 보스 공격
    - 0~20 랜덤 데미지를 플레이어에게
    - 공격으로 죽으면 데미지 X
- 출력
    - 보스 HP - 보스 이미지 -플레이어 HP, MP
    - 공격 방법, 입힌데미지, 받은 데미지
    - 공격 반복

3. 결과 출력
- 승리한 경우
    - 레이드 성공 문구 출력(몇 턴이 소모되었는지)
- 패배한 경우
    - 레이드 실패 문구 출력


4. 예외처리
- - 잘못된 값을 입력한 경우 IllegalArgumentException을 발생, ERROR로 시작하는 메시지 출력, 그 부분부터 다시

# 기능 목록
## controller
### BossMonsterController
- [ ] Boss, Player 정보 입력받기
- [ ] 모델 객체 초기화
- [ ] 레이드 시작 문구 출력
- [ ] Boss, Player 정보 출력(반복)
- [ ] 공격 선택(반복)
- [ ] 결과 출력(반복)
- [ ] Boss, Player HP, MP 상태 확인 및 동기화
- [ ] 성공, 실패에 따른 문구 출력

## model
### Boss
- [ ] HP, maxHP
- [ ] getter

### Player
- [ ] HP, MP, name, attackNumber, maxHP, maxMP
- [ ] getter, 필요한 경우 setter


## view
### InputView
1. 입력 시 문구
- [ ] 보스 몬스터의 HP를 입력해주세요.
- [ ] 플레이어의 이름을 입력해주세요
- [ ] 플레이어의 HP와 MP를 입력해주세요.(,로 구분)

2. 공격 선택 문구
- [ ] 어떤 공격을 하시겠습니까? 1. 물리 공격 2. 마법 공격

### OutputView
- [ ] Boss HP
- [ ] 이미지
- [ ] Player HP, MP
- [ ] 공격 정보(Player, Boss 공격 문구)
- [ ] 레이드 성공 결과
- [ ] 레이드 실패 결과


## service
### BossMonsterService
- [ ] Boss 공격 데미지 설정
- [ ] Player 물리 공격 동작(Boss에 데미지, MP + 10)
- [ ] Player 마법 공격 동작(Boss에 데미지, MP - 30)

## validation
### InputValidation
- [ ] Boss HP, Player HP, MP 입력 값이 숫자인가
- [ ] Boss HP가 100 이상 300 이하인가
- [ ] Player의 이름이 5자 이하인가
- [ ] Player의 HP, MP가 합 200인가
- [ ] 공격을 선택한 숫자가 1 혹은 2인가
- [ ] IllegalArgumentException
- [ ] [ERROR] 및 문구 출력
