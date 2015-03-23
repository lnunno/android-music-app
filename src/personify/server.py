#!/usr/bin/env python

'''
Created on Mar 21, 2015

@author: lnunno
'''
import cherrypy
from personify.constants import BASE_DIR
from personify.jinja_init import env
from pyechonest.artist import Artist
from pyechonest import config, artist
from personify import secret
from echo_nest.buckets import top_artist_buckets, search_artist_buckets

class Personify(object):
    
    def __init__(self):
        config.ECHO_NEST_API_KEY = secret.ECHO_NEST_API_KEY
    
    @cherrypy.expose
    def index(self):
        '''
        Main index page.
        '''
        template = env.get_template('index.html')
        return template.render()
    
    @cherrypy.expose
    def top_artists(self):
        template = env.get_template('top_artists.html')
        num_top_artists = 20
        top_artist_list = artist.top_hottt(results=num_top_artists, buckets=top_artist_buckets)
        return template.render(top_artist_list=top_artist_list, num_top_artists=num_top_artists)
    
    @cherrypy.expose
    def artist(self, name):
        '''
        @param name: The name of the artist.
        '''
        template = env.get_template('artist.html')
        artist = Artist(name)
        return template.render(artist=artist)
        
    @cherrypy.expose
    def search(self, search_term):
        template = env.get_template('search.html')
        results = artist.search(name=search_term, buckets=search_artist_buckets, fuzzy_match=True)
        return template.render(results=results,search_term=search_term)
    
    @cherrypy.expose
    def genres(self):
        template = env.get_template('genres.html')
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
