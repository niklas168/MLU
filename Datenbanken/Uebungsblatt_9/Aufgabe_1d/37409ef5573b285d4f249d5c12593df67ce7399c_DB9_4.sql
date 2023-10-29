--Hilfstabelle ,it Durchschnittsgehältern der Abteilungen
WITH avg_sal_per_dept AS (SELECT d.dname, e.deptno, AVG(e.sal) as avg_sal
FROM emp e, dept d 
WHERE e.deptno=d.deptno 
GROUP BY e.deptno, d.dname) 

SELECT e.empno, e.ename, e.sal, e.deptno, asd.avg_sal
FROM avg_sal_per_dept asd, emp e
WHERE asd.deptno = e.deptno
AND e.sal < 0.5*asd.avg_sal

