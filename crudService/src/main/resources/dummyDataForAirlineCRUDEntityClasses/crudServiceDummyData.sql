INSERT INTO airline_System.airline VALUES (1,'AB','ABAirline'),
											(2,'BC','BCAirline'),
                                            (3,'CD','CDAirline'),
                                            (4,'DE','DEAirline'),
                                            (5,'EF','EFAirline');
                                            
INSERT INTO airline_System.history VALUES 	('historyAB',1),
											('historyBC',2),
                                            ('historyCD',3),
                                            ('historyDE',4),
                                            ('historyEF',5);
                                            
INSERT INTO airline_System.airport VALUES 	(1,'city1','state1', 'street1','zip1', 'ABC', 'ABCAirport'),
											(2,'city2','state2', 'street2','zip2', 'BCD', 'BCDAirport'),
                                            (3,'city3','state3', 'street3','zip3', 'CDE', 'CDEAirport'),
                                            (4,'city4','state4', 'street4','zip4', 'DEF', 'DEFAirport'),
                                            (5,'city5','state5', 'street5','zip5', 'EFG', 'EFGAirport');
                                            
INSERT INTO airline_System.flight VALUES (1,'2020-06-16','04:34:33', 150,
											'2020-06-15','08:38:30', '1000',1,2,1),
                                            (2,'2020-06-16','06:34:33', 160,
											'2020-06-15','10:38:30', '1001',2,2,1),
                                            (3,'2020-06-16','05:34:33', 180,
											'2020-06-15','10:38:30', '1002',4,2,1),
                                            (4,'2020-06-16','09:34:33', 180,
											'2020-06-15','13:48:30', '1003',3,2,1),
                                            (5,'2020-06-16','06:34:33', 160,
											'2020-06-15','10:38:30', '1004',5,4,2),
                                            (6,'2020-06-16','05:34:33', 180,
											'2020-06-15','10:38:30', '1005',2,5,2),
                                            (7,'2020-06-16','09:34:33', 180,
											'2020-06-15','13:48:30', '1006',3,4,3);