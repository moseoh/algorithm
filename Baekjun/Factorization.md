

문제에 대한 설명
<!--
프로그래머스 -> 코딩테스트 고득점 Kit -> 힙(Heap) - 더 맵계(Level2)에 대한 연습입니다.
-->
백준 -> 기본 수학 2 -> [소인수분해](https://www.acmicpc.net/problem/11653)에 대한 연습입니다.

# 1. 문제 읽기
 
>정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.



### 예제 입·출력
#### 입력
>72
#### 출력
>2
2
2
3
3

#### 내 생각💡
2부터 1씩 올려가며 나누면 될것 같다.

# 2. 풀이

### 풀이 과정

```java
public class Factorization {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num != 1) {
            factorization(num);
        }
    }

    static void factorization(int num) {
        int temp = 2;
        List list = new ArrayList<Integer>();
        while (num != 1) {
            if (num % temp == 0) {
                list.add(temp);
                num /= temp;
            } else {
                temp++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
```

![1](https://user-images.githubusercontent.com/45132207/104457902-fa4ea400-55ed-11eb-8f7b-36442f375559.PNG)

# 3. 문제점🚨

리스트보다 저번에 했던 스트링 빌더로 표현해보았다.

```java
// String answer = "";
StringBuilder sb = new StringBuilder();

// answer = answer + String.valueOf(num[0][k]);
sb.append(String.valueOf(num[0][k]));
```

![2](https://user-images.githubusercontent.com/45132207/104228881-cdd04600-548e-11eb-94b5-2ec25815ad6b.PNG)

처음 자바 코드 문제를 풀면서 scanf를 buffer로 사용하였을 때 만큼 메모리와 수행시간이 줄어 들었다.

포문이 많긴 하지만 실제로 수행하는데에는 큰 차이가 없는 수준이어서 StringBuilder 하나만으로 시간은 많이 단축 시켰다.







