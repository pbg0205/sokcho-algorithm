func binarySearch69(_ list:[[Int]], _ target:Int) -> Bool {
    var (row, col) = (0, list.first!.count-1)
    
    while row < list.count, col >= 0 {
        if list[row][col] > target {
            col-=1
        } else if list[row][col] < target {
            row+=1
        } else {
            return true
        }
    }
    return false
}
