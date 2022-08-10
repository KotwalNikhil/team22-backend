INSERT INTO dogs (id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (id, name, age) VALUES (2, 'Kaya', 5);

INSERT INTO USER (id, name, email, role) VALUES (1, 'Darsh', 'darshmehta@gmail.com', 'customer'),
                                        (2, 'Ragini', 'ragini@gmail.com', 'customer'),
                                        (3, 'Shriram', 'shriram@gmail.com', 'customer'),
                                        (4, 'Nikhil', 'nikhil@gmail.com', 'operation'),
                                        (5, 'Yashoda', 'yashoda@gmail.com', 'operation');

INSERT INTO BOOK (book_id, book_name) VALUES (1, 'Government Bonds'),
                                    (2, 'Corporate Bonds'),
                                    (3, 'Municipal Bonds');


INSERT INTO Security (security_id, ISIN, CUSIP, issuer, maturity_date, coupon, type, face_value, status) VALUES
                    (1, 53643, 987651, 'Apple', '2004-02-01', 2.5, 'corporate', 100, 'ACTIVE' ),
                    (2, 62378, 143219, 'Banana', '2007-08-21', 1.8, 'corporate', 50, 'ACTIVE' ),
                    (3, 62683, 654321, 'Maharashtra Government', '2002-01-01', 1.5, 'government', 10, 'ACTIVE' ),
                    (4, 62838, 432198, 'Samsung', '2005-03-31', 3, 'corporate', 100, 'ACTIVE' ),
                    (5, 12379, 432198, 'BMC', '2009-05-10', 1.4, 'municipal', 250, 'ACTIVE' );

INSERT INTO COUNTER_PARTY (counter_party_id, counter_party_name) VALUES (1, 'Kirti'),
                                   (2, 'Dhanshree'),
                                   (3, 'Chandana'),
                                   (4, 'Raunak'),
                                   (5, 'Rishikesh');


INSERT INTO TRADE (trade_id,actioned,  security_id, counter_party_id, BOOK_ID, quantity, status, price, buy_sell, trade_date, settlement_date) VALUES
                    (1,0,1,1,1,3, 'SETTLED', 270, 'sell', '2008-11-11', '2008-11-12'),
                    (2,0,2,2,2,3, 'SETTLED', 270, 'buy', '2008-11-11', '2008-11-12');

