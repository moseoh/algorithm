문제에 대한 설명

백준 -> 기본 수학 2 -> <a href="https://www.acmicpc.net/problem/11653" target="_blank">11653 소인수분해</a>에 대한 연습입니다.

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

# 3. 더 풀어 보기🚨

리스트보다 저번에 했던 스트링 빌더로 표현해보았다.

```java
// List list = new ArrayList<Integer>();
StringBuilder sb = new StringBuilder();

// list.add(temp);
sb.append(temp).append("\n");

// for (int i = 0; i < list.size(); i++) {
// System.out.println(list.get(i));
// }
System.out.println(sb);
```

![2](https://user-images.githubusercontent.com/45132207/104458994-75fd2080-55ef-11eb-8aa2-37e41e4a91c9.PNG)

비슷한 결과를 얻을 수 있다.

---
<a href="https://github.com/azqazq195/coding_teset/blob/master/Baekjun/Factorization.java" target="_blank">전체 코드</a>