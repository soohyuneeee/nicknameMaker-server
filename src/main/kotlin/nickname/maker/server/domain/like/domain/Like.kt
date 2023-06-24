package nickname.maker.server.domain.like.domain

import jakarta.persistence.*
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.global.entity.BaseTimeEntity

@Entity
@Table(name = "tbl_like")
class Like(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    var user: User? = null,
    @Column
    var sentence: String,
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) : BaseTimeEntity() {

}
