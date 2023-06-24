package nickname.maker.server.domain.keyword.domain

import jakarta.persistence.*
import nickname.maker.server.domain.user.domain.User

@Entity
@Table(name = "tbl_keyword")
class KeyWord(
    @Column(length = 80, nullable = false)
    var word: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    var author: User? = null,
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
