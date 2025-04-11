INSERT INTO brand (name)
VALUES ('A'),
       ('B'),
       ('C'),
       ('D'),
       ('E'),
       ('F'),
       ('G'),
       ('H'),
       ('I');

INSERT INTO category (name)
VALUES ('상의'),
       ('아우터'),
       ('바지'),
       ('스니커즈'),
       ('가방'),
       ('모자'),
       ('양말'),
       ('액세서리');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='상의'), 'A-상의', 'A-TOP', 11200),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='아우터'), 'A-아우터', 'A-OUTER', 5500),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='바지'), 'A-바지', 'A-PANTS', 4200),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='스니커즈'), 'A-스니커즈', 'A-SNEAKERS', 9000),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='가방'), 'A-가방', 'A-BAG', 2000),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='모자'), 'A-모자', 'A-HAT', 1700),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='양말'), 'A-양말', 'A-SOCKS', 1800),
    ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='액세서리'), 'A-액세서리', 'A-ACCESSORY', 2300);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='상의'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='아우터'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='바지'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='스니커즈'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='가방'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='모자'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='양말'), '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id = b.id JOIN category c ON p.category_id = c.id WHERE b.name='A' AND c.name='액세서리'), '', 'One Size');


INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='상의'),       'B-상의','B-TOP',10500),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='아우터'),     'B-아우터','B-OUTER',5900),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='바지'),       'B-바지','B-PANTS',3800),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='스니커즈'),   'B-스니커즈','B-SNEAKERS',9100),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='가방'),       'B-가방','B-BAG',2100),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='모자'),       'B-모자','B-HAT',2000),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='양말'),       'B-양말','B-SOCKS',2000),
    ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='액세서리'),   'B-액세서리','B-ACCESSORY',2200);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='B' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='상의'),       'C-상의','C-TOP',10000),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='아우터'),     'C-아우터','C-OUTER',6200),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='바지'),       'C-바지','C-PANTS',3300),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='스니커즈'),   'C-스니커즈','C-SNEAKERS',9200),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='가방'),       'C-가방','C-BAG',2200),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='모자'),       'C-모자','C-HAT',1900),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='양말'),       'C-양말','C-SOCKS',2200),
    ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='액세서리'),   'C-액세서리','C-ACCESSORY',2100);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='C' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='상의'),       'D-상의','D-TOP',10100),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='아우터'),     'D-아우터','D-OUTER',5100),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='바지'),       'D-바지','D-PANTS',3000),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='스니커즈'),   'D-스니커즈','D-SNEAKERS',9500),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='가방'),       'D-가방','D-BAG',2500),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='모자'),       'D-모자','D-HAT',1500),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='양말'),       'D-양말','D-SOCKS',2400),
    ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='액세서리'),   'D-액세서리','D-ACCESSORY',2000);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='D' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='상의'),       'E-상의','E-TOP',10700),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='아우터'),     'E-아우터','E-OUTER',5000),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='바지'),       'E-바지','E-PANTS',3800),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='스니커즈'),   'E-스니커즈','E-SNEAKERS',9900),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='가방'),       'E-가방','E-BAG',2300),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='모자'),       'E-모자','E-HAT',1800),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='양말'),       'E-양말','E-SOCKS',2100),
    ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='액세서리'),   'E-액세서리','E-ACCESSORY',2100);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='E' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='상의'),       'F-상의','F-TOP',11200),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='아우터'),     'F-아우터','F-OUTER',7200),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='바지'),       'F-바지','F-PANTS',4000),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='스니커즈'),   'F-스니커즈','F-SNEAKERS',9300),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='가방'),       'F-가방','F-BAG',2100),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='모자'),       'F-모자','F-HAT',1600),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='양말'),       'F-양말','F-SOCKS',2300),
    ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='액세서리'),   'F-액세서리','F-ACCESSORY',1900);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='F' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='상의'),       'G-상의','G-TOP',10500),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='아우터'),     'G-아우터','G-OUTER',5800),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='바지'),       'G-바지','G-PANTS',3900),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='스니커즈'),   'G-스니커즈','G-SNEAKERS',9000),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='가방'),       'G-가방','G-BAG',2200),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='모자'),       'G-모자','G-HAT',1700),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='양말'),       'G-양말','G-SOCKS',2100),
    ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='액세서리'),   'G-액세서리','G-ACCESSORY',2000);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='G' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='상의'),       'H-상의','H-TOP',10800),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='아우터'),     'H-아우터','H-OUTER',6300),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='바지'),       'H-바지','H-PANTS',3100),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='스니커즈'),   'H-스니커즈','H-SNEAKERS',9700),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='가방'),       'H-가방','H-BAG',2100),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='모자'),       'H-모자','H-HAT',1600),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='양말'),       'H-양말','H-SOCKS',2000),
    ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='액세서리'),   'H-액세서리','H-ACCESSORY',2000);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='H' AND c.name='액세서리'),   '', 'One Size');

INSERT INTO product (brand_id, category_id, name, code, price)
VALUES
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='상의'),       'I-상의','I-TOP',11400),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='아우터'),     'I-아우터','I-OUTER',6700),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='바지'),       'I-바지','I-PANTS',3200),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='스니커즈'),   'I-스니커즈','I-SNEAKERS',9500),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='가방'),       'I-가방','I-BAG',2400),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='모자'),       'I-모자','I-HAT',1700),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='양말'),       'I-양말','I-SOCKS',1700),
    ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='액세서리'),   'I-액세서리','I-ACCESSORY',2400);

INSERT INTO product_variant (product_id, color, size)
VALUES
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='상의'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='아우터'),     '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='바지'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='스니커즈'),   '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='가방'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='모자'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='양말'),       '', 'One Size'),
    ((SELECT p.id FROM product p JOIN brand b ON p.brand_id=b.id JOIN category c ON p.category_id=c.id WHERE b.name='I' AND c.name='액세서리'),   '', 'One Size');
