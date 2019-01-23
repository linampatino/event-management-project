INSERT INTO VENUES(NAME, CITY, STATE) VALUES('Wrigley Field', 'Chicago', 'IL');

	
INSERT INTO events(NAME, DATE, VENUES_ID) 
 SELECT 'Phase 1 - Chicago White Sox vs. Chicago Cubs', CURRENT_TIMESTAMP(), V.VENUE_ID 
   FROM VENUES V
  WHERE UPPER(V.NAME) LIKE UPPER('%Wrigley Field%');

 INSERT INTO events(NAME, DATE, VENUES_ID) 
 SELECT 'Phase 2 - Chicago White Sox vs. Chicago Cubs', CURRENT_TIMESTAMP(), V.VENUE_ID 
   FROM VENUES V
  WHERE UPPER(V.NAME) LIKE UPPER('%Wrigley Field%');
  
  INSERT INTO events(NAME, DATE, VENUES_ID) 
 SELECT 'Phase 3 - Chicago White Sox vs. Chicago Cubs', CURRENT_TIMESTAMP(), V.VENUE_ID 
   FROM VENUES V
  WHERE UPPER(V.NAME) LIKE UPPER('%Wrigley Field%');