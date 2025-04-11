CREATE TABLE brand
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    name       varchar(128) NOT NULL,
    created_at datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_brand_name UNIQUE (name)
);

CREATE TABLE category
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    name       varchar(128) NOT NULL,
    created_at datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_category_name UNIQUE (name)
);

CREATE TABLE product
(
    id          bigint PRIMARY KEY AUTO_INCREMENT,
    brand_id    bigint   NOT NULL,
    category_id bigint   NOT NULL,
    name        varchar(128),
    code        varchar(128),
    price       int      NOT NULL,
    created_at  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id),
    -- 브랜드의 카테고리에는 1개의 상품
    CONSTRAINT uq_brand_category UNIQUE (brand_id, category_id)
);

CREATE INDEX idx_product_brand_id ON product (brand_id);
CREATE INDEX idx_product_category_id ON product (category_id);

CREATE TABLE product_variant
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    product_id bigint   NOT NULL,
    color      varchar(32),
    size       varchar(32),
    created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE INDEX idx_variant_product_id ON product_variant (product_id);
