## 이 장에서
$5 + 10CHF = $10 문제를 해결하기 위해, 더 간단한 문제를 먼저 해결하고자 한다. $5 + $5 = $10을 먼저 해보자.

```java
Money sum = Money.dollar(5).plus(Money.dollar(5));
assertThat(sum).isEqualTo(Money.dollar(10));
```
이 테스트 코드에 기반해 구현을 작성한다면, 다중 통화와 여러 환율을 쓰기 어려워진다.
plus() 메서드 내부에서 환율을 고려한 달러로 변환할 수도 있지만, 여러 개의 환율이 존재한다면 쉬운 구현이 아닐 것이다.

수식을 떠올려보자. ($2 + 3CHF) * 5의 경우에서, Money 객체는 수식의 가장 작은 단위이다. Money 간 연산의 결과를 표현하는 "Expression"이라는 새로운 임포스터 객체를 활용하는 것은 어떨까? 연산의 마지막에서, 최종 Expression을 환율에 따라 단일 통화 형태로 축약하는 것이다. 현실 세계에서 단일 통화로 변환해주는 역할을 하는 곳은 '은행'이다. Bank라는 객체가 단일 통화로 변환할 책임을 갖도록 하자. 

테스트 코드를 아래와 같이 수정한다. 
```java
@Test
void simpleAddition() {
    Money five = Money.dollar(5);
    Expression sum = five.plus(five);
    Bank bank = new Bank();
    Money reduced = bank.reduce(sum, "USD");
    assertThat(Money.dollar(10)).isEqualTo(reduced);
}
```
일단, Expression 인터페이스, Bank 클래스를 만한 후, 스텁 메서드들을 정의한다. 테스트가 실패하는 것을 확인한 이후, 빠르게 테스트를 통과시키기 위해 가짜로 구현하자.
