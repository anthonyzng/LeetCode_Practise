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
    val num = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    //println(maxProfit(num))
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

//2215. Find the Difference of Two Arrays
fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val resultList: MutableList<List<Int>> = mutableListOf()
    val n1Set = nums1.toSet()
    val n2Set = nums2.toSet()

    val copyOfN1Set = n1Set.toMutableSet()
    for(num in n1Set){
        if(n2Set.contains(num)){
            copyOfN1Set.remove(num)
        }
    }
    val copyOfN2Set = n2Set.toMutableSet()
    for(num in n2Set){
        if(n1Set.contains(num)){
            copyOfN2Set.remove(num)
        }
    }
    resultList.add(copyOfN1Set.toList())
    resultList.add(copyOfN2Set.toList())
    return resultList
}

//35. Search Insert Position
fun searchInsert(nums: IntArray, target: Int): Int {
    for(i in nums.indices){
        if(nums[i] == target ||nums[i] > target){
            return i
        }
        if(nums[i] > target && nums[i-1] < target){
            print("index = $i, value = ${nums[i]}, previous value = ${nums[i-1]}")
            return i;
        }
    }
    return nums.size;
}

//26. Remove Duplicates from Sorted Array
fun removeDuplicates(nums: IntArray): Int {
    //{0,1,1,1,1,2,2,3,3,4} pointer = 1,index = 2
    //{0,1,2,1,1,2,2,3,3,4} pointer = 2  index = 5
    //{0,1,2,3,1,2,2,3,3,4} pointer = 3 index = 7
    //{0,1,2,3,4,2,2,3,3,4} pointer = 4 index = 9
    var pointer = 0;
    for(i in nums.indices){
        if(nums[i] != nums[pointer]){
            pointer++;
            nums[pointer] = nums[i];
        }
    }
    return pointer+1;
}

//27. Remove Element
fun removeElement(nums: IntArray, `val`: Int): Int {
    var l_pointer = 0;
    for(i in nums.indices){
        if(nums[i] != `val`){
            nums[l_pointer] = nums[i];
            l_pointer++;
        }
    }
    return l_pointer
}

//28. Find the Index of the First Occurrence in a String
fun strStr(haystack: String, needle: String): Int {
    for(i in haystack.indices){
        var h_pointer = i ;
        var n_pointer = 0;
        var tmp_result = "";
        while(n_pointer < needle.length && h_pointer<haystack.length){
            println(" Haystack "+haystack.get(h_pointer).toString() + " Needle "+needle.get(n_pointer).toString());
            if(haystack.get(h_pointer) == needle.get(n_pointer)){
                tmp_result += haystack.get(h_pointer)
            }
            h_pointer++;
            n_pointer++;
        }
        if(tmp_result==needle){
            return i;
        }

    }
    return -1;
}

//58. Length of Last Word
fun lengthOfLastWord(s: String): Int {
    var space = " ";
    var result = "";
    var pointer = 0;
    var start = 0;
    for(i in s.length-1 downTo 0 ){
        if(s.get(i).toString()!=space){
            pointer = i+1;
            for(q in i downTo 0){
                if(s.get(q).toString()==space){
                    start = q+1;
                    break;
                }
            }
            break;
        }
    }
    for(p in start until pointer){
        result+= s.get(p).toString();
    }
    return result.length;
}

//66. Plus One
fun plusOne(digits: IntArray): IntArray {
    for(i in digits.size -1 downTo 0){
        if(digits[i]<9){
            digits[i] = digits[i] + 1;
            return digits;
        }
        digits[i] = 0;
    }
    var result_arr = IntArray(digits.size+1);
    result_arr[0] = 1;
    return result_arr;
}

//67. Add Binary
fun addBinary(a: String, b: String): String {
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1
    val sb = StringBuilder()
    while (i >= 0 || j >= 0 || carry > 0) {
        val sum = (if (i >= 0) a[i] - '0' else 0) + (if (j >= 0) b[j] - '0' else 0) + carry
        if(i>=0){
            println("a sting : " + a[i]);
        }
        if(j>=0){
            println("b sting : " + b[j]);
        }
        println("Sum : " +sum);
        sb.append(sum % 2) // left 0 / 1 becuase mod 2
        println("Sum  % 2: " +sum % 2);
        carry = sum / 2
        println("Carry = Sum /2 =  : " +carry);
        i--
        j--
        println(sb);
        println("==================");
    }
    sb.reverse().toString();
    println(sb);
    return sb.toString()
}
//88. Merge Sorted Array
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var last_pointer = m + n -1;
    var n1_pointer = m-1;
    var n2_pointer = n-1;
    while(n1_pointer >= 0 && n2_pointer >= 0){
        if(nums1[n1_pointer] > nums2[n2_pointer]){
            nums1[last_pointer] = nums1[n1_pointer];
            n1_pointer--;
        }else{
            nums1[last_pointer] = nums2[n2_pointer];
            n2_pointer--;
        }
        last_pointer--;
    }
    while(n2_pointer >= 0){
        nums1[last_pointer] = nums2[n2_pointer];
        last_pointer--;
        n2_pointer--;
    }
}
