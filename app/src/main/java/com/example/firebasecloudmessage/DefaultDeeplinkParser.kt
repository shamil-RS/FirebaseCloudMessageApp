package com.example.firebasecloudmessage

import javax.inject.Inject

interface DeeplinkParser {
    fun parse(deeplink: String?): ParsedDeeplink
}

data class ParsedDeeplink(
    val destination: String,
    val parameters: Map<String, String>
)

class DefaultDeeplinkParser @Inject constructor() : DeeplinkParser {
    override fun parse(deeplink: String?): ParsedDeeplink {
        val destination = deeplink?.substringBefore("?") ?: ""
        val params = deeplink?.substringAfter("?")?.split("&")
            ?.associate {
                val (key, value) = it.split("=")
                key to value
            } ?: emptyMap()

        return ParsedDeeplink(destination, params)
    }
}
