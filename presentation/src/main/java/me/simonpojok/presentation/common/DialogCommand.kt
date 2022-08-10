package me.simonpojok.presentation.common

import me.simonpojok.presentation.common.exception.Error

open class DialogCommand {
    open var show: Boolean = false
    var error: Error = Error.None
}
