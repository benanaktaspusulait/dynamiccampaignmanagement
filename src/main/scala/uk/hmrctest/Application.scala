package uk.hmrctest

import java.util.Scanner

import uk.hmrctest.service.{CalculateService, CalculateUtil}

object Application extends App {

  val scanner = new Scanner(System.in)
  val orderText = scanner.nextLine

  val itemTextList = orderText.split(" ")
  val items = itemTextList.map(CalculateUtil.convertToItem(_))
  val basket = CalculateUtil.generateBasket(items)

  CalculateService.calculate(basket, items)

}
