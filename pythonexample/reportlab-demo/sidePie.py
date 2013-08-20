#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  未命名.py
#  
#  Copyright 2013 root <root@localhost.localdomain>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#  
#  
from reportlab.graphics.charts.piecharts import Pie
from reportlab.graphics.shapes import Drawing, _DrawingEditorMixin
from reportlab.lib.colors import Color, magenta, cyan

class pietests(_DrawingEditorMixin,Drawing):
    def __init__(self,width=400,height=200,*args,**kw):
        Drawing.__init__(self,width,height,*args,**kw)
        self._add(self,Pie(),name='pie',validate=None,desc=None)
        self.pie.sideLabels       = 1
        self.pie.labels           = ['Label 1', 'Label 2', 'Label 3', 'Label 4', 'Label 5']
        self.pie.data             = [20, 10, 5, 5, 5]
        self.pie.width            = 140
        self.pie.height           = 140
        self.pie.y                = 35
        self.pie.x                = 125


def main():
    drawing = pietests()
    # you can do all sorts of things to drawing, lets just save it as pdf and png.
    drawing.save(formats=['pdf','png'],outDir='.',fnRoot=None)
    return 0

if __name__ == '__main__':
    main()

