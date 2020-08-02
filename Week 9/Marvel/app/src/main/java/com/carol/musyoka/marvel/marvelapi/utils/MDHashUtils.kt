package com.carol.musyoka.marvel.marvelapi.utils

import java.io.UnsupportedEncodingException
import java.lang.Exception
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun String.convertToMD5(): String {
    try {
        val md = MessageDigest.getInstance("MD5")
        val array = md.digest(this.toByteArray())
        val sb = StringBuffer()
        for (i in array.indices) {
            sb.append(Integer.toHexString(array[i].toInt() and 0xFF or 0x100).substring(1, 3))
        }
        return sb.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    } catch (ex: UnsupportedEncodingException) {
        ex.printStackTrace()
    }
    throw Exception("Could not convert String to MD5 Hash")
}