CREATE TABLE IF NOT EXISTS product (
    id             BIGSERIAL,                     -- 상품 번호
    productName    VARCHAR(255),                  -- 상품명
    productPrice   VARCHAR(255),                  -- 상품 가격
    productContent TEXT,                          -- 상품 정보

    status         VARCHAR(255),                  -- 상품 현황 (재료 소진, 판매 중, 배송 중)
    created_at     TIMESTAMP       DEFAULT NOW(), -- 상품 입고일
    updated_at     TIMESTAMP,                     -- 상품 등록일

    CONSTRAINT pk_product PRIMARY KEY (id)        -- id를 기본키로 지정
);

-- 테이블 코멘트
COMMENT ON TABLE product IS '상품 판매';


-- 컬럼 코멘트
COMMENT ON COLUMN product.productName       IS '상품명';
COMMENT ON COLUMN product.productPrice      IS '상품 가격';
COMMENT ON COLUMN product.productContent    IS '상품 정보';
COMMENT ON COLUMN product.status            IS '상품 현황';
COMMENT ON COLUMN product.created_at        IS '상품 입고일';
COMMENT ON COLUMN product.updated_at        IS '상품 등록일';