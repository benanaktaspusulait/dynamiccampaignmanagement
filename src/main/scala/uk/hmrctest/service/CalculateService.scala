package uk.hmrctest.service

import javax.script.{Compilable, Invocable, ScriptEngine, ScriptEngineManager}
import uk.hmrctest.dataseeder.OfferSeeder
import uk.hmrctest.item.ItemType
import uk.hmrctest.item.Items.Item
import uk.hmrctest.offer.Offer
import uk.hmrctest.service.CalculateUtil.Basket

import scala.math.BigDecimal.RoundingMode

/**
 * calculation service
 * @author Benan Aktas <benan.aktas@pusulait.com>
 */
object CalculateService {

  val SCRIPT_ENGINE_NAME = "nashorn"

  /**
   *
   * @param basket
   * @param itemList
   */
  def calculate(basket: Basket, itemList: Array[Item]): Unit = {

    var totalAmount = BigDecimal(0)
    var totalDiscountAmount = BigDecimal(0)

    val offerList = OfferSeeder.createOffers

    for (itemType <- ItemType.values) {

      val numberOfItem = CalculateUtil.getNumberOfItem(itemList, itemType)
      val offer: Offer = offerList.filter(_.itemType.eq(itemType)).last

      var discountAmount = BigDecimal(0)
      if (offer != null && numberOfItem > 0) {
        val engine = new ScriptEngineManager()
          .getEngineByName(SCRIPT_ENGINE_NAME)
          .asInstanceOf[ScriptEngine with Invocable with Compilable]

        engine.compile(offer.function).eval()
        val result = engine.invokeFunction(offer.name, basket)

        discountAmount = BigDecimal(result.toString).setScale(2, RoundingMode.CEILING)
        if (discountAmount > 0) totalDiscountAmount = totalDiscountAmount + discountAmount
      }
      totalAmount = totalAmount + (CalculateUtil.getItemPrice(itemType) * numberOfItem)
    }
    totalAmount = totalAmount - totalDiscountAmount

    println(s"Total cost = $totalAmount and Total Discount = $totalDiscountAmount")
  }
}
