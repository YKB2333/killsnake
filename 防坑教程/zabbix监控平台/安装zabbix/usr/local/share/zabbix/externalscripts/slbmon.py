#!/usr/bin/env python
#coding=utf-8
import json
import sys
from aliyunsdkcore import client
import time
from aliyunsdkcms.request.v20180308 import QueryMetricListRequest
class SlbMon(object):
     def __init__(self,slbid='lb-bp13nnhz6ou18t9qu3me5',slbip='120.55.236.226'):
      self.slbid = slbid
      self.slbip = slbip
 #SLB最大并发数
     def MaxConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceMaxConnection')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID
      request.set_Dimensions({'instanceId': self.slbid, 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#SLB当前活跃连接数
     def ActiveConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceActiveConnection')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
  #SLB实例每秒新建连接数
     def NewConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceNewConnection')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#实例每秒丢失连接数
     def DropConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropConnection')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)

 #      实例每秒入bit数
     def TrafficRX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceTrafficRX')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
 #      实例每秒出bit数
     def TrafficTX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceTrafficTX')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#实例每秒非活跃连接数
     def InactiveConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceInactiveConnection')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#实例每秒丢失入bit数
     def DropTrafficRX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropTrafficRX')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#实例每秒丢失出bit数
     def DropTrafficTX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # 两个参数按照预设值设定，参见参考资料描述
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropTrafficTX')
      # 只获取1小时内的数据
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # 从系统输入参数获取IP地址和SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json结果处理
      datadict = json.loads(result)
      # 取倒数第二条数据，因为倒数第一条不太准
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
if __name__ == '__main__':
  slb = SlbMon()
  options = sys.argv[1:]
  if not options or 'MaxConn' in options:
    slb.MaxConn()
  if not options or 'ActiveConn' in options:
    slb.ActiveConn()
  if not options or 'DropConn' in options:
   slb.DropConn()
  if not options or 'NewConn' in options:
    slb.NewConn()
  if not options or 'TrafficRX' in options:
   slb.TrafficRX()
  if not options or 'TrafficTX' in options:
    slb.TrafficTX()
  if not options or 'InactiveConn' in options:
   slb.InactiveConn()
  if not options or 'DropTrafficRX' in options:
   slb.DropTrafficRX()
  if not options or 'DropTrafficTX' in options:
   slb.DropTrafficTX()