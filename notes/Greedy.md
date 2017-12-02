# 简介
所谓贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的仅是在某种意义上的局部最优解。
贪心算法没有固定的算法框架，算法设计的关键是贪心策略的选择。必须注意的是，贪心算法不是对所有问题都能得到整体最优解，选择的贪心策略必须具备无后效性，即某个状态以后的过程不会影响以前的状态，只与当前状态有关。
所以对所采用的贪心策略一定要仔细分析其是否满足无后效性。


# 思想


# 实现步骤
1. 建立数学模型来描述问题。
2. 把求解的问题分成若干个子问题。
3. 对每一子问题求解，得到子问题的局部最优解。
4. 把子问题的解局部最优解合成原来解问题的一个解。

# 贪心算法适用的问题
贪心策略适用的前提是：局部最优策略能导致产生全局最优解。
贪心并不能解决所有的这样动态搜索搞最优解的问题，在用贪心之前要会判断一下。
实际上，贪心算法适用的情况很少。一般，对一个问题分析是否适用于贪心算法，可以先选择该问题下的几个实际数据进行分析，就可做出判断。

# 贪心策略的选择
因为用贪心算法只能通过解局部最优解的策略来达到全局最优解，因此，一定要注意判断问题是否适合采用贪心算法策略，找到的解是否一定是问题的最优解。

# 题目类型


# 实现框架
```java
// 从问题的某一初始解出发
while (能朝给定总目标前进一步) { 
    // 利用可行的决策，求出可行解的一个解元素
}
// 由所有解元素组合成问题的一个可行解
```

# 参考资料