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
 #SLB��󲢷���
     def MaxConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceMaxConnection')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID
      request.set_Dimensions({'instanceId': self.slbid, 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#SLB��ǰ��Ծ������
     def ActiveConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceActiveConnection')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
  #SLBʵ��ÿ���½�������
     def NewConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceNewConnection')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#ʵ��ÿ�붪ʧ������
     def DropConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropConnection')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)

 #      ʵ��ÿ����bit��
     def TrafficRX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceTrafficRX')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
 #      ʵ��ÿ���bit��
     def TrafficTX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceTrafficTX')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#ʵ��ÿ��ǻ�Ծ������
     def InactiveConn(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceInactiveConnection')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#ʵ��ÿ�붪ʧ��bit��
     def DropTrafficRX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropTrafficRX')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
      res = eval(datadict['Datapoints'])[-2]['Average']
      print(res)
#ʵ��ÿ�붪ʧ��bit��
     def DropTrafficTX(self):
      clt = client.AcsClient('LTAIrt7Yy3uzbTQI', '5152BKyAB2lLaBd3hE7NRF680IUCxp', 'cn-hangzhou')
      request = QueryMetricListRequest.QueryMetricListRequest()
      request.set_accept_format('json')
      # ������������Ԥ��ֵ�趨���μ��ο���������
      request.set_Project('acs_slb_dashboard')
      request.set_Metric('InstanceDropTrafficTX')
      # ֻ��ȡ1Сʱ�ڵ�����
      start_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time() - 3600))
      timestamp_start = int(time.mktime(time.strptime(start_time, "%Y-%m-%d %H:%M:%S"))) * 1000
      request.set_StartTime(timestamp_start)
      # ��ϵͳ���������ȡIP��ַ��SLB-ID

      request.set_Dimensions({'instanceId': self.slbid, 'port': '443', 'vip': self.slbip})
      request.set_Period('60')
      # result = clt.do_action(request)
      result = clt.do_action_with_exception(request)
      # print result
      # json�������
      datadict = json.loads(result)
      # ȡ�����ڶ������ݣ���Ϊ������һ����̫׼
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