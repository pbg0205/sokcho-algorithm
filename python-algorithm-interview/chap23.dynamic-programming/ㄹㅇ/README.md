#### No.509 Fibonnaci Number

```swift
class Solution {
    func fib(_ n: Int) -> Int {
        var fibonacci = [0, 1]
        
        for num in 2...30 {
            fibonacci.append(fibonacci[num-2]+fibonacci[num-1])
        }
        
        return fibonacci[n]
    }
}
```

#### No.53 Maxinum Subarray

```swift
class Solution {
    func maxSubArray(_ nums: [Int]) -> Int {
        var dp = [Int](repeating: 0, count: nums.count)
        
        for (idx, num) in nums.enumerated() {
            guard idx > 0 else {
                dp[idx] = num
                continue
            }
            
            dp[idx] = max(dp[idx-1]+num, num)
        }

        return dp.max()!
    }
}
```

#### No.70 Climbing Stairs
```swift
class Solution {
    func climbStairs(_ n: Int) -> Int {
        guard n > 2 else { return n }
        var dp = [0, 1, 2]
        
        for num in 3...n {
            dp.append(dp[num-1]+dp[num-2])
        }
        
        return dp[n]
    }
}
```
### No.198 House Robber
```swift
class Solution {
    func rob(_ nums: [Int]) -> Int {
        var dp = [Int](repeating: 0, count: nums.count)
        
        for (idx, num) in nums.enumerated() {
            guard idx > 1 else {
                dp[idx] = num
                continue
            }
            
            guard idx > 2 else {
                dp[idx] = dp[idx-2]+num
                continue
            }
            
            dp[idx] = max(dp[idx-2]+num, dp[idx-3]+num)
        }
        
        return dp.max()!
    }
}
```
