function solution(sticker) {
    const length = sticker.length;

    const dp1 = new Array(length);
    const dp2 = new Array(length);

    if(length === 1)
        return sticker[0];
    if(length === 2)
        return Math.max(sticker[0] ,sticker[1]);

    dp1[0] = sticker[0];
    dp1[1] = sticker[0];

    dp2[0] = 0;
    dp2[1] = sticker[1];

    for (let i = 2; i < length - 1; i++) {
        dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
    }

    let i = length - 1;
    dp1[i] = Math.max(dp1[i-1], dp1[i-2]);
    dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);

    return Math.max(dp1[i], dp2[i]);
}

const sticker1 = [14, 6, 5, 11, 3, 9, 2, 10]
const sticker2 = [1, 3, 2, 5, 4]

console.log(solution(sticker1))
console.log(solution(sticker2))