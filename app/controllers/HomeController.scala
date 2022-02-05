package controllers

import javax.inject._
import org.apache.pdfbox.pdmodel.PDDocument
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val frequencyController = new FrequencyController
  val frequencyList = frequencyController.listOfFreqValues()
  val ageMode = new ModeController(frequencyList)
  val mean = new MeanController()
  val median = new MedianController()
  val range = new RangeController()
  val variance = new VarianceController()
  val standardDeviation = new StandardDeviationController()
  val document = new PDDocument
  val generatePDF = new GeneratePDFController(document)

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */


  val freqList = frequencyList.toString
  val meanVal = mean.mean(frequencyList).toString
  val medianVal = median.median(frequencyList).toString
  val modeVal = ageMode.mode.toString
  val rangeVal = range.range(frequencyList).toString
  val stdDev = standardDeviation.standardDeviation(variance.variance(mean.mean(frequencyList), frequencyList)).toString
  val varianceValue = variance.variance(mean.mean(frequencyList), frequencyList).toString

  def index(): Action[AnyContent] = Action {implicit request: Request[AnyContent] =>
    Ok(views.html.index(freqList, meanVal, medianVal, modeVal, rangeVal, stdDev, varianceValue))
  }
  def genPDF(): Action[AnyContent] = Action {implicit request: Request[AnyContent] =>
      generatePDF.createPDF()
      generatePDF.addPage()
      generatePDF.writeOnPage()
    Ok(views.html.firstexample())
  }

}
