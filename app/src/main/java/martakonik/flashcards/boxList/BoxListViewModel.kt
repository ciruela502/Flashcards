package martakonik.flashcards.boxList

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import martakonik.flashcards.BR
import martakonik.flashcards.Database
import martakonik.flashcards.utils.BottomMenuManager
import martakonik.flashcards.utils.Navigator

class BoxListViewModel(
        @get: Bindable
        val adapter: BoxListAdapter?,
        navigator: Navigator?,
        bottomMenu: BottomMenuManager,
        database: Database,
        manage: (Boolean) -> Unit
) : BaseObservable(), LifecycleObserver {
    private val chooseBox = { number: Int -> boxMenuViewModel.updateBox(number) }
    private val compositeDisposable = CompositeDisposable()

    init {
        adapter?.chooseBox = chooseBox
        database.getBoxList().subscribe {
            boxExist = it.size > 0
            notifyPropertyChanged(BR.boxExist)
        }?.addTo(compositeDisposable)
    }

    @Bindable
    var boxExist = false

    @get: Bindable("boxExist")
    var listVisible = false
        get() = boxExist

    @get: Bindable("boxExist")
    var messageVisible = true
        get() = !boxExist

    @get: Bindable
    val boxMenuViewModel = BoxMenuViewModel(navigator, bottomMenu, database, manage)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clear() {
        compositeDisposable.clear()
    }
}