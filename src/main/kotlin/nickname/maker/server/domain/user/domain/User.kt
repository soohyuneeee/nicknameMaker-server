package nickname.maker.server.domain.user.domain

import jakarta.persistence.*
import nickname.maker.server.domain.like.domain.Like
import nickname.maker.server.global.entity.BaseTimeEntity

@Entity
@Table(name = "tbl_user")
class User(
    @Column(length = 50, nullable = false, unique = true)
    var userId: String,

    @Column(length = 60, nullable = false)
    var password: String,

    @Column(length = 20, nullable = false)
    var nickname: String,

    @OneToMany(mappedBy = "user")
    var likes: MutableList<Like> = mutableListOf(),

    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) : BaseTimeEntity() {

}