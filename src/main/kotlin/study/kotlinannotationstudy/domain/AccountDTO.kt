package study.kotlinannotationstudy.domain

data class AccountDTO(
    val id: Long,
    val name: String,
    val role: Role
) {
    companion object {
        fun from(account: Account): AccountDTO {
            return AccountDTO(account.id!!, account.name, account.role)
        }
    }
}
