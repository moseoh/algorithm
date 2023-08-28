```
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
```

after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters,
모든 알파벳을 소문자로 변경하고, 알파벳이나 숫자가 아닌 문자는 제거한다.

it reads the same forward and backward.
앞뒤가 동일하면 회문이다.

return true if it is a palindrome, or false otherwise.
회문이면 true, 아니면 false를 반환한다.

```
1. 소문자로 변경한다.
2. 알파벳, 숫자가 아닌 문자는 제거한다.
3. 앞뒤 문자를 비교한다.
```