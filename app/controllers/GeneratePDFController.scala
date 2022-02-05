package controllers

import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.apache.pdfbox.pdmodel.{PDDocument, PDPage, PDPageContentStream}
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject

class GeneratePDFController(val document: PDDocument) {
  val frequency = new FrequencyController
  val frequencyList = frequency.listOfFreqValues()
  val mode = new ModeController(frequencyList).mode
  val mean = new MeanController().mean(frequencyList)
  val median = new MedianController().median(frequencyList)
  val range = new RangeController().range(frequencyList)
  val variance = new VarianceController().variance(mean, frequencyList)
  val standardDeviation = new StandardDeviationController().standardDeviation(variance)


  def createPDF(): PDDocument ={
    println("PDF created")
    document
  }

  def addPage(): PDDocument={
    val blankPage = new PDPage()
    document.addPage(blankPage)
    document
  }

  def writeOnPage(): Unit={
    val pdImage = PDImageXObject.createFromFile("C:/Users/valdo/Downloads/Compressed/survey/src/main/resources/age_graph.png", document)
    val page = document.getPage(0)
    val contentStream = new PDPageContentStream(document, page)
    contentStream.drawImage(pdImage, 30, 250)
    contentStream.beginText

    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12)
    contentStream.newLineAtOffset(25, 750)
    contentStream.setLeading(14.5f)
    contentStream.showText("Frequency List: " + frequency.listOfFreqValues())
    contentStream.newLine
    contentStream.showText("Mode: " + mode)
    contentStream.newLine
    contentStream.showText("Mean: " + mean)
    contentStream.newLine
    contentStream.showText("Max: " + frequencyList.max)
    contentStream.newLine
    contentStream.showText("Min: " + frequencyList.min)
    contentStream.newLine
    contentStream.showText("Median: " + median)
    contentStream.newLine
    contentStream.showText("Range: " + range)
    contentStream.newLine
    contentStream.showText("Variance: " + variance)
    contentStream.newLine
    contentStream.showText("Standard Deviation: " + standardDeviation)

    contentStream.endText()
    println("Content added")
    contentStream.close()
    document.save("C:/Users/valdo/Desktop/my_doc.pdf")
    document.close()
  }
}

