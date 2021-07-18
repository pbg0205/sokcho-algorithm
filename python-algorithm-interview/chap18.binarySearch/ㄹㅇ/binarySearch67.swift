func binarySearch67(_ arr1:[Int], _ arr2:[Int]) -> [Int] {
    let arr1 = arr1.sorted()
    
    var res:[Int] = []
    for num in arr2 {
        
        var (left, right) = (0, arr1.count-1)
        while left <= right, right < arr1.count {
            let mid = left + (right-left)/2
            if arr1[mid] > num {
                right = mid-1
            } else if arr1[mid] < num {
                left = mid+1
            } else {
                res.append(num)
                break
            }
        }
        
    }
    
    return Array(Set(res))
}
