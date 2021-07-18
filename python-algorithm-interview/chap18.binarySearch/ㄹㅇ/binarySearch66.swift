func binarySearch66(_ list:[Int], _ target:Int) -> Int {
    
    var (left, right) = (0, list.count-1)
    while left < right {
        let mid = left + (right-left)/2
        if list[mid] > list[right] {
            left = mid+1
        } else {
            right = mid
        }
    }
    let pivot = left
    
    
    (left, right) = (0, list.count-1)
    while left <= right {
        let mid = left + (right-left)/2
        let midPivot = (mid+pivot) % list.count
        
        if list[midPivot] < target {
            left = mid+1
        } else if list[midPivot] > target {
            right = mid-1
        } else {
            return midPivot
        }
    }
    return -1
}
