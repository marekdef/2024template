package pl.senordeveloper.template2024

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import pl.senordeveloper.template2024.logging.Loggable
import pl.senordeveloper.template2024.logging.loggable
import pl.senordeveloper.template2024.moshi.Cards

object ListOfCardsAdapter: JsonAdapter<List<Cards>>(), Loggable by loggable<ListOfCardsAdapter>() {
    @ToJson
    override fun toJson(jsonWriter: JsonWriter, cards: List<Cards>?) {
        println("toJson($cards)")
        jsonWriter.value(cards?.joinToString { "${Cards::class.java.simpleName} ${it.name} ${it.ordinal}" })
    }

    override fun fromJson(p0: JsonReader): List<Cards>? {
        TODO("Not yet implemented")
    }
}
