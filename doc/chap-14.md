## 이 장에서
프랑을 달러로 변환하는 reduce()를 만들고자 한다.


```java
// Money.java
public Money reduce(String to) {
    int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
    return new Money(amount / rate, to);
}
```

Money 객체가 환율을 알게 되었다. 환율을 계산하는 것은 Bank 객체의 책임이므로 Money는 이를 모르는게 좋다.
Expression 인터페이스의 메서드가 args로 Bank를 넘겨주도록 수정하고, Bank에서 환율을 계산하도록 수정한다.

또 한가지 꺼림칙한 점은 환율 '2'라는 매직 넘버이다. Bank에서 두개의 통화 종류와 환율을 매핑하는 환율표를 해시테이블로 가지고 있도록 만들자. 이를 위해 두개의 통화 페어를 키로 저장하기 위한 Pair 객체가 필요하다. Pair와 equals((), hasCode()
를 정의한다.
```java
// Bank.java
private class Pair {
    private String from;
    private String to;

    Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals(Object o) {
        Pair pair = (Pair) o;
        return from.equals(pair.from) && to.equals(pair.to);
    }

    public int hashCode() {
        return 0;
    }
}
```

이후 Bank에 Pair 객체를 키로 사용해 해시테이블에서 환율을 얻어오는 getRates(), 환율 정보를 추가하는 addRate() 메서드를 구현한다.

결과적으로 두 개의 통화를 변환하는 작업을 할 수 있게 되었다.