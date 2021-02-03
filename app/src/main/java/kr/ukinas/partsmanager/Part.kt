package kr.ukinas.partsmanager

data class Part(
        var id: Int,
        var name: String,
        var storage1_code: String?,
        var storage1_box: Int?,
        var storage1_slot: Int?,
        var storage2_code: String?,
        var storage2_box: Int?,
        var storage2_slot: Int?,
        var type: String?,
        var category: String?,
        var description: String?,
        var datasheet: String?
        )