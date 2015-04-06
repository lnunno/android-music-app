'''
Created on Mar 21, 2015

@author: lnunno
'''
from jinja2 import Environment
from jinja2.loaders import FileSystemLoader
from echo_nest import utils
from personify import __version__
from echo_nest.buckets import search_artist_buckets

env = Environment(loader=FileSystemLoader('templates'))
env.globals.update(echonest_util=utils)
env.globals.update(__version__=__version__)
env.globals.update(search_artist_buckets=search_artist_buckets)