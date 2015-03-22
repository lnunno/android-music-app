'''
Created on Mar 21, 2015

@author: lnunno
'''
from pyechonest import config
from personify import secret

def init():
    config.ECHO_NEST_API_KEY = secret.ECHO_NEST_API_KEY