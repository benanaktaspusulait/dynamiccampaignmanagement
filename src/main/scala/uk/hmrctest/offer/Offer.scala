package uk.hmrctest.offer

import uk.hmrctest.item.ItemType.ItemType

class Offer(var name: String, var description: String, var itemType: ItemType,
            var function: String) {

  def this() = this(null, null, null, null)
}
