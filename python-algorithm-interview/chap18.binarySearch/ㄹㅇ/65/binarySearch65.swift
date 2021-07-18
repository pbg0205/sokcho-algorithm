func binarySearch65(_ list:[Int], _ target:Int) -> Int {
    
    var (left, right) = (0, list.count-1)
    
    while left <= right, right < list.count {
        let mid = (left+right)/2
        if list[mid] > target { right = mid-1 }
        else if list[mid] < target { left = mid+1 }
        else { return mid }
    }
    
    return -1
}
