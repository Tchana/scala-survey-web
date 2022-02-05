package controllers

class MedianController {
  def median(list: List[Int]) : Float = {
    val medianValue: Int = list.sorted apply(list.size/2)
    println("Median: " + medianValue)
    medianValue
  }
}
