func binarySearch68(_ list:[Int], _ target:Int) -> [Int] {
    
    for i in 0..<list.count {
        var (left, right) = (0, list.count-1)
        while left<=right, right<list.count {
            let mid = left + (right-left)/2
            if list[i] + list[mid] > target {
                right = mid-1
            } else if list[i] + list[mid] < target {
                left = mid+1
            } else {
                return [i+1, mid+1]
            }
        }
    }
    return []
}
