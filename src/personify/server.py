#!/usr/bin/env python

'''
Created on Mar 21, 2015

@author: lnunno
'''
import cherrypy
from personify.constants import BASE_DIR, GENRE_SEARCH_PREFIX
from personify.jinja_init import env
from pyechonest.artist import Artist
from pyechonest import config, artist
from personify import secret
from echo_nest.buckets import top_artist_buckets, search_artist_buckets, \
    artist_buckets, genre_buckets
from echo_nest.utils import get_genre_list, get_top_artists_for_genre, en, \
    get_genre_details


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
        artist = Artist(name, buckets=artist_buckets)
        return template.render(artist=artist)

    @cherrypy.expose
    def search(self, search_term):
        template = env.get_template('search.html')
        search_type = 'artists'
        if search_term.startswith(GENRE_SEARCH_PREFIX):
            # Genre search
            genre_search_term = search_term[len(GENRE_SEARCH_PREFIX):]
            results = en.get('genre/search', name=genre_search_term, bucket=genre_buckets)['genres']
            search_type = 'genres'
        else:
            results = artist.search(name=search_term, buckets=search_artist_buckets, fuzzy_match=True)
        return template.render(results=results, search_term=search_term, search_type=search_type)

    @cherrypy.expose
    def genres(self, page=0):
        page = int(page)
        template = env.get_template('genres.html')
        genre_list = get_genre_list(page)
        return template.render(genre_list=genre_list, page=page)

    @cherrypy.expose
    def genre(self, name):
        template = env.get_template('genre.html')
        artist_list = get_top_artists_for_genre(name)
        genre_details = get_genre_details(name)
        return template.render(name=name, artist_list=artist_list, genre_details=genre_details)

    @cherrypy.expose(alias='404')
    def not_found(self, status, message, traceback, version):
        template = env.get_template('404.html')
        return template.render()

    @cherrypy.expose
    def help(self):
        template = env.get_template('help.html')
        return template.render()


if __name__ == '__main__':
    instance = Personify()

    config = {
        '/': {
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
