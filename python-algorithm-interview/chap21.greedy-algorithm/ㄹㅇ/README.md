```swift
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var total = 0
        
        for idx in 0..<prices.count-1 {
            if prices[idx+1] > prices[idx] {
                total += prices[idx+1] - prices[idx]
            }
        }
        
        return total
    }
}
```

```swift
class Solution {
    func reconstructQueue(_ people: [[Int]]) -> [[Int]] {
        let queue = people.sorted { $0[0] != $1[0] ? $0[0] > $1[0] : $0[1] < $1[1] }
        var reconstructed: [[Int]] = []
        
        for info in queue {
            reconstructed.insert(info, at: info[1])
        }
        
        return reconstructed
    }
}
```
```swift
class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
        let greedy = g.sorted(), size = s.sorted()
        
        var child = 0, cnt = 0
        
        while child < g.count && cnt < s.count {
            if size[cnt] >= greedy[child] {
                child += 1
            }
            cnt += 1
        }
        
        return child
    }
}
```
```swift
class Solution {
    func canCompleteCircuit(_ gas: [Int], _ cost: [Int]) -> Int {
        guard gas.reduce(0, +) >= cost.reduce(0, +) else { return -1 }
        
        var start = 0, fuel = 0
        
        for location in 0..<gas.count {
            if gas[location] + fuel < cost[location] {
                start = location+1
                fuel = 0
                continue
            }
            
            fuel += gas[location] - cost[location]
        }
        
        return start
    }
}
```
