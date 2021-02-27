# 브라이언의 고민

- 일단 문제보고 스팸 메세지들이 떠올라 좀 웃겼던것 같다. 

- Concept : 문자열 분리 방식 / 문자열 사이의 중복문자 검출

1. 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. EX) `HELLO -> HaEaLaLaO`
   - searchBlockingCharacterEachWord
2. 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. EX) `bWORLDb`
   - searchBlockingCharacterPre

3. 위의 두 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두번 적용될 수 없다. EX) `aHbEbLbLbOacWdOdRdLdDc`

4. 한번 쓰인 소문자는(특수기호)는 다시 쓰일 수 없다.

## 현재 상

```
String case1 = "♚프☆렌☆즈☆레☆이☆싱♚★사전예약★진행중\n" +
                "$지금$예약시♜이모티콘♜100%※증정※\n" +
                "★라이언★카트♨전원♨획@득@기@회\n" +
                "즉시이동 http://...";
                
                Convert....
                
                프렌즈레이싱사전예약진행중 지금예약시이모티콘100%증정 라이언카트전원획득기회 즉시이동 http://...
                

        String case2 = "HaEaLaLaObWORLDb"; => Convert ... => HELOWORLD
        String case3 = "SpIpGpOpNpGJqOqA"; => Convert ... => SIGONGJOA
```

아직 저정도 밖에 해석이 안된다.. 띄어쓰기할 지점을 골라야되는데 그게 상당히 어려운것 같다..
아님 List 에 넣고 해야되나..?

