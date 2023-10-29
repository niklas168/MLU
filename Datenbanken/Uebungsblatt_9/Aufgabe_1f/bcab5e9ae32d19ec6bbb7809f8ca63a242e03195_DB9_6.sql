With Hilfstabelle as (SELECT DEPTNO, AVG(SAL) AS avg_sal, STDDEV(SAL) AS stddev_sal
FROM emp e      
GROUP BY DEPTNO),

Hilfstabelle2 as (SELECT h.DEPTNO,  (1 - (SUM(POWER(SAL - h.avg_sal, 2)) /
             (COUNT(*) * POWER(h.stddev_sal, 2)))) AS gini_sal
FROM emp e, Hilfstabelle h 
WHERE e.deptno = h.deptno
GROUP BY h.DEPTNO,stddev_sal)

SELECT d.DEPTNO, d.DNAME, h2.GINI_SAL
FROM dept d, Hilfstabelle2 h2
WHERE d.deptno = h2.deptno
ORDER BY GINI_SAL DESC, DEPTNO ASC