#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  report.py
#  
#  Copyright 2013 root <root@localhost.localdomain>
#  yum install freetype-devel.x86_64 
#  yum install python-devel.x86_64 否则报错:
#  error: command 'gcc' failed with exit status 1 Command /usr/bin/python -c "import setuptools;__file__='/tmp/pip-build-root/reportlab/setup.py';exec(compile(open(__file__).read().replace('\r\n', '\n'), __file__, 'exec'))" install --record /tmp/pip-oneoII-record/install-record.txt --single-version-externally-managed failed with error code 1 in /tmp/pip-build-root/reportlab

#  pip install reportlab
# more reportlab example :http://www.reportlab.com/snippets/ and reportlab-userguide
from reportlab.lib import colors
from urllib import urlopen
from reportlab.graphics.shapes import *
from reportlab.graphics.charts.lineplots import LinePlot
from reportlab.graphics import renderPDF

URL="http://www.swpc.noaa.gov/ftpdir/weekly/Predict.txt"
COMMENT_CHARS='#:'

drawing = Drawing(400,200)
data = []
for  line in  urlopen(URL).readlines():
	if not line.isspace() and not line[0] in COMMENT_CHARS:
		data.append([float(n) for n in line.split()])

pred = [row[2] for row in data]
high = [row[3] for row in data]
low = [row[4] for row in data]
times = [row[0] + row[1]/12.0 for row in data]

lp = LinePlot()
lp.x = 50
lp.y = 50
lp.height = 125
lp.width = 300
lp.data = [zip(times,pred),zip(times,high),zip(times,low)]
drawing.add(lp)

renderPDF.drawToFile(drawing,'report.pdf','Sunspots')

def main():

	return 0

if __name__ == '__main__':
	main()

