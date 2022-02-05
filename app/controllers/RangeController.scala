package controllers

class RangeController {
  def range(list: List[Int]):Int={
    val rangeValue = list.max - list.min
    println("Range: " + rangeValue)
    rangeValue
  }
}
