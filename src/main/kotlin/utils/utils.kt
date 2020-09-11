package utils

import java.io.Serializable

data class Response(val step: Step? ,val message: String) : Serializable

data class Request(val message: String)

enum class Step {
    ZERO, ONE, TWO, THREE, FOUR, FINAL
}

