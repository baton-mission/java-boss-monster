# 과정
1. 기초 정보 입력
    * 보스 몬스터 HP
        - HP는 100 이상 300 이하
    * 플레이어 이름
        - 5자 이하
    * 플레이어 HP, MP
        - HP, MP 합 200
    * 잘못된 값 입력 시 IllegalArgumentException 발생, [ERROR]로 시작하는 메시지 출력, 그 부분부터 다시


2. 보스 레이드 시작(반복)
    * 보스 HP - 이미지 - 플레이어 HP / MP
    * 공격 방법 입력받기
        - 물리 공격: 10 데미지. MP 10 회복(최대치 이상 회복 불가)
        - 마법 공격: 20 데미지, MP 30 소모
        - 잘못된 값 입력 시 IllegalArgumentException 발생, [ERROR]로 시작하는 메시지 출력, 그 부분부터 다시
    * 보스 공격 및 데미지 정보 출력
        - 0 ~ 20 랜덤 데미지
        - 보스가 죽으면 피해 X
        - 보스 or 플레이어 HP가 0이 되면 결과 출력

3. 결과
    * 레이드 성공: 전투 횟수 출력
    * 레이드 실패: 실패 문구 출력


# 분류
## controller
### BossMissionController
- [ ] 객체 초기화
- [ ] 입력 문구 출력 및 입력받기
- [ ] 레이드 시작 문구 출력
- [ ] Boss, Player 정보 출력(반복)
- [ ] 공격 선택(반복)
- [ ] 결과 출력

## model
### Boss
- [ ] HP

### Player
- [ ] HP
- [ ] MP
- [ ] Name


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
- [ ] 공격 정보
- [ ] 레이드 성공 결과
- [ ] 레이드 실패 결과


## util
### BossAttackDamage
- [ ] Boss 공격 데미지 설정


## validation
### InputValidation
- [ ] Boss HP가 100 이상 300 이하인가
- [ ] Player의 이름이 5자 이하인가
- [ ] Player의 HP, MP가 합 200인가
- [ ] 공격을 선택한 숫자가 1 혹은 2인가
- [ ] IllegalArgumentException
- [ ] [ERROR] 및 문구 출력
