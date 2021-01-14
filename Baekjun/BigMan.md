



문제에 대한 설명

백준 -> 브루트 포스 -> <a href="https://www.acmicpc.net/problem/7568" target="_blank">7568 덩치</a>에 대한 연습입니다.

# 1. 문제 읽기
 
![0](https://user-images.githubusercontent.com/45132207/104536665-c9a55380-565b-11eb-84bc-a91e36d3e55c.PNG)

#### 내 생각💡

비교 대상보다 몸무게와 키가 둘다 클때 순위를 + 1해주면 된다.
이 문제는 실버5단계이고 전 문제는 브론즈2단계인데 
이번 문제가 훨씬 쉬운것 같다.

# 2. 풀이

### 풀이 과정

```java
int maxLength = str[0].length() > str[1].length() ? str[0].length() : str[1].length();
maxLength += 1;
int num[][] = new int[2][maxLength];
```


```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int num = Integer.parseInt(br.readLine());
int mans[][] = new int[num][2];
int ranks[] = new int[num];

for (int i = 0; i < num; i++) {
    String str[] = br.readLine().split(" ");
    mans[i][0] = Integer.parseInt(str[0]);
    mans[i][1] = Integer.parseInt(str[1]);
}

for (int i = 0; i < num; i++) {
    int rank = 1;
    for (int j = 0; j < num; j++) {
        if (i == j)
            continue;
        if (mans[i][0] < mans[j][0] && mans[i][1] < mans[j][1])
            rank++;
    }
    ranks[i] = rank;
}

for (int i : ranks) {
    System.out.print(i + " ");
}
```


![1](https://user-images.githubusercontent.com/45132207/104540377-b053d580-5662-11eb-8fd5-639596ff0059.PNG)


# 3. 더 풀어 보기🚨

괜찮은 수행시간이 나왔으니 패스

---
<a href="https://github.com/azqazq195/coding_teset/blob/master/Baekjun/BigNumAB.java" target="_blank">전체 코드</a>