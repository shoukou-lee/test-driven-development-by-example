## 작동하는 깔끔한 코드를 얻기 위해
- 단계를 분할한다.
- 작동하는 코드를 먼저 얻자.
- 이후, 깔끔한 코드를 만들기 위해 리팩터링한다.
- 아키텍쳐 주도 개발과 정 반대의 절차이다.

최대한 빨리 초록불을 보기 위해, 
- 가짜로 구현 : 상수를 반환하게 하고 진짜 코드를 얻을 때 까지 단계적으로 상수를 변수로 바꿔나간다. 
- 명백한 구현 : 어떤 코드를 입력해야 할지가 명확하다면 실제 구현을 입력한다. 이 과정 중간중간 테스트를 실행한다.

## 이 장에서
- `Dollar five`에 times 연산이 수행된 후, 더이상 `Dollar five`는 5달러가 아니라는 부작용을 테스트했고, Dollar 객체를 일종의 VO화 하여 실제 구현을 얻었다.