문제에 대한 설명

백준 -> 기본 수학 1 -> [2447 별 찍기 - 10](https://www.acmicpc.net/problem/2447)에 대한 연습입니다.

# 1. 문제 읽기
 
>재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
```
***
* *
***
```
>N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.


### 예제 입·출력
#### 입력
>27
#### 출력
>
```
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
```

#### 내 생각💡
재귀는 많이 안해봐서 어려웠다.

첫번째 방법으로 평소했던 별찍기 처럼 for 문과 if 문으로 조건이 맞을 때 별을 찍고 조건이 다를땐 안찍는 식으로 다가 갔지만, 도저히 재귀로 이용할 수 없었고 풀 수도 없었다.

그래서 일단 별을 다 찍어 놓고 조건에 맞는 것을 지우는 형식으로 다시 풀었다.

# 2. 풀이

### 풀이 과정

일단 입력값의 배열만큼 별을 찍어준다. 

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int num = Integer.parseInt(br.readLine());
char star[][] = new char[num][num];

for (int i = 0; i < num; i++) {
    for (int j = 0; j < num; j++) {
        star[i][j] = '*';
    }
}
```


![0](https://user-images.githubusercontent.com/45132207/104482667-8bcc0f00-560a-11eb-8d58-a899677c9469.PNG)

9*9 배열을 봐보면

9의 크기 일때,
3으로 나누었을 때 몫이 1인 숫자들 {3, 4, 5}가 비어 있고

3의 크기 일때,
1로 나누었을 때 몫이 1인 숫자 {1} 이 비어있다.

```java
int temp = num;
temp = temp / 3;
```

또, 3의 크기 일때 {0, 1, 2}, {3, 4, 5} 등으로 숫자가 있지만
{0, 1, 2}로 통일 시켜줄 수 있다.

```java
if ((i % num) / temp == 1 && (j % num) / temp == 1)
```

9의 크기일때 별을 3개씩 뺏고
3의 크기일때 별을 1개씩 뺏다.
별을 1개씩 뺄때까지 숫자를 줄여가며 재귀 호출한다.

```java
num = num / 3;
if (num != 1) {
    return drawStar(star, num, size);
} else {
    return star;
}
```

![1](https://user-images.githubusercontent.com/45132207/104483504-87ecbc80-560b-11eb-9481-f7addd2cfa9c.PNG)

짜잔! 시간초과 입니다.


# 3. 더 풀어 보기🚨

당장 고칠 수 있어보이는 것은 
자꾸 까먹는 스트링빌더와 배열을 초기화 할때의 포문이다.
String 배열은 초기 셋팅을 해주어야 하지만 boolean배열은 초기 셋팅이 false니까 이용해 볼 수 있을 것 같다.

```java
 for (int i = 0; i < num; i++) {
    for (int j = 0; j < num; j++) {
        sb.append(star[i][j]);
    }
    sb.append("\n");
}
System.out.println(sb);
```

![2](https://user-images.githubusercontent.com/45132207/104484072-2bd66800-560c-11eb-8a88-3e27df2afdd9.PNG)

스트링 빌더만으로 수행시간을 줄여 통과하였다.
하지만 여전히 수행시간이 높은 것 같다.

boolean 배열은 Default값으로 false를 가지기 때문에
입력시간을 줄이기위해 boolean 배열로 만들어 보았다.

```java
boolean star[][] = new boolean[num][num];

 if (star[i][j]) {
    sb.append(" ");
} else {
    sb.append("*");
}
```

![3](https://user-images.githubusercontent.com/45132207/104484670-e7979780-560c-11eb-83b1-e2d282739a4a.PNG)

메모리는 줄었는데 시간이 늘어났다.

다시 char 배열로 돌아와서 StringBuilder 대신 BufferedWriter을 써보았다.

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

for (int i = 0; i < num; i++) {
    for (int j = 0; j < num; j++) {
        bw.write(star[i][j]);
    }
    bw.write("\n");
}
bw.flush();
```

![4](https://user-images.githubusercontent.com/45132207/104485541-f7fc4200-560d-11eb-8f0e-a5e1db174f1e.PNG)

시간은 조금 늘었지만 메모리는 많이 줄었다.

이 문제는 가장 빠른 분들도 180ms 정도 나오는 문제였다.
빠른 분들의 코드를 봤지만 큰 구현방법은 비슷한 것 같고 세세하게는 내가 이해할 수 없어 여기서 이번문제는 마무리 할게용

---
[전체 코드](https://github.com/azqazq195/coding_teset/blob/master/Baekjun/DrawStar_10.java)