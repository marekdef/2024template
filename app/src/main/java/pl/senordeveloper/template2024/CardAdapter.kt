package pl.senordeveloper.template2024

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import pl.senordeveloper.template2024.moshi.Cards

object CardAdapter : JsonAdapter<Cards>() {
    override fun fromJson(jsonReader: JsonReader): Cards? {
        TODO("Not yet implemented")
    }

    @ToJson
    override fun toJson(jsonWriter: JsonWriter, card: Cards?) {
        jsonWriter.value(card?.name?.toLowerCase())
    }
}