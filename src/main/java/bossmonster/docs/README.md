# 🚀 기능 정리

## 1. 주요 domain
- Monster
- Player


## 2. 프로그램 진행 사항
1. 보스 몬스터와 플레이어의 초기 정보를 입력 받는다. 이때 다음과 같은 요구 사항을 지켜야 한다.
    - 플레이어의 이름은 5자 이하만 가능하다.
    - 플레이어의 초기 HP와 MP의 합은 200이다.
    - 보스 몬스터 초기 HP는 100 이상 300 이하이다.
2. 플레이어는 매 턴마다 보스 몬스터를 공격할 수 있다.
    - 물리 공격을 하면 10만큼의 데미지를 준다. 이때, 10만큼의 마나를 회복한다. 
    - 마법 공격을 하면 20만큼의 데미지를 준다. 이때, 30만큼의 마나가 소모된다.
    - 최대치 이상의 MP는 회복할 수 없다.
3. 플레이어가 공격하면 보스 몬스터가 공격한다.
    - 0 ~ 20의 랜덤 데미지를 입힌다.
    - 플레이어 공격 이후, 보스 몬스터가 죽는다면 공격을 진행하지 않는다.
4. 둘 다 HP가 0이 되면 게임은 끝난다.
   1. 보스 몬스터가 죽으면 몇 턴만에 잡았는 지 출력한다.
   2. 플레이어가 죽으면 보스 레이드 실패 메시지를 출력한다.

## 3. 패키지 구조
#### Controller
- MonsterRaidController
#### Domain
- Monster
- Player
#### DTO
###### Request
- BossStatRequest
- PlayerNameRequest
- PlayerStatRequest
- PlayerAttackRequest
###### Response
- AttackDetailResponse
- StatDetailResponse
- RaidResultResponse
- ErrorDetailResponse
#### View
- InputView
- OutputView
#### Service
- MonsterRaidService