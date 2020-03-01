package uk.hmrctest.dataseeder

import uk.hmrctest.item.ItemType
import uk.hmrctest.offer.Offer

object OfferSeeder {

  def createOffers: List[Offer] = {

    val appleOffer = new Offer
    appleOffer.name = "appleOffer"
    appleOffer.description = "buy one, get one free on Apples: "
    appleOffer.function = "function appleOffer(x) {return (Math.floor(x.appleCount() / 2)  * x.applePrice() )}"
    appleOffer.itemType = ItemType.APPLE

    val orangeOffer = new Offer
    orangeOffer.name = "orangeOffer"
    orangeOffer.description = "3 for the price of 2 on Oranges: "
    orangeOffer.function = "function orangeOffer(x) {return (Math.floor(x.orangeCount() / 3)  * x.orangePrice() )}"
    orangeOffer.itemType = ItemType.ORANGE

    List(appleOffer,orangeOffer)
  }
}
