```swift
func maxSlidingWindow(_ nums: [Int], _ k: Int) -> [Int] {
    var maxIdx = [Int]()
    var res = [Int]()
    
    for i in 0..<nums.count {
        while maxIdx.count > 0 && nums[maxIdx.last!] < nums[i] {
            maxIdx.removeLast()
        }
        
        maxIdx.append(i)
        
        if i >= k - 1 {
            if maxIdx.first! + k == i {
                maxIdx.removeFirst()
            }
            
            res.append(nums[maxIdx.first!])
        }
    }
    
    return res
}

func minWindow(_ s: String, _ t: String) -> String {
    let sChars = Array(s), tChars = Array(t)
    var tFreq = Dictionary(tChars.map { ($0, 1) }, uniquingKeysWith: +)
    var left = 0, shortestLen = Int.max, start = 0, matters = 0
    
    for (i, sChar) in sChars.enumerated() {
        guard let sCharFreq = tFreq[sChar] else {
            continue
        }
        
        tFreq[sChar] = sCharFreq - 1
        
        if sCharFreq > 0 {
            matters += 1
        }
        
        while matters == tChars.count {
            guard let leftFreq = tFreq[sChars[left]] else {
                left += 1
                continue
            }
            
            if leftFreq == 0 {
                matters -= 1
                
                if i - left + 1 < shortestLen {
                    shortestLen = i - left + 1
                    start = left
                }
                
            }
            
            tFreq[sChars[left]] = leftFreq + 1
            left += 1
        }
    }
    
    return shortestLen == Int.max ? "" : String(sChars[start..<start + shortestLen])
}

func characterReplacement(_ s: String, _ k: Int) -> Int {
    var count: [Character: Int] = [:]
    let s = Array(s)
    let n = s.count
    var start = 0, end = 0, res = 0, maxCount = 0
    
    while end < n {
        count[s[end]] = (count[s[end]] ?? 0) + 1
        maxCount = max(maxCount, count[s[end]]!)
        while end - start + 1 - maxCount > k {
            count[s[start]] = count[s[start]]! - 1
            start += 1
        }
        res = max(res, end - start + 1)
        end += 1
    }
    return res
}
```
