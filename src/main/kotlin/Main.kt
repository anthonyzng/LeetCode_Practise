import kotlin.math.abs
import kotlin.reflect.typeOf
import kotlin.system.exitProcess
import java.util.*;

// for data structure
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//for test case value
fun test_link_node(){
    // create a linkNode as  (1) -> (2) -> (4)
    var list1 : ListNode ?= ListNode(1);
    list1?.next = ListNode(2);
    list1?.next?.next = ListNode(4);
}
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

// 20 Valid Parentheses
fun isValid(s: String): Boolean {
    if(s.length % 2 != 0){
        return false
    }
    val stack = Stack<Char>();
    for (i in s.toCharArray()){
        if(i == '(' || i == '{' || i == '['){
            stack.push(i);
        }else if(i == ')' && !stack.isEmpty() && stack.peek() == '('){
            stack.pop();
        }else if(i == '}' && !stack.isEmpty() && stack.peek() == '{'){
            stack.pop();
        }else if(i == ']' && !stack.isEmpty() && stack.peek() == '['){
            stack.pop();
        }else{
            return false
        }
    }
    return stack.isEmpty();
}

// 21. Merge Two Sorted Lists
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var temp_node = ListNode(0)
    var current_node = temp_node
    var temp_l1 = list1
    var temp_l2 = list2

    while(temp_l1 != null && temp_l2 != null) {
        if(temp_l1.`val` < temp_l2.`val`) {
            current_node.next = temp_l1
            temp_l1 = temp_l1.next
        } else {
            current_node.next = temp_l2
            temp_l2 = temp_l2.next
        }
        current_node = current_node.next!!
    }
    if(temp_l1 != null) {
        current_node.next = temp_l1
    }
    if(temp_l2 != null) {
        current_node.next = temp_l2
    }
    return temp_node.next
}
// 203. Remove Linked List Elements
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummy_node = ListNode(0);
    var current_node = dummy_node;
    var temp_head : ListNode ?= head;
    while(temp_head != null){
        if(temp_head?.`val` == `val`){
            while(temp_head?.`val` == `val`){
                temp_head = temp_head.next
            }
        }
        current_node.next = temp_head
        if(current_node?.next != null){
            current_node = current_node.next!!;
        }
        //println("current_node val : " + current_node.`val`);
        //println("next val : "+ current_node.next.`val`);
        temp_head = temp_head?.next;
    }
    return dummy_node.next
}

//206. Reverse Linked List
fun reverseList(head: ListNode?): ListNode? {
    var prev_node : ListNode? = null;
    var current_node = head;
    while(current_node != null){
//        println("==============loop start=================")
//        println("start current_node = "+current_node?.`val`?:"null")
        var next  = current_node.next;
//        println("next = " + next?.`val`?:"null");
        current_node.next = prev_node;
//        println("current node.next = " + prev_node?.`val`?:"null");
        prev_node = current_node;
//        println("prev_node = " + current_node?.`val`?:"null");
        current_node = next;
//        println("update current_node = "+current_node?.`val`?:"null")
//        println("==============loop end=================")
    }
    return prev_node;
}