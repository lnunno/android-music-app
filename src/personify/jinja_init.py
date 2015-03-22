'''
Created on Mar 21, 2015

@author: lnunno
'''
from jinja2 import Environment
from jinja2.loaders import FileSystemLoader
from echo_nest import utils

env = Environment(loader=FileSystemLoader('templates'))
env.globals.update(echonest_util=utils)