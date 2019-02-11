# -*- coding:utf-8 -*-
from common.getdb import *
from common.timeutil import *
from common.getCrashTablename import *
from common.formTimegraularity import *
import decimal
def responceCrash(timeperiod,timegraularity,dataname,tablename):
    responceCrashsqllist = []
    EndTime = gettime()#获取系统时间
    EndTimeStampSQl = "SELECT (%s.nl_to_timestamp('%s'))"%(dataname,EndTime)#将系统时间转换为tingyun时间戳的SQl语句
    EndTimeStampSQlresult = get_sqldata(EndTimeStampSQl)
    EndTimeStampMin = EndTimeStampSQlresult[0][0]#得到系统时间转换为tingyun时间戳的值
    print("EndTimeStampMin",EndTimeStampMin)
    StartTimeStampMin = EndTimeStampMin-int(timeperiod)#开始时间戳是系统时间戳(按分钟计算)减去时间的间隔
    print("StartTimeStampMin",StartTimeStampMin)
    #将开始的时间戳按tingyun特有的算法,转换为开始时间,开始时间转换为系统时间戳的SQL语句
    SYstartTimeStampMinSQl = "SELECT FLOOR(UNIX_TIMESTAMP(%s.nl_to_date('%d')) / 60)"%(dataname,StartTimeStampMin)

    SYstartTimeStampMinResult = get_sqldata(SYstartTimeStampMinSQl)
    SYstartTimeStampMin = SYstartTimeStampMinResult[0][0]
    print("SYstartTimeStampMin",SYstartTimeStampMin)
    timelidu = transform_timegraularity(timegraularity)
    print("timelidu",timelidu)
    mobile_app_id = 1
    strSql1 = "SELECT CASE WHEN SUM(launch_count) =0 AND SUM(crash_count)=0 THEN 0 WHEN SUM(launch_count)<SUM(crash_count) THEN 1 \
    ELSE SUM(crash_count)*1e0/SUM(launch_count) END AS crash_percent,SUM(crash_count) AS crash_count,\
    SUM(launch_count) AS launch_count,\
    FROM_UNIXTIME(('%d' + FLOOR(FLOOR((CAST(TIMESTAMP AS SIGNED) - '%d') / '%d')) * '%d') * 60) AS tmTick,mobile_app_version_id \
    AS mobile_app_version_id FROM %s.%s WHERE  1>0 \
    AND TIMESTAMP >= '%d' AND TIMESTAMP < '%d'  AND \
    mobile_app_version_id in (3,4,1) AND mobile_app_id = '%d' \
    GROUP BY tmTick,mobile_app_version_id ORDER BY tmTick ASC,mobile_app_version_id DESC" % \
    (SYstartTimeStampMin,StartTimeStampMin,timelidu,timelidu,dataname,tablename,StartTimeStampMin,EndTimeStampMin, mobile_app_id)
    responceCrashsql = get_sqldata(strSql1)
    print("responceCrashsql",responceCrashsql)

    try:
        for a in responceCrashsql:
            sqldata = {}
            sqldata["crash_percent"] = a[0]
            sqldata["crash_count"] = a[1]
            sqldata["launch_count"] = a[2]
            sqldata["tmTick"] = a[3]
            sqldata["mobile_app_version_id"] = a[4]
            responceCrashsqllist.append(sqldata)
        return responceCrashsqllist
    except:
        print("Error:unable to fetch data")

if __name__ == '__main__':
    timeperiod = getTimeperiod_Timegranularity()[0]
    timegraularity = getTimeperiod_Timegranularity()[1]
    dataname = getCrashDataname()
    tablename = getTablebame("129600")
    print(tablename)
    print((responceCrash("129600","1d",dataname=dataname,tablename=tablename)))