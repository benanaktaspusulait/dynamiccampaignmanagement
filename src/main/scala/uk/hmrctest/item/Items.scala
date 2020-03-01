package uk.hmrctest.item

import uk.hmrctest.item.ItemType._

object Items {

  abstract class Item(val price: BigDecimal = 0, val itemType: ItemType)

  case class Apple(override val price: BigDecimal = 0.60, override val itemType: ItemType = APPLE) extends Item(price, itemType)

  case class Orange(override val price: BigDecimal = 0.25, override val itemType: ItemType = ORANGE) extends Item(price, itemType)

}