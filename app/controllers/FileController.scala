package controllers

import java.io.File

import javax.inject.Singleton
import org.apache.poi.ss.usermodel.{Sheet, Workbook, WorkbookFactory}

@Singleton
class FileController {
  val filename = new File(  "C:/Users/valdo/Downloads/Compressed/survey/src/main/resources/surveyfile.xlsx")
  val workbook: Workbook = WorkbookFactory.create(filename)
  val sheet: Sheet = workbook.getSheetAt(0)

  def returnSheet(): Sheet = sheet
}
