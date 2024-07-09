<h2><a href="https://www.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1">Longest alternating subsequence</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">A sequence {x1, x2, .. xn} is an alternating sequence if its elements satisfy one of the following relations :<br>x1 &lt; x2 &gt; x3 &lt; x4 &gt; x5..... or &nbsp;x1 &gt;x2 &lt; x3 &gt; x4 &lt; x5.....<br>Your task is to find the longest length of such a sequence.<br><br><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>nums = {1,5,4}
<strong>Output: </strong>3
<strong>Explanation: </strong>The entire sequenece is a 
alternating sequence.</span>
<span style="font-size: 18px;"><strong>Input: </strong>nums = {</span><span style="font-size: 18px;">1,17,5,10,13,15,10,5,16,8}
<strong>Output: </strong>7
<strong>Explanation: </strong>There are several subsequences
that achieve this length. 
One is maximum length subsequences {1,17,10,13,10,16,8}.</span>
</pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n)<br><strong>Expected Space Complexity:&nbsp;</strong>O(1)<br><strong>Constraints:</strong><br>1 &lt;= nums[i] &lt;= 10<sup>4&nbsp;</sup><br>1 &lt;= n &lt;= 10<sup>5&nbsp;<br></sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;<code>Arrays</code>&nbsp;