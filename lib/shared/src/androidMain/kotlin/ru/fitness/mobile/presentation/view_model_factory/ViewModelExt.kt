package ru.fitness.mobile.presentation.view_model_factory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.adeo.kviewmodel.KViewModel

@Composable
inline fun <reified T: KViewModel> ViewModel(
    key: String,
    crossinline factory: @DisallowComposableCalls () -> T,
    content: @Composable (T) -> Unit
) {
    val localOwnerViewModel = LocalOwnerViewModel.current
    val viewModel = remember {
        localOwnerViewModel.getViewModel<T>(key) ?: localOwnerViewModel.setViewModel(key, factory())
    }

    content(viewModel)

}

@Stable
class OwnerViewModel {
    val hashViewModelSet: MutableMap<String, KViewModel> = mutableMapOf()

    inline fun <reified T> getViewModel(hashKey: String): T? =
        hashViewModelSet[hashKey] as? T

    inline fun <reified T> setViewModel(hashKey: String, viewModel: KViewModel): T {
        hashViewModelSet[hashKey] = viewModel
        return hashViewModelSet.getValue(hashKey) as T
    }

}


val LocalOwnerViewModel: ProvidableCompositionLocal<OwnerViewModel> =
    compositionLocalOf { error("No LocalOwnerViewModel provided!") }