#!/usr/bin/env python3

'''
Created on Mar 21, 2015

@author: lnunno
'''
import cherrypy
from personify.constants import BASE_DIR
from personify.jinja_init import env

class Personify(object):
    
    def __init__(self):
        pass
    
    '''
    Main index page.
    '''
    @cherrypy.expose
    def index(self):
        template = env.get_template('index.html')
        return template.render()
        
    @cherrypy.expose(alias='404')
    def not_found(self, status, message, traceback, version):
        template = env.get_template('404.html')
        return template.render()
    
if __name__ == '__main__':
    
    instance = Personify()
    
    config = {
              '/':{
                   'tools.sessions.on': True,
                   'tools.staticdir.on': True,
                   'tools.staticdir.root': BASE_DIR,
                   'tools.staticdir.dir': 'static',
                   'error_page.404': instance.not_found
                   }
              }
    cherrypy.server.socket_host = '0.0.0.0'
    cherrypy.server.socket_port = 8080
    cherrypy.quickstart(instance, '/', config=config)