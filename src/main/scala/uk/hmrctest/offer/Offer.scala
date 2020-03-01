package uk.hmrctest.offer

import uk.hmrctest.item.ItemType.ItemType

case class Offer(var name: String, var description: String, var itemType: ItemType,
            var function: String) {

  def this() = this(null, null, null, null)

  def apply(name: String, description: String, itemType: ItemType, function: String): Offer =
                                                             Offer(name, description, itemType, function)

}
