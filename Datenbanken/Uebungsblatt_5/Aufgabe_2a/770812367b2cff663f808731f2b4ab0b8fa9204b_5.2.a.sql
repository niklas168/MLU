-- Teilaufgabe 2.a)

SELECT DISTINCT A1.candidate, A2.candidate, A1.winner_loser_indic, A2.winner_loser_indic
FROM election A1, election A2
WHERE A1.candidate = A2.candidate
AND A1.election_year < A2.election_year
AND A1.winner_loser_indic = 'L' AND A2.winner_loser_indic = 'W'

-- Begründung DISTINCT: Es könnten KAndidaten herausgegeben werde, welche eine Wahl erst verloren und dann zweimal gewannen.
