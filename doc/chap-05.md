## 이 장에서
다시 To-do-list 1번으로 돌아가, 이를 어떻게 테스트해야 할지 고민했다. 작은 스텝으로 해결할 수 없는 일이라고 판단하고, Dollar와 비슷한 Franc 객체를 만들었다.

Franc을 위한 테스트 코드, 객체를 Dollar에서 그대로 복사하고 리네임 정도만 하자.

물론 TDD 또한 중복된 코드, code smell을 철저히 지양한다. 
1. 테스트 작성
2. 컴파일되게 만들기
3. 실패를 확인하기 위해 테스트를 실행하기
4. 테스트를 성공시키게 구현을 수정
5. 중복 제거

1~4 단계에서는 코드의 심미성, 깨끗한 설계, 유연성보다 중요한 것은 빠른 속도이다. 5단계에 빠르게 도달할 수 있다면 어떠한 죄악도 허용된다.

코드의 중복도가 높아졌으므로, 중복 제거와 관련된 To-do를 추가하자.