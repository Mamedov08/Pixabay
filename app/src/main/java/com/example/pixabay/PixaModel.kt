package com.example.pixabay

import java.net.URL

data class PixaModel (
    var hits : List<ImageModel>?
        )

data class ImageModel(
    var largeImageURL: String?

)
