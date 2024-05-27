package com.example.mpproject.data


data class Comment(
    val commentId: String = "",
    val userId: String = "",
    val text: String = "",
    val createdDate: String = ""
) {
    constructor() : this("", "", "", "")
}