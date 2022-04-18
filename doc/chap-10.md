## 이 장에서
하위 클래스의 times() 메서드는 어떤 콘크리트 클래스의 인스턴스를 반환할 것이냐를 제외한 모든 것이 같다. 이를 동일하게 만들기 위해, chap.9에서 times()를 스태틱 팩토리로 수정했던 것을 다시 되돌릴 것이다. 

```java
// Franc.java
- Franc times(int multiplier) {
+ Money times(int multiplier) {
-   return new Franc(amount * multiplier, currency);
+   return new Money(amount * multiplier, currency);
  }
```
코드를 위와 같이 수정 후 테스트 코드를 실행했을 때 발생하는 오류를 없애기 위해, Money를 콘크리트 클래스로, Money.times()를 return null을 하도록 임시로 구현한다.
그 결과, Money와 Franc의 객체 형식이 맞지 않는 오류가 나온다.

이를 해결하기 위해 equals() 메서드를 다시 살펴본다. 객체의 타입이 아닌 currency가 같은지를 검사하는 것이 더 적절하므로, 이를 수정한다. 
이후 테스트 코드가 잘 실행된다. 이 과정을 Dollar 클래스에서 반복한 후, times()의 구현이 완벽하게 같아진 것을 볼 수 있다.

times() 메서드를 Money로 push-up 한 후, 하위 클래스의 times()를 지움으로써 공용 times() 메서드를 얻어냈다.

Dollar, Franc는 생성자만 남은 클래스가 되었고, Dollar/Franc의 중복을 없앨 준비가 되었다.