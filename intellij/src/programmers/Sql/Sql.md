

문제에 대한 설명
프로그래머스 -> SQL 고득점 Kit에 대한 연습입니다.

# MySql

문제 답이 간단한 편이어서 
문제 순서대로 쿼리와 구문들의 간략한 설명만 기록

## 1. SELECT
### 1) 모든 레코드 조회하기

```sql
SELECT * 
FROM   ANIMAL_INS 
ORDER  BY ANIMAL_ID ASC; 
```

### 2) 역순 정렬하기

```sql
SELECT NAME, 
       DATETIME 
FROM   ANIMAL_INS 
ORDER  BY ANIMAL_ID DESC; 
```

### 3) 아픈 동물 찾기

```sql
SELECT ANIMAL_ID, 
       NAME 
FROM   ANIMAL_INS 
WHERE  INTAKE_CONDITION = 'Sick' 
ORDER  BY ANIMAL_ID ASC; 
```

### 4) 어린 동물 찾기

```sql
SELECT ANIMAL_ID, 
       NAME 
FROM   ANIMAL_INS 
WHERE  INTAKE_CONDITION != 'Aged' 
ORDER  BY ANIMAL_ID ASC; 
```

### 5) 동물의 아이디와 이름

```sql
SELECT ANIMAL_ID, 
       NAME 
FROM   ANIMAL_INS 
ORDER  BY ANIMAL_ID ASC; 
```

### 6) 여러 기준으로 정렬하기

```sql
SELECT ANIMAL_ID, 
       NAME, 
       DATETIME 
FROM   ANIMAL_INS 
ORDER  BY NAME ASC, 
          DATETIME DESC; 
```

### 7) 상위 n개의 레코드

```sql
SELECT NAME 
FROM   ANIMAL_INS 
WHERE  DATETIME = (SELECT MIN(DATETIME) 
                   FROM   ANIMAL_INS) 
```

## 2. SUM, MAX, MIN
### 1) 최댓값 구하기

```sql
SELECT MAX(DATETIME) 
FROM   ANIMAL_INS; 
```

### 2) 최솟값 구하기

```sql
SELECT MIN(DATETIME) 
FROM   ANIMAL_INS; 
```

### 3) 동물 수 구하기

```sql
SELECT COUNT(*) 
FROM   ANIMAL_INS 
```

### 4) 중복 제거하기

```sql
SELECT COUNT(DISTINCT NAME) 
FROM   ANIMAL_INS 
WHERE  NAME IS NOT NULL 
```

## 3. GROUP BY
### 1) 고양이와 개는 몇마리 있을까

```sql
SELECT ANIMAL_TYPE, 
       COUNT(*) AS COUNT 
FROM   ANIMAL_INS 
GROUP  BY ANIMAL_TYPE 
ORDER  BY ANIMAL_TYPE ASC; 
```

### 2) 동명 동물 수 찾기

```sql
SELECT NAME, 
       COUNT(NAME) 
FROM   ANIMAL_INS 
GROUP  BY NAME 
HAVING COUNT(NAME) >= 2 
ORDER  BY NAME ASC; 
```

### 3) 입양 시각 구하기(1)

```sql
SELECT HOUR(DATETIME)        AS HOUR, 
       COUNT(HOUR(DATETIME)) AS COUNT 
FROM   ANIMAL_OUTS 
WHERE  Time(DATETIME) BETWEEN '09:00:00' AND '19:59:00' 
GROUP  BY HOUR(DATETIME) 
ORDER  BY HOUR ASC; 
```

### 4) 입양 시각 구하기(2)

```sql
SET @HOUR:=-1; 

SELECT ( @HOUR := @HOUR + 1 )          AS HOUR, 
       (SELECT COUNT(*) AS COUNT 
        FROM   ANIMAL_OUTS 
        WHERE  HOUR(DATETIME) = @HOUR) AS COUNT 
FROM   ANIMAL_OUTS 
WHERE  @HOUR < 23 
```
SET을 이용해 @HOUR 변수를 -1 초기화한다.
@HOUR는 0부터 23까지


## 4. IS NULL
### 1) 이름이 없는 동물의 아이디

```sql
SELECT ANIMAL_ID 
FROM   ANIMAL_INS 
WHERE  NAME IS NULL; 
```

### 2) 이름이 있는 동물의 아이디

```sql
SELECT ANIMAL_ID 
FROM   ANIMAL_INS 
WHERE  NAME IS NOT NULL; 
```

### 3) NULL 처리하기

```sql
SELECT ANIMAL_TYPE, 
       IFNULL(NAME, 'No name'), 
       SEX_UPON_INTAKE 
FROM   ANIMAL_INS; 
```


## 5. JOIN
### 1) 없어진 기록 찾기 (다시 풀기)

```sql
SELECT ANIMAL_ID, 
       NAME 
FROM   ANIMAL_OUTS 
WHERE  ANIMAL_ID NOT IN (SELECT ANIMAL_ID 
                         FROM   ANIMAL_INS) 
```

### 2) 있었는데요 없었습니다

```sql
SELECT ins.ANIMAL_ID, 
       ins.NAME 
FROM   ANIMAL_INS AS ins 
       JOIN ANIMAL_OUTS AS outs 
       ON   ins.ANIMAL_ID = outs.ANIMAL_ID 
WHERE  ins.DATETIME >= outs.DATETIME 
ORDER  BY ins.DATETIME ASC 
```

