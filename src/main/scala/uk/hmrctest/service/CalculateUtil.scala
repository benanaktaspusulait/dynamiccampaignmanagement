package uk.hmrctest.service

import uk.hmrctest.item.ItemType
import uk.hmrctest.item.ItemType.ItemType
import uk.hmrctest.item.Items._

object CalculateUtil {

  case class Basket(appleCount: Long = 0, orangeCount: Long = 0,
                    applePrice: BigDecimal = null, orangePrice: BigDecimal = null)


  def getNumberOfItem(items: Array[Item], itemType: ItemType): Long = items.filter(_.itemType.eq(itemType)).size

  def generateBasket(items: Array[Item]): Basket =
    Basket(getNumberOfItem(items, ItemType.APPLE), getNumberOfItem(items, ItemType.ORANGE), Apple().price, Orange().price)

  def getItemPrice(itemType: ItemType): BigDecimal = {
    itemType match {
      case ItemType.APPLE => Apple().price
      case ItemType.ORANGE => Orange().price
      case _ => 0
    }
  }

  def convertToItem(name: String): Item = {
    name.toUpperCase match {
      case null => throw new NullPointerException
      case "ORANGE" => new Orange
      case "APPLE" => new Apple
    }
  }
}
