## 이 장에서
모든 중복이 제거되기 전까지 테스트를 통과한 것으로 간주하지 않는다. 앞으로 Sum이라는 객체가 필요할 것으로 예상되기 때문에, Sum을 사용한 테스트 코드를 작성했다.

Bank.reduce()를 다음과 같이 구현했다.

```java
// Bank.java
Money reduce (Expression src, String to) {
    if (src instanceof Money)
        return (Money) src;
    Sum sum = (Sum) src;
    return sum.reduce(to);
}
```

명시적인 클래스 타입 체크가 있을 때는 다형성을 사용하도록 리팩터링할 수 있다. Sum.reduce()와 함께, Money.reduce()를 구현하는 것이다.

```java
// Bank.java
public Money reduce (Expression src, String to) {
    if (src instanceof Money)
        return (Money) src.reduce(to);
    Sum sum = (Sum) src;
    return sum.reduce(to);
}

// Sum.java
@Override
public Money reduce(String to) {
        int amount = augend.amount + addend.amount;

        return new Money(amount, to);
        }

// Money.java
@Override
public Money reduce(String to) {
    return this;
} 

// Expression.java
Money reduce(String to);
```

이때 Bank.reduce()를 아래처럼 리팩터링 할 수 있게 된다.
```java
public Money reduce (Expression src, String to) {
    return src.reduce(to);
}
```