package pl.senordeveloper.template2024

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import pl.senordeveloper.template2024.moshi.Cards

class MainViewModel : ViewModel() {
    private val _uiState: MutableState<UiState> = mutableStateOf(UiState.Loading)
    val uiState: State<UiState> = _uiState

    private val moshi by lazy {
        Moshi.Builder()
//            .add(CardAdapter)
//            .add(ListOfCardsAdapter)
//            .add(ListOfCardsAdapterFactory)
//            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private val cardAdapter: JsonAdapter<List<Cards>> by lazy {
        val type = Types.newParameterizedType(
            List::class.java,
            Types.subtypeOf(Cards::class.java)
        )

        /*val type = Types.newParameterizedType(
            List::class.java,
            Cards::class.java
        )*/
        moshi.adapter<List<Cards>?>(type).also {
            println("adapter - ${it::class.java}")
        }
    }

    public fun randomCard() {
        val toMutableList = Cards.entries.toMutableList()
        toMutableList.shuffle()

        _uiState.value = UiState.Loaded(
            cardAdapter.toJson(
                toMutableList
            )
        )
    }

    interface UiState {
        data object Loading : UiState
        data class Loaded(val json: String) : UiState
    }
}
