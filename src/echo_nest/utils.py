'''
Created on Mar 21, 2015

@author: lnunno
'''
from pyechonest import config
import pyen

from personify import secret
from echo_nest.buckets import genre_buckets, artist_buckets
from datetime import datetime
from personify.constants import NUM_GENRE_RESULTS_PER_PAGE


en = None


def init():
    global en
    en = pyen.Pyen(api_key=secret.ECHO_NEST_API_KEY)
    config.ECHO_NEST_API_KEY = secret.ECHO_NEST_API_KEY


def truncate_text(text, num_char=80):
    text = (text[:num_char] + '...') if len(text) > num_char else text
    return text


def truncate_bio(text):
    return truncate_text(text, num_char=400)


def get_artist_display_image(artist, placeholder_size=64):
    if not hasattr(artist, 'images') and not artist.has_key('images'):
        return None  # Not an object with images.
    if isinstance(artist, dict):
        image_ls = artist['images']
    else:
        image_ls = artist.images
    if len(image_ls) == 0:
        placeholder_image = 'http://placehold.it/%d&text=No+Artist+Image+Available' % (placeholder_size)
        return placeholder_image
    return image_ls[0]['url']


def get_brief_bio(artist):
    if isinstance(artist, dict):
        biography_ls = artist['biographies']
    else:
        biography_ls = artist.biographies
    if len(biography_ls) == 0:
        return ''
    bio = biography_ls[0]
    bio_text = bio['text']
    return truncate_text(bio_text, 400)


def get_genre_list(page=0):
    results = NUM_GENRE_RESULTS_PER_PAGE
    start = page * NUM_GENRE_RESULTS_PER_PAGE
    response = en.get('genre/list', bucket=genre_buckets, results=results, start=start)
    return response['genres']


def get_top_artists_for_genre(name):
    '''
    :see: http://developer.echonest.com/docs/v4/genre.html#artists
    :return: A list of artists.
    '''
    response = en.get('genre/artists', name=name, bucket=artist_buckets)
    artist_list = response['artists']
    return artist_list


def get_genre_details(name):
    response = en.get('genre/profile', name=name, bucket=genre_buckets)
    return response['genres'][0]


def pretty_date(date_str):
    dt = datetime.strptime(date_str, '%Y-%m-%dT%H:%M:%S')
    return dt.strftime('%a %b %d, %Y')


def pretty_score(score_num):
    score_num = score_num * 100
    score_num = int(score_num)
    return '%d%%' % (score_num)


init()