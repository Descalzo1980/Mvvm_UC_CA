package domain.repository

import domain.models.SaveUserNameParam
import domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName() : UserName
}