package src.baekjun.브루트_포스

fun main() {
    val N = readLine()!!.toInt()
    var count = 1
    var num = 666

    while(N > count){
        num++
        if(num.toString().contains("666")){
            count++
        }
    }
    println(num)

}