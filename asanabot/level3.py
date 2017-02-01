import datetime
import queue as Q
def recurringTask(firstDate, k, daysOfTheWeek, n):
    days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    dayToIndex = dict(zip( days,range(0,len(days))))
    day = int(firstDate[:2])
    month = int(firstDate[3:5])
    year= int(firstDate[6:])
    
    firstDay = days[datetime.date(year,month,day).weekday()]
    date = datetime.date(year, month, day)
    
    nextDate = lambda date, day: date + datetime.timedelta(days=(day-date.weekday()+7)%7)
    result = []
    pq = Q.PriorityQueue()
    m = 0
    for j in daysOfTheWeek:
        pq.put(nextDate(date, dayToIndex[j]))
    while(len(result) < n):
        _date = pq.get()
        _datestring = _date.strftime("%d/%m/%Y")
        if len(result) == 0 or _datestring != result[-1]:
            result.append(_datestring)
        _ndate = _date + datetime.timedelta(days=7*k)
        pq.put(_ndate)

    return result

