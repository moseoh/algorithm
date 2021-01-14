문제에 대한 설명

백준 -> 브루트 포스 -> <a href="https://www.acmicpc.net/problem/1018" target="_blank">1018 체스판 다시 칠하기</a>에 대한 연습입니다.

# 1. 문제 읽기

![0](https://user-images.githubusercontent.com/45132207/104543620-33782a00-5669-11eb-8c8a-b4dea32ee8c3.PNG)
 
#### 내 생각💡

이것도 분해합 보단 쉬운것 같다.
8*8 체스판을 만들 것인데 
8*8 보다 큰 판이 있을때는 시작점을 구해주고 
8*8을 순회하며 검사한다.

# 2. 풀이

### 풀이 과정

```java
for (int i = 0; i < n; i++) {
    String line = br.readLine();
    for (int j = 0; j < m; j++) {
        if (line.charAt(j) == 'B') {
            chessBoard[i][j] = true;
        }
    }
}
```

계산하기 쉽도록 판을 boolean배열에 저장하였다.
false이면 흰색
true이면 검은색이다.

```java
for (int a = 0; a <= n - 8; a++) {
    for (int b = 0; b <= m - 8; b++) {
        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (j % 2 == i % 2) {
                    if (chessBoard[i][j] == false) {
                        black++;
                    } else {
                        white++;
                    }
                } else {
                    if (chessBoard[i][j] == true) {
                        black++;
                    } else {
                        white++;
                    }
                }
            }
        }

        if (whiteMin == 0 && blackMin == 0) {
            whiteMin = white;
            blackMin = black;
        } else {
            whiteMin = whiteMin > white ? white : whiteMin;
            blackMin = blackMin > black ? black : blackMin;
        }
        white = 0;
        black = 0;
    }
}
```

뭔가 굉장히 지저분한 코드가 나왔다..
그래도 적어보자면

```java
for (int a = 0; a <= n - 8; a++)
for (int b = 0; b <= m - 8; b++)
```

가장 위에 있는 이 코드는 시작점을 표시한다.
10*13인 판에서는 {0, 1, 2}, {0, 1, 2, 3, 4, 5} 지점에서 시작할 수 있다.

```java
for (int i = a; i < a + 8; i++)
for (int j = b; j < b + 8; j++)
```
두번째 포문은 시작점부터 8*8크기의 보드를 검사한다.

```java
if (j % 2 == i % 2) {
    if (chessBoard[i][j] == false) {
        black++;
    } else {
        white++;
    }
} else {
    if (chessBoard[i][j] == true) {
        black++;
    } else {
        white++;
    }
}
```
최상위 if문으로 반전? 을 줄 수 있다.
WBWBW
BWBWB
이런판이 있다고 가정했을때
W로 시작했다면 두번째 줄은 B로 시작한다.

안에 있는 if문은 W로 시작했을 때와 B로 시작했을 때이다.

각각 어떤 색으로 시작했냐에 따라 white, black으로 갯수를 세어서
최솟값을 출력한다.

![1](https://user-images.githubusercontent.com/45132207/104543624-34a95700-5669-11eb-9a70-d3528bc1df00.PNG)

# 3. 더 풀어 보기🚨

간단한 문제였고 괜찮은 수행시간이 나왔지만 코드가 너무 지저분하게 나왔다.
깔끔하게 정리해야 좋은 개발자겠지만 오늘은 일단 도망

---
<a href="https://github.com/azqazq195/coding_teset/blob/master/Baekjun/Factorization.java" target="_blank">전체 코드</a>