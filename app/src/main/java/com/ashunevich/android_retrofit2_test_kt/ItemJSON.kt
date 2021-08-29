package com.ashunevich.android_retrofit2_test_kt

import com.squareup.moshi.Json

data class ItemJSON(@field:Json(name = "title") var title: String?,
                     @field:Json(name ="id") var id: Int?)