### 3) 오랜 기간 보호한 동물(1)

```sql
SET @ROWNUM:=0; 

SELECT temp.NAME, 
       temp.DATETIME 
FROM   (SELECT ( @ROWNUM := @ROWNUM + 1 ) AS rownum, 
               NAME, 
               DATETIME 
        FROM   ANIMAL_INS 
        WHERE  ANIMAL_ID NOT IN (SELECT ANIMAL_ID 
                                 FROM   ANIMAL_OUTS) 
        ORDER  BY DATETIME ASC) AS temp 
WHERE  ROWNUM <= 3 
```

### 4) 보호소에서 중성화한 동물

```sql
SELECT ins.ANIMAL_ID, 
       ins.ANIMAL_TYPE, 
       ins.NAME 
FROM   ANIMAL_INS AS ins 
       LEFT OUTER JOIN ANIMAL_OUTS AS outs 
                  ON   ins.ANIMAL_ID = outs.ANIMAL_ID 
WHERE  ins.SEX_UPON_INTAKE != outs.SEX_UPON_OUTCOME 
ORDER  BY ins.ANIMAL_ID ASC; 
```


## 6. String, Data
### 1) 루시와 엘라 찾기

```sql
SELECT ANIMAL_ID, 
       NAME, 
       SEX_UPON_INTAKE 
FROM   ANIMAL_INS 
WHERE  NAME IN ( 'Lucy', 'Ella', 'Pickle', 'Rogan', 
                 'Sabrina', 'Mitty' ) 
ORDER  BY ANIMAL_ID; 
```

### 2) 이름에 el이 들어가는 동물 찾기

```sql
SELECT ANIMAL_ID, 
       NAME 
FROM   ANIMAL_INS 
WHERE  ANIMAL_TYPE = 'Dog' 
       AND NAME LIKE '%el%' 
ORDER  BY NAME ASC; 
```

### 3) 중성화 여부 파악하기

```sql
SELECT ANIMAL_ID, 
       NAME, 
       IF(SEX_UPON_INTAKE LIKE 'Intact%', 'X', 'O') AS '중성화' 
FROM   ANIMAL_INS 
```

### 4) 오랜 기간 보호한 동물(2)

```sql
SELECT outs.ANIMAL_ID, 
       outs.NAME 
FROM   ANIMAL_OUTS outs 
       JOIN ANIMAL_INS ins 
       ON   outs.ANIMAL_ID = ins.ANIMAL_ID 
ORDER  BY outs.DATETIME - ins.DATETIME DESC 
LIMIT  2 
```

### 5) DATETIME에서 DATE로 형 변환

```sql
SELECT ANIMAL_ID, 
       NAME, 
       DATE_FORMAT(DATETIME, '%Y-%m-%좌표정렬하기2') AS 날짜 
FROM   ANIMAL_INS 
ORDER  BY ANIMAL_ID ASC 
```

---

# 정리

### ORDER
>ORDER BY {컬럼명} {정렬 방법(ASC, DESC)}

,를 통해 여러개 가능

### WHERE
>WHERE {컬럼명} = {값('문자', 숫자)}
WHERE {컬럼명} != {값('문자', 숫자)}
WHERE {컬럼명} IS NULL {값('문자', 숫자)}
WHERE {컬럼명} IS NOT NULL

포함하고 싶은 값이나, 포함하고 싶지 않은 값
AND나 OR을 통해 여러개 가능

NULL은 IS 와 IS NOT 을 사용한다.

>WHERE IN
WHERE NOT IN

WHERE IN 과 NOT IN을 통해서 여러개를 동시에 검색 할 수 있다.
SELECT문을 안에 넣어서 검색할 수도 있다.

>WHERE  ANIMAL_TYPE = 'Dog' 
       AND NAME LIKE '%el%' 

LIKE를 통해 특정 문자열을 포함한 검색이 가능
% = 어떠한 값
NAME에 el이 앞에도 뒤에도 어떠한 값이 없다고 표기 되었으므로
el이 포함된 이름을 찾는다

### MIN(), MAX(), SUM(), COUNT()
>SELECT MIN(DATETIME) 
FROM   ANIMAL_INS; 

SELECT 시 MIN({컬럼명}) 혹은 MAX({컬럼명})을 통해
최솟값이나 최댓값만 가져올 수 있다.

컬럼값이 실수일 경우 SUM을 통해 총 합을 구할 수 있다.

COUNT를 통해 컬럼의 갯수를 셀 수 있다. 

DISTINCT 옵션을 붙이면 중복 값을 제외 한다.

### IF()

>IFNULL(A, B)

A가 널일 경우 B 출력, A가 널이 아닐경우 A 출력

>IF(SEX_UPON_INTAKE LIKE 'Intact%', 'X', 'O') AS '중성화'

IF에 (조건문, '참일 경우', '거짓일 경우')를 표기 할 수 있다.

### LIMIT

>LIMIT  2 

LIMIT를 이용해 결과의 갯수를 정할 수 있다.


### DATETIME 형변환
>HOUR() MINUITE() DAY() MONTH()

등으로 HOUR(DATETIME)처럼 쓸 수 있다. => 시간만 표시

>DATE_FORMAT(DATETIME, '%Y-%m-%d')

DATE_FORMAT으로 원하는 데이트 형식을 만들 수 있다.