package martakonik.flashcards.mainScreen

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import martakonik.flashcards.BR
import martakonik.flashcards.Database
import martakonik.flashcards.boxList.BoxListAdapter


class MainViewModel(
        private val addBoxDialog: AddBoxDialog,
        @get: Bindable
        val adapter: BoxListAdapter,
        database: Database
) : BaseObservable() {

    fun onAddClick(view: View) {
        addBoxDialog.show()
    }

    private val compositeDisposable = CompositeDisposable()

    init {
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

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clear() {
        compositeDisposable.clear()
    }
}