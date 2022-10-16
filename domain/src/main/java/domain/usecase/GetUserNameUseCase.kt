package domain.usecase

import domain.models.UserName
import domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName {
        return userRepository.getName()
    }
}