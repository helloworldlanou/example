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

from reportlab.lib.colors import HexColor 

pdf_chart_colors = [ HexColor("#0000e5"), HexColor("#1f1feb"), HexColor("#5757f0"), HexColor("#8f8ff5"), HexColor("#c7c7fa"), HexColor("#f5c2c2"), HexColor("#eb8585"), HexColor("#e04747"), HexColor("#d60a0a"), HexColor("#cc0000"), HexColor("#ff0000"), ] 

def setItems(n, obj, attr, values): 
    m = len(values) 
    i = m // n 
    for j in xrange(n): 
        setattr(obj[j],attr,values[j*i % m])



