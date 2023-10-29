SELECT e.job, count(empno) AS COUNT_EMP, avg(sal) AS AVG_SAL 
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND (d.loc = 'CHICAGO' OR d.loc= 'DALLAS')
GROUP BY e.job