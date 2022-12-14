import kotlin.math.abs
import kotlin.reflect.typeOf
import kotlin.system.exitProcess
fun main(args: Array<String>) {
    val num = intArrayOf(7,1,5,3,6,4)
    //print(longestCommonPrefix(arrayOf("flower","flower","flower","flower")))
    println(maxProfit(num))
}

//218 Contains Duplicate I
fun containsDuplicate(nums: IntArray): Boolean {
    var map = mutableMapOf<Int, Int?>()
    nums.forEachIndexed { index, element ->
        if (map.containsKey(element)){
            return true
        }else{
            map.put(element,index)
        }
    }
    print(map)
    return false
}
//219. Contains Duplicate II

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    var hashmap = mutableMapOf<Int,Int>()
    nums.forEachIndexed { index,value ->
        if(hashmap.containsKey(value) && (index - hashmap.get(value)!! <= k)){
            return true
        }
        hashmap.put(value,index)
    }
    return false
}

//220. Contains Duplicate III ( to be continued)
fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    return false
}

//9. Palindrome Number
fun isPalindrome(x: Int): Boolean {
    var x_string = x.toString()
    if(x_string.get(0) != x_string.get(x_string.length-1)){
        return false
    }
    var pal_num = StringBuilder()
    for (i in (x_string.length-1)downTo 0){
        pal_num.append(x_string.get(i))
    }

    if (pal_num.toString() != x_string){
        return false
    }
    return true
}

//14. Longest Common Prefix
fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.size == 0 || strs ==null){
        return ""
    }
    strs.sort()
    val long_str = strs[strs.size-1]
    var result = StringBuilder ()
    result.append("")
    strs.forEachIndexed(){index,value->
        if(value == "" || value == null ){
            return@forEachIndexed
        }
        if(value.get(0) == long_str.get(0)){
            for (i in 0 until value.length){
                if(value.get(i)!=long_str.get(i) || result.toString() == long_str){
                    return result.toString()
                }
                result.append(value.get(i))
            }
        }
    }
    return result.toString()
}

// 125. Valid Palindrome

fun isPalindrome(s: String): Boolean {
    var asc_str : String = "";
    var d_str : String = "";
    var tmp_str : String = "";

    for (i in 0 until s.length){
        if(isAlphanumeric(s.get(i))){
            tmp_str = toLowerCase(s.get(i)).toString()
        }
        asc_str += tmp_str
        tmp_str =""
    }

    for (i in s.length-1 downTo  0){
        if(isAlphanumeric(s.get(i))){
            tmp_str = toLowerCase(s.get(i)).toString()
        }
        d_str += tmp_str
        tmp_str =""
    }

    if (asc_str != d_str){
        return  false
    }
    return true
}

fun isAlphanumeric(c : Char): Boolean{
    if (isLowerCase(c) || isNumber(c) || isUpperCase(c)){
        return true
    }
    return false
}

fun isLowerCase(c : Char):Boolean{
    return ('a' <= c && c <= 'z')
}

fun isNumber(c : Char):Boolean{
    return ('0' <= c && c <= '9')
}

fun isUpperCase(c : Char):Boolean{
    return ('A' <= c && c <= 'Z')
}

fun toLowerCase(c : Char):Char{
    if(isUpperCase(c)){
        return ((c - 'A').plus('a'.toInt())).toChar()
    }
    return c
}

// 121. Best Time to Buy and Sell Stock
fun maxProfit(prices: IntArray): Int {
    var m_day =  prices.get(0)
    var profit = 0
    for (i in 1 until prices.size){

        if(prices.get(i) < m_day){
            m_day = prices.get(i)
        }

        if(prices.get(i) - m_day > profit){
            profit = prices.get(i) - m_day
        }
    }
    return profit
}