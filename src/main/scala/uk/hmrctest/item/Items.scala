package uk.hmrctest.item

import uk.hmrctest.item.ItemType._

/**
 * definition of base item and other items
 * @author Benan Aktas <benan.aktas@pusulait.com>
 */
object Items {

  /**
   *
   * @param price
   * @param itemType
   */
  abstract class Item(val price: BigDecimal = 0, val itemType: ItemType)

  /**
   *
   * @param price
   * @param itemType
   */
  case class Apple(override val price: BigDecimal = 0.60, override val itemType: ItemType = APPLE) extends Item(price, itemType)

  /**
   *
   * @param price
   * @param itemType
   */
  case class Orange(override val price: BigDecimal = 0.25, override val itemType: ItemType = ORANGE) extends Item(price, itemType)

}