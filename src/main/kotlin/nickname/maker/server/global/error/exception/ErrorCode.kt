package nickname.maker.server.global.error.exception

enum class ErrorCode(
        val status: Int,
        val message: String,
) {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(404, "잘못된 요청입니다."),

    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),

    USER_ALREADY_EXISTS(422, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(404, "사용자가 없습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 틀렸습니다."),

    PRODUCT_NOT_FOUND(404, "상품이 없습니다."),

    CART_NOT_FOUND(404, "해당 상품이 장바구니에 담겨있지 않습니다."),
}