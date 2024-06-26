<h2><a href="https://www.geeksforgeeks.org/problems/largest-independent-set-problem/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article">Largest Independent Set Problem</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a Binary Tree of size <strong>N</strong>, find the size of the&nbsp;<strong>Largest&nbsp;Independent&nbsp;Set(LIS)</strong> in it. A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset. Your task is to complete the function <strong>LISS()</strong>, which finds the size of the&nbsp;Largest&nbsp;Independent&nbsp;Set.</span></p>

<pre><span style="font-size:18px">For example:
Consider the following binary tree.The LIS is
LIS: [10, 40, 60, 70, 80]
Size: 5.
<img src="http://www.geeksforgeeks.org/wp-content/uploads/LargestIndependentSet.png" style="height:250px; width:350px">
</span></pre>

<p><span style="font-size:18px"><strong>Example1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
10 20 30 40 50 N 60 N N 70 80</span>

<span style="font-size:18px"><strong>Output:</strong>
5
<strong>Explanation:</strong> LIS of the above 
tree will be [10,40, 60, 70,80]</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input: </strong>
1 2 5 3 4 N 6</span>

<span style="font-size:18px"><strong>Output:</strong>
4</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1&lt;= Number of nodes &lt;=500<br>
<strong>Your Task:</strong><br>
You don't need to take input. Just complete the function<strong> LISS() </strong>that takes the root <strong>node </strong>as a parameter and returns the largest independent set<strong>.</strong></span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;