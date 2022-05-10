## 이 장에서
Sum.plus()의 스텁을 실제로 구현한다. 

```java
@Test
void sumPlusMoney() {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFranc = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);

    Expression sum = new Sum(fiveBucks, tenFranc).plus(fiveBucks);
    Money result = bank.reduce(sum, "USD");

    assertThat(result.amount).isEqualTo(Money.dollar(15).amount);
}
```
테스트 코드에서, `new Sum(fiveBucks, tenFranc)`은 Money.plus()와 똑같다. 이를 추상화할 수 있을 것 같다.

Sum.plus()도 마찬가지로 구현해준다.
```java
@Override
public Expression plus(Expression addend) {
    return new Sum(this, addend);
}
```
첫 번째 테스트가 통과한다. 다음은 Expression.times()를 만드려고 한다. Expression의 plus(), times()를 선언하고, 서브클래스에서 오버라이딩하는 방법으로 추상화하기 위함이다.

```java
@Test
void sumTimes() {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFranc = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);

    Expression sum = new Sum(fiveBucks, tenFranc).times(2);

    Money result = bank.reduce(sum, "USD");

    assertThat(result.amount).isEqualTo(Money.dollar(20).amount);
}
```

Expression.times()를 선언한다. Sum, Money의 times()를 public override 메서드로 정의한다. 모든 테스트를 통과하는 것을 볼 수 있다.
