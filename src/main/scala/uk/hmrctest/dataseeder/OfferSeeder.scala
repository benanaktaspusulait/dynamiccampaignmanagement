package uk.hmrctest.dataseeder

import uk.hmrctest.item.ItemType._
import uk.hmrctest.offer.Offer

object OfferSeeder {

  def createOffers: List[Offer] = {

    var name = "appleOffer"
    var description = "buy one, get one free on Apples: "
    var function = "function appleOffer(x) {return (Math.floor(x.appleCount() / 2)  * x.applePrice() )}"
    var itemType = APPLE
    val appleOffer = Offer.apply(name, description, itemType,function)

    name = "orangeOffer"
    description = "3 for the price of 2 on Oranges: "
    function = "function orangeOffer(x) {return (Math.floor(x.orangeCount() / 3)  * x.orangePrice() )}"
    itemType = ORANGE
    val orangeOffer = Offer.apply(name, description, itemType,function)

    List(appleOffer,orangeOffer)
  }
}
