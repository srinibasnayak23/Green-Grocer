package com.example.gronic.domain.model


data class LoginResponse(
    val status: Int,
    val message: String,
    val data: UserData? = null,
    val img_path: String? = null,
    val type: String? = null
)

data class UserData(
    val BadgeNumber: String?,
    val FirstName: String?,
    val LastName: String?,
    val EmployeeId: String?,
    val Company: String?,
    val PositionType: String?,
    val Discipline: String?,
    val Site: String?,
    val EmailId: String?,
    val EmployeeStatus: String?
)
