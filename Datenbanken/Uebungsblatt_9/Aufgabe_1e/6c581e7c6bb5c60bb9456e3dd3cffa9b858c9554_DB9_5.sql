-- Hilfstabelle mit dem Topverdienergehalt der Abteilungen mit dname= OPERATIONS
WITH op_top_verdiener AS (
SELECT max(e.sal) AS topverdiener
FROM emp e, dept d
WHERE d.dname = 'OPERATIONS'
AND e.deptno=d.deptno),

--Topverdienergehälter aller Abteilungen 
topverdiener_per_abt AS (
SELECT d.deptno, d.dname, max(e.sal) AS topverdiener 
FROM dept d, emp e
WHERE e.deptno = d.deptno
GROUP BY d.dname, d.deptno) 

SELECT d.deptno, d.dname, h2.topverdiener
FROM dept d, emp e,  op_top_verdiener h1, topverdiener_per_abt h2
WHERE e.deptno = d.deptno
AND h2.deptno=d.deptno
AND h2.topverdiener < h1.topverdiener
GROUP BY d.dname, d.deptno, h2.topverdiener