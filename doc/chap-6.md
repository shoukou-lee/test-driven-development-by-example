## 이 장에서
equals() 메서드의 코드 중복도를 제거하기 위해 리팩터링한다.
Dollar와 Franc의 공통 상위 클래스 Money를 정의한다.

변화의 각 스텝마다 테스트 코드를 돌린다. 각 스텝은 생각보다 더욱 작은 변화로 이루어진다. 

- Dollar, Franc가 Money를 확장하도록 만들고 테스트
- amount를 Money로 옮기고 테스트
- Dollar.equals()의 인자 객체를 Object로 바꾸고 테스트
- 등등..

더이상 Dollar.equals가 Dollar 내부 속성으로 표현되지 않을 때 Money의 상위 메서드로 올릴 수 있다.
이 과정을 Franc에 대해서도 반복하는데, Franc.equals()가 Money.equals()와 완전히 같다면 Franc.equals()를 제거할 수 있게 된다.

수정된 equals()를 검증하기 위해 Dollar.equals() 테스트 코드 두줄을 복사했다. (테스트 코드의 중복 또한 죄악이며, 추후의 수정 대상에 포함된다는 점에 주목하자.)

테스트 코드는 잘 통과했다. 하지만
Franc(5)와 Dollar(5)의 equality 수행 결과는 어떨까?

