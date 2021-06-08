# Write your MySQL query statement below

select
    Trips.Request_at as `Day`,
    round(sum(if(Trips.status in ('cancelled_by_driver', 'cancelled_by_client'), 1, 0)) / count(*), 2) as 'Cancellation Rate'
from Trips
where Trips.Client_Id in (select Users_Id from Users where Users.Banned = 'No' and Users.role = 'client')
and  Trips.Driver_Id in (select Users_Id from Users where Users.Banned = 'No' and Users.role = 'driver')
and Trips.Request_at between '2013-10-01' and '2013-10-03'
group by Trips.Request_ata

