SELECT d.dname, d.deptno, count(empno) AS COUNT_EMP, avg(sal) AS AVG_SAL -- dname und deptno aus Übersichtlichkeit mit ausgegeben, obwohl es in der Aufgabe nicht genau spezifiziert ist
FROM emp e, dept d
WHERE e.deptno= d.deptno 
GROUP BY d.deptno, d.dname