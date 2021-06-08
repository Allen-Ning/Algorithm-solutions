select id,
       SUM(if(month = "jan", revenue, null)) as 'Jan_Revenue',
       SUM(if(month = "feb", revenue, null)) as 'Feb_Revenue',
       SUM(if(month = "mar", revenue, null)) as 'Mar_Revenue',
       SUM(if(month = "apr", revenue, null)) as 'Apr_Revenue',
       SUM(if(month = "may", revenue, null)) as 'May_Revenue',
       SUM(if(month = "jun", revenue, null)) as 'Jun_Revenue',
       SUM(if(month = "jul", revenue, null)) as 'Jul_Revenue',
       SUM(if(month = "aug", revenue, null)) as 'Aug_Revenue',
       SUM(if(month = "sep", revenue, null)) as 'Sep_Revenue',
       SUM(if(month = "oct", revenue, null)) as 'Oct_Revenue',
       SUM(if(month = "nov", revenue, null)) as 'Nov_Revenue',
       SUM(if(month = "dec", revenue, null)) as 'Dec_Revenue'
from Department
group by Department.id
