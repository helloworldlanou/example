import yaml
f = open("yamlusage2.yaml")
ya = yaml.load(f)
print ya
cobbler_dhcp = ya.get('cobbler_dhcp')
print cobbler_dhcp
# cobbler_dhcp['id']="1"
# print cobbler_dhcp

cobbler_dhcp2 = {'server3': {'netmask_ip': '0.0.0.0', 'iso_addr': '/dev/sr0', 'range_ip_start': '0.0.0.0', 'dns_ip': '0.0.0.0', 'subnet_netmask': '0.0.0.0', 'gateway_ip': '0.0.0.0', 'range_ip_stop': '0.0.0.0', 'subnet_ip': '0.0.0.0'}, 'server2': {'netmask_ip': '1.1.1.1', 'iso_addr': '/dev/sr1', 'range_ip_start': '1.1.1.1', 'dns_ip': '1.1.1.1', 'subnet_netmask': '1.1.1.1', 'gateway_ip': '1.1.1.1', 'range_ip_stop': '1.1.1.1', 'subnet_ip': '1.1.1.1'}}

ya['cobbler_dhcp']=cobbler_dhcp2;
print ya

import uuid

print uuid.uuid1()