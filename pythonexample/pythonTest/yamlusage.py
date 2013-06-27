import yaml
f = open("yamlusage.yaml")
ya = yaml.load(f)
print ya
cobbler_dhcp = ya.get('cobbler_dhcp')
print cobbler_dhcp