package com.example.lessonapp3

import io.reactivex.rxjava3.disposables.Disposable

class MainPresenter(private val _view: MainActivity, private val _userService: UserService) :
    MainObject.Presenter {

    lateinit var _user: User
    lateinit var disposable: Disposable

    override fun signOut() {
        _view.navigationToEnterActivity()
    }

    override fun userInitialization(id: Int): User {
        disposable=_userService.getUser(id).subscribe(
            { user -> _user=user
            _view.welcomText(true)},
            {_view.welcomText(false)}
        )
        disposable.dispose()
        return _user
    }
}