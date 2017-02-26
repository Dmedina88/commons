package com.grayherring.common.ui.base

import com.grayherring.common.util.ErrorHandler

abstract class BaseVM(errorHandler: ErrorHandler) : ErrorHandler by errorHandler, LifeCycleBindable