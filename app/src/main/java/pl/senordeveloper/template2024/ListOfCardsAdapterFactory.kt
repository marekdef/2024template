package pl.senordeveloper.template2024

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import pl.senordeveloper.template2024.moshi.Cards
import java.lang.reflect.Type

object ListOfCardsAdapterFactory : JsonAdapter.Factory {
    private val type = Types.newParameterizedType(List::class.java, Cards::class.java)
    private val subtype = Types.newParameterizedType(List::class.java, Types.subtypeOf(Cards::class.java))
    override fun create(type: Type, annoutations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        if (type == this.type) {
            return ListOfCardsAdapter
        }
        if (type == this.subtype) {
            return ListOfCardsAdapter
        }
        return null
    }
}