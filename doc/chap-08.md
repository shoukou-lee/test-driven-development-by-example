## 이 장에서
times() 메서드를 통일하고자 한다. Dollar, Franc 클래스가 많은 일을 하는 것 같지도 않고, 그냥 제거해버릴까 한다. 그렇기 위해서 하위 클래스에 대한 직접적인 참조를 하나하나 없애야 한다. 따라서, Money 클래스에서 스태틱 팩토리를 정의해 Dollar와 Franc을 생성하게끔 할 것이다.

리팩터링 후 모든 테스트 코드가 성공한다. 문제는 dollar multipy, franc multiply의 테스트 코드가 실질적으로 동일하다는 것이다. 과연 franc multiply 테스트를 제거해야 할까?