
```swift
func singleNumber(_ nums: [Int]) -> Int {
    var res = 0
    for num in nums {
        res ^= num
    }
    return res
}

func singleNumber2(_ nums: [Int]) -> Int {
    var dict: [Int: Int] = [:]
    for num in nums {
        if dict[num] == nil {
            dict[num] = 1
        } else {
            dict[num]? -= 1
        }
    }
    return dict.keys.filter{ dict[$0] == 1 }.first!
}

func hammingDistance(_ x: Int, _ y: Int) -> Int {
    var cnt = 0
    var num = x^y
    
    while num > 0 {
        cnt += 1
        num = num & (num-1)
    }
    return cnt
}

func getSum(_ a: Int, _ b: Int) -> Int {
    let and = (a&b) << 1
    let xor = a^b
    return and == 0 ? xor : xor == 0 ? and : getSum(and, xor)
}

func validUtf8(_ data: [Int]) -> Bool {
    var cnt = 0
    for bit in data {
        if cnt == 0 {
            if (bit>>5) == 0b110 { cnt = 1 }
            else if (bit>>4) == 0b1110 { cnt = 2 }
            else if (bit>>3) == 0b11110 { cnt = 3 }
            else if (bit>>7) == 1 { return false }
            else if (bit>>7) == 0b1 { return false }
        } else {
            if (bit>>6) != 0b10 { return false }
            cnt-=1
        }
    }
    return cnt == 0
}


func hammingWeight(_ n: Int) -> Int {
    var cnt = 0
    var num = n^0
    
    while num > 0 {
        cnt += 1
        num = num & (num-1)
    }
    return cnt
}

```
