## 이 장에서
$5 + 10CHF = $10 (환율이 2:1인 경우)를 테스트할 것이다. 아래와 같은 테스트 코드를 작성한다.
리마인드 하자면, Expression은 Money 간의 연산 결과를 의미하며 좀더 일반화된 표현식으로 볼 수 있다.

```java
@Test
void mixedAddition() {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();

    bank.addRate("CHF", "USD", 2);

    Money ret = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
    assertThat(ret.equals(Money.dollar(10))).isEqualTo(true);
}
```
Expression.plus 메서드가 없다. fiveBucks, tenFrancs의 타입을 Money로 수정하자, 테스트가 실패한다.
기대값은 $10이지만, 이 수식의 결과는 $15이다. Sum.reduce() 메서드에 문제가 있다.
코드를 아래와 같이 수정한다.
```java
@Override
public Money reduce(Bank bank, String to) {
    // int amount = augend.amount + addend.amount;
    int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
    return new Money(amount, to);
}
```

Sum의 addend, augend는 Expression으로 일반화할 수 있다. 
Money.plus()의 리턴 타입, 인자 타입 또한 Expression이 될 수 있고, times()의 리턴 타입 또한 Expression으로 수정하자.
다시 말하면, Expression을 얻기 위해서는 plus(), times()를 통해 얻어야 한다는 것을 제안한다. 

다시 실패한 테스트코드로 되돌리자. plus() 메서드를 인터페이스에 선언한다. Money, Sum에도 plus()를 구현해야 한다.
Money.plus()는 public으로 액세스 타입을 변경하고, Sum.plus()는 스텁 구현을 해놓자.

그 결과 모든 테스트 코드가 통과한다. 
