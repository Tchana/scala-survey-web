package controllers

import controllers.{FileController, FrequencyController, GeneratePDFController, MeanController, MedianController, ModeController, RangeController, StandardDeviationController, VarianceController}
import org.apache.pdfbox.pdmodel.PDDocument

object MainController {
  println("Hello, World!")

  val document = new PDDocument
  val generatePDF = new GeneratePDFController(document)
  val createPDF = generatePDF.createPDF()
  val page = generatePDF.addPage()
  val writeOnPage: Unit = generatePDF.writeOnPage()
  val frequency = new FrequencyController()
  val frequencyList = frequency.listOfFreqValues()
  val ageMode = new ModeController(frequencyList).mode
  val mean = new MeanController().mean(frequencyList)
  val median = new MedianController().median(frequencyList)
  val range = new RangeController().range(frequencyList)
  val variance = new VarianceController().variance(mean, frequencyList)
  val standardDeviation = new StandardDeviationController().standardDeviation(variance)
}