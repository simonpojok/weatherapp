package me.simonpojok.presentation.base

import me.simonpojok.presentation.base.exception.Error

open class DialogCommand {
    open var show: Boolean = false
    var error: Error = Error.None
}
