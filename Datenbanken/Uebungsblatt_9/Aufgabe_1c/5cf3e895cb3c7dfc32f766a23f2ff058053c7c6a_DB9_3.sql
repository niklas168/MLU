--Hilfstabelle ,it Durchschnittsgehältern der Abteilungen
WITH avg_sal_per_dept AS (SELECT d.dname, e.deptno, AVG(e.sal) as avg_sal
FROM emp e, dept d 
WHERE e.deptno=d.deptno 
GROUP BY e.deptno, d.dname) 

SELECT asd1.avg_sal, asd1.dname, asd1.deptno
FROM avg_sal_per_dept asd1 
WHERE NOT EXISTS (SELECT * FROM avg_sal_per_dept asd2 
WHERE asd2.avg_sal > asd1.avg_sal)

