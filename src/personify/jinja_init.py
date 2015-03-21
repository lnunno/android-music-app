'''
Created on Mar 21, 2015

@author: lnunno
'''
from jinja2 import Environment
from jinja2.loaders import FileSystemLoader

env = Environment(loader=FileSystemLoader('templates'))